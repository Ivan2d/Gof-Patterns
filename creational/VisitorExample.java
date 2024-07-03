package creational;

public class VisitorExample {
    public static void main(String[] args) {

    }
}

interface Animal {
    void accept(AnimalVisitor animalVisitor);
}

class Cat implements Animal {
    @Override
    public void accept(AnimalVisitor animalVisitor) {
        animalVisitor.action(this);
    }
}

class Dog implements Animal {
    @Override
    public void accept(AnimalVisitor animalVisitor) {
        animalVisitor.action(this);
    }
}

interface AnimalVisitor {
    void action(Dog dog);
    void action(Cat cat);
}

class SoundAnimalVisitor implements AnimalVisitor {
    @Override
    public void action(Dog dog) {
        System.out.println("Gaf");
    }
    @Override
    public void action(Cat cat) {
        System.out.println("Myau");
    }
}
