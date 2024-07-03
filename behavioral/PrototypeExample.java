package behavioral;

public class PrototypeExample {
    public static void main(String[] args) {

    }
}

class Prototype {
    String name;
    int age;

    public Prototype(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Prototype copy(Prototype prototype) {
        return new Prototype(prototype.name, prototype.age);
    }
}

class PrototypeJDK implements Cloneable {
    String name;
    int age;

    public PrototypeJDK(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public PrototypeJDK clone() {
        try {
            return (PrototypeJDK) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

