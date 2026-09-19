import java.util.Scanner;

public class Main {


    static int showMenu(Scanner scan){
        print("=== CMDGAME ===");
        print("1. Play");
        print("2. How to play");
        print("3. Quit");
        try {
            return scan.nextInt();
        }catch (Exception e){
            print("Invalid choice.");
            scan.nextLine();
            return 0;
        }
    }

    static String getName(Scanner scan){
        UI.clearScreen();
        print("Enter Name: ");
        return scan.nextLine();
    }



    static void print(String text){
        UI.print(text);
    }


    void main() {
        Scanner scan = new Scanner(System.in);
        int mchoice = 0;
        while (mchoice != 1){
            mchoice = showMenu(scan);
            if (mchoice == 2) System.out.println("TBA");
            if (mchoice == 3) System.exit(0);
        }
        scan.nextLine();
        String name = getName(scan);
        Player player = new Player(name, 100, 15);
        Enemy enemy = new Enemy("Goblin", 50, 8,250);
        Enemy enemy2 = new Enemy("Goblin", 50, 8,250);
        Enemy enemy3 = new Enemy("Dragon", 200, 10,500);
        player.inventory.add(new HealthPot("Health Potion", 30));

        Enemy[] enemies = {enemy,enemy2,enemy3};
        for(Enemy e  : enemies){
            UI.print("A "+ e.name + " appears!");
            UI.print("Press enter to fight");
            scan.nextLine();
            UI.clearScreen();
            Battle.start(player, e, scan);
            if (!player.isAlive()) break;
        }

    }
}

