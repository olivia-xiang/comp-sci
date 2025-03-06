import java.util.Scanner;
import java.util.StringTokenizer;

public class PolynomialEvaluator2 {
    public static void main(String[] args) {
        double sum = 0;
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Please enter a poylnomial in the form f(x)=...");
        StringTokenizer poly = new StringTokenizer(keyboard.nextLine());

        System.out.println("Please enter an x value:");
        double x = keyboard.nextInt();

        while (poly.hasMoreTokens()) {
            String temp = poly.nextToken();
            int coeffStart = -1;
            int coeffEnd = -1;
            boolean isConst = true;
            for (int i = 0; i < temp.length() ; i++) {
                if (Character.isDigit(temp.charAt(i)) || temp.charAt(i) == '-') {
                    if (coeffStart == -1){
                        coeffStart = i;
                    } 
                } else if (temp.charAt(i) == 'x' && temp.charAt(i + 1) =='^') {
                    coeffEnd = i;
                    isConst = false;
                    break;
                } 
            }
            coeffEnd = (coeffEnd == -1) ? temp.length() : coeffEnd;

            double coeffValue = Double.parseDouble(temp.substring(coeffStart, coeffEnd));

            double expoValue = 0;

            expoValue = (isConst) ? 0 : Double.parseDouble(temp.substring(coeffEnd + 2, temp.length()));

            sum += (coeffValue) * Math.pow(x,expoValue);
        }
        System.out.println("The final value of f(" + (int)x + ") is " + sum);
        keyboard.close();
    }
}
