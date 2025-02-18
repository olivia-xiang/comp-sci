import java.util.Scanner;
public class NAND {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner (System.in); 
        boolean isTrue = true;

        System.out.println("Please enter the value of a: [y/n] ");
        char a = keyboard.next().charAt(0);
        System.out.println("Please enter the value of b: [y/n] ");
        char b = keyboard.next().charAt(0);
       
        keyboard.close();

        isTrue =! ((a == 'y' || a == 'Y') && (b == 'y' || b =='Y')); 
        System.out.println(isTrue);
    }
}
