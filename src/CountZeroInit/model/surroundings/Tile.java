package CountZeroInit.model.surroundings;

public abstract class Tile {
    int col;
    int row;
    String name;
    String imageAddress;

    public Tile() {
    }

    public void setCol(int col){ this.col = col; }
    public void setRow(int row) { this.row = row; }
    public void setName(String name) { this.name = name; }
    public void setImageAddress(String imageAddress) {
        this.imageAddress = imageAddress;
    }


    public int getCol() { return col; }
    public int getRow() { return row; }
    public String getName() { return name; }
    public String getImageAddress() {
        return imageAddress;
    }
}
