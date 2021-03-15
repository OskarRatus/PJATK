package week4;

public class Cplx {
    private double re;
    private double im;

    public Cplx(double re, double im){
        this.re = re;
        this.im = im;
    }

    public void add(Cplx num){
        this.re += num.re;
        this.im += num.im;
    }

    public void sub(Cplx num){
        this.re -= num.re;
        this.im -= num.im;
    }

    public void mul(Cplx num){
        double tempRe;
        double tempIm;
        tempRe = this.re * num.re - this.im * num.im;
        tempIm = this.re * num.im + this.im * num.re;

        this.re = tempRe;
        this.im = tempIm;

    }

    public void inc(){
        this.re++;
    }

    public void show(){
        if (this.im >= 0)
            System.out.println((int)this.re + " + " + (int)this.im + "i");
        else
            System.out.println((int)this.re + " + (" + (int)this.im + ")i");
    }


}
