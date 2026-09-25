import java.util.Scanner;


public class Main {

    static int showMenu(Scanner scan){
        UI.print("=== CMDGAME ===");
        UI.print("1. Play");
        UI.print("2. How to play");
        UI.print("3. Quit");
        try {
            return scan.nextInt();
        }catch (Exception e){
            UI.print("Invalid choice.");
            scan.nextLine(); // clear the bad token so the next read works
            return 0;
        }
    }

    static String getName(Scanner scan){
        UI.clearScreen();
        UI.print("Enter Name: ");
        return scan.nextLine();
    }

    void main() {
        Scanner scan = new Scanner(System.in);
        int mchoice = 0;
        while (mchoice != 1){ // keep showing menu until player chooses "play"
            mchoice = showMenu(scan);
            if (mchoice == 2) UI.print("TBA");
            if (mchoice == 3) System.exit(0);
        }
        scan.nextLine();    // consume leftover newline after nextInt()
        String name = getName(scan);
        Player player = new Player(name, 100, 15);
        Dungeon dungeon = new Dungeon();
        dungeon.generate();

        // starting item so the player has something useful immediately (and to test item features)
        player.inventory.add(new HealthPot("Health Potion", 30));

        // walk through every room sequentially
        for(int i=0; i < dungeon.rooms.length; i++ ){
            UI.print("You approach a room.");
            UI.print("Press enter to enter");
            scan.nextLine();
            UI.clearScreen();
            dungeon.enter(i, player, scan);
            if (!player.isAlive()) break; // stop the run on death
        }

    }
}

