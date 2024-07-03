package behavioral;

public class MethodFactoryAndAbstractFactoryExample {
    public static void main(String[] args) {
        CarFactory factory = new ToyotaCarFactory();
        Car toyota = factory.createCar();
        toyota.drive();
    }
}

interface Car {
    void drive();
}
interface Bike {
    void drive();
}
class Toyota implements Car {
    @Override
    public void drive() {
        System.out.println("Drive behavioral.Toyota");
    }
}
class ToyotaBike implements Bike {
    @Override
    public void drive() {
        System.out.println("Drive behavioral.Toyota behavioral.Bike");
    }
}
interface AbstractCarBikeFactory {
    Car createCar();
    Bike createBike();
}
class ToyotaCarBikeFactory implements AbstractCarBikeFactory{
    @Override
    public Car createCar() {
        return new Toyota();
    }

    @Override
    public Bike createBike() {
        return new ToyotaBike();
    }
}

abstract class CarFactory {
    public Car createCar() {
        //...
        return getCar();
    }
    abstract Car getCar();
}

class ToyotaCarFactory extends CarFactory {
    @Override
    Car getCar() {
        return new Toyota();
    }
}

