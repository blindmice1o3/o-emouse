package Tinker.chess_game;


import Tinker.chess_game.view_controller.ChessGame;

import javax.swing.*;
import java.awt.*;

public class TestClassChess {

    public static void main(String[] args) {

        Toolkit awt = Toolkit.getDefaultToolkit();
        int screenWidth = (int)awt.getScreenSize().getWidth();
        int screenHeight = (int)awt.getScreenSize().getHeight();

        JFrame displayer = new JFrame();
        displayer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int gameWidth = 716;
        int gameHeight = 738;
        displayer.setSize(gameWidth, gameHeight);
        displayer.setLocation((screenWidth/2)-(gameWidth/2), ((screenHeight-33)/2)-(gameHeight/2));
        displayer.setTitle("Chess");
        displayer.setContentPane(new ChessGame());

        displayer.setVisible(true);

    } // end main()

} // end TestClassChess class