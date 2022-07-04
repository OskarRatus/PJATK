package zad1;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class Trip {
    private Locale defaultLocale = new Locale("pl_PL");
    private SimpleDateFormat dateFormat;

    private Locale locale;
    private String cntryName;
    private Date dateStart;
    private Date dateEnd;
    private String place;
    private double price;
    private String currency;

    public Trip(String[] inputString) {


        //set local formatting for dates and numbers
        this.locale = Locale.forLanguageTag(inputString[0].replace('_','-'));
        ResourceBundle resourceBundle = ResourceBundle.getBundle("zad1.Places", locale);
        NumberFormat nf = NumberFormat.getInstance(locale);
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        //localize Country
        for (Locale l : Locale.getAvailableLocales()) {
            if (l.getDisplayCountry(locale).equals(inputString[1])){
                this.cntryName = l.getDisplayCountry(defaultLocale);
                break;
            }
        }



        //localize Dates
        try {
            this.dateStart = dateFormat.parse(inputString[2]);
            this.dateEnd = dateFormat.parse(inputString[3]);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //localize Place
        for (String label : Arrays.asList("jezioro", "góry", "morze")) {
            if (inputString[4].equals(resourceBundle.getString(label))){
                this.place = label;
                break;
            }
        }

        try {
            this.price = nf.parse(inputString[5]).doubleValue();
        } catch (ParseException e) {
            System.out.println("Blad w parsowaniu price: " + e.getMessage());
        }

        //currency in ISO format
        this.currency = inputString[6];

        this.locale=defaultLocale;

    }


    public String makeLocal(String locDestination, String date){
        Locale localeTo = Locale.forLanguageTag(locDestination.replace("_","-"));
        NumberFormat nf = NumberFormat.getInstance(localeTo);
        dateFormat = new SimpleDateFormat(date);
        String cntryLocalized = "";
        String placeLocalized = "";

        for (Locale l : Locale.getAvailableLocales()) {
            if (l.getDisplayCountry(defaultLocale).equals(cntryName)){
                cntryLocalized = l.getDisplayCountry(localeTo);
                break;
            }
        }

        ResourceBundle resourceBundle = ResourceBundle.getBundle("zad1.Places", localeTo);
        placeLocalized = resourceBundle.getString(place);

//TODO ma być spacja a nie tab
        String strOut = cntryLocalized + "\t"
                + dateFormat.format(dateStart) + "\t"
                + dateFormat.format(dateEnd) + "\t"
                + placeLocalized + "\t"
                + nf.format(price) + "\t"
                + currency;
        return strOut;
    }


    @Override
    public String toString() {
        return cntryName +
                " " + dateStart +
                " " + dateEnd +
                " " + place +
                " " + price +
                " " + currency;
    }


    public Locale getLocale() {
        return locale;
    }

    public String getCntryName() {
        return cntryName;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public String getPlace() {
        return place;
    }

    public double getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }
}
