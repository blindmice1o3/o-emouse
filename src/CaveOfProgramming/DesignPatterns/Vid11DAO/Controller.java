package CaveOfProgramming.DesignPatterns.Vid11DAO;

public class Controller {
    // In the Controller, we'll have a class variable representing our DAO

    private View view;
    private Model model;

    private PersonDAO personDAO = new PersonDAO();

    public Controller(View view, Model model){
        this.view = view;
        this.model = model;
    }

    /* @Override
    public void userCreated(CreateUserEvent event) {
        System.out.println("Login event received: " + event.getName() + "; " + event.getPassword());

        personDAO.addPerson(new Person(event.getName(), event.getPassword()));
        // The idea is to create a new Person object and pass it to your DAO, and the DAO will deal with passing it to
        //      the database/table
    }
    */

}
