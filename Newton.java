import java.util.Scanner;

public class Newton {
    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);
        int counter = 0;
        String[] list = new String[200];

        while (true) {
            System.out.println("Please enter a guess:");
            double guess = keyboard.nextDouble();

            double fx = 6 * Math.pow(guess, 4) - 13 * Math.pow(guess, 3) - 18 * Math.pow(guess, 2) + 7 * guess + 6;
            double fxDerived = 24 * Math.pow(guess, 3) - 39 * Math.pow(guess, 2) - 36 * guess + 7;
            double approx = guess - fx / fxDerived;
            list[counter] = Double.toString(approx);
            for (int i = 0; i < counter; i++) {
                System.out.println(list[i]);
            }

            if ((Math.abs(guess) - approx) >= 0.0001) {
                guess = approx;
                System.out.println(approx);   
            }   
                System.out.println("You have found one root which is " + (Math.round(guess)));
                break;
            } else {
                System.out.println("A closer guess would be " + (approx));
                System.out.println("Would you like to try again? [y/n]");

                //maybe change the y to be both upper and lower case
                if (keyboard.next().charAt(0) != 'y') {
                    keyboard.close();
                    break;
                }
            }
        }
    }
}