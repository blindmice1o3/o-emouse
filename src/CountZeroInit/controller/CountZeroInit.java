package CountZeroInit.controller;

import CountZeroInit.model.creatures.Humanoid;
import CountZeroInit.model.creatures.LifeForm;
import CountZeroInit.model.creatures.Monster;
import CountZeroInit.model.creatures.ThunderMouse;
import CountZeroInit.model.map.ForestMapSpec;
import CountZeroInit.model.map.Map;
import CountZeroInit.model.map.MapSpec;
import CountZeroInit.model.surroundings.Tile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class CountZeroInit {
    public static void main (String[] args) {
        Humanoid player1 = new Humanoid("Player1");
        Monster monster1 = new ThunderMouse("Fun-Guy Fungus", "Fungi");

        //System.out.println("Hello player1\nWhat is your name?\n");

        //BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        /*
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

        MapSpec forestMapSpec = new ForestMapSpec();
        Map act1Forest = new Map(forestMapSpec);
        Tile[][] gameBoard = act1Forest.getGameBoard();
        List<LifeForm> lifeFormsOnBoard = forestMapSpec.getLifeFormsOnBoard();

        for (int col = 0; col < 20; col++) {
            for (int row = 0; row < 20; row++) {
                if (row != 19) {
                    System.out.print(gameBoard[col][row].getPix() + " + ");
                } else {
                    System.out.println(gameBoard[col][row].getPix());
                    if (col != 19) {
                        System.out.println("+ + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + +");
                    }
                }
            }
        }

        System.out.println("");
        System.out.println("***Monster from ForestMapSpec: \n" +
                            lifeFormsOnBoard.get(0) + "\n" +
                            "***Location: (" + lifeFormsOnBoard.get(0).getCol() + ", " + lifeFormsOnBoard.get(0).getRow() + ")");
    }
}

