package week4;

public class MethodCurrier {
    public static void setValue(int x){
        System.out.println("Out int");
    }

    public static void setValue(float x){
        System.out.println("Out float");

    }

    public void setValue(Number num){
        num.showValue();
        num.setValue(42);
        num.showValue();
    }
}
