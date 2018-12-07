package CaveOfProgramming.JavaForCompleteBeginners.ProgrammingCoreJava.TransientKeywordAndMoreSerialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObjects {

    public static void main(String[] args) {
        System.out.println("Writing objects...");

        // Classes can go in the try-with-resource list if they implement the AutoCloseable interface.

        // This try-with-resource line can be made more tidy if FileOutputStream is created as an anonymous class (we
        // don't use the variable name "fs" anyways so we could just instantiate it anonymously.
            // Let's do this to our ReadObjects class too.

        try(ObjectOutputStream os = new ObjectOutputStream( new FileOutputStream("test.ser") )) {
        //try(FileOutputStream fs = new FileOutputStream("test.ser"); ObjectOutputStream os = new ObjectOutputStream(fs)) {
            Person person = new Person(7, "Bob");
            Person.setCount(88);
            os.writeObject(person);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
