package creational;

public class StateExample {
    public static void main(String[] args) {
        GumMachine gumMachine = new GumMachine();
        gumMachine.turnCrank();
        gumMachine.insertCoin();
        gumMachine.insertCoin();
        gumMachine.turnCrank();
        gumMachine.turnCrank();
    }
}

abstract class State {
    abstract public void insertCoin(GumMachine gumMachine);
    abstract public void turnCrank(GumMachine gumMachine);
}
class NoCoinState extends State {
    @Override
    public void insertCoin(GumMachine gumMachine) {
        gumMachine.state = new InsertedCoinState();
    }
    @Override
    public void turnCrank(GumMachine gumMachine) {
        System.out.println("Where money?");
    }
}
class InsertedCoinState extends State {
    @Override
    public void insertCoin(GumMachine gumMachine) {
        System.out.println("You already insert money");
    }
    @Override
    public void turnCrank(GumMachine gumMachine) {
        System.out.println("This your gum");
        gumMachine.state = new NoCoinState();
    }
}
class GumMachine {
    State state;
    public GumMachine() {
        this.state = new NoCoinState();
    }
    public void insertCoin() {
        state.insertCoin(this);
    }
    public void turnCrank() {
        state.turnCrank(this);
    }
}