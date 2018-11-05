package CountZeroInit.controller;

import CountZeroInit.controller.state.*;
import CountZeroInit.model.creatures.Humanoid;
import CountZeroInit.model.creatures.LifeForm;
import CountZeroInit.model.map.Map;
import CountZeroInit.view.Displayer;

public class GameboyColor {
    State battleState;
    State gameState;
    State itemListState;
    State monsterListState;
    State myMonsterListState;
    State startMenuState;
    Humanoid player1;
    int numberOfItems;

    State currentState;
    Map currentMap;
    Displayer displayer;

    public GameboyColor(Map map) {
        // The following println() is just to see where GameboyColor's constructor is called in the output.
        System.out.println("GameboyColor.constructor...");

        // Instantiate the concrete state classes (using "this" gameboyColor) and have our State instance variables
        // reference them.
        battleState = new BattleState(this);
        gameState = new GameState(this);
        itemListState = new ItemListState(this);
        monsterListState = new MonsterListState(this);
        myMonsterListState = new MyMonsterListState(this);
        startMenuState = new StartMenuState(this);

        // Calls helper methods setCurrentState() (which starts us in the startMenuState by default) and setCurrentMap()
        // (which is specified by a concrete map passed in as an argument.
        setCurrentState(startMenuState);
        setCurrentMap(map);

        // Loop through the List<LifeForm> provided by the MapSpec class (all the data about the starting state of that
        // map level), find our humanoid player and call the helper method instantiatePlayer1() which takes our Humanoid
        // object from the MapSpec and "copies" its data to a new, separate Humanoid object that's composed in this
        // GameboyColor object.
        for (LifeForm lifeForm: getCurrentMap().getLifeFormsOnBoard()) {
            if (lifeForm.getType().equals("humanoid")) {
                initiatePlayer1((Humanoid)lifeForm);
            }
        }

        // The following println() are just to see if initiatePlayer1() is really setting the fields of the Humanoid
        // object composed in "this" GameboyColor object to the Humanoid object we're obtaining by searching the
        // List<LifeForm> from MapSpec's lifeFormsOnMap variable.

        // The following println() are suppose to test the initiatePlayer1(), and it does... but not in a well thought
        // out and "clean" way; we should refactor this.
        System.out.println("GameboyColor.Constructor... after calling initiatePlayer1(): " + this.player1);
        System.out.println(getPlayer1().getCol() + ", " + getPlayer1().getRow() + "; \n" + getPlayer1().getMyMonsterList()
                + "\n" + getPlayer1().getInventory()
                + "\n" + getPlayer1().getImageAddress()
                + "\n" + getPlayer1().getName());

        System.out.println("GameboyColorConstructor... after calling initiatePlayer1(): \nnow seeing if we can can call " +
                        "the Humanoid's inventory field (an ArrayList) to call the size() on it: ");

        numberOfItems = player1.getInventory().size();

        System.out.println("Inventory size for GameboyColor constructor: " + numberOfItems);
        System.out.println("Number of Monsters for GameboyColor constructor: " + player1.getMyMonsterList().size());

        // Instantiate a new Displayer object, passing it a reference to "this" GameboyColor object and the Map object
        // that was passed to the GameboyColor's constructor. Then call the Displayer object's initiate().
        displayer = new Displayer(this, map);
        displayer.initiate();
    }

    public void initiatePlayer1(Humanoid fromMap) {
        // The following println() is just to see where initiatePlayer1() is called in the output.
        System.out.println("GameboyColor.initiatePlayer1()... is being passed its starting state as whatever state the " +
                "Humanoid object from the concrete MapSpec's List<LifeForm> lifeFormsOnBoard started as.");

        player1 = new Humanoid(fromMap.getName(), fromMap.getType());
        player1.setRow(fromMap.getRow());
        player1.setCol(fromMap.getCol());
        player1.setImageAddress(fromMap.getImageAddress());
    }

    public Humanoid getPlayer1() {
        // The following println() is just to see where getPlayer1() is called in the output.
        System.out.println("GameboyColor.getPlayer1()...");

        return player1;
    }

    public void setCurrentMap(Map map) {
        // The following println() is just to see where setCurrentMap() is called in the output.
        System.out.println("GameboyColor.setCurrentMap()...");

        this.currentMap = map;
    }

    public Map getCurrentMap() {
        // The following println() is just to see where getCurrentMap() is called in the output.
        System.out.println("GameboyColor.getCurrentMap()...");

        return currentMap;
    }

    public void setCurrentState(State newState) {
        // The following println() is just to see where setCurrentState() is called in the output.
        System.out.println("GameboyColor.setCurrentState()...");

        currentState = newState;
    }

    public State getBattleState() {
        // The following println() is just to see where getBattleState() is called in the output.
        System.out.println("GameboyColor.getBattleState()...");

        return battleState;
    }

    public State getGameState() {
        // The following println() is just to see where getGameState() is called in the output.
        System.out.println("GameboyColor.getGameState()...");

        return gameState;
    }

    public State getItemListState() {
        // The following println() is just to see where getItemListState() is called in the output.
        System.out.println("GameboyColor.getItemListState()...");

        return itemListState;
    }

    public State getMonsterListState() {
        // The following println() is just to see where getMonsterListState() is called in the output.
        System.out.println("GameboyColor.getMonsterListState()...");

        return monsterListState;
    }

    public State getMyMonsterListState() {
        // The following println() is just to see where getMyMonsterListState() is called in the output.
        System.out.println("GameboyColor.getMyMonsterListState()...");

        return myMonsterListState;
    }

    public State getStartMenuState() {
        // The following println() is just to see where getStartMenuState() is called in the output.
        System.out.println("GameboyColor.getStartMenuState()...");

        return startMenuState;
    }

    public State getCurrentState() {
        // The following println() is just to see where getCurrentState() is called in the output.
        System.out.println("GameboyColor.getCurrentState()...");

        return currentState;
    }
}
