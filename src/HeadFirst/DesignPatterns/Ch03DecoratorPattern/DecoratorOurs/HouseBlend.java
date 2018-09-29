package HeadFirst.DesignPatterns.Ch03DecoratorPattern.DecoratorOurs;

public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "House Blend Coffee";
    }

    public double cost() {
        System.out.println("HouseBlend's cost");
        return 0.89;
    }
}
