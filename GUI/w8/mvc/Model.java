package w8.mvc;

public class Model {

    private int a, b, c;
    private double x1, x2;

    public Model() {
        this.a = 0;
        this.b = 0;
        this.c = 0;
    }

    public void calculate(){
        x1 = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
        x2 = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);
    }

    public double getX1() {
        return this.x1;
    }

    public double getX2() {
        return this.x2;
    }

    public int getA() {
        return a;
    }

    public void setABC(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}