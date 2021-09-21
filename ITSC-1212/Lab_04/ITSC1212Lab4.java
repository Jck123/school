import java.util.Scanner;

public class ITSC1212Lab4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        //Part A

        /*System.out.print("State your name: ");
        String name = input.nextLine().toUpperCase();
        System.out.println("Welcome to ITSC1212, " + name);
        */

        String welcomeMessage = "Welcome to ITSC1212";
        String name = "james";

        String message = (welcomeMessage + " " + name).toUpperCase();

        System.out.println(message);
        System.out.println("The length of this message is: " + message.length());
        System.out.println("The word 'to' is located at index: " + message.indexOf("to"));

        //8
        //The method RETURNS the uppercase string, doesn't change the input
        //The input is immutable within the method

        //15
        //Yes, because you are setting the name to be the uppercase version
        //of itself, the change is occurring OUTSIDE of the method.

        //Part B

        //Math.random()
        //Generates a random number between 0 to 1

        //Math.abs(int)
        //Returns absolute value of an integer

        //Math.pow(double, double)
        //Returns first double to the power of the second double

        //Math.sqrt(double)
        //Returns square root of the double value provided

        //Math.random()                 range: 0 to 1
        //(int)Math.random()            range: 0
        //(int) (Math.random() * 5)     range: 0 to 4
        //(int) (Math.random() * 2)     range: 0 to 2
        //(int) (Math.random() * 9 + 1) range: 1 to 9

        input.close();
    }
}
