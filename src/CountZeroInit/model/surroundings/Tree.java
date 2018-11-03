package CountZeroInit.model.surroundings;

public class Tree extends Tile
    implements Walkable {
    String pix = "T";

    public Tree(int col, int row) {
        this.col = col;
        this.row = row;
        setImageAddress("src/CountZeroInit/model/surroundings/tree.png");
    }
}
