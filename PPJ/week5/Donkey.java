package week5;

public class Donkey {
    private double mass; // in kg

    public Donkey(double mass){
        this.mass = mass * 1000;
    }

    Balloon[] arr = new Balloon[0];

    public void addBalloon(Balloon var1){
        Balloon[] tempArr = new Balloon[(this.arr.length + 1)];
        for (int i=0; i<arr.length; i++){
            tempArr[i] = arr[i];
        }
        tempArr[tempArr.length-1] = var1;
        arr = tempArr;
    }

    public boolean isFlying(){
        double sum = 0;
        for (int i=0; i<this.arr.length; i++){
            sum = sum + this.arr[i].helVol;
        }
        return sum > mass ? true : false;
    }
}
