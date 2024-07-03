package creational;

import java.util.ArrayList;
import java.util.List;

public class MediatorExample {
    public static void main(String[] args) {

    }
}

interface Chat {
    void sendMessage(String message, College college);
    void addCollege(College college);
}

abstract class College {
    Chat chat;
    String name;
    abstract void printMessage(String message);
}

class ChatMediator implements Chat {
    List<College> colleges = new ArrayList<>();
    @Override
    public void sendMessage(String message, College me) {
        colleges.forEach(college -> {
            if (college != me) {
                college.printMessage(message);
            }
        });
    }
    @Override
    public void addCollege(College college) {
        colleges.add(college);
    }
}

class CollegeImpl extends College {
    public CollegeImpl(Chat chat, String name) {
        this.chat = chat;
        this.name = name;
    }
    @Override
    void printMessage(String message) {
        System.out.println(name + " " + message);
    }
}

