package HeadFirst.DesignPatterns.Ch04FactoryPattern;

public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {
    public Dough createDough() {
        return new ThickCrustDough();
    }
    public Sauce createSauce() {
        return new PlumTomatoSauce();
    }
    public Cheese createCheese() {
        return new Mozzarella();
    }
    public Veggies[] createVeggies() {
        Veggies[] veggies = { new Spinach(), new EggPlant(), new BlackOlives() };
        return veggies;
    }
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }
    public Clams createClam() {
        return new FrozenClams();
    }
}
