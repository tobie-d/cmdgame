import java.util.Scanner;
import java.util.Random;



public class Room {

    public enum RoomType {
        ENEMY, CHEST, TRAP, EMPTY, BOSS // keep BOSS last until i figure out how weighted rooms will work
    }

    RoomType type;
    Random random = new Random();

    public Room(RoomType type) {
        this.type = type;
    }

    /**
     * Executes the effect of this room (empty, chest, trap, enemy or boss).
     */
    public void trigger(Player p, Scanner scan){
        switch(type){
            case EMPTY -> UI.print("The room is empty, keep going.");
            case CHEST -> {
                p.inventory.add(new HealthPot(random.nextInt(1,4)));
                UI.print("You found a potion!");
            }
            case TRAP -> {
                // simple random damage between 1 and 20
                int damage = (int) (Math.random() * 20) + 1;
                p.health = Math.max(0, p.health - damage);
                UI.print("You got caught by a trap, you took " + damage + " HP of damage.");
            }
            case ENEMY -> {
                Enemy e = EnemyFactory.getRandom();
                Battle.start(p,e,scan);
            }
            case BOSS -> BossBattle.start(p,scan);
        }
    }


}
