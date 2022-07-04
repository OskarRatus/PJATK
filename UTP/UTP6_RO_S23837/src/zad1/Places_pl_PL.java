package zad1;

import java.util.ListResourceBundle;

public class Places_pl_PL extends ListResourceBundle {
    @Override
    public Object[][] getContents() {
        return new Object[][] {
                {"morze", "morze"},
                {"góry", "góry"},
                {"jezioro", "jezioro"}
        };
    }
}
