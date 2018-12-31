package count_zero_init.model;

import java.util.ArrayList;
import java.util.List;


public interface Observable {
    List<Observer> observers = new ArrayList<Observer>();

    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObservers();
}
