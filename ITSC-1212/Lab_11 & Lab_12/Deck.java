import java.util.ArrayList;

public class Deck {

    private ArrayList<Card> deck = new ArrayList<Card>();       //Yeah, I know this isn't in the cirriculum, but this class is cooler now
    private int numOfDecks;

    public Deck() {                     //Creates a single deck of cards
        numOfDecks = 1;                 //One of each card, resulting in a proper 52 card deck
        resetDeck();
    }

    public Deck(int numOfDecks) {       //Creates multiple decks of cards and puts them in one big one
        this.numOfDecks = numOfDecks;
        resetDeck();
    }

    public Card drawCard() {            //Draws a single random card and removes it from the deck
        Card c = deck.get((int)(Math.random() * deck.size()));
        deck.remove(c);
        return c;
    }

    public Card drawCard(Card card) {   //Draws a single specific card and removes it from the deck
        int cardIndex = this.indexOf(card);
        if (cardIndex == -1)
            return null;
        Card c = deck.get(cardIndex);
        deck.remove(c);
        return c;
    }

    public void addCard(Card card) {        //Adds card to deck
        deck.add(card);
    }

    public int indexOf(Card card) {         //Searches for a card based on suit and value
        for (Card c : deck) {               //Note: CANNOT JUST USE deck.indexOf(), the card objects are technically different objects in this instance
            if (c.equals(card))             //because their references, not values, are being compared
                return deck.indexOf(c);
        }
        return -1;
    }

    public Card getCard(int index) {        //Just looks at a single card at specified location
        return deck.get(index);
    }

    public int size() {
        return deck.size();
    }

    public void sort() {                                                //Sorts the deck, mostly used for Blackjack, but could also be used for poker
        ArrayList<Card> tempList = new ArrayList<Card>(deck.size());
        ArrayList<Card> acesList = new ArrayList<Card>();               //Two array lists to sort with because aces are valued at 1 here
        for (int i = 1; i <= 13; i++) {                                 //Counts the cards up by one group at a time
            for (Card c : deck) {
                if (c.getVal(false) == i)                               //If the card matches the number we're currently searching for, then it goes in the ordered list
                    if (i == 1)                                         //If the matched card is 1, then it goes into the aces
                        acesList.add(c);
                    else                                                //All other cards go here
                        tempList.add(c);
            }                                                           //Honestly, this sorting method here is probably NOT the most effecient, but I wanted ANY solution at this point
        }
        if(!acesList.isEmpty())
            for(Card c : acesList)                                      //If there ARE any aces, then the aces are added to the end of the temp list
                tempList.add(c);
        deck.clear();                                                   //Original deck is erased and remade using the temp list
        deck.addAll(tempList);
    }

    public int getVal(boolean isBlackjack) {            //Calculates the value of the deck, mostly used for Blackjack purposes
        int deckVal = 0;                                //But is still open for other uses

        if (!isBlackjack) {
            for (Card c : deck)
                deckVal += c.getVal(false);
        }
        else {
            this.sort();
            for (Card c : deck) {
                if (c.getVal(true) == 1 && (deckVal + 11 < 22)) //Checks if the current card is both an ace and if so, if that card
                    deckVal += 11;                              //can be an 11 without busting
                else
                    deckVal += c.getVal(true);
            }
        }
        return deckVal;
    }

    public void resetDeck() {                   //Used after each round of a game
        deck.clear();
        String suit;                            //Generates the deck in wholes, adding each card to the arraylist

        for (int i = 1; i <= numOfDecks; i++) {
            for (int j = 1; j <= 4; j++) {
                switch(j) {
                    case 1:
                        suit = "Hearts";
                        break;
                    case 2:
                        suit = "Diamonds";
                        break;
                    case 3:
                        suit = "Clubs";
                        break;
                    case 4:
                        suit = "Spades";
                        break;
                    default:
                        suit = "";
                        break;
                }
                for (int k = 1; k <= 13; k++) {
                    deck.add(new Card(suit, k));
                }
            }
        }
    }

    public String declareDeck() {                   //Converts object into a formatted string for display purposes
        String output = "";
        for(Card c : deck)
            output += c.declareCard() + ", ";
        if (!output.isEmpty())
            output = output.substring(0, output.length() - 2);
        return output;
    }

    public String toString() {                      //Converts object to String for debug purposes
        int i = 0;
        String output = "";
        for (Card c : deck) {
            output += c.toString() + " ";
            i++;
            if (i == 30) {
                output += "\n";
                i = 0;
            }
        }
        return output;
    }
}