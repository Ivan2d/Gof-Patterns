package creational;

public class CommandExample {
    public static void main(String[] args) {
        Button button = new Button(new CoffeeMachineCommand(new CoffeeMachine()));
        button.clickButton();
    }
}

class Button {
    Command command;
    public Button(Command command) {
        this.command = command;
    }
    void clickButton() {
        command.execute();
    }
}

interface Command {
    void execute();
}

class CoffeeMachineCommand implements Command {
    CoffeeMachine coffeeMachine;
    public CoffeeMachineCommand(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }
    @Override
    public void execute() {
        coffeeMachine.createCoffee();
    }
}

class CoffeeMachine {
    void createCoffee() {
        System.out.println("coffee machine start");
    }
}
