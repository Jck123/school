import java.util.Scanner;

public class Business {
    
    public static String businessName = "James' Cookie Bakery";
    public static String ownerName = "James";
    public static String[] menu = {"Chocolate Chip", "Snickerdoodle", "Cinnamon Roll", "Peanut Butter", "Sugar Cookie", "Gingerbread"};
    public static int menuSize = menu.length;
    public static void main(String[] args) throws InterruptedException {
        String decorativeLine = "#########################################################";
        String customerName = "";                       //Keeps the customer's name
        int[] customerOrder = new int[10];              //Keeps the customer's order numbers
        String customerLine = "";                       //Keeps the customer's order(but held as a single string)
        Scanner input = new Scanner(System.in);
        int choice = 0;                                 //Input holder

        System.out.println(decorativeLine);
        System.out.println("Welcome to " + businessName);
        Thread.sleep(750);                                  //Intro and name getting
        System.out.print("My name is " + ownerName + ". What's your name? ");
        customerName = input.nextLine();
        Thread.sleep(750);
        System.out.println("Hey there, " + customerName + "!\n");
        Thread.sleep(750);                                      //Introduction of menu
        System.out.println("Here's the cookies we're selling this week. Take a look, " + customerName + ":");
        Thread.sleep(750);
        System.out.println("-----------Menu----------");
        for (int i = 0; i < menu.length; i++) {     //Why would I use a for each loop if I need to include a number??
            System.out.println("| " + (i + 1) + " - " + menu[i] + "\t|");
        }
        System.out.println("-------------------------");
        Thread.sleep(1000);
        System.out.println("What would you like to order today?\n(You may enter up to 10 items; Please enter items in by number; Enter -1 when you are done)");
        for(int i = 0; i < 10; i++) {
            System.out.print("Enter item #" + (i + 1) +":");        //Getting order from customer
            choice = input.nextInt();
            if (choice == -1) {                         //Stops loop if customer doesn't want all 10 cookies
                customerOrder[i] = -1;
                break;
            }
            else if (choice > 0 && choice < 7)          //Keeps customer's input within parameters
                customerOrder[i] = choice - 1;
            else {
                System.out.println("Invalid input! Please Try again");
                i--;
            }
        }
        System.out.println("Thank you for ordering! Your cookies will be ready in a second");
        Thread.sleep(1000);                             //Waits a literal second
        System.out.println(customerName + "! Your order is ready!");
        for(int i : customerOrder) {
            if (i == -1)                                //Order is ready and given to customer
                break;
            customerLine += menu[i] + ", ";
        }
        customerLine = customerLine.substring(0, customerLine.length() - 2);
        Thread.sleep(750);
        System.out.println("Your order is: " + customerLine);
        Thread.sleep(750);
        System.out.println("Thank you and have a nice day!");       //Bye :)

        System.out.println(decorativeLine);
        input.close();
    }
}