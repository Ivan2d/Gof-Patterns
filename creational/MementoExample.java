package creational;

public class MementoExample {
    public static void main(String[] args) {
        Original original = new Original("one");
        Original.Memento memento = original.createMemento();
        original.setState("two");
        original.returnStateFromMemento(memento);
        System.out.println(original.state);
    }
}

class Original {
    String state;
    public Original(String state) {
        this.state = state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public Memento createMemento() {
        return new Memento(state);
    }
    public void returnStateFromMemento(Memento memento) {
        setState(memento.getName());
    }
    static class Memento {
        String name;
        public Memento(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
    }
}


