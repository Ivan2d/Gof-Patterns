package behavioral;

public class SingletonExample {
    public static void main(String[] args) {

    }
}

class Singleton {
    private Singleton() {}

    private static volatile Singleton singleton;

    private static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}


