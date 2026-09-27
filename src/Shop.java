import java.util.ArrayList;
import java.util.Scanner;

public class Shop {

    ArrayList<ShopItem> items;
    public Shop() {
        items = new ArrayList<>();
        items.add(new ShopItem(new Armour(1),50));
        items.add(new ShopItem(new Armour(2),100));
        items.add(new ShopItem(new Armour(3),150));
        items.add(new ShopItem(new Sword(1),50));
        items.add(new ShopItem(new Sword(2),110));
        items.add(new ShopItem(new Sword(3),160));
        items.add(new ShopItem(new Sword(4),250));
        items.add(new ShopItem(new HealthPot(1),40));
        items.add(new ShopItem(new HealthPot(2),60));
        items.add(new ShopItem(new HealthPot(3),120));
    }


    public void enter(Player player, Scanner scan){
        UI.print("Which item would you like to buy? You have " + player.gold + " Gold");
        UI.print("Type 0 to exit.");
        for (int i = 0; i < items.size(); i++) {

            ShopItem shopItem = items.get(i);
            UI.print((i + 1) + ". " + shopItem.item.name + " - " + shopItem.price + " Gold");
        }
        while(true) {
            int choice = scan.nextInt();
            if (choice == 0) {
                scan.nextLine();
                UI.print("Exited shop");
                UI.print("You descend to the next floor.");
                player.currentFloor++;
                UI.print("Press enter to continue");
                scan.nextLine();
                return;
            }
            if (choice < 0 || choice > items.size()) {
                UI.print("Invalid choice");
            }
            if (choice > 0 && choice <= items.size()) {
                ShopItem shopItem = items.get(choice - 1);
                if (player.gold >= shopItem.price) {
                    player.gold = player.gold - shopItem.price;
                    player.inventory.add(shopItem.item);
                    UI.print("You bought " + shopItem.item.name + " for " + shopItem.price);
                } else {
                    UI.print("You do not have enough gold, you need " + shopItem.price + " Gold, and you have " + player.gold + " Gold");
                }
            }
        }
    }


}
