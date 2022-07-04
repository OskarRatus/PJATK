package zad1;

import java.util.ListResourceBundle;

public class ColNames_en extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][]{
                {"Country", "Country"},
                {"DateFrom", "DateFrom"},
                {"DateTo", "DateTo"},
                {"Place", "Place"},
                {"Price", "Price"},
                {"Currency", "Currency"}
        };
    }
}