import java.util.Scanner;
import java.awt.Color;

public class ITSC1212Lab8 {
    
    static int randomX = (int)(Math.random() * 100) * 5;
    static int randomY = (int)(Math.random() * 100) * 5;
    static World w = new World(500,500);

    public static void main(String[] args) throws InterruptedException{
        Turtle tom = new Turtle(randomX, randomY, w);
        Scanner input = new Scanner(System.in);
        boolean easyMode = false;                   //True if user says yes to easy mode, false otherwise
        boolean correctX = false;                   //True if user gets the right number or is within range if in easy mode
        boolean correctY = false;
        
        tom.setVisible(false);                      //Conceals Tom's presence

        System.out.print("Hello! Welcome to Find Turtle Tom!\nWould you like to play easy mode(Y/N): ");
        char in = input.next().charAt(0);
        if (in == 'Y' || in == 'y')                 //Asks player if they want to do easy mode, has failsafe if user puts invalid answer
            easyMode = true;
        else if (in == 'N' || in == 'n')
            easyMode = false;
        else
            System.out.println("Invalid response detected, defaulting to standard mode\n");

        System.out.print("Enter a guess for the X position of Turtle Tom: ");
        int guessX = input.nextInt();

        System.out.print("Enter a guess for the Y position of Turtle Tom: ");
        int guessY = input.nextInt();                  //Initial guesses

        //System.out.println("Turtle Tom is at: " + randomX + ", " + randomY);
        while(!correctX || !correctY) {                 //Loops until BOTH X and Y are correctly guessed
            if (guessX > randomX) {                     //Checks if guessed X was higher or lower than the answer
                System.out.println("Your X position is too high!");
                if (guessX <= (randomX + 20) && easyMode) {     //Checks if easy mode is activated and if so, if within range
                    System.out.println("But that's close enough");
                    correctX = true;
                } else {
                    colorGuessX(guessX);                //If user failed to get the correct guess, colors in range that it turtle can't be in
                    System.out.print("Please enter a new guess for X: ");
                    guessX = input.nextInt();
                }
            } else if (guessX < randomX) {
                System.out.println("Your X position is too low!");
                if (guessX >= (randomX - 20) && easyMode) {
                    System.out.println("But that's close enough");
                    correctX = true;
                } else {
                    colorGuessX(guessX);
                    System.out.print("Please enter a new guess for X: ");
                    guessX = input.nextInt();
                }
            } else {                                    //If user was spot on with their guess
                System.out.println("Your X position is correct");
                correctX = true;
            }
            
            if (guessY > randomY) {                     //Same exact code as above, but with the Y coordinate
                System.out.println("Your Y position is too high!");
                if (guessY <= (randomY + 20) && easyMode) {
                    System.out.println("But that's close enough");
                    correctY = true;
                } else {
                    colorGuessY(guessY);
                    System.out.print("Please enter a new guess for Y: ");
                    guessY = input.nextInt();
                }
            } else if (guessY < randomY) {
                System.out.println("Your Y position is too low!");
                if (guessY >= (randomY - 20) && easyMode) {
                    System.out.println("But that's close enough");
                    correctY = true;
                } else {
                    colorGuessY(guessY);
                    System.out.print("Please enter a new guess for Y: ");
                    guessY = input.nextInt();
                }
            } else {
                System.out.println("Your Y position is correct");
                correctY = true;
            }
            System.out.print("\n");         //Cleans up output a bit
        }
        System.out.println("You found Turtle Tom!");
        tom.setVisible(true);               //You did it!
        input.close();
    }

    public static void colorGuessY(int y) {
        Turtle jen = new Turtle(w);
        jen.penUp();
        jen.setVisible(false);
        jen.setPenColor(Color.black);

        if (y > randomY) {                  //Colors in area the turtle cannot be in, one line at a time
            for (int i = y; i <= 500; i++) {
                jen.moveTo(0,i);
                jen.penDown();
                jen.setHeading(90);
                jen.forward(499);
                jen.penUp();
            }
        } else {
            for (int i = y; i >= 0; i--) {
                jen.moveTo(0, i);
                jen.penDown();
                jen.setHeading(90);
                jen.forward(499);
                jen.penUp();
            }
        }
    }
    
    public static void colorGuessX(int x) throws InterruptedException {
        Thread.sleep(10);
        Turtle jen = new Turtle(w);
        jen.penUp();
        jen.setVisible(false);
        jen.setPenColor(Color.black);

        if (x > randomX) {                  //Same code as above, but with X coordinates
            for (int i = x; i <= 500; i++) {
                jen.moveTo(i, 0);
                jen.penDown();
                jen.setHeading(180);
                jen.forward(499);
                jen.penUp();
            }
        } else {
            for (int i = x; i >= 0; i--) {
                jen.moveTo(i, 0);
                jen.penDown();
                jen.setHeading(180);
                jen.forward(499);
                jen.penUp();
            }
        }
    }
}


//11a. A while loop is better suited because it will run infinitely until a certain condition is met
//a for loop can do the same thing, but it revolves around a specific number and is better suited
//for loops where an incrementing or decrementing number is vital to the loop, like a summation in math

//11b. If we are to use an AND in the loop, then the loop will cancel out when only ONE of the
//answers are correct. When we use an OR, then both X and Y must be accurate. However, we can use
//an AND if we just change the statement to be if X AND Y are NOT true as seen below
//if(!(guessX == randomX && guessY == randomY))