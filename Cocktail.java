package beverage;

/**
 * Represents a cocktail drink with various properties and methods to manipulate
 * them that extends the alcohol class
 * 
 * @author Olivia Xiang
 * @version 1.0 - April 2025
 */

public class Cocktail extends Alcohol {
    /**
     * Contains whether there is a rim coating on the beverage
     */
    private boolean rimCoating;
    /**
     * Contains the color of the beverage
     */
    private String color;
    /**
     * Contains the type of fruit decoration on the beverage
     */
    private String fruitDecoration;
    /**
     * Contains the number of fruit decoration on the beverage
     */
    private int numFruitDecorations;
    private final double FRUIT_PRICE = 0.5;

    /**
     * Constructs a beverage given a volume, calories, alcohol by volume, age of
     * alcohol,
     * alcohol mix in, rim coating, color, fruit decoration, and number of fruit
     * decorations
     * 
     * @param volume              the inital volume of the beverage
     * @param calories            the amount of calories in the total drink
     * @param alcoholByVolume     the amount of alcohol in the beverage
     * @param ageOfAlcohol        the age of the alcohol in the beverage
     * @param alcoholMixIn        the type of alcohol mix in the beverage
     * @param rimCoating          whether there is a rim coating on the beverage
     * @param color               the color of the beverage
     * @param fruitDecoration     the type of fruit decoration on the beverage
     * @param numFruitDecorations the number of fruit decorations on the beverage
     */
    public Cocktail(double volume, int calories, double alcoholByVolume, double ageOfAlcohol, String alcoholMixIn,
            boolean rimCoating,
            String color, String fruitDecoration, int numFruitDecorations) {
        super(volume, calories, alcoholByVolume, ageOfAlcohol, alcoholMixIn);
        this.rimCoating = rimCoating;
        this.color = color;
        this.fruitDecoration = fruitDecoration;
        this.numFruitDecorations = numFruitDecorations;
    }

    /**
     * Constructs a beverage given a volume, calories, alcohol by volume, age of
     * alcohol,
     * alcohol mix in
     * 
     * @param volume          the inital volume of the beverage
     * @param calories        the amount of calories in the total drink
     * @param alcoholByVolume the amount of alcohol in the beverage
     * @param ageOfAlcohol    the age of the alcohol in the beverage
     * @param alcoholMixIn    the type of alcohol mix in the beverage
     */

    public Cocktail(double volume, int calories, double alcoholByVolume, double ageOfAlcohol, String alcoholMixIn) {
        this(volume, calories, alcoholByVolume, ageOfAlcohol, "none", false, "pink", "strawberry", 3);
    }

    /**
     * Constructs a beverage given a volume, calories, alcohol by volume, age of
     * alcohol
     * 
     * @param volume          the inital volume of the beverage
     * @param calories        the amount of calories in the total drink
     * @param alcoholByVolume the amount of alcohol in the beverage
     * @param ageOfAlcohol    the age of the alcohol in the beverage
     */

    public Cocktail(double volume, int calories, double alcoholByVolume, double ageOfAlcohol) {
        this(volume, calories, alcoholByVolume, ageOfAlcohol, "none", false, "pink", "strawberry", 3);
    }

    /**
     * Constructs a beverage given a volume and calories
     * 
     * @param volume   the inital volume of the beverage
     * @param calories the amount of calories in the total drink
     */

    public Cocktail(double volume, int calories) {
        this(volume, calories, 0.5, 0, "none");
    }

    /**
     * Resets the cocktail with new values for volume, calories, alcohol by volume,
     * 
     * @param volume          the inital volume of the beverage
     * @param calories        the amount of calories in the total drink
     * @param alcoholByVolume the amount of alcohol in the beverage
     * @param ageOfAlcohol    the age of the alcohol in the beverage
     * @param rimCoating      the rim coating of the beverage
     * @param color           the color of the beverage
     * @param fruitDecoration the type of fruit decoration on the beverage
     */

    public void reset(double volume, int calories, double alcoholByVolume, double ageOfAlcohol, boolean rimCoating,
            String color, String fruitDecoration) {
        reset(volume, calories, alcoholByVolume, ageOfAlcohol);
        this.rimCoating = rimCoating;
        this.color = color;
        this.fruitDecoration = fruitDecoration;
    }

    /**
     * Returns the color of the beverage
     * 
     * @return the color of the beverage
     */

    public String getColor() {
        return color;
    }

    /**
     * Returns whether there is a rim coating on the beverage
     * 
     * @return whether there is a rim coating on the beverage
     */

    public boolean getRimCoating() {
        return rimCoating;
    }

    /**
     * Returns the type of fruit decoration on the beverage
     * 
     * @return the type of fruit decoration on the beverage
     */

    public String getFruitDecoration() {
        return fruitDecoration;
    }

    /**
     * Returns the number of fruit decorations on the beverage
     * 
     * @return the number of fruit decorations on the beverage
     */

    public int getNumFruitDecoration() {
        return numFruitDecorations;
    }

    /**
     * Licks the rim of the beverage
     * 
     * @return the taste of the rim coating
     */

    public String lickTheRim() {
        if (rimCoating) {
            int typeOfRim = (int) (Math.random() * 3);
            rimCoating = false;
            switch (typeOfRim) {
                case 1:
                    return "salty and sweet";
                case 2:
                    return "citrusy and sour";
                default:
                    return "spicy and earthy";
            }
        }
        return "no rim coating to lick";
    }

    /**
     * Eats a fruit decoration on the beverage
     */

    public void eatAFruit() {
        if (numFruitDecorations > 1) {
            numFruitDecorations -= 1;
            System.out.println("You ate  " + fruitDecoration + ", you have " + numFruitDecorations + " left");
        } else {
            System.out.println("You have no more fruit to eat, buy more to eat more");
        }
    }

    /**
     * Buys a new fruit decoration for the beverage
     * 
     * @param money             the amount of money the user has
     * @param amtFruitPurchased the amount of fruit purchased
     * @return the amount of money left after purchasing the fruit
     */

    public double buyNewFruit(double money, int amtFruitPurchased) {
        if (money >= amtFruitPurchased * FRUIT_PRICE) {
            numFruitDecorations += amtFruitPurchased;
            return money - amtFruitPurchased * FRUIT_PRICE;
        }
        System.out.println("Insufficent funds, " + amtFruitPurchased * FRUIT_PRICE + " is required to buy "
                + amtFruitPurchased + " " + fruitDecoration + (amtFruitPurchased > 1 ? "s" : ""));
        return money;
    }

    /**
     * Mixes two cocktails together
     * 
     * @param c the cocktail to mix with
     * @return the new cocktail created by mixing the two cocktails
     */

    public Cocktail mixCocktails(Cocktail c) {
        double totalVolumes = c.volumes[0] + volumes[0];
        double percentVolume1 = volumes[0] / totalVolumes;
        double percentVolume2 = c.volumes[0] / totalVolumes;
        return new Cocktail(totalVolumes, calories + c.calories,
                (alcoholByVolume * percentVolume1 + c.alcoholByVolume * percentVolume2) / 2,
                (ageOfAlcohol * percentVolume1 + c.ageOfAlcohol * percentVolume2) / 2,
                "none", false, color + "ish " + c.color,
                fruitDecoration + " and " + c.fruitDecoration, numFruitDecorations + c.numFruitDecorations);
    }
}