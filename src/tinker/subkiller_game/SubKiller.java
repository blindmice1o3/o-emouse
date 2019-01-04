package tinker.subkiller_game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubKiller extends JPanel {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Submarine Killer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(600, 480);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        SubKiller panel = new SubKiller();
        frame.setContentPane(panel);

        frame.setVisible(true);

    } // **** end main(String[]) ****

    // -----------------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------

    private Timer timer;

    private int width, height;

    private Boat boat;
    private Bomb bomb;
    private Submarine submarine;

    /*
     * The constructor ...
     */
    public SubKiller() {

        setBackground( new Color(0, 200, 0) );

        ActionListener actionTimerFire = new ActionListener() {
                // Defines the action taken each time the timer fires.
            public void actionPerformed(ActionEvent e) {

                if (boat != null) {
                    boat.updateForNewFrame();
                    bomb.updateForNewFrame();
                    submarine.updateForNewFrame();
                }
                repaint();

            } // **** end actionPerformed(ActionEvent) ****

        };
        timer = new Timer( 30, actionTimerFire );   // Fires every 30 milliseconds.



    } // **** end SubKiller() constructor ****


    /*
     * Nested class to define the boat.
     * Note: its constructor cannot be called until the width of the panel is known!
     */
    private class Boat {

        void updateForNewFrame() {



        } // **** end updateForNewFrame() ****

    } // **** end Boat nested class ****


    /*
     * Nested class to define the bomb.
     */
    private class Bomb {

        void updateForNewFrame() {



        } // **** end updateForNewFrame() ****

    } // **** end Bomb nested class ****


    /*
     * Nested class to define the submarine.
     */
    private class Submarine {

        void updateForNewFrame() {



        } // **** end updateForNewFrame() ****

    } // **** end Submarine nested class ****

} // **** end SubKiller class ****