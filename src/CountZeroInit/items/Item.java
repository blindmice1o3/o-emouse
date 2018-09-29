package CountZeroInit.items;

public abstract class Item {
    String name;

    @Override
    public String toString() {
        return "Item's name is: " + name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
