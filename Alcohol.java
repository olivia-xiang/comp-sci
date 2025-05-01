package beverage;

/**
 * Represents the alcoholic beverage class that extends the beverage class
 * 
 * @author Olivia Xiang
 * @version 1.0 - April 2025
 */
public class Alcohol extends Beverage {
    /**
     * Contains the concentration of alcohol in the drink
     */
    protected double alcoholByVolume;
    /**
     * Contains how long the alcohol has been aged for
     */
    protected double ageOfAlcohol;
    private final int YEAR = 2025;
    private boolean ofAge = false;
    private final int DRINKING_AGE = 25;
    private String alcoholMixIn = "none";

    /**
     * Creates a new alcohol object
     * 
     * @param volume          the inital volume of the drink
     * @param calories        the amount of calories in the inital volume
     * @param alcoholByVolume the concentration of alcohol in the drink
     * @param ageOfAlcohol    how long the alcohol has been aged for
     * @param alcoholMixIn    the liquids that have been mixed into the alcohol
     */
    public Alcohol(double volume, int calories, double alcoholByVolume, double ageOfAlcohol, String alcoholMixIn) {
        super(volume, calories);
        this.alcoholByVolume = alcoholByVolume;
        this.ageOfAlcohol = ageOfAlcohol;
        this.alcoholMixIn = alcoholMixIn;
    }

    /**
     * Creates a new alcohol object
     * 
     * @param volume   the inital volume of the drink
     * @param calories the amount of calories in the inital volume
     */
    public Alcohol(double volume, int calories) {
        this(volume, calories, 0.5, 0, "none");
    }

    /**
     * Resets the properties of the alcohol object
     * 
     * @param volume          the amount in volume the new drink can hold
     * @param calories        the amount of calories present in the new drink
     * @param alcoholByVolume the concentration of alcohol in the new drink
     * @param ageOfAlcohol    how long the new alcohol has been aged for
     */

    public void reset(double volume, int calories, double alcoholByVolume, double ageOfAlcohol) {
        this.volumes[0] = volume;
        this.volumes[1] = volume;
        this.calories = calories;
        this.alcoholByVolume = alcoholByVolume;
        this.ageOfAlcohol = ageOfAlcohol;
    }

    /**
     * Returns amount of alcohol in the drink
     * 
     * @return the amount of alcohol in the drink
     */

    public double getAlcoholByVolume() {
        return alcoholByVolume;
    }

    /**
     * Returns the age of the alcohol in the drink
     * 
     * @return the age of the alcohol in the drink
     */

    public double ageOfAlcohol() {
        return ageOfAlcohol;
    }

    /**
     * Returns the mix in present in the alcohol if there are any
     * 
     * @return the mix in of the alcohol, there are none, it returns a String
     *         containing none
     */

    public String checkMixIn() {
        return alcoholMixIn;
    }

    /**
     * Prints an error message if the user is not of age to drink alcohol
     * 
     * @param error the error that the user has made
     */

    private void alchoholErrorMsg(String error) {
        System.out.println("You aren't of age to " + error + " alcohol");
    }

    /**
     * Check if the user is of age to drink alcohol
     * 
     * @param idBirthYear the year the user was born
     */

    public void checkId(int idBirthYear) {
        if (YEAR - idBirthYear >= DRINKING_AGE) {
            ofAge = true;
        } else {
            alchoholErrorMsg("buy and drink");
        }
    }

    /**
     * If the user is of age, the user is allowed to drink alcohol
     * 
     * @param volume the amount of alcohol the user wants to drink
     */

    public void drink(double volume) {
        if (ofAge) {
            super.drink(volume);
        } else {
            alchoholErrorMsg("drink");
        }
    }

    /**
     * If the user is of age, the user is allowed to buy alcohol
     * 
     * @param money     the amount of money the user has
     * @param refillAmt the amount of alcohol the user wants to buy
     * @return the change if the user is not of age to buy alcohol or 0 if they are
     *         eligible to buy alcohol
     */

    public int cashReciever(int money, double refillAmt) {
        if (ofAge) {
            super.cashReciever(money, refillAmt);
            return 0;
        } else {
            alchoholErrorMsg("buy");
            return money;
        }
    }

    /**
     * If the user is of age, the user is allowed to buy alcohol
     * 
     * @param cardNum   the card number of the user
     * @param refillAmt the amount of alcohol the user wants to buy
     */

    public void cashReciever(String cardNum, double refillAmt) {
        if (ofAge) {
            super.creditReciever(cardNum, refillAmt);
        } else {
            alchoholErrorMsg("buy");
        }
    }

    /**
     * Appraises the alcohol based on its age, mouth feel, and flavour
     * 
     * @return the rating of the alcohol
     */

    public int alcoholApprasier() {
        int rating = 0;
        int mouthFeel = (int) (Math.random() * 5);
        int flavour = (int) (Math.random() * 5);

        System.out.println("Aging quality: " + (ageOfAlcohol >= 5 ? 2 : 0));
        System.out.println("Mouth feel: " + mouthFeel);
        System.out.println("Flavour: " + flavour);

        rating += (ageOfAlcohol >= 5 ? 2 : 0);
        return mouthFeel + flavour + rating;
    }
}