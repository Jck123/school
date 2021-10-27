public class TurtleCheckerboard {
    public static void main(String[] args) {
        int a = 4;  //Rows
        int b = 4;  //Columns       Decided to add some of my own finesse

        World w = new World((b * 100) + 100, (a * 100) + 100);  //Determines size of world
        Turtle tom = new Turtle(w);                             //based on how many squares are needed
        /*tom.penUp();          //Unnecessary
        tom.moveTo(50,50);
        tom.setHeading(0);
        tom.penDown();*/

        for (int y = 0; y < a; y++) {
            for (int x = 0; x < b; x++) {       //Moves turtle to specifically calculated
                tom.penUp();                    //calculated coordinates based on loop values
                tom.moveTo((x * 100) + 50, (y * 100) + 50);
                tom.penDown();
                tom.drawSquare();               //Draws a square
            }
        }
        tom.setVisible(false);                  //Hides turtle after all is done
    }
}
