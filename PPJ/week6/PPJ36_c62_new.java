package week6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PPJ36_c62_new {
    public static void main(String[] args) {
        // TREE
        {
            System.out.println("============================== TREE");
            NeedleTree sosna = new NeedleTree(true,123, "test", 12.2, 12);
            NeedleTree modrzewiec = new NeedleTree(false,100, "test2", 12.2, 12);
            LeafTree dab = new LeafTree(false, 130, "cos tam", 1);
            LeafTree osika = new LeafTree(false, 90, "cos tam2", 2);
            FruitTree morelowiec = new FruitTree(false, 50, "inna wartosc", 3, "morela");
            FruitTree sliwa = new FruitTree(false, 40, "inna wartosc2", 4, "sliwka");

            Tree[] forest = {sosna, modrzewiec, dab, osika, morelowiec, sliwa};

            for (Tree obj : forest)
                System.out.println(obj); // metoda .toString jest tutaj wywoływana automatycznie

            for (Tree obj : forest) {
                try {
                    obj.pickFruit();
                } catch (NoFruitTreeException e) {
                    e.printStackTrace();
                }
            }
        }

        // ALARM
        {
            System.out.println("============================== ALARM");
            SmokeDetector test = new SmokeDetector();
            try {
                test.check();
            } catch (Alarm alarm) {
                alarm.printStackTrace();
            }
        }

        // RAKIETA
        {
            System.out.println("============================== RAKIETA");
            Rocket roc = new Rocket("Falcon");
            roc.tank();

            try {
                roc.start();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        // TXT READ
        {
            System.out.println("============================== TXT READ");

            int[] tab = new int[255];
            try {
                FileInputStream fis = new FileInputStream("C:\\Users\\oskar\\OneDrive\\Dokumenty\\_PJATK\\PPJ\\pjatkJava\\src\\week6\\test.txt"); // może byc blad z brakiem pliku
                int val;
                while ((val = fis.read()) != -1)
                    tab[val]++;
//                    System.out.print((char)val);
//                System.out.println();
                fis.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            for (int i=0;i< tab.length;i++)
                if (tab[i] > 0)
                    System.out.println((char) i + " " + tab[i]);

        }

    }

}



class Rocket{
    protected String name;
    protected int fuelWeight;

    public Rocket(String name){
        this.name = name;
        this.fuelWeight = 0;
    }

    public void tank(){
        this.fuelWeight = (int) (Math.random()*100);
    }

    public void start() throws Exception {
        if (this.fuelWeight > 1000)
            System.out.println("Rozpoczato proc statowa");
        else
            throw new Exception("Start anulowany - za malo paliwa");

    }

}

//==============================

class SmokeDetector {
    boolean isSmoke;
    public void check() throws Alarm {
        if (isSmoke)
            throw new Alarm();
    }
}


class Alarm extends Exception{
    public Alarm(){
        super("Wykryto alarm");
    }
}


//==============================
class NoFruitTreeException extends Exception{
    public NoFruitTreeException(){
        super("to drzewo nie ma owoców");
    }
}

class FruitTree
        extends LeafTree{

    protected String fruitName;

    public FruitTree(boolean alwaysGreen, int height, String sectionTree, int leafShape, String fruitName) {
        super(alwaysGreen, height, sectionTree, leafShape);
        this.fruitName = fruitName;
    }

    @Override
    public String toString() {
        return "FruitTree{" +
                " alwaysGreen=" + alwaysGreen +
                ", height=" + height +
                ", sectionTree='" + sectionTree +
                ", fruitName='" + fruitName + '\'' +
                ", leafShape=" + leafShape +'\'' +
                '}';
    }

    public void pickFruit(){
        System.out.println("Zerwano: "+ fruitName);

    }
}

class LeafTree
        extends Tree{

    protected int leafShape;

    public LeafTree(boolean alwaysGreen, int height, String sectionTree, int leafShape) {
        super(alwaysGreen, height, sectionTree);
        this.leafShape = leafShape;
    }

    @Override
    public String toString() {
        return "LeafTree{" +
                " alwaysGreen=" + alwaysGreen +
                ", height=" + height +
                ", sectionTree='" + sectionTree +
                ", leafShape=" + leafShape +'\'' +
                '}';
    }
}

class NeedleTree
        extends Tree{

    protected int     qanNeedles;
    protected double  lenCone;

    public NeedleTree(boolean alwaysGreen, int height, String sectionTree, double lenCone, int qanNeedles) {
        super(alwaysGreen, height, sectionTree);
        this.lenCone = lenCone;
        this.qanNeedles = qanNeedles;
    }

    @Override
    public String toString() {
        return "NeedleTree{" +
                " alwaysGreen=" + alwaysGreen +
                ", height=" + height +
                ", sectionTree='" + sectionTree +
                ", qanNeedles=" + qanNeedles +
                ", lenCone=" + lenCone +'\'' +
                '}';
    }
}

class Tree{
    protected boolean alwaysGreen;
    protected int height;
    protected String sectionTree;

    public Tree(boolean alwaysGreen, int height, String sectionTree){
        this.alwaysGreen = alwaysGreen;
        this.height = height;
        this.sectionTree = sectionTree;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "alwaysGreen=" + alwaysGreen +
                ", height=" + height +
                ", sectionTree='" + sectionTree + '\'' +
                '}';
    }

    public void pickFruit() throws NoFruitTreeException {
        throw new NoFruitTreeException();
    }
}