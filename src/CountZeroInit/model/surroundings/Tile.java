package CountZeroInit.model.surroundings;

public abstract class Tile {
    int col;
    int row;
    String pix;

    public Tile() {

    }

    public Tile(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public void setCol(int col){ this.col = col; }
    public void setRow(int row) { this.row = row; }
    public String getPix() {
        return this.pix;
    }
}
