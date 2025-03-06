import java.util.Scanner;
import java.util.StringTokenizer;

public class PolynomialEvaluatorH {
    public static void main (String[] args) {
        Scanner keyboard = new Scanner(System.in);
        double sum = 0;

        System.out.println("Please enter a list of coefficents with spaces inbetween");
        StringTokenizer coeffToken = new StringTokenizer(keyboard.nextLine());

        System.out.println("Please enter a list of the exponents with spaces inbetween");
        StringTokenizer expoToken = new StringTokenizer(keyboard.nextLine());

        System.out.println("Please enter the value of x");
        double x = keyboard.nextDouble();

        String[] coeffValues = new String [coeffToken.countTokens()];
        String[] expoValues = new String [expoToken.countTokens()];

        while (coeffToken.hasMoreTokens() && expoToken.hasMoreTokens()) {
            for (int i = 0; i < (coeffValues.length); i ++) {
                if (coeffValues[i] == null) {
                    coeffValues[i] = coeffToken.nextToken();
                    expoValues[i] = expoToken.nextToken();
                    break;
                }
            }
        }
        System.out.print("f(x)=");
        for (int i = 0; i < (coeffValues.length); i++) {
            sum += Double.parseDouble(coeffValues[i]) * Math.pow(x,Double.parseDouble((expoValues[i])));
            System.out.print(coeffValues[i] + "x^" + expoValues[i] + " ");
            
            
        }
        System.out.println("");
        System.out.println("f(" + x + ")= " + sum);
        keyboard.close();
    }
}