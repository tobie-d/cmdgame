import java.util.Scanner;

public class Dungeon {
    Room[] rooms = new Room[10];
    // cache enum values so we don't call values() repeatedly
    Room.RoomType[] randomRoom = Room.RoomType.values();

    public void generate(){
        for (int i = 0; i < rooms.length; i++){

            int randomIndex=(int)(Math.random() * randomRoom.length);
            Room.RoomType roomType = randomRoom[randomIndex];
            rooms[i] = new Room(roomType);

        }
        // TODO: force only the last room to be a BOSS. currently any room can be one
    }

    public void enter(int index, Player player, Scanner scan){
        rooms[index].trigger(player, scan);
    }





}
