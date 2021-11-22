import java.util.Scanner;

public class GameSelection {
    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        int choice = 03;
        BlackJack blackjack = new BlackJack();
        HighLowGame highLow = new HighLowGame();

        System.out.println("Welcome to Grand Sierra Resort's Online Card Game Simulator!");
        do {
            System.out.print("Which game would you like to play?\n(1 for HighLow, 2 for Blackjack, anything else to quit): ");
            choice = input.nextInt();
            input.nextLine();

            if (choice == 1)
                highLow.playGame();
            else if (choice == 2)
                blackjack.playGame();
        } while (choice == 1 || choice == 2);
        System.out.println("Have a nice day!");
        input.close();
    }
}