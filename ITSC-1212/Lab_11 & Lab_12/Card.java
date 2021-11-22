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

    public String getSuit() {     //Returns value of the card's Suit
        return suit;
    }

    public int getVal(boolean isBlackjack) {    //Returns value of the card's number
        if (!isBlackjack) {
            return val;
        }
        else {
            if (val > 10)
                return 10;
            else
                return val;
        }
    }

    public boolean equals(Card c) {             //Returns if cards are exact matches
        return (this.suit.equals(c.getSuit()) && this.val == c.getVal(false));  //Simply checks if both cards have same suit and numerical value
    }

    public String declareCard() {
        switch(val) {                           //Prints out the formatted name of the card
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

    public String toString() {                      //Prints out object into String for debug purposes
        return suit.charAt(0) + "" + val;
    }
}
