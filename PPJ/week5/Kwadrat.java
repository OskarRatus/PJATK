package week5;

public class Kwadrat {
    private int bok;

    public Kwadrat(int x ){
        this.bok = x;
    }

    public double getVolume(){
        return bok*bok*bok;
    }

    public int getSide(){ return this.bok; }

    @Override
    public String toString() {
        return "Kwadrat{" +
                "pole powierzchni= " + (bok*bok) +
                ", objetosc= " + (bok*bok*bok) +
                '}';
    }
}
