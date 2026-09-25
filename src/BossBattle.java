import java.util.Scanner;


public class BossBattle {

    static void start(Player player, Scanner scan){
        Boss boss = new Boss("Boss 1", 150, 18, 500, 100, 250); // placeholder before random boss creation
        UI.print(player.name + " HP: " + player.health);
        UI.print(boss.name + " HP: " + boss.health);

        while (player.isAlive() && boss.isAlive()) {
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
                player.attack(boss);
                UI.clearScreen();
                UI.print(player.name + " Attacked " + boss.name);
                UI.print(boss.name + " HP: " + boss.health);
                if (!boss.isAlive()) {

                    int goldEarned = (int)(Math.random()* (boss.maxGold - boss.minGold + 1))+ boss.minGold;
                    player.gainGold(goldEarned);
                    player.gainXP(boss.xpReward);
                    UI.print(boss.name + " died! You win!");
                    UI.print("You gained " + goldEarned + " Gold");
                    break;
                }

                // boss qte
                if(Math.random() < 0.3) {
                    long start = System.currentTimeMillis();
                    UI.print("QTE! type 'dodge' in 3 seconds or take damage!");
                    String inp = scan.nextLine();
                    long end = System.currentTimeMillis();
                    if (inp.equals("dodge") && end - start < 3000) {
                        UI.print("Sucessfully dodged!");
                    } else {
                        boss.attack(player);
                        UI.print(boss.name + " Attacked " + player.name);
                        UI.print(player.name + " HP: " + player.health);
                    }
                }else{
                    boss.attack(player);
                    UI.print(boss.name + " Attacked " + player.name);
                    UI.print(player.name + " HP: " + player.health);
                }


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


                }
            } else if(choice == 3) {
                UI.print("You ran away!");
                break;
            }
        }
    }
}
