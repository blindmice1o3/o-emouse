package CountLegacyInit;
/*
    Game programming requires custom drawing. For a Swing application, we extend a JPanel (called GameCanvas) and
    override the paintComponent(Graphics) method to do custom drawing. The paintComponent() method is not meant to
    be called directly, but called-back via the repaint() method. The Graphics context supports rendering of
    text (drawString()), primitive shapes (drawXxx(), fillXxx()), and bitmap images (drawImage()). For higher-quality
    graphics, we could use Graphics2D (of the Java 2D API) instead of the legacy Graphics.

    The main game class is derived from a JPanel, so that it can be run as an application as well as an applet. An
    instance of GameCanvas called canvas is instantiated and added to the JPanel.


    ***** Init and Shutdown - gameInit() & gameShutdown() *****
    The gameInit() method is meant to be run once, to instantiate all the gaming objects, pre-load images and sound
    effects, among others. In this framework, gameInit() is called once in the constructor of the main application.

    The gameShutdown() is also meant to be run once, for clean-up operations such as writing out the high-score.


    ***** Starting the Game Play - gameStart() *****
    Once all the game objects are in place (via gameInit()), we can start the game by running a game loop to repeat the
    game steps.

    In a typical single-player game, the game loop executes at a fixed interval. It calculates the new position of all
    the game objects and move them into the new position. It then detects collision among the game objects and provides
    responses, renders a new frame and pushes it to the screen.

    We shall use the method gameStart() to start the play, or re-start after the previous play. The gameStart() runs
    the game-loop as follows: (see code below)

    Within the game loop, we invoke the gameUpdate() method to calculate the position of game objects, update their
    states, detect collision and provide responses.

    The game loop is written as an infinite loop. We need to keep track of the state of the game via boolean variables
    such as gameOver and gamePaused (will change to an enumeration later). We can then use these boolean flags to
    control the loop.


    ***** Controlling the Refresh (Update) Rate of the Game *****
    The monitor refreshes at 50-100 Hz. It is pointless for your game to update your game faster than the monitor. For
    some action games, you may wish to intercept the video buffer and update the game at the same rate as the monitor.
    For others like tetris and snake games, you may wish to update at the same rate as the player's response, say
    1-5 moves per second.

    Suppose that we wish to refresh the game at 5 moves per second. Each move takes 1000/5 = 200 milliseconds. The delay
    timer must provide (200 - time taken to run the earliest processes). This can be achieved as follows: (see code below)

    JDK 1.5 provides a new timer called System.nanoTime() for measuring the elapsed time, which is reportedly more
    precise than the legacy System.currentTimeMillis().

    The static method Thread.sleep() suspends the current thread, and wait for the specified milliseconds before
    attempting to resume. This process serves two purposes. Firstly, it provides the necessary time delay needed to
    meet the target rate. Secondly, by suspending itself, another thread can resume and perform its task. In particular,
    the so-called event dispatch thread, which is responsible for processing input events (such as mouse-clicked, key-pressed)
    and refreshing the display, cannot be starved. Otherwise, the infamous unresponsive user-interface resulted, that is,
    the display is frozen and the system does not response to any input event.


    ***** Game Thread *****
    Next, we need to run the game loop in its own thread - let's call it the game thread. We use a dedicated thread to
    run our game loop to ensure responsive user-interface (as mentioned above).

    The game thread (called GameThread) is derived from the class Thread. It is written as an inner class. We override
    the run() method to program the running behavior of the thread. To start the play, we need to create a new instance
    of the GameThread and invoke the start() method, which will call-back the run() method to run the programmed behavior.

    There is, however, an issue here. We would like to start the play via the gameStart() method. But we need to program
    the running behavior in the overridden run(). To resolve this program (problem?), I break the game starting method
    into two parts: gameStart() which simply create and run a new GameThread; and gameLoop(), which is called by the
    run() method to run the game loop, as follows: (see code below)


    ***** Game State *****
    Let's try to handle the game state in a more systematic way, instead of using boolean flags (such as gameOver and
    gamePaused). The state diagram for a typical game is as illustrated below: (see website: http://www.ntu.edu.sg/home/ehchua/programming/java/J8d_Game_Framework.html )

    We shall define a nested static enumeration to represent the game states in the GameMain class (CountLegacyInit)
    as follow: (see code below)

    The enumeration State and the instance variable state are declared as static, which can be accessed via the classname
    directly. For example, you can manipulate the state:
        // in the GameMain class
        state = GameState.GAMEOVER;
        ......
        switch (state) {
            case INITIALIZED:
                .....
                break;
            case PLAYING:
                .....
                break;
            case PAUSED:
                .....
                break;
            case GAMEOVER:
                .....
                break;
            case DESTROYED:
                .....
                break;
        }


    ***** Summary *****
    You can use the (below) template by:
    -Declare all the instance variables for game objects.
    -Instantiate all the game objects in the method gameInit().
    -Program the gameUpdate(), for calculating the new position of the game objects, updating the states, detecting the
        collision and providing responses.
    -Program the gameDraw(), for displaying game objects and information after each game step.
    -Handle the input event in gameKeyPressed(). Update the state of the game.

 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CountLegacyInit extends JPanel {       // main class for the game
    // Define constants for the game
    static final String TITLE = "CountLegacyInit";  // title of the game
    static final int CANVAS_WIDTH = 800;            // width and height of the drawing canvas (game screen)
    static final int CANVAS_HEIGHT = 600;
    static final int UPDATES_PER_SEC = 4;           // number of game update per second
    static final long UPDATE_PERIOD_NSEC = 1000000000L / UPDATES_PER_SEC; // nanoseconds
    // .....


    // Enumeration for the states of the game.
    static enum GameState {
        INITIALIZED, PLAYING, PAUSED, GAMEOVER, DESTROYED
    }
    static GameState state;                         // current state of the game


    // Define instance variables for the game objects
    // .....
    // .....


    // Handle (name?) for the custom drawing panel
    private GameCanvas canvas;
    //public static JMenuBar menuBar;               // the menu bar (if needed)


    // Constructor to initialize the UI components and game objects
    public CountLegacyInit() {
        // Initialize the game objects
        gameInit();

        // UI components
        canvas = new GameCanvas();
        canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
        //this.setContentPane(canvas);      // using add() instead
        add(canvas);        // center of default BorderLayout

        // Other UI components such as buttons, score board, if any.
        // .....

        // Set up menu bar

    }

    // ----- All the game related codes here -----

    // Initialize all the game objects, run only once (in the constructor of the main class).
    public void gameInit() {
        // .....
        state = GameState.INITIALIZED;
    }

    // Shutdown the game, clean up code that runs only once (e.g. write the high-score); before the program terminates.
    public void gameShutdown() {
        // .....
    }

    // Start (and re-start) the game.
    public void gameStart() {
        // Create a new thread
        Thread gameThread = new Thread() {
            // Override run() to provide the running behavior of this thread.
            @Override
            public void run() {
                gameLoop();
            }
        };
        // Start the thread. start() calls run(), which in turn calls gameLoop().
        gameThread.start();
    }

    // Run the game loop here.
    private void gameLoop() {
        // Regenerate the game objects for a new game.
        // .....
        state = GameState.PLAYING;

        // Game loop
        long beginTime, timeTaken, timeLeft;    // in msec
        while (state != GameState.GAMEOVER) {
            beginTime = System.nanoTime();
            if (state == GameState.PLAYING) {   // not paused
                // Update the state and position of all the game objects,
                // detect collisions and provide responses.
                gameUpdate();
            }
            // Refresh the display.
            repaint();
            // Delay timer to provide the necessary delay to meet the target rate.
            timeTaken = System.nanoTime() - beginTime;
            timeLeft = (UPDATE_PERIOD_NSEC - timeTaken) / 1000000L; // in milliseconds
            if (timeLeft < 10) {
                timeLeft = 10;                  // set a minimum
            }
            try {
                // Provides the necessary delay and also yields control so that other tread can do work.
                Thread.sleep(timeLeft);
            } catch (InterruptedException ex) { }
        }
    }

    // One step of the game.
    // To be called in the game loop for updating the position and state of the game objects, detecting collision and
    // provide proper responses.
    public void gameUpdate() { /* .....*/ }

    // Refresh the display after each step. Called back via repaint(), which invoke the paintComponent().
    // Use (Graphics g) as argument if you are not using Java 2D.
    // Render the graphics, to be called inside the paintComponent() of the drawing JPanel.
    private void gameDraw(Graphics2D g2d) {
        switch (state) {
            case INITIALIZED:
                // .....
                break;
            case PLAYING:
                // .....
                break;
            case PAUSED:
                // .....
                break;
            case GAMEOVER:
                // .....
                break;
        }
        // .....
    }

    // KeyEvent handler for key-pressed, key-released, and key-typed.
    // Process a key-pressed event. Update the current state.
    public void gameKeyPressed(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_UP:
                // .....
                break;
            case KeyEvent.VK_DOWN:
                // .....
                break;
            case KeyEvent.VK_LEFT:
                // .....
                break;
            case KeyEvent.VK_RIGHT:
                // .....
                break;
        }
    }
    private void gameKeyReleased(int keyCode) { }
    private void gameKeyTyped(int keyCode) { }

    // Other methods
    // .....

    // Custom drawing panel, written as an inner class.
    /*
        The custom drawing panel is usually designed as an inner class to the main game class, in order to directly
        access the private variables of the outer class - in particular, the game objects. The game canvas is a
        key-event source, as well as listener (via addKeyListener(this)). As source, it triggers KeyEvent upon
        key-pressed, key-released, and key-typed. As a listener, it implements KeyListener interface and provides
        event handlers for key-pressed, key-released, and key-typed.
    */
    class GameCanvas extends JPanel
            implements KeyListener {

        // Constructor
        public GameCanvas() {
            setFocusable(true);     // so that this can receive key-events
            requestFocus();
            addKeyListener(this);
        }

        // Override paintComponent to do custom drawing.
        // Called back by repaint().
        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D)g;     // if using Java 2D
            super.paintComponent(g2d);          // paint background
            setBackground(Color.BLACK);         // may use an image for background

            // Draw the game objects
            gameDraw(g2d);
        }

        // KeyEvent handlers
        @Override
        public void keyPressed(KeyEvent e) {
            gameKeyPressed(e.getKeyCode());
        }

        @Override
        public void keyReleased(KeyEvent e) { }

        @Override
        public void keyTyped(KeyEvent e) { }
    }

    // Entry point to the game, the main() method.
    public static void main(String[] args) {
        // Use the event dispatch thread to build the UI for thread-safety.
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame(TITLE);
                // Set the content-pane of the JFrame to an instance of main JPanel
                frame.setContentPane(new CountLegacyInit());    // main JPanel as content pane
                //frame.setJMenuBar(menuBar);                   // menu-bar (if defined)
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);              // center the application window
                frame.setVisible(true);                         // show it
            }
        });
    }

}


