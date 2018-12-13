package Tinker.deck_of_cards;

public class CardTest {

    public static void main(String[] args) {

        // displays each value of the Rank enum on one row with a ", " separator inbetween the values unless it's
        // the last value of the Rank enum (in which case, it inserts a new line).
        int countRank = 0;
        int lengthRankEnum = Rank.values().length;
        for (Rank rank: Rank.values()) {
            countRank++;
            System.out.print( rank + " (" + rank.getValue() + ", " + rank.getText() + ")" );
            if (countRank != lengthRankEnum) {
                System.out.println(", ");
            } else {
                System.out.println("\n");
            }
        }


        System.out.println("***************************************************");


        // displays each value of the Suit enum on one row with a ", " separator inbetween the values unless it's
        // the last value of the Suit enum (in which case, it inserts a new line).
        int countSuit = 0;
        int lengthSuitEnum = Suit.values().length;
        for (Suit suit: Suit.values()) {
            countSuit++;
            System.out.print( suit + " (" + suit.getValue() + ", " + suit.getText() + ")" );
            if (countSuit != lengthSuitEnum) {
                System.out.println(", ");
            } else {
                System.out.println("\n");
            }
        }

    } // end main()

} // end CardTest class
