package CountZeroInit.model.surroundings;

public class Grass extends Tile
    implements Walkable {
    String pix = "-";

    public Grass(int col, int row) {
        this.col = col;
        this.row = row;
    }

    @Override
    public String getPix() {
        return this.pix;
    }
}
