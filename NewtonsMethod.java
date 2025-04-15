import java.util.Scanner;

public class NewtonsMethod {
    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);

        main: while (true) {
            System.out.println("Please enter a guess:");
            double guess = keyboard.nextDouble();

            while (true) {
                double fx = 6 * Math.pow(guess, 4) - 13 * Math.pow(guess, 3) - 18 * Math.pow(guess, 2) + 7 * guess + 6;
                double fxDerived = 24 * Math.pow(guess, 3) - 39 * Math.pow(guess, 2) - 36 * guess + 7;
                double approx = guess - fx / fxDerived;

                if (Math.abs(guess - approx) > 0.0001) {
                    guess = approx;
                    System.out.println(approx);
                } else {
                    System.out.println("A root has been found: " + guess);
                    System.out.println("Would you like to try again? [y/n]");

                    if (keyboard.next().charAt(0) != 'y') {
                        keyboard.close();
                        break main;
                    }
                }
            }
        }
    }
}