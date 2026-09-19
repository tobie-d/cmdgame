public class Enemy {

    String name;
    int health;
    int attackDMG;
    int xpReward;


    public Enemy(String name, int health, int attackDMG, int xpReward) {
        this.name = name;
        this.health = health;
        this.attackDMG = attackDMG;
        this.xpReward = xpReward;
    }


    public void attack(Player e) {
        e.health = Math.max(0, e.health - attackDMG);
    }

    boolean isAlive() {
        return health > 0;
    }
}