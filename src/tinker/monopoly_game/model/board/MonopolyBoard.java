package tinker.monopoly_game.model.board;

import tinker.monopoly_game.model.PairOfDices;
import tinker.monopoly_game.model.card.ChanceCard;
import tinker.monopoly_game.model.card.CommunityChestCard;
import tinker.monopoly_game.model.card.PropertyCard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MonopolyBoard {

    private List<PropertyCard> deckOfPropertyCard;
    private List<ChanceCard> deckOfChanceCard;
    private List<CommunityChestCard> deckOfComunityChestCard;
    private List<Tile> board;
    private PairOfDices pairOfDices;

    public static void main(String[] args) {
        new MonopolyBoard();
    }

    public MonopolyBoard() {

        initDeckOfPropertyCard();
        initDeckOfChanceCard();
        initDeckOfCommunityChestCard();

        initializeBoard();



        pairOfDices = new PairOfDices();

        pairOfDices.rollPairOfDices();
        pairOfDices.rollPairOfDices();
        pairOfDices.rollPairOfDices();
        pairOfDices.rollPairOfDices();
        pairOfDices.rollPairOfDices();
        pairOfDices.rollPairOfDices();
        pairOfDices.rollPairOfDices();
        pairOfDices.rollPairOfDices();
    }



    private void initDeckOfPropertyCard() {
        deckOfPropertyCard = new ArrayList<PropertyCard>();
        Map map = new HashMap();
        int[] rent = new int[6];

        // ==== PURPLE ====
        map.put("color", Color.PURPLE);
        map.put("name", "Mediterranean Avenue");
        map.put("price", 60);
        initRent(rent, 2, 10, 30, 90, 160, 250);
        map.put("rent", rent);
        addPropertyCard( 1, ItemType.PROPERTY, new MapOfSpecs(map) );

        map.put("color", Color.PURPLE);
        map.put("name", "Baltic Avenue");
        map.put("price", 60);
        initRent(rent, 4, 20, 60, 180, 320, 450);
        map.put("rent", rent);
        addPropertyCard( 3, ItemType.PROPERTY, new MapOfSpecs(map) );

        // ==== RAILROAD ====
        map.remove("color");
        map.put("name", "Reading Railroad");
        map.put("price", 200);
        map.remove("rent");
        addPropertyCard(5, ItemType.PROPERTY, new MapOfSpecs(map) );

        // ==== LIGHT_BLUE ====
        map.put("color", Color.LIGHT_BLUE);
        map.put("name", "Oriental Avenue");
        map.put("price", 100);
        initRent(rent, 6, 30, 90, 270, 400, 550);
        map.put("rent", rent);
        addPropertyCard( 6, ItemType.PROPERTY, new MapOfSpecs(map) );

        map.put("color", Color.LIGHT_BLUE);
        map.put("name", "Vermont Avenue");
        map.put("price", 100);
        initRent(rent, 6, 30, 90, 270, 400, 550);
        map.put("rent", rent);
        addPropertyCard( 8, ItemType.PROPERTY, new MapOfSpecs(map) );

        map.put("color", Color.LIGHT_BLUE);
        map.put("name", "Connecticut Avenue");
        map.put("price", 120);
        initRent(rent, 8, 40, 100, 300, 450, 600);
        map.put("rent", rent);
        addPropertyCard( 9, ItemType.PROPERTY, new MapOfSpecs(map) );
    } // **** end initDeckOfPropertyCard() ****

    private void initDeckOfChanceCard() {
        deckOfChanceCard = new ArrayList<ChanceCard>();
    }

    private void initDeckOfCommunityChestCard() {
        deckOfComunityChestCard = new ArrayList<CommunityChestCard>();
    }

    private void initializeBoard() {
        board = new ArrayList<Tile>();

        for (PropertyCard card: deckOfPropertyCard) {
            addTile( card.getBoardPosition(), card.getItemType(), card.getMapOfSpecs() );
        }

        // ************************* OTHER, COMMUNITY_CHEST, and CHANCE **************************************
        Map map = new HashMap();

        map.put("name", "Go: Collect $200");
        addTile( 0, ItemType.OTHER, new MapOfSpecs(map) );

        map.put("name", "Community Chest");
        addTile( 2, ItemType.COMMUNITY_CHEST, new MapOfSpecs(map) );

        map.put("name", "Chance");
        addTile(7, ItemType.CHANCE, new MapOfSpecs(map) );

        map.put("name", "Income Tax: Pay 10% or $200");
        addTile( 4, ItemType.OTHER, new MapOfSpecs(map) );

        map.put("name", "In Jail/Just Visiting");
        addTile(10, ItemType.OTHER, new MapOfSpecs(map) );

        //3333333333333333333333333333333333333333333333333333333
        for (Tile tile: board) {
            System.out.println(tile);
        }
        //333333333333333333333333333333333333333333333333333333333

    } // **** end initializeBoard() ****

    public List<Tile> getBoard() {
        return board;
    }

    private void addTile(int boardPosition, ItemType type, MapOfSpecs mapOfSpecs) {

        Tile tile = new Tile(boardPosition, type, mapOfSpecs);
        board.add(tile);

    } // **** end addTile(int, ItemType, MapOfSpecs) ****

    private void addPropertyCard(int boardPosition, ItemType type, MapOfSpecs mapOfSpecs) {

        PropertyCard card = new PropertyCard(boardPosition, type, mapOfSpecs);
        deckOfPropertyCard.add(card);

    } // **** end addPropertyCard(int, ItemType, MapOfSpecs) ****

    private void initRent(int[] rent, int noHouse, int oneHouse, int twoHouse, int threeHouse, int fourHouse, int hotel) {
        rent[0] = noHouse;
        rent[1] = oneHouse;
        rent[2] = twoHouse;
        rent[3] = threeHouse;
        rent[4] = fourHouse;
        rent[5] = hotel;
    } // **** end initRent(int, int, int, int, int, int, int) ****

} // **** end MonopolyBoard class ****
