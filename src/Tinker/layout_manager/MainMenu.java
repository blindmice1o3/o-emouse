package Tinker.layout_manager;


public enum MainMenu {
    MONSTER_LIST("Monster List"), MY_MONSTER_LIST("My Monster List"), ITEM_LIST("Item List"), PLAYER_INFO("Player Info"),
    SAVE("Save"), OPTION("Option"), EXIT("Exit");

    String name;

    MainMenu(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
