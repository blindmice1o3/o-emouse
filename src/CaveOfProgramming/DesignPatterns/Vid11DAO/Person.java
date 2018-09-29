package CaveOfProgramming.DesignPatterns.Vid11DAO;

public class Person {
    private int it;
    private String name;
    private String password;

    // A bean needs a no argument constructor
    public Person() {

    }
    // For convenience, we'll have a second constructor
    public Person(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public int getIt() {
        return it;
    }

    public void setIt(int it) {
        this.it = it;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
