public class Enemy {

    String name;
    int health;
    int attackDMG;
    int xpReward;
    int minGold;
    int maxGold;

    public Enemy(String name, int health, int attackDMG, int xpReward, int minGold,int maxGold) {
        this.name = name;
        this.health = health;
        this.attackDMG = attackDMG;
        this.xpReward = xpReward;
        this.minGold = minGold;
        this.maxGold = maxGold;
    }


    public void attack(Player e) {
        e.health = Math.max(0, e.health - attackDMG); // same safety clamp as Player.attack
    }

    boolean isAlive() {
        return health > 0;
    }
}