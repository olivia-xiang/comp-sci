import java.util.Scanner;
import java.lang.Math;

public class cossinelaw {
    public static void main (String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter side a ");
        double a = keyboard.nextDouble();
        System.out.println("Please enter side b ");
        double b = keyboard.nextDouble();
        System.out.println("Please enter an angle C ");
        double angleC = keyboard.nextDouble();

        keyboard.close();

        System.out.println("The value of side C is " + (Math.sqrt(Math.pow(a, 2) + Math.pow(b,2) - 2 * b * a * Math.cos(Math.toRadians(angleC)))));
    }
}
