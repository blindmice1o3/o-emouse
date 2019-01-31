package tinker.monopoly_game.model.board;

import java.util.HashMap;
import java.util.Map;

public class MapOfSpecs {

    private Map mapOfSpecs;

    public MapOfSpecs(Map mapOfSpecs) {
        this.mapOfSpecs = new HashMap();
        this.mapOfSpecs.putAll(mapOfSpecs);
    } // **** end MapOfSpecs(Map) constructor ****

    public Map getMapOfSpecs() {
        return mapOfSpecs;
    }

    public String toString() {
        return mapOfSpecs.values().toString();
    }

} // **** end MapOfSpecs class ****
