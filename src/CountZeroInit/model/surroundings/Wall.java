package CountZeroInit.model.surroundings;

public class Wall extends Tile
    implements NotWalkable {

    public Wall(int col, int row) {
        this.col = col;
        this.row = row;
        this.name = "wall";
    }

}
