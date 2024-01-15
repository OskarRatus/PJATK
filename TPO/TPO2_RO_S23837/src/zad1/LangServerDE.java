package zad1;

import java.util.Locale;
import java.util.ResourceBundle;

public class LangServerDE extends LangServer{
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("zad1.langs.pl", new Locale("de"));

    public String getTranslation(String s) {
        return resourceBundle.getString(s);
    }
}
