public class Alcohol extends Beverage {
    
    protected double alcoholByVolume;
    protected double age;

    public Alcohol(double volume, int calories, double alcoholByVolume, double age) {
        super(volume,calories);
        this.alcoholByVolume = alcoholByVolume;
        this.age = age;
    }

    public Alcohol(double volume, int calories) {
        this(volume, calories, 0.5, 0);
    }

    public void reset(double volume, int calories, double alcoholByVolume, double age) {
        this.volumes[0] = volume;
        this.volumes[1] = volume;
        this.calories = calories;
        this.alcoholByVolume = alcoholByVolume;
        this.age = age;
    }


}
