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


            Person person1 = (Person)os.readObject();   //1object
            Person person2 = (Person)os.readObject();   //2object

            Person[] personArray = (Person[])os.readObject();       //3object
            ArrayList<Person> personArrayList = (ArrayList<Person>)os.readObject();     //4object

            System.out.println(person1);
            System.out.println(person2);

            for (Person person: personArray) {
                System.out.println("regular array of Person objects deserialized:  " + person);
            }

            for (Person person: personArrayList) {
                System.out.println("ArrayList<Person> deserialized: " + person);
            }



            // We saved the size of the ArrayList<Person> in our WriteObjects class on purpose so we can read it back in
            // this ReadObjects class, able to use it as an upper index in a regular for loop.
            int num = os.readInt();     //1Int

            for (int i=0; i < num; i++) {
                Person person = (Person)os.readObject();    //5,6,7object
                System.out.println(person);
            }

            os.close();








        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

}
