package week5;

public class Walec {
    private int promień;
    private int wysokość;

    public Walec(int r, int h){
        this.promień = r;
        this.wysokość = h;
    }

    public double getArea(){
        double area = (double) (2*Math.PI*promień*promień);
        return area;
    }

    public double getVolume(){
        double vol = (double) (this.getArea() * wysokość);
        return vol;
    }

    public int getPromień(){
        return this.promień;
    }

    public int getWysokość(){
        return this.wysokość;
    }

    @Override
    public String toString() {
        return "Walec{" +
                "pole powierzchni podstawy= " + this.getArea() +
                ", objetosc walca=" + this.getVolume() +
                '}';
    }
}
