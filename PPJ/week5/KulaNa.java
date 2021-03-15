package week5;

public class KulaNa {
    double r;

    public KulaNa(Kwadrat sq){
        r = sq.getSide() * Math.sqrt(3) / 2;

    }

    public KulaNa(Walec cyl){
        r = Math.pow(cyl.getWysokość(), 2) + Math.pow(cyl.getPromień() * 2, 2);
        r = Math.sqrt(r) / 2;
    }

    @Override
    public String toString() {
        return "KulaNa{" +
                "r=" + r +
                '}';
    }
}
