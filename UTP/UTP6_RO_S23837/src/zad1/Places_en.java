package zad1;

import java.util.ListResourceBundle;

public class Places_en extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][] {
                {"morze", "sea"},
                {"jezioro", "lake"},
                {"góry", "mountains"}
        };
    }
}
