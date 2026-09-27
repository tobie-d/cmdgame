import java.util.Scanner;

// it is just a copy of Battle.java with some changes to how the enemy system works

public class BossBattle {

    static void start(Player player, Scanner scan){
        Boss boss = new Boss("Boss 1", 150, 18, 500, 100, 250); // placeholder before random boss creation
        UI.print(player.name + " HP: " + player.health);
        UI.print(boss.name + " HP: " + boss.health);

        while (player.isAlive() && boss.isAlive()) {
            UI.print(player.name + "'s turn! Pick an option");
            UI.print("1. Attack");
            UI.print("2. Inventory");
            UI.print("3. Run"); // need to disable or add a cost or chance
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
                    UI.print(boss.name + " died! You beat the boss!");
                    UI.print("You gained " + goldEarned + " Gold");
                    UI.print("Would you like to enter the shop? Y/N ");
                    String shopinp = scan.nextLine();
                    if(shopinp.equalsIgnoreCase("Y")){
                        UI.print("You enter the shop.");
                        Shop shop = new Shop();
                        shop.enter(player, scan);
                        break;
                    } else{
                        UI.print("You descend to the next floor.");
                        player.currentFloor++;
                        break;
                    }
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
                    UI.print("Stats:");
                    UI.print("Floor: " + player.currentFloor);
                    UI.print("Level: " + player.level);
                    UI.print("XP: " + player.xp + "/" + player.xpToNextLevel);
                    UI.print("Gold: " + player.gold);
                    UI.print("Attack Damage: " + player.attackDMG);
                    UI.print("Max Health: " + player.maxHealth);
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
