package week4;

public class Person {
    public String name;
    public String surname;
    public int bDay;

    public Person(){
        name = "Adam";
        surname = "J.";
        bDay = 444;

    }

    public void show(){
        System.out.println("Name \t\t" + name);
        System.out.println("Surname \t" + surname);
        System.out.println("bDay \t\t" + bDay);

    }


}
