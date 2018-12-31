package count_zero_init.view;

import java.util.ArrayList;
import java.util.List;

public interface Subject {
    List<Subscriber> subscribers = new ArrayList<Subscriber>();

    public void addSubscriber(Subscriber subscriber);
    public void removeSubscriber(int i);
    public Subject notifySubscribers();
}
