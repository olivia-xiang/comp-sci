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

    public String getColor() {
        return color;
    }

    public boolean getRimCoating() {
        return rimCoating;
    }

    public String getFruitDecoration() {
        return fruitDecoration;
    }

    public int getNumFruitDecoration() {
        return numFruitDecorations;
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
        double totalVolumes = c.volumes[0] + volumes[0];
        double percentVolume1 = volumes[0] / totalVolumes;
        double percentVolume2 = c.volumes[0] / totalVolumes;
        return new Cocktail(totalVolumes, calories + c.calories,
                (alcoholByVolume * percentVolume1 + c.alcoholByVolume * percentVolume2) / 2,
                (ageOfAlcohol * percentVolume1 + c.ageOfAlcohol * percentVolume2) / 2, false, color + "ish " + c.color,
                fruitDecoration + " and " + c.fruitDecoration, numFruitDecorations + c.numFruitDecorations);
    }
}