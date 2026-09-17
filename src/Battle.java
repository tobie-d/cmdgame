import java.util.Scanner;

public class Battle {
    static void start(Player player, Enemy enemy, Scanner scan){
    System.out.println(player.name + " HP: " + player.health);
        System.out.println(enemy.name + " HP: " + enemy.health);
            while (player.isAlive() && enemy.isAlive()) {
                System.out.println(player.name + "'s turn! Pick an option");
                System.out.print("""
                        1. Attack
                        2. Inventory
                        3. Run
                        """);
                int choice = 0;
                try{
                    choice = scan.nextInt();
                }catch(Exception e){
                    System.out.println("Invalid input.");
                    scan.nextLine();
                    continue;
                }



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
                    if (player.inventory.isEmpty()) {
                        System.out.println("Inventory is empty!");
                    } else {
                        for (int i = 0; i < player.inventory.size(); i++) {
                            System.out.println((i + 1) + ". " + player.inventory.get(i).name);
                        }
                        System.out.println("Which item?");
                        try {
                            int ic = scan.nextInt() - 1;
                            Item item = player.inventory.get(ic);
                            item.use(player);
                            System.out.println("Used " + item.name);
                            if (item instanceof HealthPot) {
                                System.out.println("Healed " + ((HealthPot) item).healAmount + " HP");
                            }
                            System.out.println(player.name + " HP: " + player.health);
                            player.inventory.remove(ic);
                        } catch (Exception e) {
                            System.out.println("Invalid choice.");
                            scan.nextLine();
                        }
                    }
                } else if(choice == 3) {
                    System.out.println("You ran away!");
                    break;
                }

            }
        }

    }
