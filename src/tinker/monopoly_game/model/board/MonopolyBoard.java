package tinker.monopoly_game.model.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MonopolyBoard {

    private List<Tile> board;

    private void initializeBoard() {
        Map properties = new HashMap();
        int[] rent = new int[6];

        // ****************************** TileType: PROPERTY ***********************************************************

        // PURPLE
        properties.put("color", Color.PURPLE);
        properties.put("name", "Mediterranean Avenue");
        properties.put("price", 60);
        initRent(rent, 2, 10, 30, 90, 160, 250);
        properties.put("rent", rent);
        addTile( 1, TileType.PROPERTY, new TileSpec(properties) );

        properties.put("color", Color.PURPLE);
        properties.put("name", "Baltic Avenue");
        properties.put("price", 60);
        initRent(rent, 4, 20, 60, 180, 320, 450);
        properties.put("rent", rent);
        addTile( 3, TileType.PROPERTY, new TileSpec(properties) );

        // LIGHT_BLUE
        properties.put("color", Color.LIGHT_BLUE);
        properties.put("name", "Oriental Avenue");
        properties.put("price", 100);
        initRent(rent, 6, 30, 90, 270, 400, 550);
        properties.put("rent", rent);
        addTile( 6, TileType.PROPERTY, new TileSpec(properties) );

        properties.put("color", Color.LIGHT_BLUE);
        properties.put("name", "Vermont Avenue");
        properties.put("price", 100);
        initRent(rent, 6, 30, 90, 270, 400, 550);
        properties.put("rent", rent);
        addTile( 8, TileType.PROPERTY, new TileSpec(properties) );

        properties.put("color", Color.LIGHT_BLUE);
        properties.put("name", "Connecticut Avenue");
        properties.put("price", 120);
        initRent(rent, 8, 40, 100, 300, 450, 600);
        properties.put("rent", rent);
        addTile( 9, TileType.PROPERTY, new TileSpec(properties) );

        // LIGHT_PURPLE
        properties.put("color", Color.LIGHT_PURPLE);
        properties.put("name", "St. Charles Place");
        properties.put("price", 140);
        initRent(rent, 10, 50, 150, 450, 625, 750);
        properties.put("rent", rent);
        addTile( 11, TileType.PROPERTY, new TileSpec(properties) );



        // ************************* TileType: OTHER, COMMUNITY_CHEST, and CHANCE **************************************

        properties.remove("color");
        properties.remove("price");
        properties.remove("rent");

        properties.put("name", "Go: Collect $200");
        addTile( 0, TileType.OTHER, new TileSpec(properties) );

        properties.put("name", "Community Chest");
        addTile( 2, TileType.COMMUNITY_CHEST, new TileSpec(properties) );

        properties.put("name", "Income Tax: Pay 10% or $200");
        addTile( 4, TileType.OTHER, new TileSpec(properties) );




    } // **** end initializeBoard() ****

    private void initRent(int[] rent, int noHouse, int oneHouse, int twoHouse, int threeHouse, int fourHouse, int hotel) {
        rent[0] = noHouse;
        rent[1] = oneHouse;
        rent[2] = twoHouse;
        rent[3] = threeHouse;
        rent[4] = fourHouse;
        rent[5] = hotel;
    }

    private void addTile(int boardPosition, TileType type, TileSpec spec) {

        Tile tile = new Tile(boardPosition, type, spec);
        board.add(tile);

    } // **** end addTile(int, TileType, TileSpec) ****

} // **** end MonopolyBoard class ****
