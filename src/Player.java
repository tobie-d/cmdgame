import java.util.ArrayList;

public class Player {

    String name;
    int health;
    int attackDMG;
    ArrayList<Item> inventory = new ArrayList<>();

    public Player(String name, int health, int attackDMG) {
        this.name = name;
        this.health = health;
        this.attackDMG = attackDMG;
    }


    public void attack(Enemy e) {
        e.health = Math.max(0, e.health - attackDMG);
    }

    boolean isAlive() {
        if (health <= 0) {
            return false;
        }
        return true;
    }
}