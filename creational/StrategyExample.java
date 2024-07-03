package creational;

public class StrategyExample {
    public static void main(String[] args) {

    }
}

interface Flyable {
    void fly();
}
class Fly implements Flyable {
    @Override
    public void fly() {
        System.out.println("creational.Fly");
    }
}
class NoFly implements Flyable {
    @Override
    public void fly() {
        System.out.println("No fly");
    }
}
abstract class Track {
    Flyable flyable;
    public Track(Flyable flyable) {
        this.flyable = flyable;
    }
}

