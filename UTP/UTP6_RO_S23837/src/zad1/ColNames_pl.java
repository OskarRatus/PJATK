package zad1;

import java.util.ListResourceBundle;

public class ColNames_pl extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][]{
                {"Country", "Państwo"},
                {"DateFrom", "DataOd"},
                {"DateTo", "DataDo"},
                {"Place", "Miejsce"},
                {"Price", "Cena"},
                {"Currency", "Waluta"}
        };
    }
}
