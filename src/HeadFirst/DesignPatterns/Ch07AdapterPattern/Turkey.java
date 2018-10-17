package HeadFirst.DesignPatterns.Ch07AdapterPattern;

public interface Turkey {
    // Turkeys don't quack, they gobble.
    public void gobble();
    // Turkeys can fly, although they can only fly short distances.
    public void fly();
}
