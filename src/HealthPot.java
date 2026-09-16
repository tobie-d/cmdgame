public class HealthPot extends Item {

    int healAmount;

    public HealthPot(String name, int healAmount){
        super(name);
        this.healAmount = healAmount;
    }

    public void use(Player p){
        p.health = p.health + healAmount;
    }

}