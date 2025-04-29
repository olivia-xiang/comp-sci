public class Alcohol extends Beverage {

    protected double alcoholByVolume;
    protected double ageOfAlcohol;
    private final int YEAR = 2025;
    private boolean ofAge = false;
    private final int DRINKING_AGE = 25;
    private String alcoholMixIn = "none";

    public Alcohol(double volume, int calories, double alcoholByVolume, double ageOfAlcohol, String alcoholMixIn) {
        super(volume, calories);
        this.alcoholByVolume = alcoholByVolume;
        this.ageOfAlcohol = ageOfAlcohol;
        this.alcoholMixIn = alcoholMixIn;
    }

    public Alcohol(double volume, int calories) {
        this(volume, calories, 0.5, 0, "none");
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

    public String checkMixIn() {
        return alcoholMixIn;
    } 
   
    private void alchoholErrorMsg(String error) {
        System.out.println("You aren't of age to " + error + " alcohol");
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
        }
    }

    public int cashReciever(int money, double refillAmt) {
        if (ofAge) {
            super.cashReciever(money, refillAmt);
            return 0;
        } else {
            alchoholErrorMsg("buy");
            return money;
        }
    }

    public void cashReciever(String cardNum, double refillAmt) {
        if (ofAge) {
            super.creditReciever(cardNum, refillAmt);
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

        rating += (ageOfAlcohol >= 5 ? 2 : 0);
        return mouthFeel + flavour + rating;
    }
}