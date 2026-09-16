import java.util.Scanner;

public class Main {
    void main() {
        Scanner scan = new Scanner(System.in);
        Player player = new Player("Test", 100, 15);
        Enemy enemy = new Enemy("Goblin", 50, 8);
        player.inventory.add(new HealthPot("Health Potion", 30));


        System.out.println(player.name + " HP: " + player.health);
        System.out.println(enemy.name + " HP: " + enemy.health);

        while (player.isAlive() && enemy.isAlive()) {
            System.out.println(player.name + "'s turn! Pick an option");
            System.out.print("1. Attack\n" + "2. Inventory\n" + "3. Run\n");
            int choice = scan.nextInt();

            if (choice == 1) {
                player.attack(enemy);
                System.out.println(player.name + " Attacked " + enemy.name);
                System.out.println(enemy.name + " HP: " + enemy.health);
                if (!enemy.isAlive()) {
                    System.out.println(enemy.name + " died! You win!");
                    break;
                }
                enemy.attack(player);
                System.out.println(enemy.name + " Attacked " + player.name);
                System.out.println(player.name + " HP: " + player.health);
                if (!player.isAlive()) {
                    System.out.println("You died!");
                    break;
                }
            } else if (choice == 2) {
                for (int i = 0; i < player.inventory.size(); i++) {
                    System.out.println((i + 1) + ". " + player.inventory.get(i).name);
                }
                System.out.println("Which item?");
                int ic = scan.nextInt() - 1;
                Item item = player.inventory.get(ic);
                item.use(player);
                System.out.println("Used " + item.name);
                if(item instanceof HealthPot){
                    System.out.println("Healed " +  ((HealthPot) item).healAmount + " HP");
                }
                System.out.println(player.name + " HP: " + player.health);
                player.inventory.remove(ic);

            } else if(choice == 3) {
                System.out.println("You ran away!");
                break;
            }

        }
    }
}
