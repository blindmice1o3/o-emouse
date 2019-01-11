package tinker.subkiller_game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This panel implements a simple arcade game in which the user tries to blow up a "submarine" (a black oval) by
 * dropping "depth charges" (a red disk) from a "boat" (a blue roundrect).
 *
 * The user moves the boat with the left- and right-arrow keys and drops the depth charge with the down-arrow key.
 *
 * The submarine moves left and right erratically along the bottom of the panel.
 *
 * This class contains a main() routine to allow it to be run as a program.
 */
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

    private Timer timer;    // Timer that drives the animation.

    private int width, height;  // The size of the panel -- the values are set the first time the paintComponent(Graphics)
                                //      method is called. This class is not designed to handle changes in size; once the
                                //      width and height have been set, they are not changed.
                                //      Note that width and height cannot be set in the constructor because the width and
                                //      height of the panel have not been set at the time that the constructor is called.

    private Boat boat;          // The boat, bomb, and submarine objects are defined by nested classes Boat, Bomb, and
    private Bomb bomb;          //      Submarine, which are defined later in this class.
    private Submarine submarine;//      Note that the objects are created in the paintComponent(Graphics) method, after
                                //      the width and height of the panel are known.

    /**
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

    /**
     * The paintComponent(Graphics) method draws the current state of the game. It draws a gray or cyan border around
     * the panel to indicate whether or not the panel has the input focus. It draws the boat, submarine, and bomb by
     * calling their respective draw() methods.
     */
    public void paintComponent(Graphics g) {

        // Fill panel with background color, green.
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // The first time that paintComponent(Graphics) is called, it assigns values to the instance variables.
        if (boat == null) {
            width = getWidth();
            height = getHeight();
            boat = new Boat();
            bomb = new Bomb();
            submarine = new Submarine();
        }

        if (hasFocus()) {
            g.setColor(Color.CYAN);
        }
        else {
            g.setColor(Color.BLACK);
            g.drawString("CLICK TO ACTIVATE", 20, 30);
            g.setColor(Color.GRAY);
        }
        // Draw a 3-pixel boarder.
        g.drawRect(0, 0, width-1, height-1);
        g.drawRect(1, 1, width-3, height-3);
        g.drawRect(2, 2, width-5, height-5);

        boat.draw(g);
        bomb.draw(g);
        submarine.draw(g);

    } // **** end paintComponent(Graphics) ****

// *********************************************************************************************************************

    /**
     * Nested class to define the boat.
     * Note: its constructor cannot be called until the width of the panel is known!
     */
    private class Boat {

        int centerX, centerY;       // Current position of the center of the boat.

        Boat() {    // Constructor centers the boat horizontally, 80 pixels from top.

            centerX = width/2;
            centerY = 80;

        } // **** end Boat() constructor ****

        void updateForNewFrame() {  // Makes sure boat has not moved off screen.

            if (centerX < 0) {
                centerX = 0;
            }
            else if (centerX > width) {
                centerX = width;
            }

        } // **** end Boat.updateForNewFrame() ****

        void draw(Graphics g) {     // Draws the boat at its current location.

            g.setColor(Color.BLUE);
            g.fillRoundRect(centerX-40, centerY-20, 80, 40, 20, 20);

        } // **** end Boat.draw(Graphics) ****

    } // **** end Boat nested class ****

// *********************************************************************************************************************

    /**
     * Nested class to define the bomb.
     */
    private class Bomb {

        int centerX, centerY;       // Current position of the center of the bomb.
        boolean isFalling;          // If true, the bomb is falling; if false, it is attached to the boat.

        Bomb() {    // Constructor creates a bomb that is initially attached to the boat.

            isFalling = false;

        } // **** end Bomb() constructor ****

        void updateForNewFrame() {  // If bomb is falling, take appropriate action.

            if (isFalling) {
                // Bomb has missed the submarine. It is returned to its initial state, with isFalling equal to false.
                if (centerY > height) {
                    isFalling = false;
                }
                // Bomb has hit the submarine. The submarine enters the "isExploding" state.
                else if (Math.abs(centerX - submarine.centerX) <= 36 && Math.abs(centerY - submarine.centerY) <= 21) {
                    submarine.isExploding = true;
                    submarine.explosionFrameNumber = 1;
                    // Bomb reappears on the boat.
                    isFalling = false;
                }
                // If the bomb has not fallen off the panel or hit the submarine, then it is moved down 10 pixels.
                else {
                    centerY += 10;
                }
            }

        } // **** end Bomb.updateForNewFrame() ****

        void draw(Graphics g) {     // Draw the bomb.

            // If not falling, set centerX and centerY to show the bomb on the bottom of the boat.
            if ( ! isFalling ) {
                centerX = boat.centerX;
                centerY = boat.centerY + 23;
            }

            g.setColor(Color.RED);
            g.fillOval(centerX-8, centerY-8, 16, 16);

        } // **** end Bomb.draw(Graphics) ****

    } // **** end Bomb nested class ****

// *********************************************************************************************************************

    /**
     * Nested class to define the submarine.
     * Note: its constructor cannot be called until the width of the panel is known!
     */
    private class Submarine {

        int centerX, centerY;       // Current position of the center of the submarine.
        boolean isMovingLeft;       // Tells whether the submarine is moving left or right.
        boolean isExploding;        // Set to true when the submarine is hit by the bomb.
        int explosionFrameNumber;   // If submarine is exploding, this is number of frames since the explosion started.

        Submarine() {   // Constructor creates the submarine at a random location 40 pixels from bottom.

            centerX = (int)(width * Math.random());
            centerY = height - 40;
            isExploding = false;
            isMovingLeft = (Math.random() < 0.5);

        } // **** end Submarine() constructor ****

        void updateForNewFrame() {  // Move submarine or increase explosionFrameNumber.

            // If the submarine is exploding, add 1 to explosionFrameNumber. When the number reaches 15, the explosion
            // ends and the submarine reappears in a random position.
            if (isExploding) {
                explosionFrameNumber++;
                if (explosionFrameNumber == 15) {
                    centerX = (int)(width * Math.random());
                    centerY = height - 40;
                    isExploding = false;
                    isMovingLeft = (Math.random() < 0.5);
                }
            }
            // The submarine is NOT exploding, therefore just move the submarine.
            else {
                // In one frame out of every 25, on average, the submarine reverses its direction of motion.
                if (Math.random() < 0.04) {
                    isMovingLeft = ! isMovingLeft;
                }
                // Move the submarine 5 pixels to the left. If it moves off the left edge of the panel, move it back to
                // the left edge and start it moving to the right.
                if (isMovingLeft) {
                    centerX -= 5;
                    if (centerX <= 0) {
                        centerX = 0;
                        isMovingLeft = false;
                    }
                }
                // Move the submarine 5 pixels to the right. If it moves off the right edge of the panel, move it back
                // to the right edge and start it moving to the left.
                else {
                    centerX += 5;
                    if (centerX > width) {
                        centerX = width;
                        isMovingLeft = true;
                    }
                }
            }

        } // **** end Submarine.updateForNewFrame() ****

        void draw(Graphics g) {     // Draw submarine and, if it is exploding, the explosion.

            g.setColor(Color.BLACK);
            g.fillOval(centerX-30, centerY-15, 60, 30);

            // Draw an "explosion" that grows in size as the number of frames since the start of the explosion increases.
            if (isExploding) {
                g.setColor(Color.YELLOW);
                g.fillOval(centerX - 4*explosionFrameNumber, centerY - 2*explosionFrameNumber,
                        8*explosionFrameNumber, 4*explosionFrameNumber);

                g.setColor(Color.RED);
                g.fillOval(centerX - 2*explosionFrameNumber, centerY - explosionFrameNumber/2,
                        4*explosionFrameNumber, explosionFrameNumber);
            }

        } // **** end Submarine.draw(Graphics) ****

    } // **** end Submarine nested class ****

// *********************************************************************************************************************

} // **** end SubKiller class ****