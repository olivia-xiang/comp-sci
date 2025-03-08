import java.util.Scanner;

public class PowerRule {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner (System.in);
        String firstDeriv = "Your first derivative is: f'(x)= ";
        String secondDeriv = "Your second derivative is: f''(x)= ";

        System.out.println("Please input the coefficients seperated by a space");
        String coeff = keyboard.nextLine();
        System.out.println("Please input the degrees seperated by a space");
        String degree = keyboard.nextLine();
        keyboard.close();

        String[] coeffArray = coeff.split(" ");
        String[] degreeArray = degree.split(" ");

        for (int i = 0; i < coeffArray.length; i ++) {
            int expo = Integer.parseInt(degreeArray[i]) - 1;
            double term = Double.parseDouble(coeffArray[i]) * Integer.parseInt(degreeArray[i]);
            firstDeriv += ((Integer.parseInt(degreeArray[i]) == 1) ? Double.toString(term) : Double.toString(term) + "x^" + expo) + " ";  
            //firstDeriv += ((i + 1 < coeffArray.length) ? ((coeffArray[i + 1].indexOf(0)) == '1' ? "" : "+") : "");
            if (expo > 0) {
                secondDeriv += (((Integer.parseInt(degreeArray[i]) - 1) <= 1) ? Double.toString(term * expo) : Double.toString(term * expo) + "x^" + (expo - 1)) + " ";
                //secondDeriv += ((i + 1 < coeffArray.length) ? ((coeffArray[i + 1].indexOf(0)) == '-' ? "" : "+") : "");
            }
        }
        System.out.println(firstDeriv);
        System.out.println(secondDeriv);
    }
}

