package Tinker.chess_game.view_controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ChessBoardMouseListener
        implements MouseListener {

    String rankMouseClicked;
    String fileMouseClicked;

    public ChessBoardMouseListener() {
        rankMouseClicked = "";
        fileMouseClicked = "";
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println( "Mouse clicked: (" + e.getX() + ", " + e.getY() + "),\n" +
                            "Rank/File: (" + translateMouseClickToRank(e) + "/" + translateMouseClickToFile(e) + ")\n" +
                            "MouseEvent source => " + e.getSource().getClass());


    }

    public String translateMouseClickToFile(MouseEvent e) {
        int xMouseClick = e.getX();

        if ( (xMouseClick >= 0) && (xMouseClick < 70) ) {
            return "A";
        }
        else if ( (xMouseClick >= 70) && (xMouseClick < 140) ) {
            return "B";
        }
        else if ( (xMouseClick >= 140) && (xMouseClick < 210) ) {
            return "C";
        }
        else if ( (xMouseClick >= 210) && (xMouseClick < 280) ) {
            return "D";
        }
        else if ( (xMouseClick >= 280) && (xMouseClick < 350) ) {
            return "E";
        }
        else if ( (xMouseClick >= 350) && (xMouseClick < 420) ) {
            return "F";
        }
        else if ( (xMouseClick >= 420) && (xMouseClick < 490) ) {
            return "G";
        }
        else if ( (xMouseClick >= 490) && (xMouseClick < 560) ) {
            return "H";
        }
        else {
            return "";
        }
    }

    public String translateMouseClickToRank(MouseEvent e) {
        int yMouseClick = e.getY();

        if ( (yMouseClick >= 0) && (yMouseClick < 70) ) {
            return "8";
        }
        else if ( (yMouseClick >= 70) && (yMouseClick < 140) ) {
            return "7";
        }
        else if ( (yMouseClick >= 140) && (yMouseClick < 210) ) {
            return "6";
        }
        else if ( (yMouseClick >= 210) && (yMouseClick < 280) ) {
            return "5";
        }
        else if ( (yMouseClick >= 280) && (yMouseClick < 350) ) {
            return "4";
        }
        else if ( (yMouseClick >= 350) && (yMouseClick < 420) ) {
            return "3";
        }
        else if ( (yMouseClick >= 420) && (yMouseClick < 490) ) {
            return "2";
        }
        else if ( (yMouseClick >= 490) && (yMouseClick < 560) ) {
            return "1";
        }
        else {
            return "";
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
