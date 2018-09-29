package HeadFirst.DesignPatterns.Ch02ObserverPattern.ObserverJavaBuiltInPattern;

// Make sure we are importing the right Observer/Observable
import java.util.Observable;
import java.util.Observer;

// We are now subclassing Observable
public class WeatherData extends Observable {
    // We don't need to keep track of our observers anymore, or manage their registration and removal, (the superclass
    //     will handle that) so we've removed the code for register, add and notify.
    private float temperature;
    private float humidity;
    private float pressure;

    // Our constructor no longer needs to create a data structure to hold Observers
    public WeatherData() {

    }

    public void measurementsChanged() {
        // We now first call setChanged() to indicate the state has changed before calling notifyObservers().
        setChanged();

        // Notice we aren't sending a data object with the notifyObservers() call. That means we're using the PULL model.
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    // These methods aren't new, but because we are going to use "pull" we thought we'd remind you they are here. The
    //     Observers will use them to get at the WeatherData object's state.
    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
