package tinker.subkiller_game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SubKiller extends JPanel {

// *********************************************************************************************************************

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

// *********************************************************************************************************************

    private Timer timer;

    private int width, height;

    private Boat boat;
    private Bomb bomb;
    private Submarine submarine;

    /*
     * Constructor sets the background color of the panel, creates the timer, and adds a MouseListener, FocusListener,
     * and KeyListener to the panel. These listeners, as well as the ActionListener for the timer, are defined by
     * anonymous inner classes. The timer will run only when the panel has the input focus.
     */
    public SubKiller() {

        setBackground( new Color(0, 200, 0) );

    // -----------------------------------------------------------------------------------------------------------------

        ActionListener actionTimerFire = new ActionListener() {     // anonymous implementation of an interface

            // Defines the action taken each time the timer fires.
            public void actionPerformed(ActionEvent e) {    // implementation of interface's only method
                if (boat != null) {
                    boat.updateForNewFrame();
                    bomb.updateForNewFrame();
                    submarine.updateForNewFrame();
                }
                repaint();
            } // **** end actionPerformed(ActionEvent) ****

        }; // **** end anonymous ActionListener ****
        timer = new Timer( 30, actionTimerFire );       // Fires every 30 milliseconds.

    // -----------------------------------------------------------------------------------------------------------------

        addMouseListener( new MouseAdapter() {  // anonymous implementation of an abstract class
                                                // adapter pattern containing blank implementations of 3 mouse-related interfaces
            // The mouse listener simply request focus when the user clicks the panel.
            public void mousePressed(MouseEvent event) {    // implementation of the only method we care about
                requestFocus();
            } // **** end mousePressed(MouseEvent) ****

        } ); // **** end anonymous MouseAdapter ****

    // -----------------------------------------------------------------------------------------------------------------

        addFocusListener( new FocusListener() {     // anonymous implementation of an interface
            // The focus listener starts the timer when the panel gains the input focus and stops the timer when the
            // panel loses the focus. It also calls repaint() when these events occur.
            public void focusGained(FocusEvent event) {     // implementation of interface's method
                timer.start();
                repaint();
            } // **** end focusGained(FocusEvent) ****
            public void focusLost(FocusEvent event) {       // implementation of interface's method
                timer.stop();
                repaint();
            } // **** end focusLost(FocusEvent) ****

        } ); // **** end anonymous FocusListener ****

    // -----------------------------------------------------------------------------------------------------------------

        addKeyListener( new KeyAdapter() {  // anonymous implementation of an abstract class
                                            // adapter pattern containing blank implementations of 1 keyboard-related interface
            // The key listener responds to keyPressed events on the panel. Only the left-, right-, and down-arrow keys
            // have any effect. The left- and right-arrow keys move the boat, and down-arrow releases the bomb.
            public void keyPressed(KeyEvent event) {
                int code = event.getKeyCode();              // Stores which key was pressed.
                if (code == KeyEvent.VK_LEFT) {
                    // Move the boat left. (If this moves the boat out of the frame, its position will be adjusted in
                    // the boat.updateForNewFrame() method.)
                    boat.centerX -= 15;
                }
                else if (code == KeyEvent.VK_RIGHT) {
                    // Move the boat right. (If this moves the boat out of the frame, its position will be adjusted in
                    // the boat.updateForNewFrame() method.)
                    boat.centerX += 15;
                }
                else if (code == KeyEvent.VK_DOWN) {
                    // Start the bomb falling, if it is not already falling.
                    if (bomb.isFalling == false) {
                        bomb.isFalling = true;
                    }
                }
            } // end keyPressed(KeyEvent) ****

        } ); // **** end anonymous KeyAdapter ****

    } // **** end SubKiller() constructor ****

    /*
     * The paintComponent() method draws the current state of the game. It draws a gray or cyan border around the panel
     * to indicate whether or not the panel has the input focus. It draws the boat, submarine, and bomb by calling their
     * respective draw() methods.
     */
    public void paintComponent(Graphics g) {



    } // **** end paintComponent(Graphics) ****

// *********************************************************************************************************************

    /*
     * Nested class to define the boat.
     * Note: its constructor cannot be called until the width of the panel is known!
     */
    private class Boat {

        int centerX, centerY;       // Current position of the center of the boat.

        Boat() {    // Constructor centers the boat horizontally, 80 pixels from top.



        } // **** end Boat() constructor ****

        void updateForNewFrame() {



        } // **** end updateForNewFrame() ****

        void draw(Graphics g) {



        } // **** end draw(Graphics) ****

    } // **** end Boat nested class ****

// *********************************************************************************************************************

    /*
     * Nested class to define the bomb.
     */
    private class Bomb {

        int centerX, centerY;       // Current position of the center of the bomb.
        boolean isFalling;          // If true, the bomb is falling; if false, it is attached to the boat.

        Bomb() {    // Constructor creates a bomb that is initially attached to the boat.



        } // **** end Bomb() constructor ****

        void updateForNewFrame() {



        } // **** end updateForNewFrame() ****

        void draw(Graphics g) {



        } // **** end draw(Graphics) ****

    } // **** end Bomb nested class ****

// *********************************************************************************************************************

    /*
     * Nested class to define the submarine.
     */
    private class Submarine {

        int centerX, centerY;       // Current position of the center of the submarine.
        boolean isMovingLeft;       // Tells whether the submarine is moving left or right.
        boolean isExploding;        // Set to true when the submarine is hit by the bomb.
        int explosionFrameNumber;   // If submarine is exploding, this is number of frames since the explosion started.

        Submarine() {   // Constructor creates the submarine at a random location 40 pixels from bottom.



        } // **** end Submarine() constructor ****

        void updateForNewFrame() {



        } // **** end updateForNewFrame() ****

        void draw(Graphics g) {



        } // **** end draw(Graphics) ****

    } // **** end Submarine nested class ****

// *********************************************************************************************************************

} // **** end SubKiller class ****