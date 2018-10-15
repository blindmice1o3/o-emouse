package HeadFirst.DesignPatterns.Ch06CommandPattern;

public class TestClassRemoteLoader {
    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();

        // Create all the devices in their proper locations. These are instances of vender-provided classes.
        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light ("Kitchen");
        //CeilingFan ceilingFan = new CeilingFan("Living Room");
        GarageDoor garageDoor = new GarageDoor();
        Stereo stereo = new Stereo();

        // Create all the Light Command objects.
        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
        LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
        LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);

        // Create the On and Off for the ceiling fan.
        /*
            Code for ceiling fan related commands goes here.
         */

        // Create the Up and Down commands for the Garage.
        /*
            Code for garage door related commands goes here.
         */

        // Create the stereo On and Off commands.
        StereoOnWithCDCommand stereoOnWithCD = new StereoOnWithCDCommand(stereo);
        StereoOffCommand stereoOff = new StereoOffCommand(stereo);

        // Now that we've got all our commands, we can load them into the remote slots.
        remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        remoteControl.setCommand(1, kitchenLightOn, kitchenLightOff);
        remoteControl.setCommand(2, stereoOnWithCD, stereoOff);

        // Here's where we use our toString() method to print each remote slot and the command that it is assigned to.
        System.out.println(remoteControl);

        // All right, we are ready to roll! Now, we step through each slot and push its On and Off button.
        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
        remoteControl.onButtonWasPushed(1);
        remoteControl.offButtonWasPushed(1);
        remoteControl.onButtonWasPushed(2);
        remoteControl.offButtonWasPushed(2);

        // Time to QA that Undo button!
        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
        System.out.println(remoteControl);
        remoteControl.undoButtonWasPushed();
        remoteControl.offButtonWasPushed(0);
        remoteControl.onButtonWasPushed(0);
        System.out.println(remoteControl);
        remoteControl.undoButtonWasPushed();


        // *********** Test the ceiling fan ***************

        System.out.println("\n\nTest the ceiling fan");

        RemoteControl remoteControl2 = new RemoteControl();

        CeilingFan ceilingFan = new CeilingFan("Living Room");

        // Here we instantiate three commands: high, medium, and off.
        CeilingFanHighCommand ceilingFanHigh = new CeilingFanHighCommand(ceilingFan);
        CeilingFanMediumCommand ceilingFanMedium = new CeilingFanMediumCommand(ceilingFan);
        CeilingFanOffCommand ceilingFanOff = new CeilingFanOffCommand(ceilingFan);

        // Here we put medium in slot zero, and high in slot one. We also load up the off commands.
        remoteControl2.setCommand(0, ceilingFanMedium, ceilingFanOff);
        remoteControl2.setCommand(1, ceilingFanHigh, ceilingFanOff);

        // First, turn the fan on medium.
        remoteControl2.onButtonWasPushed(0);
        // Then turn it off.
        remoteControl2.offButtonWasPushed(0);
        System.out.println(remoteControl2);
        // Undo! It should go back to medium...
        remoteControl2.undoButtonWasPushed();

        // Turn it on to high this time.
        remoteControl2.onButtonWasPushed(1);
        System.out.println(remoteControl2);
        // And, one more undo; it should go back to medium.
        remoteControl2.undoButtonWasPushed();
    }
}
