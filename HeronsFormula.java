import java.util.Scanner;

public class HeronsFormula {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Please enter side a:");
        double a = keyboard.nextDouble();
        System.out.println("Please enter side b:");
        double b = keyboard.nextDouble();
        System.out.println("Please enter side c:");
        double c = keyboard.nextDouble();
        keyboard.close();

        double area = 0.25 * Math.sqrt(4 * a * a * b * b - Math.pow((a * a + b * b - c * c), 2));
        System.out.println("The area is: " + area);
    }
}