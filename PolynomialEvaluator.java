import java.util.Scanner;
import java.util.StringTokenizer;

public class PolynomialEvaluator {
    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Please enter a polynomial in the form f(x)=");
        StringTokenizer polyToken = new StringTokenizer ((keyboard.nextLine()).substring(5), " ");

        while (polyToken.hasMoreTokens()) {
            String temp = polyToken.nextToken();
            for (int i = 0; i < temp.length(); i++) {
                
            }
            
        } 
    }
}