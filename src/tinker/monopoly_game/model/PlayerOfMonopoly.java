package tinker.monopoly_game.model;

public class PlayerOfMonopoly {

    private int currentBoardPosition;
    private String name;
    private String imageAddress;

    public PlayerOfMonopoly() {
        currentBoardPosition = 0;
        name = "player1";
        imageAddress = "src/count_zero_init/model/icons/fish_gold_flying_hellfish(simpsons).png";
    }

    public PlayerOfMonopoly(String name) {
        super();

        this.name = name;
    } // **** end PlayerOfMonopoly() constructor ****

    public int getCurrentBoardPosition() {
        return currentBoardPosition;
    }

    public void setCurrentBoardPosition(int newPosition) {
        currentBoardPosition = newPosition;
    }

    public String getName() {
        return name;
    }

    public String getImageAddress() {
        return imageAddress;
    }

} // **** end PlayerOfMonopoly class ****
