import java.util.Scanner;

public class BlackJack {
    public void playGame() throws InterruptedException{
        Deck deck = new Deck();
        Deck playerHand = new Deck(0);                      //Creates decks with 0 cards for the player and dealer
        Deck dealerHand = new Deck(0);
        Scanner input = new Scanner(System.in);
        int choice = 0;

        System.out.println("Welcome to the Blackjack program!");

        while (choice != 1) {                               //Keeps going as long as the player doesn't answer the prompt at the end with '1'
            playerHand.addCard(deck.drawCard());
            System.out.print("Your first card is... ");     //Adds a slight pause so it's a bit easier to follow and adds some slight suspense too
            Thread.sleep(500);
            System.out.println(playerHand.getCard(0).declareCard());
            playerHand.addCard(deck.drawCard());
            System.out.print("Your second card is... ");   //Revealing each card seperately also adds some slight suspense/excitement
            Thread.sleep(500);
            System.out.println(playerHand.getCard(1).declareCard());
            Thread.sleep(300);
            System.out.println("Your cards total out to " + playerHand.getVal(true));
            if (playerHand.getVal(true) == 21 && dealerHand.getVal(true) == 21)     //Both get Blackjack
                System.out.println("Both house and player got blackjack. Draw!");
            else if (playerHand.getVal(true) == 21)                                 //Player gets Blackjack
                System.out.println("Blackjack!");
            else if (dealerHand.getVal(true) == 21)                                 //House gets Blackjack
                System.out.println("House got blackjack, you lose");
            else {                                                                  //Nobody gets blackjack, normal game
                dealerHand.addCard(deck.drawCard());
                dealerHand.addCard(deck.drawCard());
                System.out.print("The dealer's hand is showing... ");
                Thread.sleep(500);                                                  //Only shows one of the dealer's cards because that's how Blackjack works
                System.out.println(dealerHand.getCard(0).declareCard());            //(We don't cut corners here)

                while (playerHand.getVal(true) < 22) {                              //Runs as long as the player doesn't bust
                    System.out.print("What would you like to do for your next turn?\n(1 for hit, 2 for stand): ");
                    choice = input.nextInt();

                    if (choice == 2)                                                //Player stands(breaks loop)
                        break;
                    else if (choice == 1) {                                         //Player hits
                        playerHand.addCard(deck.drawCard());
                        System.out.print("Your next card is... ");
                        Thread.sleep(500);
                        System.out.println(playerHand.getCard(playerHand.size() - 1).declareCard());
                        Thread.sleep(300);
                        System.out.println("Your total is at " + playerHand.getVal(true));
                    } else                                                          //Player is a cretin who can't follow instructions
                        System.out.println("Invalid input, please try again");
                }
                if (playerHand.getVal(true) > 21)                                   //Player busts
                    System.out.println("Player has busted, you lose");
                else {                                                              //Player doesn't busts and stands(dealer's turn)
                    System.out.println("The dealer has... " + dealerHand.declareDeck() + "\nThe dealer has " + dealerHand.getVal(true));
                    while (dealerHand.getVal(true) < 17) {                          //Keeps going until house hits 17 or higher(as rules state)
                        dealerHand.addCard(deck.drawCard());
                        System.out.print("The dealer has drawn a... ");
                        Thread.sleep(500);
                        System.out.println(dealerHand.getCard(dealerHand.size() - 1).declareCard());
                        Thread.sleep(300);
                        System.out.println("The dealer has " + dealerHand.getVal(true));
                    }
                    Thread.sleep(500);                                              //Slight pause again to just help with flow
                    if (dealerHand.getVal(true) > 21)                               //Dealer busts
                        System.out.println("The dealer has busted, player wins!");
                    else if (dealerHand.getVal(true) == playerHand.getVal(true))    //Draw condition
                        System.out.println("Both player and dealer tie, draw!");
                    else if (dealerHand.getVal(true) > playerHand.getVal(true))     //House wins
                        System.out.println("Dealer wins!");
                    else                                                            //Player wins
                        System.out.println("Player wins!");
                        
                }
            }
            deck.resetDeck();                                                       //Resets every deck for new game
            playerHand.resetDeck();
            dealerHand.resetDeck();
            System.out.println("Would you like to play again?\n(1 for 'No' and anything else for 'Yes')");
            choice = input.nextInt();
        }
        System.out.println("Thanks for playing!");
    }
}