import java.util.Scanner;

public class Main {


    static int showMenu(Scanner scan){
        System.out.println(center("=== CMDGAME ===", 80));
        System.out.println(center("1. Play", 80));
        System.out.println(center("2. How to play", 80));
        System.out.println(center("3. Quit", 80));
        try {
            return scan.nextInt();
        }catch (Exception e){
            System.out.println(center("Invalid choice.", 80));
            scan.nextLine();
            return 0;
        }
    }


    static String center(String text, int width){
        int padding = (width - text.length()) / 2;
        return " ".repeat(padding) + text;
    }


    void main() {
        Scanner scan = new Scanner(System.in);
        int mchoice = 0;
        while (mchoice != 1){
            mchoice = showMenu(scan);
            if (mchoice == 2) System.out.println("TBA");
            if (mchoice == 3) System.exit(0);
        }
        Player player = new Player("Test", 100, 15);
        Enemy enemy = new Enemy("Goblin", 50, 8);
        player.inventory.add(new HealthPot("Health Potion", 30));

        Battle.start(player,enemy,scan);

    }
}

