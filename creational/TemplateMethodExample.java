package creational;

public class TemplateMethodExample {
    public static void main(String[] args) {
        Beverage beverage = new Tea();
        beverage.makeBeverage();
    }
}

abstract class Beverage {
    private void boilWater() {
        System.out.println("boiled water");
    }
    private void addSugar() {
        System.out.println("add sugar");
    }
    abstract void addBeverage();
    abstract void addCondiment();
    public void makeBeverage() {
        boilWater();
        addBeverage();
        addSugar();
        addCondiment();
    }
}
class Tea extends Beverage {
    @Override
    void addBeverage() {
        System.out.println("add tea");
    }
    @Override
    void addCondiment() {
        System.out.println("add lemon");
    }
}

