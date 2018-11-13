package CountZeroInit.controller;

import CountZeroInit.model.map.ForestMap;

public class GameboyColor {
    public static void main (String[] args) {
        CountZeroInit countZeroInit = new CountZeroInit(new ForestMap());

        // Currently, the game starts off by default with currentGameState set to GameState.
        System.out.println("Current game state: " + countZeroInit.getCurrentState());

        // The player in ForestMap starts with position (1, 4), with 3 Items in myInventory, and 2 Monsters in myMonsterList.
        System.out.println("Player1's current position: (" + countZeroInit.getPlayer1().getCol() + ", " + countZeroInit.getPlayer1().getRow() + ")");
        System.out.println("Player1's inventory: " + countZeroInit.getPlayer1().getInventory());
        System.out.println("Player1's myMonsterList: " + countZeroInit.getPlayer1().getMyMonsterList());

        // The CountZeroInit's upButtonPressed() is called to change the player's row variable to decrement by two and
        // column increment by two (3, 2).
        countZeroInit.getCurrentState().upButtonPressed();
        countZeroInit.getCurrentState().upButtonPressed();
        countZeroInit.getCurrentState().rightButtonPressed();
        countZeroInit.getCurrentState().rightButtonPressed();
        System.out.println("Player1's current position: (" + countZeroInit.getPlayer1().getCol() + ", " + countZeroInit.getPlayer1().getRow() + ")");

        /*
        // The CountZeroInit's startButtonPressed() is called to change the currentGameState to StartMenuState, then is
        // navigated to call the Command for ItemListStateCommand (which sets currentGameState to ItemListState).
        countZeroInit.getCurrentState().startButtonPressed();
        countZeroInit.getCurrentState().downButtonPressed();
        countZeroInit.getCurrentState().downButtonPressed();
        countZeroInit.getCurrentState().aButtonPressed();
        */

        /*
        Humanoid player1 = countZeroInit.getPlayer1();
        Monster monster1 = (Monster)countZeroInit.getLifeFormsOnBoard().get(0);

        System.out.println("Current game state: " + countZeroInit.getCurrentState());

        System.out.println("Monster1's Col, Row: " + monster1.getCol() + ", " + monster1.getRow());
        System.out.println("Player1's Col, Row: " + player1.getCol() + ", " + player1.getRow());
        System.out.println("Player1's inventory: " + player1.getInventory());
        System.out.println("Player1's myMonsterList: " + player1.getMyMonsterList());


        countZeroInit.getCurrentState().startButtonPressed();
        System.out.println("Current game state: " + countZeroInit.getCurrentState());

        countZeroInit.getCurrentState().upButtonPressed();
        countZeroInit.getCurrentState().rightButtonPressed();
        countZeroInit.getCurrentState().rightButtonPressed();

        System.out.println("Monster1's Col, Row: " + monster1.getCol() + ", " + monster1.getRow());
        System.out.println("Player1's Col, Row: " + player1.getCol() + ", " + player1.getRow());
        */
    }
}



