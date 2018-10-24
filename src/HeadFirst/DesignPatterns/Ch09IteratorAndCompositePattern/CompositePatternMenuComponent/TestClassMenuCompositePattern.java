package HeadFirst.DesignPatterns.Ch09IteratorAndCompositePattern.CompositePatternMenuComponent;

// Unlike our previous version, we're going to handle all the menu creation in the test drive. We could ask each chef to
// give us his new menu, but let's get it all tested first.
public class TestClassMenuCompositePattern {
    public static void main(String[] args) {
        // Let's first create all the menu objects.
        MenuComponent pancakeHouseMenu = new Menu("PANCAKE HOUSE MENU", "Breakfast");
        MenuComponent dinerMenu = new Menu("DINER MENU", "Lunch");
        MenuComponent cafeMenu = new Menu("CAFE MENU", "Dinner");
        MenuComponent dessertMenu = new Menu("DESSERT MENU", "Dessert of course!");

        // We also need a top level menu that we'll name allMenus.
        MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");

        // We're using the Composite add() method to add each menu to the top level menu, allMenus.
        allMenus.add(pancakeHouseMenu);
        allMenus.add(dinerMenu);
        allMenus.add(cafeMenu);

        // Now we need to add all the menu items, here's one example, for the rest, look at the complete source code.
        // add menu items here

        dinerMenu.add(new MenuItem(
                "Pasta",
                "Spaghetti with Marianara Sauce, and a slice of sourdough bread",
                true,
                3.89));

        // And we're also adding a menu to a menu. All dinerMenu cares about is that everything it holds, whether it's a
        // menu item or menu, is a MenuComponent().
        dinerMenu.add(dessertMenu);

        // Add some apple pie to the dessert menu...
        dessertMenu.add(new MenuItem(
                "Apple Pie",
                "Apple pie with a flakey crust, topped with vanilla icecream",
                true,
                1.59));

        // add more menu items here

        // One we've constructed our entire menu hierarchy, we hand the whole thing to the Waitress, and as you've seen,
        // it's easy as apple pie for her to print it out.
        Waitress waitress = new Waitress(allMenus);

        waitress.printMenu();
        waitress.printVegetarianMenu();

    }
}
