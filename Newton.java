import java.util.Scanner;

public class Newton {
     public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);

       
        while (true) { 
            System.out.println("Please enter a guess:");
            double guess = keyboard.nextDouble();

            double fx = 6 * Math.pow(guess, 4) - 13 * Math.pow(guess, 3) - 18 * Math.pow(guess, 2) + 7 * guess + 6;
            double fxDerived = 24 * Math.pow(guess,3) - 39 * Math.pow(guess,2) - 36 * guess + 7;
            
            System.out.println(guess - fx / fxDerived); 
        }
}
