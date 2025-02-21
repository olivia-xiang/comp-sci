import java.util.Scanner;

public class AsymptoteFinder {
    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Please enter expontent value of the numerator:");
        int m = keyboard.nextInt();
        System.out.println("Please enter expontent value of the denominator:");
        int n = keyboard.nextInt();
        keyboard.close();

        if (m < n) {
            System.out.println("The asymptote is the x-axis");
        } else if (m > n) {
            int difference = m - n;
            switch (difference) {
                case 10:
                    System.out.println("It is decic.");
                    break; 
                case 9:
                    System.out.println("It is nonic.");
                    break;
                case 8:
                    System.out.println("It is octic.");
                    break;
                case 7:
                    System.out.println("It is septic.");
                    break;
                case 6:
                    System.out.println("It is sextic.");
                    break;
                case 5:
                    System.out.println("It is quintic.");
                    break;
                case 4:
                    System.out.println("It is quartic.");
                    break;
                case 3:
                    System.out.println("It is cubic.");
                    break;
                case 2:
                    System.out.println("It is quadratic.");
                    break;
                case 1:
                    System.out.println("It is linear.");
                    break;
            }
        } else {
            System.out.println("The asymptote is horizontal.");
        }
    }
}