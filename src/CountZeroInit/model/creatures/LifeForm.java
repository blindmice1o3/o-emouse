package CountZeroInit.model.creatures;

public abstract class LifeForm {
    String name;
    String type;
    int col;
    int row;

    @Override
    public String toString() {
        return "LifeForm's name is: " + name + "\nLifeForm's type is: " + type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
