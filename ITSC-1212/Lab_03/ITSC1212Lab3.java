import java.awt.Color;

public class ITSC1212Lab3 {
    public static void main(String[] args) {
        
        World w = new World(500, 500);
        Turtle tom = new Turtle(w);
        
        //Part C

        //Creates a green hexagon centered top right of tom
        tom.setPenColor(Color.green);
        tom.hexagon();
        //Creates a cyan hexagon centered bottom right of tom
        tom.turnRight();
        tom.setPenColor(Color.cyan);
        tom.hexagon();
        //Creates a magenta hexagon centered bottom left of tom
        tom.turnRight();
        tom.setPenColor(Color.magenta);
        tom.hexagon();
        //Creates a light gray hexagon centered top left of tom
        tom.turnRight();
        tom.setPenColor(Color.lightGray);
        tom.hexagon();

        //Part A & B

        /*Turtle tom = new Turtle(100, 250, w);
        tom.forward();
        //Moves tom forward 100 pixels
        tom.turn(270);
        tom.penUp();
        //Turns tom so he face left in a less efficient way, then moves the pen up
        tom.forward(50);
        //Moves tom forward 50 pixels
        tom.turn(180);
        tom.penDown();
        tom.forward();
        //Turns tom around so he faces right, puts the pen down, and draws
        //a line 100 pixels long
        tom.penUp();
        tom.forward(90);
        //Sets tom in place to draw an O
        tom.penDown();
        tom.turnRight();
        tom.forward();
        //Puts pen down and draws right line of O
        tom.turnRight();
        tom.forward(75);
        //Draws bottom of O
        tom.turnRight();
        tom.forward();
        //Draws left side of O
        tom.turnRight();
        tom.forward(75);
        tom.penUp();
        //Draws top of O and puts pen up
        tom.forward(15);
        tom.turn(45);
        tom.penDown();
        tom.forward(50);
        //Draws left half of top part of M
        tom.turnLeft();
        tom.forward(50);
        //Draws right half of top part of M
        tom.turn(135);
        tom.forward();
        //Draws right "leg" of M
        tom.penUp();
        tom.turnRight();
        tom.forward(71);
        tom.penDown();
        tom.turnRight();
        tom.forward();
        //Moves tom to other side of M and draws left "leg" of M

        */

        //4
        //World w does not need any arguments because it has an empty default constructor
        //Meanwhile, Turtle tom needs to fit the arguments of one of the constructors, at minimum is the world variable
        //Turtle tom essentially needs to know what world to exist in or it just won't work

        //6
        //The window is significantly smaller and the turtle moves forward as far as it can go
        //Also, for some reason, the run button seems to run my code then exit immediately, but debug leaves the window up for me


    }
}
