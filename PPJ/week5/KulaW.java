package week5;

public class KulaW {
    int r;

    public KulaW(Kwadrat sq){
        r = sq.getSide();

    }

    public KulaW(Walec cyl){
        r = cyl.getPromień()*2 < cyl.getWysokość() ? cyl.getPromień() : cyl.getWysokość()/2;

    }

    public double getVol(){
        return 4/3 * Math.PI * r * r * r;
    }

    @Override
    public String toString() {
        return "KulaW{" +
                "r=" + r +
                '}';
    }
}
