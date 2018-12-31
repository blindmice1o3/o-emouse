package count_zero_init.model.surroundings;

public class House extends Tile
    implements NotWalkable {

    public House(int col, int row) {
        this.col = col;
        this.row = row;
        this.name = "house";
    }

}
