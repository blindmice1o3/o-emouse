package CaveOfProgramming.DesignPatterns.Vid12DAOFactory;
// DAO: Database Access Object
// DAO Factory: manages DAO classes/objects

// We have a DAO for Person class, there's also a Log DAO for the database's log tracking (adds entries to a log table)
//      So we have multiple DAO classes (in this ex., Log DAO doesn't need all methods of CRUD (no need update/delete)

// We have static methods to deal with whenever we use the DAOs in our M/V/C classes (mostly controller)

// Next tutorial will deal with JUnit testing of DAO classes
public class DAOFactory {
    /* public static DesignPatterns12.DAOFactory.PersonDAO getPersonDAO() {
        return new DesignPatterns12.DAOFactory.PersonDAO();
    }

    public static DesignPatterns12.DAOFactory.LogDAO getLogDAO() {
        return new DesignPatterns12.DAOFactory.LogDAO();
    }
    */
}
