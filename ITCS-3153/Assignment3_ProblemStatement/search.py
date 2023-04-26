"""
This module contains code to define a search problem (via class SearchProblem)
and is designed to contain the function definitions of several uninformed and
informed search algorithms.
"""
from collections import deque
import heapq
import math


class SearchProblem:
    """The abstract class for a formal problem. You should subclass
    this and implement the methods actions and result, and possibly
    __init__, goal_test, and path_cost. Then you will create instances
    of your subclass and solve them with the various search functions."""

    def __init__(self, initial, goal=None):
        """The constructor specifies the initial state, and possibly a goal
        state, if there is a unique goal. Your subclass's constructor can add
        other arguments."""
        self.initial = initial
        self.goal = goal

    def actions(self, state):
        """Return the actions that can be executed in the given
        state. The result would typically be a list, but if there are
        many actions, consider yielding them one at a time in an
        iterator, rather than building them all at once."""
        raise NotImplementedError

    def result(self, state, action):
        """Return the state that results from executing the given
        action in the given state. The action must be one of
        self.actions(state)."""
        raise NotImplementedError

    def goal_test(self, state):
        """Return True if the state is a goal. The default method compares the
        state to self.goal or checks for state in self.goal if it is a
        list, as specified in the constructor. Override this method if
        checking against a single self.goal is not enough."""
        if isinstance(self.goal, list):
            testlist = []
            for goal in self.goal:
                testlist.append(state == goal)
            goalReached = any(testlist)
        else:
            goalReached = state == self.goal
        return goalReached
    
    def action_cost(self, state1, action, state2): 
        return 1
    
    def path_cost(self, c, state1, action, state2):
        """Return the cost of a solution path that arrives at state2 from
        state1 via action, assuming cost c to get up to state1. If the problem
        is such that the path doesn't matter, this function will only look at
        state2. If the path does matter, it will consider c and maybe state1
        and action. The default method costs 1 for every step in the path."""
        return c + 1


# ______________________________________________________________________________


class Node:
    """A node in a search tree. Contains a pointer to the parent (the node
    that this is a successor of) and to the actual state for this node. Note
    that if a state is arrived at by two paths, then there are two nodes with
    the same state. Also includes the action that got us to this state, and
    the total path_cost (also known as g) to reach the node. Other functions
    may add an f and h value; see best_first_graph_search and astar_search for
    an explanation of how the f and h values are handled. You will not need to
    subclass this class."""

    def __init__(self, state, parent=None, action=None, path_cost=0):
        """Create a search tree Node, derived from a parent by an action."""
        self.state = state
        self.parent = parent
        self.action = action
        self.path_cost = path_cost
        self.depth = 0
        if parent:
            self.depth = parent.depth + 1

    def __repr__(self):
        return "<Node {}>".format(self.state)
    
    def __lt__(self, node):
        return self.state < node.state

    def expand(self, problem):
        """List the nodes reachable in one step from this node."""
        return [self.child_node(problem, action)
                for action in problem.actions(self.state)]

    def child_node(self, problem, action):
        """[Figure 3.10]"""
        next_state = problem.result(self.state, action)
        next_node = Node(next_state, self, action, problem.path_cost(self.path_cost, self.state, action, next_state))
        return next_node

    def solution(self):
        """Return the sequence of actions to go from the root to this node."""
        return [node.action for node in self.path()[1:]]

    def path(self):
        """Return a list of nodes forming the path from the root to this node."""
        node, path_back = self, []
        while node:
            path_back.append(node)
            node = node.parent
        return list(reversed(path_back))

    # We want for a queue of nodes in breadth_first_graph_search or
    # astar_search to have no duplicated states, so we treat nodes
    # with the same state as equal. [Problem: this may not be what you
    # want in other contexts.]

    def __eq__(self, other):
        return isinstance(other, Node) and self.state == other.state

    def __hash__(self):
        # We use the hash value of the state
        # stored in the node instead of the node
        # object itself to quickly search a node
        # with the same state in a Hash Table
        return hash(self.state)


# ______________________________________________________________________________
failure = Node('failure', path_cost=math.inf) # Indicates an algorithm couldn't find a solution.
cutoff  = Node('cutoff',  path_cost=math.inf) # Indicates iterative deepening search was cut off.


FIFOQueue = deque

LIFOQueue = list

class PriorityQueue:
    """A queue in which the item with minimum f(item) is always popped first."""

    def __init__(self, items=(), key=lambda x: x): 
        self.key = key
        self.items = [] # a heap of (score, item) pairs
        for item in items:
            self.add(item)
         
    def add(self, item):
        """Add item to the queuez."""
        pair = (self.key(item), item)
        heapq.heappush(self.items, pair)

    def pop(self):
        """Pop and return the item with min f(item) value."""
        return heapq.heappop(self.items)[1]
    
    def top(self): return self.items[0][1]


def expand(problem, node):
    """Expand a node, generating the children nodes.
        Parameters
        ----------
        problem : SearchProblem object instance
        node : Node object instance of search module
        
        Returns
        -------
        Generator of node objects that refers to the sequence of children nodes
    """
    ########### ADD YOUR CODE HERE BELOW ####################
    if node.state not in problem._reachedlist:
        problem._reached[node.state] = True
        problem._reachedlist.append(node.state)
        problem._expanded += 1

    for tempNode in node.expand(problem):
        if tempNode not in node.path() and tempNode.state not in problem._reachedlist:
            yield tempNode
    #########################################################
 #       yield Node(s1, node, action, cost)   # this line of code can be uncommented and used


def depth_first_search(problem):
    """ Execute depth-first search for search problem "problem". Returns node
    at the end of search tree (which contains path information by following
                               search tree back up to the root, cf. Node class)
    Parameters
    ----------
    problem : SearchProblem object
    
    Returns
    -------
    node : Node object
    """
    ########### ADD YOUR CODE HERE BELOW ####################
    stack = LIFOQueue()
    parentNode = Node(problem.initial)
    stack.append(parentNode)
    while (len(stack) > 0):
        node = stack.pop()
        if (problem.goal_test(node.state)):
            return node
        for tempNode in expand(problem, node):
            stack.append(tempNode)
    return failure
    #########################################################
    # return node   # this line of code can be uncommented and used

def breadth_first_search(problem):
    """ Execute breadth-first search for search problem "problem". Returns node
    at the end of search tree (which contains path information by following
                               search tree back up to the root, cf. Node class)
    Parameters
    ----------
    problem : SearchProblem object
    
    Returns
    -------
    node : Node object
    """
    ########### ADD YOUR CODE HERE BELOW ####################
    queue = FIFOQueue()
    parentNode = Node(problem.initial)
    queue.append(parentNode)
    while (len(queue) > 0):
        node = queue.popleft()
        if(problem.goal_test(node.state)):
            return node
        for tempNode in expand(problem, node):
            if tempNode not in queue:
                queue.append(tempNode)
    return failure
    ########################################################
    # return node   # this line of code can be uncommented and used

def greedy_first_search(problem, h):
    """ Execute greedy best-first search for search problem "problem" with
    with heuristics function h. Returns node at the end of search tree (
            which contains path information by following search tree back up 
            to the root, cf. Node class)
    Parameters
    ----------
    problem : SearchProblem object
    h : Function that maps Node objects to its value of a heuristics function
    
    Returns
    -------
    node : Node object
    """
    ########### ADD YOUR CODE HERE BELOW ####################
    pQueue = PriorityQueue(key=h)
    parentNode = Node(problem.initial)
    pQueue.add((parentNode))
    while (pQueue.top()):
        node = pQueue.pop()
        if(problem.goal_test(node.state)):
            return node
        for tempNode in expand(problem, node):
            pQueue.add(tempNode)
    return failure
    ########################################################
    # return node   # this line of code can be uncommented and used

def astar_search(problem, h):
    """ Execute A* search for search problem "problem" with
    with heuristics function h. Returns node at the end of search tree (
            which contains path information by following search tree back up 
            to the root, cf. Node class)
    Parameters
    ----------
    problem : SearchProblem object
    h : Function that maps Node objects to its value of a heuristics function
    
    Returns
    -------
    node : Node object
    """
    ########### ADD YOUR CODE HERE BELOW ####################
    pQueue = PriorityQueue(key=lambda x: h(x) + x.path_cost)
    parentNode = Node(problem.initial)
    pQueue.add((parentNode))
    while (pQueue.top()):
        node = pQueue.pop()
        if(problem.goal_test(node.state)):
            return node
        for tempNode in expand(problem, node):
            pQueue.add(tempNode)
    return failure
    ########################################################
    # return node   # this line of code can be uncommented and used