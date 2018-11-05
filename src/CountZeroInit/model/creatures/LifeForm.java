package CountZeroInit.model.creatures;

public abstract class LifeForm {
    int col;
    int row;
    String name;
    String type;
    String imageAddress;

    @Override
    public String toString() {
        return "LifeForm.name, type, col, row: " + name + ", " + type + ", " + col + ", " + row;
    }

    public void setCol(int col) {
        this.col = col;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setImageAddress(String imageAddress) {
        this.imageAddress = imageAddress;
    }

    public int getCol() {
        return col;
    }
    public int getRow() {
        return row;
    }
    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public String getImageAddress() {
        return imageAddress;
    }
}
