package Tinker.bicycle;

public class Bicycle {

    int cadence;
    int gear;
    int speed;

    public Bicycle(int startCadence, int startGear, int startSpeed) {
        cadence = startCadence;
        gear = startGear;
        speed = startSpeed;
    }

    public void setCadence(int newCadence) {
        cadence = newCadence;
    }

    public void setGear(int newGear) {
        gear = newGear;
    }

    public void applyBrake(int decrement) {
        speed -= decrement;
    }

    public void speedUp(int increment) {
        speed += increment;
    }

}
