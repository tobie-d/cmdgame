public class HealthPot extends Item {

    int healAmount;

    public HealthPot(String name, int healAmount){
        super(name);
        this.healAmount = healAmount;
    }

    public void use(Player p){
       // cap at maxHealth so potions never over-heal
        p.health = Math.min(p.health + healAmount, p.maxHealth);
    }

}