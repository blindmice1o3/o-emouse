package CaveOfProgramming.JavaForCompleteBeginners.ProgrammingCoreJava.TransientKeywordAndMoreSerialization;

import java.io.Serializable;

// Don't want to serialize more fields than we have to because that's going to be inefficient. And sometimes there
// are going to be fields in your object that you just can't serialize (or if you did serialize it, it would be pretty
// weird [e.g. if we were using threads... we don't want to serialize a lock or something like that]). So, certain
// kind of fields you don't need to serialize, or it's just not useful to serialize them. And you can prevent fields
// being serialized by using the "transient" keyword.

// Let's pretend we don't need to serialize the field "int id". We put the keyword !!!!! "transient" !!!!! in the declaration.


// Another thing worth mentioning with serialization is the interaction with !!!!! "static" !!!!! fields.


// Classes that implement the Serializable interface can have "private static final long serialVersionUID" fields,
// which is a way to keep track of whether the original class Person have changed (like adding new fields/methods),
// our ReadObjects class may not be able to deserialize Person objects if the Person class file changed too much
// (we need the same serialVersionUID from the version of Person class that we serialized with).

public class Person
        implements Serializable {

    private static final long serialVersionUID = -12L;

    private transient int id;       // After adding the "transient" keyword, if we run WriteObjects then ReadObjects...
    private String name;            // the output will be: Person [id=0, name=Bob]
                                    // as oppose to previous: Person [id=7, name=Bob]

    private static int count;   // Going to use the IDE to generate getters and setters (which will be !!!!! "static" !!!!! methods)
    // WriteObjects class now invokes the static method setCount() to change this !!!!! "static" !!!!!! field in class Person.
    // However, after running WriteObjects then ReadObjects, we see that the static field was not serialized (it's null/0).
    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Person.count = count;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + "] Count is: " + count;
    }
}
