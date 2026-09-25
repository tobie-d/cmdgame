public class UI {

    public static void print(String text){
        System.out.println(center(text,80));
    }


    // not a great way to do this, but it works for a console game
    // probably will cause some bug so change this soon
    public static void clearScreen(){
        System.out.println("\n".repeat(50));
    }

    public static String center(String text, int width){
        int padding = (width - text.length()) / 2;
        return " ".repeat(padding) + text;
    }

}
