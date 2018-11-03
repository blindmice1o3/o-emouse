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
        battleState = new BattleState(this);
        gameState = new GameState(this);
        itemListState = new ItemListState(this);
        monsterListState = new MonsterListState(this);
        myMonsterListState = new MyMonsterListState(this);
        startMenuState = new StartMenuState(this);

        setCurrentState(startMenuState);
        setCurrentMap(map);

        for (LifeForm lifeForm: getCurrentMap().getMapSpec().getLifeFormsOnBoard()) {
            if (lifeForm.getType().equals("humanoid")) {
                initiatePlayer1((Humanoid)lifeForm);
            }
        }
        numberOfItems = player1.getInventory().size();

        displayer = new Displayer(this, map);
        displayer.initiate();
    }

    public void initiatePlayer1(Humanoid fromMap) {
        player1 = new Humanoid(fromMap.getName(), fromMap.getType());
        player1.setRow(fromMap.getRow());
        player1.setCol(fromMap.getCol());
        player1.setImageAddress(fromMap.getImageAddress());
        player1.setInventory(fromMap.getInventory());
        player1.setMyMonsterList(fromMap.getMyMonsterList());

    }

    public Humanoid getPlayer1() {
        return player1;
    }

    public void setCurrentMap(Map map) {
        this.currentMap = map;
    }

    public Map getCurrentMap() {
        return currentMap;
    }

    public void setCurrentState(State newState) {
        currentState = newState;
    }

    public State getBattleState() {
        return battleState;
    }

    public State getGameState() {
        return gameState;
    }

    public State getItemListState() {
        return itemListState;
    }

    public State getMonsterListState() {
        return monsterListState;
    }

    public State getMyMonsterListState() {
        return myMonsterListState;
    }

    public State getStartMenuState() {
        return startMenuState;
    }

    public State getCurrentState() {
        return currentState;
    }
}
