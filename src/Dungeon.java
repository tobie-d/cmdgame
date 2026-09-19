import java.util.Scanner;

public class Dungeon {
    Room[] rooms = new Room[10];
    Room.RoomType[] randomRoom = Room.RoomType.values();

    public void generate(){
        for (int i = 0; i < rooms.length; i++){

            int randomIndex=(int)(Math.random() * randomRoom.length);
            Room.RoomType roomType = randomRoom[randomIndex];
            rooms[i] = new Room(roomType);

        }
    }

    public void enter(int index, Player player, Scanner scan){
        rooms[index].trigger(player, scan);
    }





}
