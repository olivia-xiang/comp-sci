import java.util.Scanner;

public class PIApproximation {
    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);
        double sum = 0;
        boolean again = true;

        System.out.println("Please enter an n value:");
        double n = keyboard.nextDouble();

        while (again == true) {
           for (int i = 1; i < (n + 1); i++) {
            sum += 4 * (Math.pow(-1, (i + 1)) / (2 * i - 1));
            }
            System.out.println(sum); 
            System.out.println("Would you like to enter another n value? (true/false)");
            again = keyboard.nextBoolean();
            if (again == true) {
                sum = 0;
                System.out.println("Please enter an n value:");
                n = keyboard.nextDouble();
            } else {
                break;
            }
        }
      keyboard.close();  
    }
}