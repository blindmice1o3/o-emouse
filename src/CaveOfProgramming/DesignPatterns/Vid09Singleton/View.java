package CaveOfProgramming.DesignPatterns.Vid09Singleton;

public class View {

    // Doing it the following way is not ideal if we only want one thing to access to Database at a time.
    // Database db = new Database();

    // Instead, we call a method that will give us access to the one and ONLY ONE instance of Database
    // We're calling the static method of the Database class that'll return the only reference of the Database object.
    Database db = Database.getInstance();

}
