public class UI {

    public static void print(String text){
        System.out.println(center(text,80));
    }

    public static void clearScreen(){
        System.out.println("\n".repeat(50));
    }

    public static String center(String text, int width){
        int padding = (width - text.length()) / 2;
        return " ".repeat(padding) + text;
    }

}
