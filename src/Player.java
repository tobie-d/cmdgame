import java.util.ArrayList;

public class Player {

    String name;
    int health;
    int maxHealth;
    int attackDMG;
    int xp = 0;
    int level = 1;
    int xpToNextLevel = 100;
    int gold = 0;
    ArrayList<Item> inventory = new ArrayList<>();

    public Player(String name, int health, int attackDMG) {
        this.name = name;
        this.health = health;
        this.attackDMG = attackDMG;
        this.maxHealth = health;  // start fully healed
    }

    /**
     * Awards XP and handles multiple level-ups in one call if enough XP was earned.
     * Stats scale moderately so the game stays challenging.
     *
     * @param amount the amount of XP to add
     */

    public void gainXP(int amount){
        xp += amount;
        while (xp >= xpToNextLevel){
            level++;
            xp = xp - xpToNextLevel;
            // exponential XP curve, each level requires twice as much XP
            xpToNextLevel = xpToNextLevel * 2;
            // mild power growth so late-game enemies stay relevant
            attackDMG = (int)(attackDMG * 1.1);
            maxHealth = (int)(maxHealth * 1.12);
            health = maxHealth; // full heal on level-up so it feels rewarding
            UI.print("Level up! New level: " + level);
            UI.print("XP: " + xp + "/" + xpToNextLevel);
            UI.print("New damage: " + attackDMG);
            UI.print("New max health: " + maxHealth);
        }
    }

    public void gainGold(int amount){
        gold += amount;
    }


    public void attack(Enemy e) {
        e.health = Math.max(0, e.health - attackDMG); // never let health go negative, simplifies death checks
    }

    boolean isAlive() {
        return(health > 0);
    }
}