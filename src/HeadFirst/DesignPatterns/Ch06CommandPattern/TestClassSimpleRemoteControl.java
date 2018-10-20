package HeadFirst.DesignPatterns.Ch06CommandPattern;

/*
    -----     -----     -----
    COMMAND pattern: encapsulates a request as an object, thereby letting you parameterize clients with different
        requests, queue or log requests, and support undoable operation.
    -----     -----     -----

    Home Automation or Bust, Inc. hired us to write the API for programming a Remote Control that has 7 programmable
        slots along with corresponding on/off buttons for each. The remote also has a global undo button. We are supplied
        with a set of Java classes on CD-R that were created by various vendors to control home automation devices such
        as lights, fans, hot tubs, audio equipment, and other similar controllable appliances. Open for extension.

    Objectville Diner from Ch1:
        // The Customer knows what he wants and creates an order.
        // The Order consists of an order slip and the customer's menu items that are written on it.
            customer1.createOrder();

        // The Waitress takes the Order, and when she gets around to it, she calls its orderUp() method to begin the
        //     Order's preparation.
            waitress1.takeOrder();
            waitress1.orderUp();

        // The Order has all the instructions needed to prepare the meal. The Order directs the Short Order Cook with
        //     methods like makeBurger();
        // The Short Order Cook follows the instructions of the Order and produces the meal.
            order.makeBurger();
            order.makeShake();

    Command pattern:
        // The Client is responsible for creating the command object. The command object consists of a set of actions on a
        //     Receiver.
        // The actions and Receiver are bound together in the command object.
        // The command object provides one method, execute(), that encapsulates the actions and can be called to invoke the
        //     actions on the Receiver.
            client1.createCommandObject();

        // The client calls setCommand() on an Invoker object and passes it the command object, where it gets stored until
        //     it is needed.
        // At some point in the future the Invoker calls the command object's execute() method...
            invoker1.setCommand(Command command);
            command.execute();

        // ... which results in the actions being invoked on the Receiver.
            receiver.action1();
            receiver.action2();

    Diner vs Command pattern:
        Customer            <-------->    Client
        Order               <-------->    Command
        Waitress            <-------->    Invoker
        takeOrder()         <-------->    setCommand()
        orderUp()           <-------->    execute()
        Short Order Cook    <-------->    Receiver

    All command objects implement the same interface, which consists of one method. In the Diner we called this method
        orderUp(); however, we typically just use the name execute().

    The Command interface has one method: public void execute();

    For the concrete classes implementing the Command interface (e.g. LightOnCommand, the Client's order), the constructor
        is passed the Receiver it's going to command (e.g. living room light). It provide implementations for the public
        void execute() method (calling its stored Receiver's method(s) [e.g. light.on();]). Instances of LightOnCommand
        are command objects. The ConcreteCommand defines a binding/bundling between an action and a Receiver.

    The Invoker (e.g. Waitress from the diner example, the Remote Control from the home-automation scenario) has a
        method for setting its Command instance variables (e.g. public void setCommand(Command command)). This could be
        called multiple times if the client of this code wanted to change the behavior of the remote control's button.
        It also has a method to call its command object's execute() (e.g. public void buttonWasPressed(); when that
        method is called, the command object's execute() method is called [the command object is bundled as a set of
        actions to perform and a Receiver], which calls methods [the set of actions to perform] on its Receiver).


    Next, assigning commands (command objects) to each slot (buttons/Command instance variables) of the remote control...
    // See class RemoteControl (oppose to SimpleRemoteControl which just had one slot/button) and TestClassRemoteLoader


    *** The NoCommand (not official design pattern, but Honorable Mention!) ***
    The NoCommand object is an example of a null object. A null object is useful when you don't have a meaningful object
        to return, and yet you want to remove the responsibility for handling null from the client. For instance, in our
        remote control we didn't have a meaningful object to assign to each slot out of the box, so we provided a NoCommand
        object that acts as a surrogate and does nothing when its execute() method is called.
    You'll find uses for Null Objects in conjunction with many Design Patterns and sometimes you'll even see Null Object
        listed as a Design Pattern.


    Next, the undo button on the remote and the undo command...
    -The undo method is added to our Command interface, now all concrete commands must supply implementation to undo().
    -We need to work a little support into the RemoteControl class to handle tracking the last command invoked (store it
        in an instance variable) and what to do when the undo button is pressed (retrieve the last command invoked from
        its instance variable then call that command's undo() method).
    -Tested undo command for CeilingFan (stores previous state of its speed instance variable) in TestClassRemoteLoader


    Macro command (a command that can execute other Commands) (Party Mode: one button and the lights dims, stereo and TV
    turns on and set to a DVD, and the hot tub fires up)
    // See classes: MacroCommand and this class (TestClassSimpleRemoteControl, but I'm using a RemoteControl instead of
    //     SimpleRemoteControl in the second half of this test class)
    -Take an array of Commands and store them in the MacroCommand object's instance variable Command[] commands
    -When the macro gets executed by the remote, execute those commands one at a time using a for-loop


    Queuing requests:
    -Commands give us a way to package a piece of computation (a receiver and a set of actions) and pass it around as a
        first-class object.
    -Imagine a job queue, you add commands to the queue on one end, and on the other end sit a group of threads. Threads
        run the following script: they remove a command from the queue, call its execute() method, wait for the call to
        finish, then discard the command object and retrieve a new one.
    -Note that the job queue classes are totally decoupled from the objects that are doing the computation. One minute a
        thread may be computing a financial computation, and the next it may be retrieving something from the network.

    Logging requests:
    -The Command Pattern can support logging all actions and being able to recover after a crash by invoking those actions.
    -We need to add two methods to the Command interface (currently just execute and undo): store() and load().
    -In Java, we can use object serialization to implement these methods (but normal caveats for using serialization
        for persistence apply).
        -As we execute commands, we store a history of them on disk. When a crash occurs, we reload the command objects
            and invoke their execute() methods in batch and in order.
        -By using logging, we can save all the operations since the last check point, and if there is a system failure,
            apply those operations to our check point.
    -Logging wouldn't make sense for a remote control, but would for a spreadsheet application: we might want to implement
        our failure recovery by logging the actions on the spreadsheet rather than writing a copy of the spreadsheet to
        disk every time a change occurs. In more advanced applications, these techniques can be extended to apply to sets
        of operations in a transactional manner so that all of the operations complete, or none of them do.

    -----     -----     -----
    COMMAND pattern: encapsulates a request as an object, thereby letting you parameterize other objects with different
        requests, queue or log requests, and support undoable operation.
    -----     -----     -----
 */

// This is our Client in Command Pattern-speak.
public class TestClassSimpleRemoteControl {
    public static void main(String[] args) {
        // The remote is our Invoker; it will be passed a command object that can be used to make requests.
        SimpleRemoteControl remote = new SimpleRemoteControl();
        // Now we create a Light object, this will be the Receiver of the request (like the Short Order Cook from the diner).
        Light light = new Light();
        // Here, create a command and pass it to the Receiver.
        LightOnCommand lightOn = new LightOnCommand(light);

        // Here, pass the command to the Invoker.
        remote.setCommand(lightOn);
        // And then we simulate the button being pressed.
        remote.buttonWasPressed();


        GarageDoor garageDoor = new GarageDoor();
        GarageDoorOpenCommand garageOpen = new GarageDoorOpenCommand(garageDoor);
        remote.setCommand(garageOpen);
        remote.buttonWasPressed();


        System.out.println("\n\n\nTesting the macro button (the Command that execute other Commands)");
        RemoteControl remoteControlWithMacro = new RemoteControl();

        // Creating vendor classes and on/off commands for those classes to test the MacroCommand
        Stereo stereo = new Stereo();
        CeilingFan ceilingFan = new CeilingFan("Living Room");
        StereoOnWithCDCommand stereoOn = new StereoOnWithCDCommand(stereo);
        CeilingFanHighCommand ceilingFanHigh = new CeilingFanHighCommand(ceilingFan);
        LightOffCommand lightOff = new LightOffCommand(light);
        StereoOffCommand stereoOff = new StereoOffCommand(stereo);
        CeilingFanOffCommand ceilingFanOff = new CeilingFanOffCommand(ceilingFan);
        GarageDoorCloseCommand garageClose = new GarageDoorCloseCommand(garageDoor);

        // Create an array for On and an array for Off commands...
        Command[] partyOn = {lightOn, garageOpen, stereoOn, ceilingFanHigh};
        Command[] partyOff = {lightOff, garageClose, stereoOff, ceilingFanOff};
        // ...and create two corresponding macros to hold them.
        MacroCommand partyOnMacro = new MacroCommand(partyOn);
        MacroCommand partyOffMacro = new MacroCommand(partyOff);

        // Assign the macro command to a button as we would any command.
        remoteControlWithMacro.setCommand(0, lightOn, lightOff);
        remoteControlWithMacro.setCommand(1, garageOpen, garageClose);
        remoteControlWithMacro.setCommand(2, stereoOn, stereoOff);
        remoteControlWithMacro.setCommand(3, ceilingFanHigh, ceilingFanOff);
        remoteControlWithMacro.setCommand(4, partyOnMacro, partyOffMacro);

        // Push some buttons to see if this works.
        System.out.println(remoteControlWithMacro);
        System.out.println("--- Pushing Macro On ---");
        remoteControlWithMacro.onButtonWasPushed(4);
        System.out.println("--- Pushing Macro Off ---");
        remoteControlWithMacro.offButtonWasPushed(4);
    }
}
