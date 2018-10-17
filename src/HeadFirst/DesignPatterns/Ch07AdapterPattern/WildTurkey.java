package HeadFirst.DesignPatterns.Ch07AdapterPattern;

// Here's a concrete implementation of Turkey; like Duck, it just prints out its actions.
public class WildTurkey implements Turkey {
    public void gobble() {
        System.out.println("Gobble, gobble");
    }

    public void fly() {
        System.out.println("I'm flying a short distance");
    }
}
