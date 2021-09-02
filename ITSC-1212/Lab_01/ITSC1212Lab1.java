import java.util.Scanner;

public class ITSC1212Lab1 {
    public static void main(String Args[]) {
        //System.out.print("Hello, ");
        //System.out.println("World!");

        //Part C
        /*int x = 5;
        System.out.println("The value of x");
        System.out.println(x);
        System.out.println("The value of x + 2");
        System.out.println(x + 2);
        System.out.println("The value of x * x");
        System.out.println(x * x);
        System.out.println("The value of x / 2");

        double y = x / 2.0;
        System.out.println(y);*/

        //Part E
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a temperature in F.");
        double tempF = input.nextDouble();
        System.out.println("The value entered was " + tempF);
        double tempC = (tempF - 32) * (5.0 / 9.0);
        System.out.println("The temperature in C is: " + tempC);
    }
}