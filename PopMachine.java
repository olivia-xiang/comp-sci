public class PopMachine {
    private int numberOfPop;
    private double amountOfMoney;
    private double priceOfPop;

    public PopMachine(int numberOfPop, double amountOfMoney, double priceOfPop) {
        this.numberOfPop = numberOfPop;
        this.amountOfMoney = amountOfMoney;
        this.priceOfPop = priceOfPop;
    }

    public PopMachine(int numberOfPop) {
        this(numberOfPop, 90.0, 1.75);
    }

    public void coinSlot(double money) {
        amountOfMoney += money;
    }

    public void popButton() {
        if (numberOfPop >= 1) {
        numberOfPop--;
        } else {
            System.out.println("Sold out");
        }
    }

    public double coinReturn() {
        amountOfMoney -= priceOfPop;
        return amountOfMoney;
    }
}
