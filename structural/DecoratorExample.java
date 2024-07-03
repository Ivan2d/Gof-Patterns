package structural;

public class DecoratorExample {
    public static void main(String[] args) {
        Pizza cheesePizza = new PeperoniPizza(null);
        System.out.println(cheesePizza.makePizza());
    }
}

interface Pizza {
    String makePizza();
}

class PeperoniPizza implements Pizza {
    Pizza pizza;
    public PeperoniPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String makePizza() {
        return pizza.makePizza() +  " and peperoni";
    }
}