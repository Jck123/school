import java.util.Scanner;

public class HighLowGame {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Scanner input = new Scanner(System.in);
        boolean playGame = true;
        int choice;         //Yes/no input from user
        int wins = 0;
        int losses = 0;
        int gamesPlayed = 0;
        Card card2;

        Card card1 = deck.drawCard();

        while (playGame) {
            System.out.println("The first card is " + card1.declareCard());
            System.out.println("Will the next card be higher or lower?\n(Enter '1' for higher, and '2', for lower)");

            choice = input.nextInt();
            card2 = deck.drawCard();
            System.out.println("The next card is " + card2.declareCard());

            boolean higher = card2.GetVal() > card1.GetVal();       //Checks if card2 is higher
            if (card1.GetVal() == card2.GetVal())                   //Checks if values are equal
                System.out.println("Both cards were the same value. Tie game!");    //Tie
            else if ((higher && choice == 2) || !higher && choice == 1) {
                System.out.println("Winner!");                      //Win condition
                wins++;
            }
            else {                                                  //Lose condition
                System.out.println("Loser...");
                losses++;
            }
            gamesPlayed++;
            card1 = card2;                                          //Resets card1 to be card2
            System.out.print("Would you like to keep playing?(2 for no, and any other number for yes): ");
            choice = input.nextInt();
            if (choice == 2)                                        //Checks if user wants to keep playing
                playGame = false;
            
        }
        System.out.println("GAME STATS:\nWINS: " + wins             //User is done playing and prints stats
                                + "\nLOSSES: " + losses
                                + "\nTOTAL GAMES: " + gamesPlayed
                                + "\nWINRATE: " + ((double)wins / (double)gamesPlayed));
        input.close();
    }
}
