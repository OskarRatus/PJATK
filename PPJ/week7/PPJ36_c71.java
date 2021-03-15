package week7;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PPJ36_c71 {
    public static void main(String[] args) {
        // Zadanie 1
        {
            try {
                FileReader fr = new FileReader("C:\\Users\\oskar\\OneDrive - Szkoła Główna Handlowa w Warszawie\\Dokumenty\\_PJATK\\PPJ\\pjatkJava\\src\\week6\\PPJ35_c61.java");
                int data = fr.read();
                String str = new String();
//                StringBuffer str = new StringBuffer();  //TODO
                while(data != -1){
                    str += (char) data;
                    data = fr.read();
                }
                //System.out.println(str);

                String[] words = { "abstract", "assert", "boolean",
                        "break", "byte", "case", "catch", "char", "class", "const",
                        "continue", "default", "do", "double", "else", "extends", "false",
                        "final", "finally", "float", "for", "goto", "if", "implements",
                        "import", "instanceof", "int", "interface", "long", "native",
                        "new", "null", "package", "private", "protected", "public",
                        "return", "short", "static", "strictfp", "super", "switch",
                        "synchronized", "this", "throw", "throws", "transient", "true",
                        "try", "void", "volatile", "while"
                };
                for (String s : words){
                    Pattern pat = Pattern.compile(s);
                    Matcher mat = pat.matcher(str);
                    int count =0;
                    while (mat.find()){
                        count++;
                    }
                    System.out.println(s + " - " + count);
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

        // Zadanie 2
        {
//            DebitCard dc = new DebitCard();
//            CreditCard cc = new CreditCard();
//
//            Account test = new Account(1000d, 200d, 100d, dc, cc);
//            dc.pay(1000);

        }

        // Zadanie 3
        {

        }


    }
}

class File{
    protected String name;
    protected int pages;
    protected String txt;

    public File(String name, int pages, String txt){
        this.name = name;
        this.pages = pages;
        this.txt = txt;
    }

    public  void show(){
        System.out.println("Czy masz dostep?");
    }
}

class SecretFile extends File{

    public SecretFile(String name, int pages, String txt) {
        super(name, pages, txt);
    }

//    @Override
//    public void show() {
//        for (String s : ){
//
//        }
//    }
}

class TopSecretFiles extends File{

    public TopSecretFiles(String name, int pages, String txt) {
        super(name, pages, txt);
    }
}

//===================================================

class Account{
    private double balance;
    private double dailyDebit;
    private double credit;

    private DebitCard dc;
    private CreditCard cc;

    public Account(double balance, double dailyDebit, double credit, DebitCard dc, CreditCard cc){
        this.balance = balance;
        this.dailyDebit = dailyDebit;
        this.credit = credit;
        this.dc = dc;
        this.cc = cc;
    }

    public DebitCard getDc(){
        if (dc == null)
            dc = new DebitCard(this);
        return dc;
    }
    public CreditCard getCc(){

        return cc;
    }

    private double withdrawSum;

    public void withdraw(double val){
        if (val + withdrawSum < dailyDebit)
            //throw new NotEnoughFund(dailyDebit - (val + withdrawSum));
            balance -= val;
    }


}

class DebitCard {

    Account account;

    public DebitCard(Account account){
        this.account = account;
    }

    public void withdraw(double val){
        this.account.withdraw(val);
    }

}

class CreditCard {

}

class NotEnoughFund extends Exception{
    public NotEnoughFund(double val){
        super("not enugh funds");
    }
}