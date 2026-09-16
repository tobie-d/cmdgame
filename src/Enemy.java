public class Enemy {

    String name;
    int health;
    int attackDMG;


    public Enemy(String name, int health, int attackDMG) {
        this.name = name;
        this.health = health;
        this.attackDMG = attackDMG;
    }


    public void attack(Player e) {
        e.health = Math.max(0, e.health - attackDMG);
    }

    boolean isAlive() {
        if (health <= 0) {
            return false;
        }
        return true;
    }
}