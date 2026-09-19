import java.util.ArrayList;

public class Player {

    String name;
    int health;
    int maxHealth;
    int attackDMG;
    int xp = 0;
    int level = 1;
    int xpToNextLevel = 100;
    ArrayList<Item> inventory = new ArrayList<>();

    public Player(String name, int health, int attackDMG) {
        this.name = name;
        this.health = health;
        this.attackDMG = attackDMG;
        this.maxHealth = health;
    }

    public void gainXP(int amount){
        xp += amount;
        if (xp >= xpToNextLevel){
            level++;
            xp = xp - xpToNextLevel;
            xpToNextLevel = xpToNextLevel * 2;
            attackDMG = (int)(attackDMG * 1.1);
            health = maxHealth;
            UI.print("Level up! New level: " + level);
            UI.print("XP: " + xp + "/" + xpToNextLevel);
            UI.print("New damage: " + attackDMG);
        }
    }

    public void attack(Enemy e) {
        e.health = Math.max(0, e.health - attackDMG);
    }

    boolean isAlive() {
        return(health > 0);
    }
}