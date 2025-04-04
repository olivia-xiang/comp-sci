public class Quadratic {
    double a;
    double b;
    double c;
    double discriminant;

    public Quadratic(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.discriminant = b * b - 4 * a * c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setC(double c) {
        this.c = c;
    }

    public boolean hasReadlRoots() {
        return (discriminant > 0 ? true : false); 
    }

    public boolean isMaximum() {
        return (a > 0 ? true : false);
    }

    public double getDiscriminant() {
        return (discriminant);
    }

    public double[] getRoots() {
        double[] roots = new double[2];
        roots[0] = (-b + Math.sqrt(discriminant)) / 2 * a;
        roots[1] = (-b - Math.sqrt(discriminant)) / 2 * a;
        return roots;
    }

    public double[] getVertex() {
        double vertex[] = new double[2];
        vertex[0] = 2 * a / b;
        vertex[1] = vertex[0] * vertex[0] * a + vertex[0] * b + c;
        return vertex;
    }

    public double[] getXIntercept() {
        double[] intercept = 
    }
}
