import java.util.Scanner;

public class MagpieDriver{
/**
 * Create a Magpie, give it user input, and print its replies.
 */

 //Responses(#6 on lab)
 //"no" = "Why so negative?"
 //"mother" = "Tell me more about your family."
 //"" = *Random response*
 //If keywords are in otherwords, then it still identifies them as their own words. It sees "mother" in "smother" and "no" in "know"
    public static void main(String[] args) {
        MagPie maggie = new MagPie();

        System.out.println(maggie.getGreeting());
        Scanner in = new Scanner(System.in);
        String statement = in.nextLine();

        while (!statement.equalsIgnoreCase("Bye")) {
            System.out.println(maggie.getResponse(statement));
            statement = in.nextLine();
        }
        System.out.println("Goodbye!");

        in.close();         //Just adding to remove that obnoxious warning...
    }
}

