package week7;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PPJ36_c723 {
    public static void main(String[] args) {
        String test = "1010101";

        Pattern pat = Pattern.compile("1|1[01]*1");
        Matcher mat = pat.matcher(test);
        System.out.println(mat.matches());
    }
}
