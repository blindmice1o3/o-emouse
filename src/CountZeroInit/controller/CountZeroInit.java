package CountZeroInit.controller;

import CountZeroInit.model.creatures.Humanoid;
import CountZeroInit.model.creatures.Monster;
import CountZeroInit.model.map.ForestMap;

public class CountZeroInit {
    public static void main (String[] args) {
        GameboyColor gb = new GameboyColor(new ForestMap());
        Humanoid player1 = gb.getPlayer1();
        Monster monster1 = (Monster)gb.getLifeFormsOnBoard().get(0);

        System.out.println("Current game state: " + gb.getCurrentState());

        System.out.println("Monster1's Col, Row: " + monster1.getCol() + ", " + monster1.getRow());
        System.out.println("Player1's Col, Row: " + player1.getCol() + ", " + player1.getRow());
        System.out.println("Player1's inventory: " + player1.getInventory());
        System.out.println("Player1's myMonsterList: " + player1.getMyMonsterList());

        gb.getCurrentState().startButtonPressed();
        System.out.println("Current game state: " + gb.getCurrentState());

        gb.getCurrentState().upButtonPressed();
        gb.getCurrentState().rightButtonPressed();
        gb.getCurrentState().rightButtonPressed();

        System.out.println("Monster1's Col, Row: " + monster1.getCol() + ", " + monster1.getRow());
        System.out.println("Player1's Col, Row: " + player1.getCol() + ", " + player1.getRow());

    }
}



