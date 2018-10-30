package CountZeroInit.controller;

import CountZeroInit.model.creatures.Humanoid;
import CountZeroInit.model.creatures.Monster;
import CountZeroInit.model.creatures.ThunderMouse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountZeroInit {
    public static void main (String[] args) {
        Humanoid player1 = new Humanoid("Player1");
        Monster monster1 = new ThunderMouse("Fun-Guy Fungus", "Fungi");

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

    }
}

