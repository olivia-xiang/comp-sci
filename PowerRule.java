import java.util.Scanner;

public class PowerRule {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String firstDeriv = "Your first derivative is: f'(x)= ";
        String secondDeriv = "Your second derivative is: f''(x)= ";

        System.out.println("Please input the coefficients seperated by a space");
        String coeff = keyboard.nextLine();
        System.out.println("Please input the degrees seperated by a space");
        String degree = keyboard.nextLine();
        keyboard.close();

        String[] coeffArray = coeff.split(" ");
        String[] expoArray = degree.split(" ");

        for (int i = 0; i < coeffArray.length; i++) {
            int expo = Integer.parseInt(expoArray[i]) - 1;
            double term = Double.parseDouble(coeffArray[i]) * Integer.parseInt(expoArray[i]);

            if (term != 0 && expo >= 0) {
                firstDeriv += (term > 0 && i != 0 ? "+" : "")
                        + (term % 1 == 0 ? Integer.toString((int) term) : Double.toString(term));
                if (expo > 0) {
                    secondDeriv += (term > 0 && i != 0 ? "+" : "")
                            + (term % 1 == 0 ? Integer.toString((int) term * expo) : Double.toString(term * expo));
                }
            }
            if (expo > 0) {
                firstDeriv += "x^" + expo + " ";
                secondDeriv += ((expo - 1) > 0 ? "x^" + (expo - 1) : "") + " ";
            }
        }
        System.out.println(firstDeriv);
        System.out.println(secondDeriv);
    }
}