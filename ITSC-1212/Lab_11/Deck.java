public class Deck {

    public Card drawCard() {    //Draws completely random card
        String suit;
        int suitVal = (int)((Math.random() * 4) + 1);
        switch(suitVal) {
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

        return new Card(suit, (int)((Math.random() * 13) + 1));
    }
}