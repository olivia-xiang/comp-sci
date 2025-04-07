public class Point {
    private Point p1;

    public Point(double x, double y) {
        p1 = new Point (x, y);
    }

    public Point() {
        p1 = new Point(0, 0);
    }

    public double getX() {
        return p1.getX();
    }

    public double getY() {
        return p1.getY();
    }

    public Point difference(Point p2) {
        return p1.difference(p2);
    }

    public Point sum (Point p2) {
        return p1.sum(p2);
    }

    public void displayCoordinate() {
        System.out.println("The x-coordinate is: " + getX());
        System.out.println("The y coordinate is: " + getY());
    }

    public double distance(Point p2) {
        return p1.distance(p2);
    }

    public double slope(Point p2) {
        return p1.slope(p2);
    }

    public double yIntercept(Point p2) {
        return p1.yIntercept(p2);
    }

    public Point midPoint(Point p2) {
        return p1.midPoint(p2);
    }

    public void linearEquation(Point p2) {
        System.out.println("y = " + slope(p2) + "x " + yIntercept(p2));
    }
}
