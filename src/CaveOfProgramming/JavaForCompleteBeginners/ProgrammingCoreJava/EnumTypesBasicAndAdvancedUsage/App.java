package CaveOfProgramming.JavaForCompleteBeginners.ProgrammingCoreJava.EnumTypesBasicAndAdvancedUsage;

public class App {
    public static final int CORN = 0;
    public static final int GREEN_BEAN = 1;
    public static final int BROCCOLI = 2;


    public static void main(String[] args) {

        int vegetable = CORN;

        switch (vegetable) {
            case CORN:
                System.out.println("I'm a static/final constant called Corn with value: " + CORN);
                break;
            case GREEN_BEAN:
                System.out.println("I'm a static/final constant called Green Bean with value: " + GREEN_BEAN);
                break;
            case BROCCOLI:
                System.out.println("I'm a static/final constant called Broccoli with value: " + BROCCOLI);
        }

        Animal animal = Animal.MOUSE;

        switch (animal) {
            case CAT:
                System.out.println("Cat");
                break;
            case DOG:
                System.out.println("Dog");
                break;
            case MOUSE:
                System.out.println("Mouse");
                break;
            default:
                System.out.println("default");
        }

        // Animal.DOG is an enumerated constant
        System.out.println(Animal.DOG);
        // name() is from the class Enum, it returns the String version of the enumerated constant
        System.out.println("Enum name as a string: " + Animal.DOG.name());
        // the enum, Animal.DOG, is of class Animal
        System.out.println(Animal.DOG.getClass());
        // Animal.DOG is a Enum
        System.out.println(Animal.DOG instanceof Enum);
        // Animal.DOG is an Animal
        System.out.println(Animal.DOG instanceof Animal);
        // Animal.DOG is an Object
        System.out.println(Animal.DOG instanceof Object);
        // A getter method for the instance variable String name
        System.out.println(Animal.DOG.getName());

        // the opposite of Enum class's method called name(); here you give it a String and it returns an enumerated type
        // the println() prints out the toString version of the object (an enum called CAT; whose toString() has been
        // overridden to print the enum's instance data/variable called name [for our CAT, its String name is "Garfield")
        Animal animal2 = Animal.valueOf("CAT");
        System.out.println(animal2);
    }
}
