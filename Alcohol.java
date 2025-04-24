public class Alcohol extends Beverage {

    protected double alcoholByVolume;
    protected double ageOfAlcohol;
    private final int YEAR = 2025;
    private boolean ofAge = false;
    private final int DRINKING_AGE = 25;

    public Alcohol(double volume, int calories, double alcoholByVolume, double ageOfAlcohol) {
        super(volume, calories);
        this.alcoholByVolume = alcoholByVolume;
        this.ageOfAlcohol = ageOfAlcohol;
    }

    public Alcohol(double volume, int calories) {
        this(volume, calories, 0.5, 0);
    }

    public void reset(double volume, int calories, double alcoholByVolume, double ageOfAlcohol) {
        this.volumes[0] = volume;
        this.volumes[1] = volume;
        this.calories = calories;
        this.alcoholByVolume = alcoholByVolume;
        this.ageOfAlcohol = ageOfAlcohol;
    }

    public double getAlcoholByVolume() {
        return alcoholByVolume;
    }

    public double ageOfAlcohol() {
        return ageOfAlcohol;
    }

    private void alchoholErrorMsg(String error) {
        System.out.println("You aren't of age to " + error + " alcohol");
    }

    // find a way to adjust pricing of the alcohol without changing the pricing of
    // normal beverages
    private double adjustPrice(double ageOfAlcohol) {
        return 0.02 + 0.05 * ageOfAlcohol;
    }

    public void checkId(int idBirthYear) {
        if (YEAR - idBirthYear >= DRINKING_AGE) {
            ofAge = true;
        } else {
            alchoholErrorMsg("buy and drink");
        }
    }

    public void drink(double volume) {
        if (ofAge) {
            super.drink(volume);
        } else {
            alchoholErrorMsg("drink");
            ;
        }
    }

    public int cashReciever(int money) {
        if (ofAge) {
            super.cashReciever(money);
            return 0;
        } else {
            alchoholErrorMsg("buy");
            return money;
        }
    }

    public void cashReciever(String cardNum) {
        if (ofAge) {
            super.creditReciever(cardNum);
        } else {
            alchoholErrorMsg("buy");
        }
    }

    public int alcoholApprasier() {
        int rating = 0;
        int mouthFeel = (int) (Math.random() * 5);
        int flavour = (int) (Math.random() * 5);

        System.out.println("Aging quality: " + (ageOfAlcohol >= 5 ? 2 : 0));
        System.out.println("Mouth feel: " + mouthFeel);
        System.out.println("Flavour: " + flavour);

        rating += (ageOfAlcohol >= 10 ? 2 : 0);
        return mouthFeel + flavour + rating;
    }
}