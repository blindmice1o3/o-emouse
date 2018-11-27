package CaveOfProgramming.JavaForCompleteBeginners.ProgrammingCoreJava.SerializationSavingObjectsToFiles.deserialization;

import CaveOfProgramming.JavaForCompleteBeginners.ProgrammingCoreJava.SerializationSavingObjectsToFiles.Person;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ReadObjects {

    public static void main(String[] args) {
        System.out.println("Reading objects...");

        try(FileInputStream fi = new FileInputStream("people.bin")) {

            ObjectInputStream os = new ObjectInputStream(fi);


            Person person1 = (Person)os.readObject();
            Person person2 = (Person)os.readObject();

            Person[] personArray = (Person[])os.readObject();
            ArrayList<Person> personArrayList = (ArrayList<Person>)os.readObject();

            os.close();


            System.out.println(person1);
            System.out.println(person2);

            for (Person person: personArray) {
                System.out.println("regular array of Person objects deserialized:  " + person);
            }

            for (Person person: personArrayList) {
                System.out.println("ArrayList<Person> deserialized: " + person);
            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

}
