public class Point {

    // most recent
    private double x;
    private double y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    Point() {
        this.x = 0;
        this.y = 0;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Point difference(Point p) {
        return new Point(x - p.getX(), y - p.getY());
    }

    public Point sum(Point p) {
        return new Point(x + p.getX(), y + p.getY());
    }

    public void displayCoordinate() {
        System.out.println("The x-coordinate is: " + getX());
        System.out.println("The y-coordinate is: " + getY());
    }

    public double distance(Point p) {
        return Math.sqrt(Math.pow(difference(p).getX(), 2) + Math.pow(difference(p).getY(), 2));
    }

    public double slope(Point p) {
        return (difference(p).getY() / difference(p).getX());
    }

    public double yIntercept(Point p) {
        return y - slope(p) * x;
    }

    public Point midPoint(Point p) {
        return new Point(sum(p).getX() / 2, sum(p).getY() / 2);
    }

    public void linearEquation(Point p) {
        System.out.println(
                "y = " + slope(p) + "x " + (yIntercept(p) >= 0 ? "+ " + yIntercept(p) : "- " + -yIntercept(p)));
    }
}