package CaveOfProgramming.JavaForCompleteBeginners.ProgrammingCoreJava.EnumTypesBasicAndAdvancedUsage;

public enum Animal {
    CAT("Garfield"), DOG("Dogbert"), MOUSE("Mickey");

    String name;

    Animal(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public String toString() {
        return "This animal is called " + name;
    }
}
