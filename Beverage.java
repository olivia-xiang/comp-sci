package beverage;

/**
 * Represents a beverage with a volume and amount of calories
 * 
 * @author Olivia Xiang
 * @version 1.0 - April 2025
 */
public class Beverage {

    /**
     * Contains the remaining volume in the beverage and the total volume capacity
     * of the beverage
     */
    protected double[] volumes = new double[2];
    /**
     * Contains the total amount of calories in the beverage given the volume
     * remaining
     */
    protected int calories;
    private double price = 0.02;

    /**
     * Creates a new beverage object
     * 
     * @param volume   the inital volume of the beverage
     * @param calories the amount of calories in the total drink
     */

    public Beverage(double volume, int calories) {
        this.volumes[0] = volume;
        this.volumes[1] = volume;
        this.calories = calories;
    }

    /**
     * Returns the total volume that the beverage can hold
     * 
     * @return total volume that beverage can hold
     */

    protected double getVolumeTotal() {
        return volumes[1];
    }

    /**
     * Returns the total volume remaining in the beverage
     * 
     * @return total volume left in beverage
     */

    protected double getVolumeLeft() {
        return volumes[0];

    }

    /**
     * Returns the amount of calories present in the beverage given the volume
     * remaining
     * 
     * @return the amount of calories in the beverage
     */

    protected int getCalories() {
        return calories;

    }

    /**
     * Checks if the drink is empty, if the drink has at least
     * equal or more than
     * the amount looking to be drank then adjusts the volume left
     * in the beverage
     * accordingly
     * 
     * @param volumeDrank the amount of the beverage the user wants to drink
     * 
     * 
     * 
     */

    public void drink(double volumeDrank) {
        if (volumes[0] == 0) {
            System.out.println("Your drink is empty.");
        } else if (volumeDrank <= volumes[0]) {
            System.out.println(
                    "You drank " + volumeDrank + "mL, that was " + volumeDrank / volumes[0] * calories + calories
                            + " calories.");
            calories -= volumeDrank / volumes[0] * calories;
            volumes[0] -= volumeDrank;

        } else {
            volumes[0] = 0;
            System.out.println("You can't drink more than the cup can hold. Your drink is now empty. You consumed "
                    + calories + " calories.");
        }

    }

    /**
     * @param refillAmt the amount of the beverage looking to be refilled
     * 
     * @return the adjusted refillAmt if it is greater than what the beverage can
     *         hold
     */

    private double checkRefillAmt(double refillAmt) {
        return (refillAmt > (volumes[1] - volumes[0]) ? volumes[1] - volumes[0] : refillAmt);

    }

    /**
     * Adjusts the money entered into the cash deposit and calls the
     * refillDrink
     * function accordingly
     * 
     * @param money     the amount of money put in to refill the beverage
     * 
     * @param refillAmt the amount of the beverage looking to be refilled
     * 
     * @return the change from the purchase
     * 
     * 
     */

    public double cashReciever(double money, double refillAmt) {
        refillAmt = checkRefillAmt(refillAmt);
        if (money >= refillAmt * price && refillAmt != 0) {
            money -= refillAmt * price;
            return (refillDrink(money, refillAmt));
        } else {
            return (refillDrink(money, 0));
        }

    }

    /**
     * 
     * Utilizes Luhn's algorithmn to check validity of the card
     * then calls the refillDrink function accordingly
     * 
     * @param cardNumber the credit card number being used to pay
     * 
     * @param refillAmt  the amount of the beverage looking to be refilled
     * 
     * 
     */

    public void creditReciever(String cardNumber, double refillAmt) {
        int sum = 0;
        refillAmt = checkRefillAmt(refillAmt);
        if (refillAmt > 0) {
            for (int i = 0; i < cardNumber.length(); i++) {
                if (i % 2 == 0) {
                    if (cardNumber.charAt(i) * 2 > 9) {
                        String[] nums = String.valueOf(cardNumber.charAt(i) * 2).split("");
                        for (String num : nums) {
                            sum += Integer.parseInt(num);
                        }
                    } else {
                        sum += cardNumber.charAt(i) * 2;
                    }
                }
            }
            refillDrink(0, (sum % 10 == 0 ? refillAmt : 0));
        } else {
            refillDrink(0, 0);
        }

    }

    /**
     * @param change    the amount of change leftover from the user's money input
     * @param refillAmt the amount of the beverage looking to be refilled
     * 
     * @return the change
     */

    private double refillDrink(double change, double refillAmt) {
        if (refillAmt > 0) {
            System.out.println("Your drink has been filled for the price of $" + refillAmt * price);
            volumes[0] = volumes[0] + refillAmt;
        } else if (volumes[1] == volumes[0]) {
            System.out.println("Your drink is full and can't be filled");
        } else {
            System.out.println(
                    "It costs " + (volumes[1] - volumes[0]) * price + " to fill your drink. You need to enter $"
                            + ((volumes[1] - volumes[0]) * price - change) + " more.");
        }
        return change;
    }

}