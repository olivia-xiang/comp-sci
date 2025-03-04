import java.util.Scanner;
import java.util.StringTokenizer;

public class PolynomialEvaluator {
    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);
        double sum = 0;
        double coefValue = 0;

        System.out.println("Please enter a polynomial in the form f(x)=");

        // don't hard code the equal sign positon make it more dynamic
        StringTokenizer polyToken = new StringTokenizer ((keyboard.nextLine()).substring(5), " ");
        System.out.println("Please enter an x value:");
        int x = keyboard.nextInt();

        while (polyToken.hasMoreTokens()) {
            coefValue = 0;
            boolean isMinus = false;
            String temp = polyToken.nextToken();
            if ((temp.charAt(0) == 43) || (temp.charAt(0) == 45)) {
                // very redudanant make into if else 
                if (temp.charAt(0) ==45) {
                    isMinus = true;
                }
                temp = temp.substring(1);
            }
            int coefLength = -1;
            for (int i = 0; i <= temp.length(); i++) {
                if (Character.isDigit(temp.charAt(i))) {
                    coefLength += 1;
                } else {
                    break;
                }
            }
            for (int i = -1; i < coefLength; i++) {
                coefValue += Character.getNumericValue(temp.charAt(i+1)) * Math.pow(10,coefLength);
                coefLength --;
            }
            // use the ternary operator??
            if (isMinus == true) {
                sum -= coefValue * Math.pow(x,Character.getNumericValue(temp.charAt(temp.length()-1)));
            } else {
                sum += coefValue * Math.pow(x,Character.getNumericValue(temp.charAt(temp.length()-1)));
            }
        }
        System.out.println(sum); 
        keyboard.close();
    }
}