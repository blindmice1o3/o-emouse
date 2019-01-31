package tinker.monopoly_game.model;

public class PairOfDices {

    private int dice1;
    private int dice2;

    public PairOfDices() {
        dice1 = 1;
        dice2 = 1;
    } // **** end PairOfDices() constructor ****

    public void rollPairOfDices() {
        dice1 = (int)((Math.random()*6)+1);
        dice2 = (int)((Math.random()*6)+1);
        boolean isPair = (dice1 == dice2);

        System.out.println( dice1 + " and " + dice2 +
                            "\nisPair: " + isPair +
                            "\nsum of pair: " + (dice1 + dice2) );
    }

} // **** end PairOfDices class ****
