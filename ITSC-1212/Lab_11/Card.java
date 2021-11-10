public class Card {
    private String suit;
    private int val;
    
    public Card() {         //Default constructor
        suit = "Clubs";
        val = 1;
    }

    public Card(String initSuit, int initVal) { //Constructor
        this.suit = initSuit;
        this.val = initVal;
    }

    public String GetSuit() {     //Returns value of the card's Suit
        return suit;
    }

    public int GetVal() {      //Returns value of the card's number
        return val;
    }

    public String declareCard() {
        switch(val) {               //Prints out the formatted name of the card
            case 1:
                return "the Ace of " + suit;
            case 11:
                return "the Jack of " + suit;
            case 12:
                return "the Queen of " + suit;
            case 13:
                return "the King of " + suit;
            default:
                return "the " + val + " of " + suit;
        }
    }
}
