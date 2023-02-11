"""
Implement Agents and Environments. (Chapters 1-2)

The class hierarchies are as follows:

Thing ## A physical object that can exist in an environment
    Agent
    Dirt

Environment ## An environment holds objects, runs simulations
    XYEnvironment
        VacuumEnvironment

An agent program is a callable instance, taking percepts and choosing actions
    SimpleReflexAgentProgram
    ...

"""

# TODO
# Implement grabbing correctly.
# When an object is grabbed, does it still have a location?
# What if it is released?
# What if the grabbed or the grabber is deleted?
# What if the grabber moves?
# Speed control in GUI does not have any effect -- fix it.

from ipythonblocks import ImageGrid
from IPython.display import HTML, display, clear_output
from time import sleep

import random
import collections
import numbers


# ______________________________________________________________________________
def distance_squared(a, b):
    """The square of the distance between two (x, y) points."""
    xA, yA = a
    xB, yB = b
    return (xA - xB) ** 2 + (yA - yB) ** 2



class Thing:
    """This represents any physical object that can appear in an Environment.
    You subclass Thing to get the things you want. Each thing can have a
    .__name__  slot (used for output only)."""

    def __repr__(self):
        return '<{}>'.format(getattr(self, '__name__', self.__class__.__name__))

    def show_state(self):
        """Display the agent's internal state. Subclasses should override."""
        print("I don't know how to show_state.")

    def display(self, canvas, x, y, width, height):
        """Display an image of this Thing on the canvas."""
        # Do we need this?
        pass


class Agent(Thing):
    """An Agent is a subclass of Thing with one required slot,
    .program, which should hold a function that takes one argument, the
    percept, and returns an action. (What counts as a percept or action
    will depend on the specific environment in which the agent exists.)
    Note that 'program' is a slot, not a method. There is an optional slot, 
    .performance, which is a number that quantifies the performance measure 
    of the agent in its environment."""

    def __init__(self, program=None):
        self.performance = 0 # Quantative performance measure. Initialized at 0.
        self.steps = 0 # Counts how many steps/action have been taken. Initialized at 0.
        if program is None or not isinstance(program, collections.abc.Callable):
            print("Can't find a valid program for {}, falling back to default.".format(self.__class__.__name__))

            def program(percept):
                return eval(input('Percept={}; action? '.format(percept)))

        self.program = program

# Vacuum environment
class Dirt(Thing):
    pass

# ______________________________________________________________________________
# The following two classes are not necessary to be used in this assignment.

class Obstacle(Thing):
    """Something that can cause a bump, preventing an agent from
    moving into the same square it's in."""
    pass

class Wall(Obstacle):
    pass  

# ______________________________________________________________________________


class Environment:
    """Abstract class representing an Environment. 'Real' Environment classes
    inherit from this. Your Environment will typically need to implement:
        percept:           Define the percept that an agent sees.
        execute_action:    Define the effects of executing an action.
                           Also update the agent.performance slot.
    The environment keeps a list of .things and .agents (which is a subset
    of .things). Each agent has a .performance slot, initialized to 0.
    Each thing has a .location slot, even though some environments may not
    need this."""

    def __init__(self):
        self.things = []
        self.agents = []
        self.termination_flag = False

    def thing_classes(self):
        return []  # List of classes that can go into environment

    def percept(self, agent):
        """Return the percept that the agent sees at this point. (Implement this.)"""
        raise NotImplementedError

    def execute_action(self, agent, action):
        """Change the world to reflect this action. (Implement this.)"""
        raise NotImplementedError

    def default_location(self, thing):
        """Default location to place a new thing with unspecified location."""
        return None

    def exogenous_change(self):
        """If there is spontaneous change in the world, override this."""
        pass

    def is_done(self):
        """There are task environments in which an agent can perish. Other outside
        influences can likewise prematurely end the agent design problem. In 
        this case, this function can be overridden."""
        return self.termination_flag

    def step(self):
        """Run the environment for one time step. If the
        actions and exogenous changes are independent, this method will
        do. If there are interactions between them, you'll need to
        override this method."""
        if not self.is_done():
            actions = []
            for agent in self.agents:
                actions.append(agent.program(self.percept(agent)))
            for (agent, action) in zip(self.agents, actions):
                self.execute_action(agent, action)
                print("Performance measure: ",agent.performance)
            self.exogenous_change()

    def run(self, steps=1000):
        """Run the Environment for given number of time steps."""
        for step in range(steps):
            if self.is_done():
                return
            self.step()

    def list_things_at(self, location, tclass=Thing):
        """Return all things exactly at a given location."""
        if isinstance(location, numbers.Number):
            return [thing for thing in self.things
                    if thing.location == location and isinstance(thing, tclass)]
        return [thing for thing in self.things
                if all(x == y for x, y in zip(thing.location, location)) and isinstance(thing, tclass)]

    def some_things_at(self, location, tclass=Thing):
        """Return true if at least one of the things at location
        is an instance of class tclass (or a subclass)."""
        return self.list_things_at(location, tclass) != []

    def add_thing(self, thing, location=None):
        """Add a thing to the environment, setting its location. For
        convenience, if thing is an agent program we make a new agent
        for it. (Shouldn't need to override this.)"""
        if not isinstance(thing, Thing):
            thing = Agent(thing)
        if thing in self.things:
            print("Can't add the same thing twice")
        else:
            thing.location = location if location is not None else self.default_location(thing)
            self.things.append(thing)
            if isinstance(thing, Agent):
                thing.performance = 0
                self.agents.append(thing)

    def delete_thing(self, thing):
        """Remove a thing from the environment."""
        try:
            self.things.remove(thing)
        except ValueError as e:
            print(e)
            print("  in Environment delete_thing")
            print("  Thing to be removed: {} at {}".format(thing, thing.location))
            print("  from list: {}".format([(thing, thing.location) for thing in self.things]))
        if thing in self.agents:
            self.agents.remove(thing)



class XYEnvironment(Environment):
    """This class is for environments on a 2D plane, with locations
    labelled by (x, y) points, either discrete or continuous.
    Agents perceive things within a radius. Each agent in the
    environment has a .location slot which should be a location such
    as (0, 1), and a .holding slot, which should be a list of things
    that are held."""

    def __init__(self, width=10, height=10,x_start=0,y_start=0):
        super().__init__()

        self.width = width
        self.height = height
        self.observers = []
        # Sets iteration start and end (no walls).
        self.x_start, self.y_start = (x_start, y_start)
        self.x_end, self.y_end = (self.x_start+self.width-1, self.y_start+self.height-1)

    perceptible_distance = 1

    def things_near(self, location, radius=None):
        """Return all things within radius of location."""
        if radius is None:
            radius = self.perceptible_distance
        radius2 = radius * radius
        return [(thing, radius2 - distance_squared(location, thing.location))
                for thing in self.things if distance_squared(
                location, thing.location) <= radius2]

    def percept(self, agent):
        """By default, agent perceives things within a default radius."""
        return self.things_near(agent.location)

    def execute_action(self, agent, action):
        """Implement this based on the environment model."""
        pass

    def default_location(self, thing):
        location = self.random_location_inbounds()
        while self.some_things_at(location, Obstacle):
            # we will find a random location with no obstacles
            location = self.random_location_inbounds()
        return location

    def add_thing(self, thing, location=None, exclude_duplicate_class_items=False):
        """Add things to the world. If (exclude_duplicate_class_items) then the item won't be
        added if the location has at least one item of the same class."""
        if location is None:
            super().add_thing(thing)
        elif self.is_inbounds(location):
            if (exclude_duplicate_class_items and
                    any(isinstance(t, thing.__class__) for t in self.list_things_at(location))):
                return
            super().add_thing(thing, location)

    def is_inbounds(self, location):
        """Checks to make sure that the location is inbounds (within walls if we have walls)"""
        x, y = location
        
        return not (x < self.x_start or x > self.x_end or y < self.y_start or y > self.y_end)

    def random_location_inbounds(self, exclude=None):
        """Returns a random location that is inbounds (within walls if we have walls)"""
        location = (random.randint(self.x_start, self.x_end),
                    random.randint(self.y_start, self.y_end))
        if exclude is not None:
            while location == exclude:
                location = (random.randint(self.x_start, self.x_end),
                            random.randint(self.y_start, self.y_end))
        return location

    def delete_thing(self, thing):
        """Deletes thing, and everything it is holding (if thing is an agent)"""
        if isinstance(thing, Agent):
            if hasattr(thing,'holding'):
                for obj in thing.holding:
                    super().delete_thing(obj)
                    for obs in self.observers:
                        obs.thing_deleted(obj)
        super().delete_thing(thing)
        for obs in self.observers:
            obs.thing_deleted(thing)

    def add_walls(self):
        """Put walls around the entire perimeter of the grid."""
        for x in range(self.width):
            self.add_thing(Wall(), (x, 0))
            self.add_thing(Wall(), (x, self.height - 1))
        for y in range(1, self.height - 1):
            self.add_thing(Wall(), (0, y))
            self.add_thing(Wall(), (self.width - 1, y))

        # Updates iteration start and end (with walls).
        self.x_start, self.y_start = (1, 1)
        self.x_end, self.y_end = (self.width - 1, self.height - 1)

    def add_observer(self, observer):
        """Adds an observer to the list of observers.
        An observer is typically an EnvGUI.

        Each observer is notified of changes in move_to and add_thing,
        by calling the observer's methods thing_moved(thing)
        and thing_added(thing, loc)."""
        self.observers.append(observer)

  

class GraphicEnvironment(XYEnvironment):
    def __init__(self, width=10, height=10, x_start=0,y_start=0, boundary=True, color={}, display=False):
        """Define all the usual XYEnvironment characteristics,
        but initialise a ImageGrid for GUI too."""
        super().__init__(width, height,x_start,y_start)
        self.default_color = (200, 200, 200)
        self.grid = ImageGrid(width, height, fill=self.default_color)
        if display:
            self.draw_world()
            clear_output(1)
            self.grid.show()
            self.visible = True
        else:
            self.visible = False
        self.bounded = boundary
        self.colors = color
        self.x_start = x_start
        self.y_start = y_start
        

    def get_world(self):
        """Returns all the items in the world in a format
        understandable by the ipythonblocks ImageGrid."""
        result = []
        x_end, y_end = self.x_start+self.width, self.y_start+self.height
        for x in range(self.x_start, x_end):
            row = []
            for y in range(self.y_start, y_end):
                row.append(self.list_things_at((x, y)))
            result.append(row)
        return result

    def run(self, steps=1000, delay=1):
        """Run the Environment for given number of time steps,
        but update the GUI too."""
        for step in range(steps):
            if self.is_done():
                break
            self.update(delay)     
            print("Step number: ",step)
            self.step()
        self.update(delay)

    def update(self, delay=1):
        sleep(delay)
        self.reveal()

    def reveal(self):
        """Display the ImageGrid for this world - the last thing to be added
        at a location defines the location color."""
        self.draw_world()
        # wait for the world to update and
        # apply changes to the same grid instead
        # of making a new one.
        clear_output(1)
        self.grid.show()
        self.visible = True

    def draw_world(self):
        world = self.get_world()
        for x in range(0, len(world)):
            for y in range(0, len(world[x])):
                if len(world[x][y]):
                    self.grid[x, y] = self.colors[world[x][y][-1].__class__.__name__]

    def conceal(self):
        """Hide the ImageGrid for this world"""
        self.visible = False
        display(HTML(''))


# ______________________________________________________________________________

def get_envionment_dimensions(locs):
    x_start = float('inf')
    y_start = float('inf')
    x_end = float('-inf')
    y_end = float('-inf')
    for loc in locs:
        x_start = min(x_start,loc[0])
        y_start = min(y_start,loc[1])
        x_end = max(x_end,loc[0])
        y_end = max(y_end,loc[1])
    width = x_end - x_start+1
    height = y_end - y_start+1
    return x_start,y_start,width,height

class VacuumEnvironment(GraphicEnvironment):
    def __init__(self, locs=[(0,0),(1,0)], status = 'random',boundary=True, color={}, display=False):
        x_start,y_start,width,height = get_envionment_dimensions(locs)
        if type(status) == str and status == 'random':
            # set half of squares to status 'Dirty'
            self.status = dict(zip(locs,random.choices(['Clean', 'Dirty'],k=len(locs))))
        elif type(status) == dict:
            self.status = status
            # if status dictionary is provided as input, use that information to set 'Clean'/'Dirty' information
        else:
            raise TypeError("For 'status', provide a dict with status information.")
        super().__init__(width, height,x_start,y_start,boundary,color,display=False)
        self.grid = ImageGrid(2*width, 2*height,block_size=15, lines_on=False, fill=self.default_color)
        self.locs = locs
        for loc in locs: # add 'Dirt' objects for each dirty square
            if self.status[loc] == 'Dirty':
                self.add_thing(Dirt(),location=loc)
        if display:
            self.draw_world()
            clear_output(1)
            self.grid.show()
            self.visible = True
        else:
            self.visible = False
        if display:
            self.reveal()

    def percept(self, agent):
        """Returns the agent's location, and the location status (Dirty/Clean)."""
        return agent.location, self.status[agent.location]
    
    def thing_classes(self):
        return [Wall, Dirt, ModelBasedReflexVacuumAgent]

    def execute_action(self, agent, action):
        """Change agent's location and/or location's status; track performance.
        Score 10 for each dirt cleaned; -1 for each move."""
        agent.steps += 1
        if action in ['Left','Right','Up','Down']:
            if action == 'Left':
                targetloc = (agent.location[0]-1,agent.location[1])
            elif action == 'Right':
                targetloc = (agent.location[0]+1,agent.location[1])
            elif action == 'Up':
                targetloc = (agent.location[0],agent.location[1]+1)
            elif action == 'Down':
                targetloc = (agent.location[0],agent.location[1]-1)
            agent.performance -= 1
            if self.is_inbounds(targetloc):
                agent.location = targetloc
        elif action == 'Suck':
            if self.status[(agent.location[0],agent.location[1])] == 'Dirty':
                agent.performance += 10
                dirt_list = self.list_things_at((agent.location[0],agent.location[1]), Dirt)
                if dirt_list != []:
                    dirt = dirt_list[0]
                    self.delete_thing(dirt)
            else:
                agent.performance -= 1
            self.status[(agent.location[0],agent.location[1])] = 'Clean'
        elif action == 'NoOp':
            self.termination_flag = True
        print("Execute action: '"+action+"'")
        self.draw_world()
                        
    def default_location(self, thing):
        """
        Returns a location drawn at random among all tile locations in vacuum world.
        """
        return random.choice(self.locs)
    
    def delete_thing(self,thing):
        """
        Removes the object represented by input thing from the environment, 
        while updating the data of the grid to be visualized.
        """
        location = thing.location
        super().delete_thing(thing)
        if type(thing) == Agent:
            if len(self.list_things_at(location,tclass=Dirt)):
                self.grid[2*location[0],2*location[1]] = self.colors[self.list_things_at(location,tclass=Dirt)[0].__class__.__name__]
                self.grid[2*location[0]+1,2*location[1]] = self.colors[self.list_things_at(location,tclass=Dirt)[0].__class__.__name__]
            else:
                self.grid[2*location[0]:2*location[0]+2,2*location[1]] = self.default_color
        elif type(thing) == Dirt:
            self.grid[2*location[0]:2*location[0]+2,2*location[1]+1] = self.default_color
            if len(self.list_things_at(location,tclass=Agent)) == 0:
                self.grid[2*location[0]:2*location[0]+2,2*location[1]] = self.default_color

    
    def draw_world(self):
        """
        Updates the visualiztion grid data based on the geometry of the vacuum world
        and the Dirt and Agent objects currently located in the vacuum world.
        """
        world = self.get_world()
        width = len(world)
        height = len(world[0])
        self.grid = ImageGrid(2*width, 2*height,block_size=15, lines_on=False, fill=self.default_color)
        for x in range(0, 2*width):
            for y in range(0, 2*height):
                if len(world[x // 2][y // 2]):
                    if y % 2 == 1:
                        if len(self.list_things_at((x//2,y//2),tclass=Dirt)):
                            self.grid[x, y] = self.colors[self.list_things_at((x//2,y//2),tclass=Dirt)[0].__class__.__name__]
                            
                    elif y % 2 == 0:
                        if len(self.list_things_at((x//2,y//2),tclass=Agent)):
                            self.grid[x, y] = self.colors[self.list_things_at((x//2,y//2),tclass=Agent)[0].__class__.__name__]
                        elif len(self.list_things_at((x//2,y//2),tclass=Dirt)):
                            self.grid[x, y] = self.colors[self.list_things_at((x//2,y//2),tclass=Dirt)[0].__class__.__name__]
                            
                            
def ModelBasedReflexVacuumAgent(environment: VacuumEnvironment): # rules, update_state, transition_model, sensor_model
    """
    This function returns an Agent equipped with a model-based reflex agent program for 
    the vacuum world enviroment.
    We have already implemented its 'transition_model' and its 'sensor_model' below.
    
    It takes as an input argument an instance of the VacuumEnvironment class,
    and returns an Agent class object equipped with the agent program defined 
    in its method 'program'.
    
        Parameters
        ----------
        environment : VacuumEnvironment object
            Represents the vacuum world environment for which the agent is designed.
            (This is only used for the agent to know the geometry of the tiles in the enviroment.)
        
        Returns
        -------
        Agent : Agent object
            Agent object provided with agent program (see class definition above)
            that is the one of a model-based reflex agent.
    """
    class State:
        """
        Class describing the current model/state of the model-based reflex agent.
        Initialized with empty location information and empty dictionary tracking
        cleanliness information.
        """
        def __init__(self):
            self.location = None
            self.cleanliness = dict()
        
    def transition_model(state,action):
        """
        Implements transition model of model-based reflex agent. Strictly speaking,
        this is not necessarily needed to implement its agent program.
        
        Parameters
        ----------
        state : State object
            Represents the current (internal) state of the agent.
        action : str
            Action taken;
        
        Returns
        -------
        state : State object
            New state after applying 'action' to state provided to the function.
        """
        if action == 'Suck':
            state.cleanliness[state.location] = 'Clean'
        elif action == 'NoOp':
            return state
        else:
            if action == 'Left':
                targetloc = (state.location[0]-1,state.location[1])
            elif action == 'Right':
                targetloc = (state.location[0]+1,state.location[1])
            elif action == 'Up':
                targetloc = (state.location[0],state.location[1]+1)
            elif action == 'Down':
                targetloc = (state.location[0],state.location[1]-1)
            if environment.is_inbounds(targetloc):
                state.location = targetloc
        return state
    
    def sensor_model(state,percept):
        """
        Implements the sensor model of the agent, i.e., it describes how the current
        state is updated given a new percept.
    
        Parameters
        ----------
        state : State object
            Represents the current (internal) state of the agent.
        percept : tuple of size 2.
            First element contains the location (likewise a tuple of size 2, e.g., (0,0)),
            second element contains str encoding the cleanliness property of 
            a tile ('Dirty' or 'Clean').

        Returns
        -------
        state : State object
            Represents the updated (internal) state of the agent after 
            incorporating the percept information.

        """
        location, cleanliness = percept
        state.cleanliness[location] = cleanliness
        state.location = location
        return state
    
    def update_state(state,action,percept):
        """
        Updates the state based on last action and current percept.
        (In our case, it is sufficient to use only percept and state information.) 

        Parameters
        ----------
        state : State object
            Represents the updated (internal) state of the agent after 
            incorporating the percept information.
        action : str
            Represents action taken most recently.
        percept : tuple of size 2.
            First element contains the location (likewise a tuple of size 2, e.g., (0,0)),
            second element contains str encoding the cleanliness property of 
            a tile ('Dirty' or 'Clean').

        Returns
        -------
        state : State object
            Updated state.
        """
        state = sensor_model(state,percept)
        return state

    def program(percept):
        """
        This function implements the agent program of the model-based reflex agent
        for the vacuum agent problem.

        Parameters
        ----------
        percept : tuple of size 2.
            First element contains the location (likewise a tuple of size 2, e.g., (0,0)),
            second element contains str encoding the cleanliness property of 
            a tile ('Dirty' or 'Clean').

        Returns
        -------
        next_action : str
            Action taken by the agent given provided percept.
        """
        ### Add your code below / adapt existing code ###

        
        if(percept[1] == 'Dirty'):
            next_action = 'Suck'
        else:
            if(percept[0][0] % 2 == 0):
                if(environment.is_inbounds((percept[0][0], percept[0][1] + 1))):
                    next_action = 'Up'
                else:
                    if(environment.is_inbounds((percept[0][0] + 1, percept[0][1]))):
                        next_action = 'Right'
                    else:
                        next_action = 'NoOp'
            else:
                if(environment.is_inbounds((percept[0][0], percept[0][1] - 1))):
                    next_action = 'Down'
                else:
                    if(environment.is_inbounds((percept[0][0] + 1, percept[0][1]))):
                        next_action = 'Right'
                    else:
                        next_action = 'NoOp'

        program.action = next_action
        return next_action

    
    program.state = State()
    program.action = None
    
    return Agent(program)

def FlexibleModelBasedReflexVacuumAgent(environment: VacuumEnvironment):
    """
    Function that implements the flexible model-based reflex agent of
    Problem 3 of "Assignment 2: Model-based Reflex Agents for the Vacuum World".
    
    """
    ### Add you code here below

    pass
    
    