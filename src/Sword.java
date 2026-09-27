public class Sword extends Item {

    int tier;


    public Sword(int tier) {
        super("Tier " + tier + " Sword");
        this.tier = tier;
    }

    public void use(Player p){
        switch(tier){
            case 1 -> p.attackDMG =+ 5;
            case 2 -> p.attackDMG =+ 7;
            case 3 -> p.attackDMG =+ 9;
            case 4 -> p.attackDMG =+ 12;
        }
    }

}