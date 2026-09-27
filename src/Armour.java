public class Armour extends Item {

    int tier;
    public Armour(int tier) {
        super("Tier " + tier + " Armour");
        this.tier = tier;
    }

    public void use(Player p){
            p.maxHealth += tier * 20;
        }
    }

