package count_zero_init.model.surroundings;

public class Tree extends Tile
    implements NotWalkable {

    public Tree(int col, int row) {
        this.col = col;
        this.row = row;
        this.name = "tree";
        setImageAddress("src/count_zero_init/model/surroundings/tree.png");
    }

}
