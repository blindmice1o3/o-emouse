package Tinker.chess_game.view_controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ChessBoardMouseListener
        implements MouseListener {

    public ChessBoardMouseListener() {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println( "Mouse clicked: (" + e.getX() + ", " + e.getY() + "),\n" +
                            "MouseEvent source => " + e.getSource().getClass());

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
