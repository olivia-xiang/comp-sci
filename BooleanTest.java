import java.util.Scanner;

public class BooleanTest {
    public static void main (String[] args) {
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Please enter value a ");
        boolean a = keyboard.nextBoolean();
        System.out.println("Please enter value b ");
        boolean b = keyboard.nextBoolean();
        System.out.println("Please enter value c ");
        boolean c = keyboard.nextBoolean();
        System.out.println("Please enter value d ");
        boolean d = keyboard.nextBoolean();

        keyboard.close();

        boolean abcd = ((a && b) || (c && d)) || ((a && d) || (a && c)) || ((b && c) || (b && d));

        System.out.println("The result is " + abcd);
    }
}
