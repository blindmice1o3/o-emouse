package CountZeroInit.controller;

import CountZeroInit.model.creatures.Humanoid;
import CountZeroInit.model.creatures.Monster;
import CountZeroInit.model.map.ForestMap;
import CountZeroInit.model.map.Map;

public class CountZeroInit {
    public static void main (String[] args) {
        Map act1ForestMap = new ForestMap();
        GameboyColor gb = new GameboyColor(act1ForestMap);
        Humanoid player1 = gb.getPlayer1();
        Monster monster1 = (Monster)act1ForestMap.getLifeFormsOnBoard().get(0);

        System.out.println("Player1's Col, Row: " + player1.getCol() + ", " + player1.getRow());
        System.out.println("Player1's inventory: " + player1.getInventory());
        System.out.println("Player1's myMonsterList: " + player1.getMyMonsterList());

        System.out.println("Current game state: " + gb.getCurrentState());
        gb.getCurrentState().startButtonPressed();
        System.out.println("Current game state: " + gb.getCurrentState());


        gb.getCurrentState().upButtonPressed();
/*
        gb.getCurrentState().upButtonPressed();
        gb.getCurrentState().upButtonPressed();
*/

        System.out.println("Monster1's Col, Row: " + monster1.getCol() + ", " + monster1.getRow());
        System.out.println("Player1's Col, Row: " + player1.getCol() + ", " + player1.getRow());

        /*
        System.out.println("Hello player1\nWhat is your name?\n");

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        try {
            player1.setName(input.readLine());
        } catch (IOException exception) {
            System.out.println("failed to readLine() for player1.setName()");
        }

        System.out.println("\nIt's nice to meet you " + player1.getName() + ".\n");
        System.out.println("\nA wild " + monster1.getType() + " appeared!\nWould you like to:\n(Keep it) or (Leave it alone)?");

        String player1Response = "";

        try {
            player1Response = input.readLine();
        } catch (IOException exception) {
            System.out.println("failed to readLine() for player1Response");
        }

        if (player1Response.startsWith("keep")) {
            player1.keepMonster(monster1);
            System.out.println(player1.getMonster(0));
        } else if (player1Response.startsWith("leave")) {
            System.out.println("You've made PETA proud!");
        } else {
            System.out.println("I don't understand your command.");
        }
        */
    }
}



