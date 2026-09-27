public class HealthPot extends Item {

    int healAmount;
    int tier;


    public HealthPot(int tier) {
        super("Tier " + tier + " Health Potion");
        this.healAmount = switch (tier){
            case 1 -> 30;
            case 2 -> 60;
            case 3 -> 120;
            default -> throw new IllegalStateException("Unexpected value: " + tier);
        };
        this.tier = tier;
    }

    public void use(Player p){
        p.health = Math.min(p.health + healAmount, p.maxHealth);
        UI.print("Used " + name);
        UI.print("Healed " + healAmount + " HP");
        UI.print(p.name + " HP: " + p.health);
    }

}