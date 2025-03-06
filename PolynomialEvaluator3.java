import java.util.Scanner;
import java.util.StringTokenizer;

public class PolynomialEvaluator3 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        double sum = 0;

        System.out.println("Please enter a polynomial in the form f(x)=...");
        StringTokenizer poly = new StringTokenizer(keyboard.nextLine().substring(keyboard.nextLine().indexOf(('=') + 1)));
        System.out.println("Please enter the value of x");
        double x = keyboard.nextDouble();

        while (poly.hasMoreTokens()) {
            String term = poly.nextToken();
            String coeff = "";
            coeff += ((term.indexOf('x') != -1) ? term.substring(0,term.indexOf('x')) : term.substring(0,term.length())); 
            String expo = "";
            expo += ((term.indexOf('^') != -1) ? term.substring(('^') + 1) : "0");

           sum += Double.parseDouble(coeff) * Math.pow(x, Double.parseDouble(expo));
        }
        System.out.println("The value of f(" + (int)x + ") = " + sum);
    }
}
