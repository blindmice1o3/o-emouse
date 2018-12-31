package count_zero_init.model.surroundings;

public class Grass extends Tile
    implements Walkable {

    public Grass(int col, int row) {
        this.col = col;
        this.row = row;
        this.name = "grass";
    }

}
