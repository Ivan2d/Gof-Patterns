package structural;

public class AdapterExample {
    public static void main(String[] args) {
        AmericanSocket americanSocket = () -> System.out.println("Hi");
        SocketAdapter adapter = new SocketAdapter(americanSocket);
        SocketInheritedAdapter adapter1 = new SocketInheritedAdapter();
        Radio radio = new Radio();
        radio.listen(adapter);
        radio.listen(adapter1);
    }
}

interface AmericanSocket {
    void getPower();
}

interface EuroSocket {
    void getPower();
}

class Radio {
    void listen(EuroSocket euroSocket) {
        euroSocket.getPower();
    }
}

class SimpleAmericanSocket implements AmericanSocket {
    @Override
    public void getPower() {
        System.out.println("Hello, I'm American Socket");
    }
}

class SocketInheritedAdapter extends SimpleAmericanSocket implements EuroSocket {
    @Override
    public void getPower() {
        super.getPower();
    }
}

class SocketAdapter implements EuroSocket {
    AmericanSocket americanSocket;

    public SocketAdapter(AmericanSocket americanSocket) {
        this.americanSocket = americanSocket;
    }

    @Override
    public void getPower() {
        americanSocket.getPower();
    }
}