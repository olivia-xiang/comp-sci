import java.util.Scanner;

public class ISBNChecker {
    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);
        double sum = 0;

        System.out.println("Please enter an ISBN number:");
        String n = keyboard.nextLine();

        if (n.length() < 13) {
            System.out.println("Your ISBN number is invalid");
        } else {
            for (int i = 0; i < n.length(); i++) {
                if (i % 2 == 0) {
                    sum += n.charAt(i) * 1;
                } else {
                    sum += n.charAt(i) * 3;
                }
            }
            if (sum % 10 == 0 || sum % 2 == 2 || sum % 5 == 0) {
                System.out.println("Your ISBN number is valid");
            } else {
                System.out.println("Your ISBN number is invalid");
            }
        }
        keyboard.close();
    }
}
