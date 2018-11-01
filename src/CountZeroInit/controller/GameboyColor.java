package CountZeroInit.controller;

import CountZeroInit.controller.state.*;
import CountZeroInit.model.map.Map;

public class GameboyColor {
    State battleState;
    State gameState;
    State itemListState;
    State monsterListState;
    State myMonsterListState;
    State startMenuState;

    State currentState;
    Map currentMap;

    public GameboyColor(Map map) {
        battleState = new BattleState(this);
        gameState = new GameState(this);
        itemListState = new ItemListState(this);
        monsterListState = new MonsterListState(this);
        myMonsterListState = new MyMonsterListState(this);
        startMenuState = new StartMenuState(this);

        setCurrentState(startMenuState);
        setCurrentMap(map);
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
