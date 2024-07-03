package structural;

public class BridgeExample {
    public static void main(String[] args) {
        Color redColor = new RedColor();
        Color blueColor = new BlueColor();
        Shape rectangle = new Rectangle(redColor);
        Shape circle = new Circle(blueColor);
        rectangle.colored();
        circle.colored();
    }
}

enum ColorType {
    RED, BLUE
}

abstract class Shape {
    Color color;
    public Shape(Color color) {
        this.color = color;
    }
    abstract void colored();
}

interface Color {
    void colored(String str);
}

class RedColor implements Color {
    @Override
    public void colored(String str) {
        System.out.println(str + " " + ColorType.RED);
    }
}

class Rectangle extends Shape {
    public Rectangle(Color color) {
        super(color);
    }
    @Override
    void colored() {
        color.colored("structural.Rectangle");
    }
}

class BlueColor implements Color {
    @Override
    public void colored(String str) {
        System.out.println(str + " " + ColorType.BLUE);
    }
}

class Circle extends Shape {
    public Circle(Color color) {
        super(color);
    }
    @Override
    void colored() {
        color.colored("structural.Circle");
    }
}