package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;

public class PPJ36_c72 {
    public static void main(String[] args) {
        Person p1 = new Person();
        System.out.println(p1);

    }
}

class MyInput{
    private InputStream is;
    private StringBuffer sb;

    BufferedReader br;

//    public MyInput(){
//        this.is = System.in;
//        this.sb = new StringBuffer();
//        this.br = new BufferedReader();
//
//    }

    public MyInput(){
        this.is = System.in;
        this.sb = new StringBuffer();

    }

    public String getString(){
        int data;

        while(true){
            try {
                while (((data = is.read()) != -1)){
                    sb.append((char) data);
                    //if(sb.charAt(sb.length()) == '\n'){
                    //if(sb.toString().endsWith("\n")){
                    if(data == '\n'){
                        String tmp = sb.toString().trim();
                        sb.delete(0, sb.length());
                        return tmp;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";

        }
    }
}

class Person{
    private String name;
    private String surname;
    private int year;
    private boolean sex;
    private short postCode;

    public Person(){
        MyInput in = new MyInput();
        System.out.println("podaj name ");
        this.name = in.getString();
        System.out.println("podaj surname ");
        this.surname = in.getString();
        System.out.println("podaj year ");
        this.year = Integer.parseInt(in.getString());
        System.out.println("podaj sex ");
        this.sex = in.getString().startsWith("m") ? true : false;
        System.out.println("podaj postCode ");
        this.postCode = Short.parseShort(in.getString());

    }

//    public Person(){
//        InputStream is = System.in;
//        try {
//            int val = is.read();
//            while (val != 97){ // DODAC ENTER
//                this.name += (char) val;
//                val = is.read();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", year=" + year +
                ", sex=" + sex +
                ", postCode=" + postCode +
                '}';
    }
}

class WrongDataException extends Exception{
    public WrongDataException(){
        super("Podano niewlasciwy rodzaj pola");
    }
}
