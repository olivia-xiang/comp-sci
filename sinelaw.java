import java.util.Scanner;
import java.lang.Math;

public class sinelaw {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner (System.in);
        System.out.println("Enter the value of side A: ");
        double sideA = keyboard.nextDouble();
        System.out.println("Enter the value in degrees of angle A: ");
        double angleA = keyboard.nextDouble();
        System.out.println("Enter the value of side B: ");
        double sideB = keyboard.nextDouble();

        keyboard.close();

        System.out.println(Math.toDegrees((Math.asin((Math.sin(Math.toRadians(angleA)) * sideB / sideA)))));
    }
}
