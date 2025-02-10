import java.lang.Math;
import java.util.Scanner;

public class quadraticformula {
    public static void main (String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter an a value: ");
        double a = keyboard.nextDouble();
        System.out.println("Enter a b value: ");
        double b = keyboard.nextDouble();
        System.out.println("Enter a c value: ");
        double c = keyboard.nextDouble();

        keyboard.close();
        //System.out.println( Math.pow(b,2) - 4*a*c);
        double finalValue = (-b + Math.sqrt(Math.pow(b,2) - 4*a*c)) / 2*a;

        System.out.println("Your first root is: " + finalValue);
    }
}
