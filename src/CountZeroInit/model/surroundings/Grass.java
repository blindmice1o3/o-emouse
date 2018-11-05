package CountZeroInit.model.surroundings;

public class Grass extends Tile
    implements Walkable {

    public Grass(int col, int row) {
        this.col = col;
        this.row = row;
        this.name = "grass";
    }

}
