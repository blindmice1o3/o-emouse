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
    State battleState;
    State gameState;
    State itemListState;
    State monsterListState;
    State myMonsterListState;
    State startMenuState;
    State introState;
    Humanoid player1;

    State currentState;
    Map currentMap;
    List<Tile> tiles;
    List<LifeForm> lifeFormsOnBoard;
    Displayer displayer;

    public CountZeroInit(Map map) {
        // The following println() is just to see where CountZeroInit's constructor is called in the output.
        System.out.println("CountZeroInit.constructor...");

        setCurrentMap(map);
        tiles = getCurrentMap().getTiles();
        lifeFormsOnBoard = getCurrentMap().getLifeFormsOnBoard();

        // Loop through the List<LifeForm> provided by the concrete Map class (all the data about the starting state of that
        // map level), find our humanoid player and call the helper method instantiatePlayer1() which takes our Humanoid
        // object from the MapSpec and "copies" its data to a new, separate Humanoid object that's composed in this
        // CountZeroInit object.
        for (LifeForm lifeForm: getCurrentMap().getLifeFormsOnBoard()) {
            if (lifeForm.getType().equals("humanoid")) {
                initiatePlayer1((Humanoid)lifeForm);
            }
        }

        // Register with Humanoid (player1's class; an Observable) as an Observer
        player1.registerObserver(this);

        // Instantiate the concrete state classes (using "this" gameboyColor) and have our State instance variables
        // reference them.
        introState = new IntroState(this);
        startMenuState = new StartMenuState(this);
        gameState = new GameState(this);
        itemListState = new ItemListState(this);
        myMonsterListState = new MyMonsterListState(this);
        monsterListState = new MonsterListState(this);
        battleState = new BattleState(this);

        // Instantiate a new Displayer object, passing it a reference to "this" CountZeroInit object and the Map object
        // that was passed to the CountZeroInit's constructor. Then call the Displayer object's initiate().
        displayer = new Displayer(this, map);

        // The following line may be redundant.
        //displayer.redrawPanel();

        setCurrentState(getGameState());

        //displayer.drawIntroPanel();

        // TODO: figure out how to update/refresh the JPanel in Displayer class's JFrame; incorporate this into IntroState's startButtonPressed().



/*
        // The following println() are just to see if initiatePlayer1() is really setting the fields of the Humanoid
        // object composed in "this" CountZeroInit object to the Humanoid object we're obtaining by searching the
        // List<LifeForm> from concrete Map's lifeFormsOnMap variable.

        // The following println() are suppose to test the initiatePlayer1(), and it does... but not in a well thought
        // out and "clean" way; we should refactor this.
        System.out.println("CountZeroInit.Constructor... after calling initiatePlayer1(): " + this.player1);
        System.out.println(getPlayer1().getCol() + ", " + getPlayer1().getRow() + "; \n" + getPlayer1().getMyMonsterList()
                + "\n" + getPlayer1().getInventory()
                + "\n" + getPlayer1().getImageAddress()
                + "\n" + getPlayer1().getName());

        System.out.println("CountZeroInitConstructor... after calling initiatePlayer1(): \nnow seeing if we can can call " +
                        "the Humanoid's inventory field (an ArrayList) to call the size() on it: ");

        numberOfItems = player1.getInventory().size();

        System.out.println("Inventory size for CountZeroInit constructor: " + numberOfItems);
        System.out.println("Number of Monsters for CountZeroInit constructor: " + player1.getMyMonsterList().size());
*/

    }

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

        currentState = newState;
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
