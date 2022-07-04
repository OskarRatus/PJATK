package zad1;

import java.util.ListResourceBundle;

public class ColNames_de extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][]{
                {"Country", "Land"},
                {"DateFrom", "Datum von"},
                {"DateTo", "Datum bis"},
                {"Place", "Ort"},
                {"Price", "Preis"},
                {"Currency", "Währung"}
        };
    }
}
