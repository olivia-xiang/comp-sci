public class Drink {

    protected String name;
    protected double[] volumes = new double[2];
    protected int calories;
    private double price = 0.01;

    public Drink(String name, double volume, int calories) {
        this.name = name;
        this.volumes[0] = volume;
        this.volumes[1] = volume;
        this.calories = calories;
    }

    protected String getName() {
        return name;
    }

    protected double getVolumeTotal() {
        return volumes[1];
    }

    protected double getVolumeLeft() {
        return volumes[0];
    }

    protected int getCalories() {
        return calories;
    }

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

    public void cashReciever(double money) {
        if (money >= (volumes[1] - volumes[0]) * price) {
            money -= (volumes[1] - volumes[0]) * price;
            refillDrink(true, money);
        }
        refillDrink(false, money);
    }

    public void creditReciever(String cardNumer) {
        int sum = 0;
        for (int i = 0; i < cardNumer.length(); i++) {
            if (i % 2 == 0) {
                if (cardNumer.charAt(i) * 2 > 9) {
                    String[] nums = String.valueOf(cardNumer.charAt(i) * 2).split("");
                    for (String num : nums) {
                        sum += Integer.parseInt(num);
                    }
                } else {
                    sum += cardNumer.charAt(i) * 2;
                }
            }
        } 
        refillDrink((sum % 10 == 0 ? true : false), 0);
    }

    private double refillDrink(boolean enoughPaid, double change) {
        if (enoughPaid) {
            System.out.println("Your drink has been refilled for the price of $" + (volumes[1] - volumes[0]) * price);
            volumes[0] = volumes[1];
            return change;
        } else {
            System.out.println("It costs " + (volumes[1] - volumes[0]) * price + " to refill your drink. You need to enter $"
                    + ((volumes[1] - volumes[0]) * price - change) + " more.");
            return change;
        }
    }
}
