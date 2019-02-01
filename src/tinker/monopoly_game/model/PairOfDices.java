package tinker.monopoly_game.model;

public class PairOfDices {

    private int dice1;
    private int dice2;
    private boolean isPair;

    public PairOfDices() {
        dice1 = 1;
        dice2 = 1;
        isPair = false;
    } // **** end PairOfDices() constructor ****

    public int rollPairOfDices() {
        dice1 = (int)((Math.random()*6)+1);
        dice2 = (int)((Math.random()*6)+1);

        if (dice1 == dice2) {
            isPair = true;
        } else { isPair = false; }

        System.out.println( dice1 + " and " + dice2 +
                            "\nisPair: " + isPair +
                            "\nsum of pair: " + (dice1 + dice2) );

        return dice1+dice2;
    }

    public int getDice1() {
        return dice1;
    }

    public int getDice2() {
        return dice2;
    }

    public boolean getIsPair() {
        return isPair;
    }

} // **** end PairOfDices class ****
