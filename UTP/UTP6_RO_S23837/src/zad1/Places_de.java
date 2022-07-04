package zad1;

import java.util.ListResourceBundle;

public class Places_de extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][]{
                {"morze", "Meer"},
                {"jezioro", "See"},
                {"góry", "Berge"}
        };
    }
}
