package zad1.langs;

import java.util.ListResourceBundle;

public class pl_en extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][]{
                {"morze", "see"},
                {"jezioro", "lake"},
                {"góry", "mountains"}
        };
    }
}
