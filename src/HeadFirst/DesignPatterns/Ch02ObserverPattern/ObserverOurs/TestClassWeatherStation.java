package HeadFirst.DesignPatterns.Ch02ObserverPattern.ObserverOurs;

/*    *some class files were downloaded, READ THROUGH: ForecaseDisplay, StatisticsDisplay, HeatIndexDisplay
    -----     -----     -----
    Observer pattern: defines a one-to-many dependency between objects so that when one object changes state,
        all of its dependents are notified and updated automatically.
    -----     -----     -----


    Subject (Observable) (publisher): WeatherData object (temperature sensor, humidity sensor, pressure sensor).
    Observer (Observer) (subscriber): CurrentConditionsDisplay object, StatisticsDisplay object, ForecastDisplay object.


    WeatherData source file is provided (3 getter methods return most recent weather measurements, and
        measurementChanged() [our code goes here; "This method gets called whenever the weather measurements
        have been updated"; we don't know/care HOW this method is called, we just know that it IS called]).

        We need to implement 3 display elements (observers) that use the weather data, must be updated each time
            WeatherData has new measurements.

        Our system must be expandable, other developers can create new custom display elements and users can add or remove
            as many display elements as they want to the application. FutureDisplay object (future observer).

    Try implementing measurementChanged() by creating local variables of temp, humidity, and pressure and setting each to
        point to whatever the 3 getter methods return. Then called update(temp, humidity, pressure) for each display elements.
    Problem: we're calling update on 3 concrete display elements (so we have no way to add/remove other display elements
        without going back into this code and adding/removing changes to it).

    Observer pattern (newspaper/magazine subscriptions):
        1. A newspaper publisher goes into business and begins publishing newspapers.
        2. You subscribe to a particular publisher, and every time there's a new edition it gets delivered to you. As long
            as you remain a subscriber, you get a new newspaper.
        3. You unsubscribe when you don't want papers anymore, and they stop being delivered.
        4. While the publisher remains in business, people, hotels, airlines and other businesses constantly subscribe and
            unsubscribe to the newspaper.

    *****
    Try creating 3 interfaces (Subject, Observer, DisplayElement); WeatherData implements Subject, the 3 display elements
        implements Observer, DisplayElement; Observer's only method is update(), DisplayElement's only method is display().
    *****
    Problem: The Weather-O-Rama's CEO now wants to add a Heat Index display element.

    Things-to-know: multiple ways to implement the observer pattern; ***push*** state data OR ***pull*** state data
    Things-to-know: Java has "built-in" observer pattern. Main differences compared to what we created are (1) our
        subject (WeatherData) will extend a CLASS (Observable) instead of implementing an INTERFACE and (2) now it's a 2
        step process where you have to call the ***setChanged()*** method to signify that the state has changed in our
        subject/publisher/observable and then call ***one of two notifyObservers() methods*** (***notifyObservers()***
        OR ***notifyObservers(Object arg)***). Observers still implement update() method, but the signature is a bit
        different: update(Observable obs, Object arg).
            -"Object arg" is just an arbitrary data object that gets passed to each Observer when it is notified.
            -"setChanged()" method: sets a changed flag to true (behind the scenes). If notifyObservers() is called without
                first calling setChanged(), the observers will NOT be notified. This method gives us more flexibility in
                how we update observers by allowing us to optimize the notifications. I.e. only call setChanged() after
                temperature changes more than half a degree.
            -"push" data to the observers: notifyObservers(arg) method pass data object to the observers.
            -"pull" data from the Observable object passed to it: if statement to check that obs is an instanceof
                WeatherData, cast obs to be (WeatherData), then use WeatherData's getTemperature()/getHumidity() methods
                to set the observer's this.temperature/this.humidity.
    Things-to-know: Observer Pattern in the JDK also seen in APIs: JavaBeans, RMI, Swing, etc (observers == listeners).

    -----     -----     -----
    Observer pattern: defines a one-to-many dependency between objects so that when one object changes state,
        all of its dependents are notified and updated automatically.
    -----     -----     -----
 */

public class TestClassWeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
        // StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        // ForecastDisplay forecaseDisplay = new ForecastDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);
    }
}
