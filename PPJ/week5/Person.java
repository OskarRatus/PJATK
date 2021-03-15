package week5;

public class Person {
    private String name;
    private int birthYear;

    public Person(String name, int birthYear){
        this.birthYear = birthYear;
        this.name = name;

    }

    public Person(String name){
        this.name = name;
        this.birthYear = 1990;

    }

    public void getName(){
        System.out.println(this.name);
    }

    public int getAge(){
        return (2020 - this.birthYear);
    }

    public static Person getOlder(Person var1, Person var2){
        if (var1.getAge() < var2.getAge()) {
            return var2;
        } else {
            return var1;
        }
    }

    public static Person getOldest(Person[] var1){
        Person tempPrsn = var1[0];
        for (int i=1; i< var1.length; i++){
            if (tempPrsn.getAge() < var1[i].getAge())
                tempPrsn = var1[i];
        }

        return tempPrsn;
    }




}
