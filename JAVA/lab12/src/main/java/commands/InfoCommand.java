package commands;

import app.LocaleExplore;

import java.text.DateFormatSymbols;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Currency;
import java.util.Locale;

public class InfoCommand {
    LocaleExplore localeExplore;

    public InfoCommand(LocaleExplore localeExplore) {
        this.localeExplore=localeExplore;
    }

    public void info() {
        System.out.println(localeExplore.message("locale.set", localeExplore.locale.toString()));
        System.out.println(localeExplore.message("info", localeExplore.locale.toString()));
        //Implement this method (see below)
        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter
                .ofLocalizedDate(FormatStyle.FULL)
                .withLocale(localeExplore.locale);
        DateFormatSymbols symbols = new DateFormatSymbols(localeExplore.locale);
        String[] dayNames = symbols.getWeekdays();
        String[] monthNames = symbols.getMonths();
        String days="";
        for ( String day: dayNames)
            days += day + " ";
        String months="";
        for(String month: monthNames )
            months+= month+" ";
            Currency currency=Currency.getInstance(localeExplore.locale);
            System.out.println("Country: "+ localeExplore.locale.getDisplayCountry(Locale.forLanguageTag("en_US")));
            System.out.println("Language: "+ localeExplore.locale.getDisplayLanguage(Locale.forLanguageTag("en_US")));
            System.out.println("Currency: "+ currency);
            System.out.println("Days of the week: "+days);
            System.out.println("Months of the year: "+months);
            System.out.println("Date: " + today.format(formatter));


    }
    public void informatii() {
        System.out.println(localeExplore.message("locale.set", localeExplore.locale.toString()));
        System.out.println(localeExplore.message("info", localeExplore.locale.toString()));
        //Implement this method (see below)
        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter
                .ofLocalizedDate(FormatStyle.FULL)
                .withLocale(localeExplore.locale);
        DateFormatSymbols symbols = new DateFormatSymbols(localeExplore.locale);
        String[] dayNames = symbols.getWeekdays();
        String[] monthNames = symbols.getMonths();
        String days="";
        for ( String day: dayNames)
            days += day + " ";
        String months="";
        for(String month: monthNames )
            months+= month+" ";
            Currency currency= Currency.getInstance(localeExplore.locale);
            System.out.println("Tara: "+ localeExplore.locale.getDisplayCountry(Locale.forLanguageTag("ro")));
            System.out.println("Limba: "+ localeExplore.locale.getDisplayLanguage(Locale.forLanguageTag("ro")));
            System.out.println("Valuta: "+ currency);
            System.out.println("Zilele saptamanii: "+days);
            System.out.println("Lunile anului: "+months);
            System.out.println("Data: " + today.format(formatter));

    }
}
