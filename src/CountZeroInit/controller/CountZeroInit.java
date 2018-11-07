package CountZeroInit.controller;

import CountZeroInit.model.map.ForestMap;

public class CountZeroInit {
    public static void main (String[] args) {
        GameboyColor gb = new GameboyColor(new ForestMap());

        // Currently, the game starts off by default with currentGameState set to GameState.
        System.out.println("Current game state: " + gb.getCurrentState());

        // The player in ForestMap starts with position (0, 4), with 3 Items in myInventory, and 2 Monsters in myMonsterList.
        System.out.println("Player1's current position: (" + gb.getPlayer1().getCol() + ", " + gb.getPlayer1().getRow() + ")");
        System.out.println("Player1's inventory: " + gb.getPlayer1().getInventory());
        System.out.println("Player1's myMonsterList: " + gb.getPlayer1().getMyMonsterList());

        // The GameboyColor's upButtonPressed() is called to change the player's row variable to decrement by one (0, 3).
        gb.getCurrentState().upButtonPressed();
        System.out.println("Player1's current position: (" + gb.getPlayer1().getCol() + ", " + gb.getPlayer1().getRow() + ")");

        // The GameboyColor's startButtonPressed() is called to change the currentGameState to StartMenuState, then is
        // navigated to call the Command for ItemListStateCommand (which sets currentGameState to ItemListState).
        gb.getCurrentState().startButtonPressed();
        gb.getCurrentState().downButtonPressed();
        gb.getCurrentState().downButtonPressed();
        gb.getCurrentState().aButtonPressed();

        /*
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
        */
    }
}



