import java.util.Scanner;

public class Battle {
    /**
     * Starts a turn-based battle between the player and an enemy.
     * The player can attack, use an item from inventory or run away.
     * The battle continues until one side dies or the player successfully runs away.
     *
     * @param player the player character
     * @param enemy the enemy being fought
     * @param scan scanner for player input
     */

    static void start(Player player, Enemy enemy, Scanner scan){
    UI.print(player.name + " HP: " + player.health);
        UI.print(enemy.name + " HP: " + enemy.health);
            while (player.isAlive() && enemy.isAlive()) {
                UI.print(player.name + "'s turn! Pick an option");
                UI.print("1. Attack");
                UI.print("2. Inventory");
                UI.print("3. Run");
                int choice;
                try{
                    choice = scan.nextInt();
                    scan.nextLine(); // consume newline
                }catch(Exception e){
                    UI.print("Invalid input.");
                    scan.nextLine();
                    continue;
                }



                if (choice == 1) {
                    player.attack(enemy);
                    UI.clearScreen();
                    UI.print(player.name + " Attacked " + enemy.name);
                    UI.print(enemy.name + " HP: " + enemy.health);
                    if (!enemy.isAlive()) {
                        // random gold in the enemy's declared range
                        int goldEarned = (int)(Math.random()* (enemy.maxGold - enemy.minGold + 1))+ enemy.minGold;
                        player.gainGold(goldEarned);
                        player.gainXP(enemy.xpReward);
                        UI.print(enemy.name + " died! You win!");
                        UI.print("You gained " + goldEarned + " Gold");
                        break;
                    }

                    // enemy always gets a turn after a successful attack
                    enemy.attack(player);
                    UI.print(enemy.name + " Attacked " + player.name);
                    UI.print(player.name + " HP: " + player.health);
                    if (!player.isAlive()) {
                        UI.print("You died!");
                        break;
                    }

                } else if (choice == 2) {
                    UI.clearScreen();
                    if (player.inventory.isEmpty()) {
                        UI.print("Inventory is empty!");
                    } else {
                        for (int i = 0; i < player.inventory.size(); i++) {
                            UI.print((i + 1) + ". " + player.inventory.get(i).name);
                        }
                        UI.print("Which item?");
                        try {
                            int ic = scan.nextInt() - 1;
                            scan.nextLine();
                            Item item = player.inventory.get(ic);
                            item.use(player);
                            UI.print("Used " + item.name);
                            if (item instanceof HealthPot) {
                                UI.print("Healed " + ((HealthPot) item).healAmount + " HP");
                            }
                            UI.print(player.name + " HP: " + player.health);
                            UI.print("\n");
                            player.inventory.remove(ic); // consume the item
                        } catch (Exception e) {
                            UI.print("Invalid choice.");
                            scan.nextLine();
                        }
                        // using an item still costs a turn so the enemy attacks afterwards
                        enemy.attack(player);
                        UI.print(enemy.name + " Attacked " + player.name);
                        UI.print(player.name + " HP: " + player.health);
                    }
                } else if(choice == 3) {
                    UI.print("You ran away!");
                    break;
                }
            }
        }

    }
