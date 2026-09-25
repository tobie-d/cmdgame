public class Boss extends Enemy {

    int phase = 1;
    boolean hasHealed = false;

    public Boss(String name, int health, int attackDMG, int xpReward, int minGold, int maxGold) {
        super(name, health, attackDMG, xpReward, minGold, maxGold);


    }
}
