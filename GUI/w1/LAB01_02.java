package w1;

public class LAB01_02 {
    public static void main(String[] args) {
		Flyable f[] = {new Bird(), new Virus()};
		Speakable s[] = {new Bird(), new Human()};

        System.out.println(shortest(f));
        System.out.println(loudest(s));
    }

	private static Flyable shortest(Flyable[] f) {
        double min = Double.MAX_VALUE;
        Flyable out = null;
		for (Flyable tmp : f){
		    if (tmp.distance() < min){
		        min = tmp.distance();
		        out = tmp;
            }
        }
		return out;
	}

	private static Speakable loudest(Speakable[] s) {
        double max = 0;
        Speakable out = null;
        for (Speakable tmp : s){
            if (tmp.speak().length() > max){
                max = tmp.speak().length();
                out = tmp;
            }
        }

        return out;
	}


}

interface Flyable{
    public double distance();
    public String drive();
}

interface Speakable{
    public String speak();
}

class Bird implements Flyable, Speakable{

    @Override
    public String speak() {
        return "sth";
    }

    @Override
    public double distance() {
        return 20;
    }

    @Override
    public String drive() {
        return "Wings";
    }

}

class Virus implements Flyable {

    @Override
    public double distance() {
        return 2.5;
    }

    @Override
    public String drive() {
        return "airborne";
    }

}

class Human implements Speakable{

    @Override
    public String speak() {
        return "sth2";
    }
}


