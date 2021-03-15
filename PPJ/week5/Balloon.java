package week5;

public class Balloon {
    double helVol;


    public Balloon(){
        helVol = (Math.random()*4d) / 1000 + 0.005d;

    }

    public double getLoad(){
        return this.helVol/0.007d * 6d; // in grams
    }
}
