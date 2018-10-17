package HeadFirst.DesignPatterns.Ch08TemplatePattern;

// CaffeineBeverageWithHook is abstract
public abstract class CaffeineBeverageWithHook {
    // Now, the same prepareRecipe() method will be used to make both Tea and Coffee. prepareRecipe() is declared
    // final because we don't want our subclasses to be able to override this method and change the recipe! We've
    // generalized steps 2 and 4 to brew() the beverage and addCondiments().
    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        // We've added a little conditional statement that bases its success on a concrete method, customerWantsCondiments().
        // If the customer WANTS condiments, only then do we call addCondiments().
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    // Because Coffee and Tea handle these methods in different ways, they're going to have to be declared as abstract.
    abstract void brew();

    abstract void addCondiments();

    // Remember, we moved these into the CaffeineBeverageWithHook class (back in our class diagram)
    void boilWater() {
        System.out.println("Boiling water");
    }

    void pourInCup() {
        System.out.println("Pouring into cup");
    }

    // Here we've defined a method with a (mostly) empty default implementation. This method just returns true and does
    //     nothing else.
    // This is a hook because the subclass can override this method, but doesn't have to.
    boolean customerWantsCondiments() {
        return true;
    }
}
