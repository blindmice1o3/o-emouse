package tinker.enum_practice.deck_of_cards;

/*
Each enum constant is declared with values for the mass and radius parameters. These values are passed to the
constructor when the constant is created. Java requires that the constants be defined first, prior to any fields or
methods. Also, when there are fields and methods, the list of enum constants must end with a semicolon.

Note: The constructor for an enum type must be package-private or private access. It automatically creates the constants
that are defined at the beginning of the enum body. You cannot invoke an enum constructor yourself.

In addition to its properties and constructor, Planet has methods that allow you to retrieve the surface gravity and
weight of an object on each planet. Here is a sample program that takes your weight on earth (in any unit) and
calculates and prints your weight on all of the planets (in the same unit)
 */

public enum Suit {
    // Java requires that the constants be defined first, prior to any fields or methods.

        // The constants:
    DIAMONDS    (1, "Diamonds"),
    CLUBS       (2, "Clubs"),
    HEARTS      (3, "Hearts"),
    SPADES      (4, "Spades");
    // Also, when there are fields and methods, the list of enum constants must end with a semicolon.

        // The fields:
    private final int value;
    private final String text;

        // The constructors:
    Suit(int value, String text) {
        this.value = value;
        this.text = text;
    }

        // The methods:
    public int getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

} // end Suit enum
