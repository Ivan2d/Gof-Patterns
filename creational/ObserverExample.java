package creational;

import java.util.ArrayList;
import java.util.List;

public class ObserverExample {
    public static void main(String[] args) {
        Subscriber subscriber = new ConcreteSubscriber();
        Channel channel = new Channel();
        channel.subscribe(subscriber);
        channel.notifySubscribers("Hi");
        channel.unsubscribe(subscriber);
        channel.notifySubscribers("Hi again");
    }
}

interface Subscriber {
    void notifyMe(String message);
}

class ConcreteSubscriber implements Subscriber {
    @Override
    public void notifyMe(String message) {
        System.out.println("concrete subscriber have a new message " + message);
    }
}

class Channel {
    List<Subscriber> subscriberList = new ArrayList<>();
    public void subscribe(Subscriber subscriber) {
        subscriberList.add(subscriber);
    }
    public void unsubscribe(Subscriber subscriber) {
        subscriberList.remove(subscriber);
    }
    public void notifySubscribers(String message) {
        subscriberList.forEach(subscriber -> subscriber.notifyMe(message));
    }
}
