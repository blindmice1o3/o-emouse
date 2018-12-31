package count_zero_init.controller.state;

public interface State {
    public void aButtonPressed();
    public void bButtonPressed();
    public void selectButtonPressed();
    public void startButtonPressed();
    public void upButtonPressed();
    public void downButtonPressed();
    public void rightButtonPressed();
    public void leftButtonPressed();
    public String toString();
    public void gameKeyPressed(int keyCode);
}
