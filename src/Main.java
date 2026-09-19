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
            if (mchoice == 2) print("TBA");
            if (mchoice == 3) System.exit(0);
        }
        scan.nextLine();
        String name = getName(scan);
        Player player = new Player(name, 100, 15);
        Dungeon dungeon = new Dungeon();
        dungeon.generate();
        player.inventory.add(new HealthPot("Health Potion", 30));

        for(int i=0; i < dungeon.rooms.length; i++ ){
            UI.print("You approach a room.");
            UI.print("Press enter to enter");
            scan.nextLine();
            UI.clearScreen();
            dungeon.enter(i, player, scan);
            if (!player.isAlive()) break;
        }

    }
}

