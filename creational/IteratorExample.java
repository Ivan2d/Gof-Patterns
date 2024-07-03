package creational;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorExample {
    public static void main(String[] args) {
        MyCollection myCollection = new MyCollection();
    }
}

class MyCollection implements Iterable<String> {
    private final String[] items = new String[] {"aaa", "bbb", "ccc"};
    @Override
    public Iterator<String> iterator() {
        return new Iterator<>() {
            private int index = -1;

            @Override
            public boolean hasNext() {
                return index + 1 < items.length;
            }

            @Override
            public String next() {
                index++;
                if (index >= 0 && index < items.length) {
                    return items[index];
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
    }
}

class MyCustomIterator implements Iterator<String> {
    private final String[] items = new String[] {"aaa", "bbb", "ccc"};
    private int index = -1;
    @Override
    public boolean hasNext() {
        return index + 1 < items.length;
    }

    @Override
    public String next() {
        index++;
        if (index >= 0 && index < items.length) {
            return items[index];
        } else {
            throw new NoSuchElementException();
        }
    }
}
