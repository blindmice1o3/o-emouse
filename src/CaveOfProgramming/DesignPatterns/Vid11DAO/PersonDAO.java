package CaveOfProgramming.DesignPatterns.Vid11DAO;

// Design Patterns: DAO (Database Access Object pattern)
//  bean class: transfer object
//  DAO class: middleman between bean data and the database (has methods to manipulate the database)
//      CRUD - create, retrieve, update, delete (DAO class's methods)

// Caveofprogramming's example starts with a form (window) to create new users; and takes that data and enters
//      it into a MySQL database/table (creates a new row that includes id (int), name (varChar), and
//      password (varChar)

// We also have a class called Person that stores the id, name, and password
//      It's considered a "bean" (small/light-weight object used to transfer data)

// The bean (Person object) will get passed to a class called PersonDAO (which is what will deal with the
//      database) (it will have methods: create, retrieve, and update) to add, remove, find stuff from the database

// The idea behind a DAO class is you have one DAO class per table (or view... a view could be multiple tables)

// The essence of this is to abstract away the details of dealing with the data and database

// The next tutorial will be DAO Factories, which will help us manage our DAO objects
import java.util.List;

public class PersonDAO {
    public void addPerson(Person person) {  // Our create method...

    }

    public Person getPerson(int id) {   // Our retrieve method... retrieves a single Person
        return null;
    }

    public List<Person> getPeople() {   // Our retrieve method... retrieves a list of multiple Person
        return null;                    // If it's a big database, you don't want to retrieve all of it at once
    }                                   // Normally there's a find method to get only the data we want

    public void updatePerson(Person person) {   // Our update method...

    }

    public void deletePerson(int id) {  // Our delete method...

    }
}
