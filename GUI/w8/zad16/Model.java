package w8.zad16;

public class Model {

    private int a, b, c;

     public Model(){
         this.a = 0;
         this.b = 0;
         this.c = 0;
     }

    public int getX1() {
        return (int) ((-1*b + Math.sqrt((-1*b - (4*a*c))))/2*a);
    }

    public int getX2() {
        return (int) ((-1*b - Math.sqrt((-1*b - (4*a*c))))/2*a);
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void setC(int c) {
        this.c = c;
    }
}
