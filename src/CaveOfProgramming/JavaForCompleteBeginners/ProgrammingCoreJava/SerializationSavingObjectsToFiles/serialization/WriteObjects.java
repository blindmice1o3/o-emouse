package CaveOfProgramming.JavaForCompleteBeginners.ProgrammingCoreJava.SerializationSavingObjectsToFiles.serialization;

import CaveOfProgramming.JavaForCompleteBeginners.ProgrammingCoreJava.SerializationSavingObjectsToFiles.Person;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class WriteObjects {

    public static void main(String[] args) {
        System.out.println("Writing objects...");

        Person mike = new Person(543, "Mike");
        Person sue = new Person(123, "Sue");

        System.out.println(mike);
        System.out.println(sue);

        Person[] personArray = { new Person(1, "Bob"), new Person(2, "Nancy"), new Person(3, "Rue") };
        ArrayList<Person> personArrayList = new ArrayList<Person>(Arrays.asList(personArray));

        // This class lets us stream data to a file (streaming just means sending data sequentially to a file).
        // We need to supply an argument to the constructor (which is the name of the file to stream TO).
        // Could give it a full file path, but just going to give it a simple name "people.bin" (if I just give a name
        //      without the full path, it'll write that to the working directory of this program. It'll be the project
        //      folder in the IDE.
        // The extension doesn't matter, you can give it whatever you want (.bin and .data are typical for binary files,
        //      but it could be anything at all).
        // Then we need to surround it in a try/catch or throw the exception.
        // Here we're going to use the "try-with-resources" syntax, something introduced in Java7. This syntax will
        //      automatically call the close the close() on the fs object (previously we had to close it manually).
        // We have the FileOutputStream, the next thing we need is the ObjectOutputStream.
        // And we need to pass a FileOutputStream object to the constructor of the ObjectOutputStream. The fs object we
        //      pass to the ObjectOutputStream lets os stream data to a file.
        // Have to call the close() on os myself (otherwise I'll get a warning). fs is closed automatically, os it not.
        try(FileOutputStream fs = new FileOutputStream("people.bin")) {

            ObjectOutputStream os = new ObjectOutputStream(fs);

            // We're taking some kind of output stream and passing it some kind of fileoutput stream, and using that to
            //      write to file. Like russian doll thing (within each other) (decorator pattern, object composition).

            os.writeObject(mike);   //1object
            os.writeObject(sue);    //2object

            os.writeObject(personArray);    //3object
            os.writeObject(personArrayList);    //4object

            // Record the size of the ArrayList during the Serialization so we can use it when we Deserialize.
            os.writeInt(personArrayList.size());    //1Int

            // Record all the objects in this ArrayList (we had saved the size of it in our previous method call which
            // recorded an int. When the ReadObjects class deserializes the people.bin file, it will record that int, then
            // it can go on to use a regular for loop to iterate through the ArrayList<Person>, calling the readObject()
            // method the correction number of times because of the int.
            for (Person person: personArrayList) {
                os.writeObject(person);             //5,6,7object
            }

            os.close();


            System.out.println("person1 and person2 written to \"people.bin\"");


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
