package zad1.langs;

import java.util.ListResourceBundle;

public class pl_de extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][]{
                {"morze", "Meer"},
                {"jezioro", "See"},
                {"góry", "Berge"}
        };
    }
}
