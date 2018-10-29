package CountZeroInit.controller.state;

public class GameState implements State {
    @Override
    public void aButtonPressed() {
        System.out.println("Pressed button: A");
    }

    @Override
    public void bButtonPressed() {
        System.out.println("Pressed button: B");
    }

    @Override
    public void selectButtonPressed() {
        System.out.println("Pressed button: select");
    }

    @Override
    public void startButtonPressed() {
        System.out.println("Pressed button: start");
    }

    @Override
    public void upButtonPressed() {
        if (player1.getLocation())
    }

    @Override
    public void downButtonPressed() {

    }

    @Override
    public void rightButtonPressed() {

    }

    @Override
    public void leftButtonPressed() {

    }
}
