import java.util.Scanner;
public class integers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        double number = scanner.nextDouble();
        scanner.close();
        System.out.println("You entered: " + ((int)number));
    }
}