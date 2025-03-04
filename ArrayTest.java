import java.util.Scanner;

public class ArrayTest {
    public static void main (String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String[] input = new String[10];
        while (true) {
            System.out.println("Please select a menu option: 1,2,3,4");
            int choice = keyboard.nextInt();
            
            if (choice == 2) {
                for (int i = 0; i < input.length; i++) {
                    System.out.println(input[i]);
                } 
            } else if (choice == 1) {
                for (int i = 0; i < input.length; i++) {
                        System.out.println("Please enter a value to be inputted into the " + i + " array slot");
                        input[i] = keyboard.nextLine();
                }
            } else if (choice == 3) {
                System.out.println("Please enter a number from 1-10");
                int arrayChoice = keyboard.nextInt();
                System.out.println("The value at arrayChoice" + input[arrayChoice - 1]);
            } else if (choice == 4) {
                System.exit(1);
            }
        }
    }
}
    