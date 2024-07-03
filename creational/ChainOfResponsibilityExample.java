package creational;

public class ChainOfResponsibilityExample {
    public static void main(String[] args) {
        MessageHandler messageHandler = new MessageAddMarkHandler(new MessagePrintHandler(null));
        messageHandler.handle("Hello World");
    }
}

abstract class MessageHandler {
    MessageHandler messageHandler;
    public MessageHandler(MessageHandler messageHandler) {
        this.messageHandler = messageHandler;
    }
    abstract void handle(String str);
}

class MessageAddMarkHandler extends MessageHandler {
    public MessageAddMarkHandler(MessageHandler messageHandler) {
        super(messageHandler);
    }
    @Override
    void handle(String str) {
        messageHandler.handle(str + "!");
    }
}

class MessagePrintHandler extends MessageHandler {
    public MessagePrintHandler(MessageHandler messageHandler) {
        super(messageHandler);
    }
    @Override
    void handle(String str) {
        System.out.println(str);
    }
}
