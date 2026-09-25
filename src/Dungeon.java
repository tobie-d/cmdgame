import java.util.Scanner;

public class Dungeon {
    Room[] rooms = new Room[10];
    // cache enum values so we don't call values() repeatedly
    Room.RoomType[] randomRoom = Room.RoomType.values();

    public void generate(){
        for (int i = 0; i < rooms.length - 1; i++){

            int randomIndex=(int)(Math.random() * randomRoom.length - 1);
            Room.RoomType roomType = randomRoom[randomIndex];
            rooms[i] = new Room(roomType);

        }
        rooms[9] = new Room(Room.RoomType.BOSS);
    }

    public void enter(int index, Player player, Scanner scan){
        rooms[index].trigger(player, scan);
    }





}
