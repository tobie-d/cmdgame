import java.util.Scanner;

public class Room {

    public enum RoomType {
        EMPTY, CHEST, TRAP, ENEMY, BOSS
    }

    RoomType type;

    public Room(RoomType type) {
        this.type = type;
    }

    public void trigger(Player p, Scanner scan){
        switch(type){
            case EMPTY -> UI.print("The room is empty, keep going.");
            case CHEST -> {
                p.inventory.add(new HealthPot("Health Potion", 30));
                UI.print("You found a potion!");
            }
            case TRAP -> {
                int min = 1;
                int max = 20;
                int range = max - min;
                int damage = (int) (Math.random() * range) + min;
                p.health -= damage;
                UI.print("You got caught by a trap, you took " + damage + " HP of damage.");
            }
            case ENEMY -> {
                Enemy e = EnemyFactory.getRandom();
                Battle.start(p,e,scan);
            }
            case BOSS -> UI.print("Boss TBA");
        }
    }


}
