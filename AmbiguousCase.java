import java.util.Scanner;

public class AmbiguousCase {
    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Please enter angle A:");
        double angleA = keyboard.nextDouble();
        System.out.println("Please enter a side a:");
        double a = keyboard.nextDouble();
        System.out.println("Please enter side b:");
        double b = keyboard.nextDouble();
        
        double angleB = Math.asin(b * Math.sin(Math.toRadians(angleA)) / a);
        double h = b * Math.sin(Math.toRadians(angleA));
        
        keyboard.close();

        if (angleB < 90 || Double.isNaN(angleB) == true ) {
            
            if (a < h) {
                System.out.println("There is no triangle.");
            } else if (a == h) {
                System.out.println("It is a right triangle.");
            } else if (a < b && h < a) {
                System.out.println("There are two triangles, it is an ambiguous case.");
            } else {
                System.out.println("There is one triangle.");
            }
        } else {
            if (a < b || a == h) {
                System.out.println("There is no triangle.");
            } else {
                System.out.println("There is one triangle.");
            }
        }
    }
}