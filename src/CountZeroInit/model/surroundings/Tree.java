package CountZeroInit.model.surroundings;

public class Tree extends Tile
    implements NotWalkable {

    public Tree(int col, int row) {
        this.col = col;
        this.row = row;
        this.name = "tree";
        setImageAddress("src/CountZeroInit/model/surroundings/tree.png");
    }

}
