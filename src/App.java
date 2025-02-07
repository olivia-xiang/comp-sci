import java.util.Scanner;
public class App {
    
    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);
        System.out.println ("Please enter a decimal: ");
        double n = keyboard.nextDouble();
        keyboard.close();

        System.out.println ("Your input was " + (int) n + ".");
    }
}
