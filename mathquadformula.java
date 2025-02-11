import java.lang.Math;
import java.util.Scanner;

public class mathquadformula {
    public static void main (String[] args) {
        Scanner keyboard = new Scanner (System.in);
        System.out.println("Please enter the value of a: ");
        double a = keyboard.nextDouble();
        System.out.println("Please enter the value of b: ");
        double b = keyboard.nextDouble();
        System.out.println("Please enter the value of c: ");
        double c = keyboard.nextDouble();

        keyboard.close();
        if ((Math.pow(b, 2) - 4 * a * c) < 0) {
            System.out.println("Your function has zero real roots.");
        }
        else {
            System.out.println("Your first root is " + ((-b + Math.sqrt((Math.pow(b, 2) - 4 * a * c))) / (2 * a)) + ".");
            System.out.println("Your second root is " + ((-b - Math.sqrt((Math.pow(b, 2) - 4 * a * c))) / (2 * a)) + ".");
        }
    }
}
    