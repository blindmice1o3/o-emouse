package Tinker.deck_of_cards;

import java.util.ArrayList;
import java.util.List;

public class DeckOfCards {
    List<Card> deck;

    public DeckOfCards() {

        deck = new ArrayList<Card>(52);

    } // end DeckOfCards constructor

    public void initDeckOfCards() {

        for (Rank rank: Rank.values()) {
            for (Suit suit: Suit.values()) {
                deck.add( new Card(rank, suit) );
            }
        }

    } // end initDeckOfCards()

    public void checkDeckOfCards() {

        int cardNumber = 1;
        for (Card card: deck) {
            System.out.println( "Card number " + cardNumber + ": (" + card.getRank() + ", " + card.getSuit() + ")" );
            cardNumber++;
        }

    } // end checkDeckOfCards()

    public static void main(String[] args) {

        DeckOfCards deckOfCards = new DeckOfCards();
        deckOfCards.initDeckOfCards();
        deckOfCards.checkDeckOfCards();

    } // end main(String[])

} // end DeckOfCards class
