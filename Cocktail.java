public class Cocktail extends Alcohol {

    private boolean rimCoating;
    private String color;
    private String fruitDecoration;
    private int numFruitDecorations;
    private final double FRUIT_PRICE = 0.5;

    public Cocktail(double volume, int calories, double alcoholByVolume, double ageOfAlcohol, boolean rimCoating,
            String color, String fruitDecoration, int numFruitDecorations) {
        super(volume, calories, alcoholByVolume, ageOfAlcohol);
        this.rimCoating = rimCoating;
        this.color = color;
        this.fruitDecoration = fruitDecoration;
        this.numFruitDecorations = numFruitDecorations;
    }

    public Cocktail(double volume, int calories, double alcoholByVolume, double ageOfAlcohol) {
        this(volume, calories, alcoholByVolume, ageOfAlcohol, false, "pink", "strawberry", 3);
    }

    public Cocktail(double volume, int calories) {
        this(volume, calories, 0.5, 0);
    }

    public void reset(double volume, int calories, double alcoholByVolume, double ageOfAlcohol, boolean rimCoating,
            String color, String fruitDecoration) {
        reset(volume, calories, alcoholByVolume, ageOfAlcohol);
        this.rimCoating = rimCoating;
        this.color = color;
        this.fruitDecoration = fruitDecoration;
    }

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

    public void eatAFruit() {
        if (numFruitDecorations > 1) {
            numFruitDecorations -= 1;
            System.out.println("You ate  " + fruitDecoration + ", you have " + numFruitDecorations + " left");
        } else {
            System.out.println("You have no more fruit to eat, buy more to eat more");
        }
    }

    public double buyNewFruit(double money, int amtFruitPurchased) {
        if (money >= amtFruitPurchased * FRUIT_PRICE) {
            numFruitDecorations += amtFruitPurchased;
            return money - amtFruitPurchased * FRUIT_PRICE;
        }
        System.out.println("Insufficent funds, " + amtFruitPurchased * FRUIT_PRICE + " is required to buy "
                + amtFruitPurchased + " " + fruitDecoration + (amtFruitPurchased > 1 ? "s" : ""));
        return money;
    }

    public Cocktail mixCocktails(Cocktail c) {
        return new Cocktail(volumes[0] + c.volumes[0], calories + c.calories,
                (alcoholByVolume + c.alcoholByVolume) / (volumes[0] + volumes[1]), (ageOfAlcohol + c.ageOfAlcohol) / 2,
                false, color + "ish " + c.color, fruitDecoration + "s and " + c.fruitDecoration + "s",
                numFruitDecorations + c.numFruitDecorations);
    }
}