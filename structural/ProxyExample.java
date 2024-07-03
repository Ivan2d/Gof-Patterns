package structural;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyExample {
    public static void main(String[] args) {
        Reader reader = new MyReader();
        Reader reader1 = new ProxyReader(reader);
        reader1.read("Aboba");
        InvocationHandler invocationHandler = new ReaderInvocationHandler();
        Object result = Proxy.newProxyInstance(
                Main.class.getClassLoader(),
                new Class[]{Reader.class},
                invocationHandler);
        ((Reader) result).read("Hello");
    }
}

class ReaderInvocationHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(args[0]);
        Object result = method.invoke(new MyReader(), args);
        System.out.println(result);
        return result;
    }
}

interface Reader {
    String read(String str);
}

class MyReader implements Reader {
    @Override
    public String read(String string) {
        return string;
    }
}

class ProxyReader implements Reader {
    Reader reader;
    public ProxyReader(Reader reader) {
        this.reader = reader;
    }
    @Override
    public String read(String str) {
        return reader.read(str);
    }
}

