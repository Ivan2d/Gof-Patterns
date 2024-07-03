package structural;

public class FacadeExample {
    public static void main(String[] args) {
        LivingRoom livingRoom = new LivingRoom();
        livingRoom.pressButton(true);
    }
}

class Music {
    void playMusic(boolean play) {
        System.out.println("music play is: " + play);
    }
}

class RoomFacade {
    Music music = new Music();
    void pressButton(boolean play) {
        music.playMusic(play);
    }
}

class LivingRoom {
    RoomFacade roomFacade = new RoomFacade();
    void pressButton(boolean play) {
        roomFacade.pressButton(play);
    }
}

