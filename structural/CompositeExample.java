package structural;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompositeExample {
    public static void main(String[] args) {
        City city1 = new City("1");
        city1.addGeographicComponent(new City("2"), new City("3"));
        city1.printAll();
    }
}

interface GeographicComponent {
    void print();
}

class City implements GeographicComponent {
    String name;
    List<GeographicComponent> list = new ArrayList<>();
    public City(String name) {
        this.name = name;
    }
    public void addGeographicComponent(GeographicComponent... components) {
        list.addAll(Arrays.asList(components));
    }
    @Override
    public void print() {
        System.out.println(name);
    }

    public void printAll() {
        for (GeographicComponent component: list) {;
            component.print();
        }
    }
}
