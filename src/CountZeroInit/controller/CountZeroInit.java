package CountZeroInit.controller;

import CountZeroInit.controller.state.*;
import CountZeroInit.model.Observer;
import CountZeroInit.model.creatures.Humanoid;
import CountZeroInit.model.creatures.LifeForm;
import CountZeroInit.model.map.Map;
import CountZeroInit.model.surroundings.Tile;
import CountZeroInit.view.Displayer;

import java.util.List;

public class CountZeroInit
        implements Observer {
    static final int UPDATES_PER_SEC = 4;                               // number of game update per second
    static final long UPDATE_PER_NSEC = 1000000000L / UPDATES_PER_SEC;  // nanoseconds

    State battleState, gameState, introState, itemListState, monsterListState, myMonsterListState, startMenuState;

    Displayer displayer;
    Map currentMap;
    List<Tile> tiles;
    List<LifeForm> lifeFormsOnBoard;
    Humanoid player1;
    State currentState;

    public CountZeroInit(Map map) {
        // The following println() is just to see where CountZeroInit's constructor is called in the output.
        System.out.println("CountZeroInit.constructor...");

        setCurrentMap(map);

        gameInit();

//        gameStart();

    }

    public void gameInit() {
        tiles = getCurrentMap().getTiles();
        lifeFormsOnBoard = getCurrentMap().getLifeFormsOnBoard();
        // Loop through the List<LifeForm> provided by the concrete Map class (all the data about the starting state of that
        // map level), find our humanoid player and call the helper method instantiatePlayer1() which takes our Humanoid
        // object from the Map and "copies" its data to a new, separate Humanoid object that's composed in this
        // CountZeroInit object.
        for (LifeForm lifeForm: getCurrentMap().getLifeFormsOnBoard()) {
            if (lifeForm.getType().equals("humanoid")) {
                initiatePlayer1((Humanoid)lifeForm);
            }
        }
        // Register with Humanoid (player1's class; an Observable) as an Observer
        player1.registerObserver(this);


        // Instantiate the concrete state classes (using "this" countZeroInit) and have our State instance variables
        // reference them.
        battleState = new BattleState(this);
        gameState = new GameState(this);
        introState = new IntroState(this);
        itemListState = new ItemListState(this);
        monsterListState = new MonsterListState(this);
        myMonsterListState = new MyMonsterListState(this);
        startMenuState = new StartMenuState(this);

        // Instantiate a new Displayer object, passing it a reference to "this" CountZeroInit object and the Map object
        // that was passed to the CountZeroInit's constructor.
        displayer = new Displayer(this, getCurrentMap());

        // Using this line to select the module to work on.
        setCurrentState(getGameState());
    }

    public void gameStart() {
        // Create a new game thread
        Thread gameThread = new Thread() {
            // Override run() to provide the running behavior of this thread.
            @Override
            public void run() {
//                gameLoop();
            }
        };
        // Start the thread. start() calls run(), which in turn calls gameLoop().
        gameThread.start();
    }

/*    public void gameLoop() {
        // Regenerate the game objects for a new game.

        // Game loop.
        long timeBegin, timeTaken, timeLeft;    // in msec

        while (true) {
            timeBegin = System.nanoTime();
            if (currentState instanceof GameState) {    // desired: not paused (currently configured: if in GameState)
                // Update the state and position of all the game objects, detect collisions,
                // and provide responses. It is one step in the game.
//                gameUpdate();
            }
            // Refresh the display.
//            gameDraw();
            // Delay timer to provide the necessary delay to meet the target rate.
            timeTaken = System.nanoTime() - timeBegin;
            timeLeft = (UPDATE_PER_NSEC - timeTaken) / 1000000L;    // in milliseconds
            if (timeLeft < 10) {
                timeLeft = 10;                                      // set a minimum
            }
            try {
                // Provides the necessary delay and also yields control so that other thread can do work.
                Thread.sleep(timeLeft);
            } catch (InterruptedException ex) {

            }
        }

    }
*/
    public void gameUpdate() {
        // TODO: Implement player providing input.



    }

    public void gameDraw() {
        displayer.redrawPanel();
    }

    public void gameShutdown() {}

    public Displayer getDisplayer() {
        return displayer;
    }

    public void update() {
        displayer.redrawPanel();
    }



    public void initiatePlayer1(Humanoid fromMap) {
        // The following println() is just to see where initiatePlayer1() is called in the output.
        System.out.println("CountZeroInit.initiatePlayer1()... is being passed its starting state as whatever state the " +
                "Humanoid object from the concrete Map's List<LifeForm> lifeFormsOnBoard started as.");

        player1 = new Humanoid(fromMap.getType());
        player1.setRow(fromMap.getRow());
        player1.setCol(fromMap.getCol());
        player1.setImageAddress(fromMap.getImageAddress());
    }

    public Humanoid getPlayer1() {
        // The following println() is just to see where getPlayer1() is called in the output.
        System.out.println("CountZeroInit.getPlayer1()...");

        return player1;
    }

    public List<Tile> getTiles() {
        return tiles;
    }

    public List<LifeForm> getLifeFormsOnBoard() {
        return lifeFormsOnBoard;
    }

    public void setCurrentMap(Map map) {
        // The following println() is just to see where setCurrentMap() is called in the output.
        System.out.println("CountZeroInit.setCurrentMap()...");

        this.currentMap = map;
    }

    public Map getCurrentMap() {
        // The following println() is just to see where getCurrentMap() is called in the output.
        System.out.println("CountZeroInit.getCurrentMap()...");

        return currentMap;
    }

    public void setCurrentState(State newState) {
        // The following println() is just to see where setCurrentState() is called in the output.
        System.out.println("CountZeroInit.setCurrentState()...");
        // ********** ACTUAL INTENDED FUNCTION ***********
        // Set the currentState field to the State argument passed in.
        currentState = newState;


        // All other time, it's just switching the panels to match its corresponding states.
        displayer.setCurrentPanel(currentState.toString());
    }

    public State getIntroState() {
        // The following println() is just to see where getIntroState() is called in the output.
        System.out.println("CountZeroInit.getIntroState()...");

        return introState;
    }

    public State getBattleState() {
        // The following println() is just to see where getBattleState() is called in the output.
        System.out.println("CountZeroInit.getBattleState()...");

        return battleState;
    }

    public State getGameState() {
        // The following println() is just to see where getGameState() is called in the output.
        System.out.println("CountZeroInit.getGameState()...");

        return gameState;
    }

    public State getItemListState() {
        // The following println() is just to see where getItemListState() is called in the output.
        System.out.println("CountZeroInit.getItemListState()...");

        return itemListState;
    }

    public State getMonsterListState() {
        // The following println() is just to see where getMonsterListState() is called in the output.
        System.out.println("CountZeroInit.getMonsterListState()...");

        return monsterListState;
    }

    public State getMyMonsterListState() {
        // The following println() is just to see where getMyMonsterListState() is called in the output.
        System.out.println("CountZeroInit.getMyMonsterListState()...");

        return myMonsterListState;
    }

    public State getStartMenuState() {
        // The following println() is just to see where getStartMenuState() is called in the output.
        System.out.println("CountZeroInit.getStartMenuState()...");

        return startMenuState;
    }

    public State getCurrentState() {
        // The following println() is just to see where getCurrentState() is called in the output.
        System.out.println("CountZeroInit.getCurrentState()...");

        return currentState;
    }
}
