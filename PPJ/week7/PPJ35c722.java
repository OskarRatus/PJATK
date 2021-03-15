package week7;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PPJ35c722 {
    public static void main(String[] args) {
        String test = "0101010";

        Pattern pat = Pattern.compile("[01]+");
        Matcher mat = pat.matcher(test);
        System.out.println(mat.matches() ? true : false);





//        for (String s : words){
//            Pattern pat = Pattern.compile(s);
//            Matcher mat = pat.matcher(str);
//            int count =0;
//            while (mat.find()){
//                count++;
//            }
//            System.out.println(s + " - " + count);
//        }
    }
}
