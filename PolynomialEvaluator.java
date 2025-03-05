import java.util.Scanner;
import java.util.StringTokenizer;

public class PolynomialEvaluator {
    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);
        double sum = 0;
        double coefValue = 0;

        System.out.println("Please enter a polynomial in the form f(x)=");

        // don't hard code the equal sign positon make it more dynamic
        StringTokenizer polyToken = new StringTokenizer((keyboard.nextLine()).substring(5), " ");
        System.out.println("Please enter an x value:");
        int x = keyboard.nextInt();

        while (polyToken.hasMoreTokens()) {
            coefValue = 0;
            boolean isMinus = false;
            String temp = polyToken.nextToken();

            if ((temp.charAt(0) == 43) || (temp.charAt(0) == 45)) {
                // very redudanant make into if else
                if (temp.charAt(0) == 45) {
                    isMinus = true;
                }
                temp = temp.substring(1);
            }

            int coefLength = 0;
            int coefDeciPlace = 0;
            int coefNumPlace = 0;
            double expoTerm = 0;
            double expoDig = 0;
            boolean xValue = false;
            double termValue = 0;

            for (int i = 0; i < temp.length(); i++) {
                if (temp.charAt(i) != 'x' && xValue == false) {
                    coefLength += 1; 
                } else {
                    xValue = true;
                    expoDig += 1;
                }
            }
            expoDig = expoDig - 2;
            coefNumPlace = coefLength - 1;

            for (int i = 0; i < coefLength; i++) {
                if (temp.charAt(i) == '.') {
                    coefDeciPlace = -1;
                    continue;
                }
                double numValue = Character.getNumericValue(temp.charAt(i));

                if (coefNumPlace >= 0) {
                    coefValue += numValue * Math.pow(10, coefNumPlace);
                    coefNumPlace--;
                } else {
                    coefValue += numValue * Math.pow(10, (coefDeciPlace));
                    coefDeciPlace--;
                }

            }
            if (xValue == true) {
                for (int i = coefLength + 2; i < temp.length(); i++) {
                    expoTerm += Character.getNumericValue(temp.charAt(i)) * Math.pow(10,expoDig - 1);
                    expoDig --;
                }
                termValue = coefValue * Math.pow(x, expoTerm);
            } else {
                termValue = coefValue;
            }
            sum = (isMinus) ? sum - termValue : sum + termValue;
        }
        System.out.println(sum);
        keyboard.close();
    }
}

// CONSTANTS

//wrong values w decimals?? -1.23x^2 where x =2, print -4.92 instead of 5