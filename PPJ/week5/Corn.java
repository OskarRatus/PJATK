package week5;

public class Corn {
    private int cornCount;

    public Corn(int x){
        this.cornCount = x;
    }

    public Popcorn[] makePopcorn(){
        Popcorn[] arr1 = new Popcorn[(int)(Math.random()*cornCount)];
        for (int i=0; i<arr1.length; i++, cornCount--){
            arr1[i] = new Popcorn();
        }
        return arr1;
    }
}
