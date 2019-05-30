package commands;

import app.LocaleExplore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormatSymbols;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Currency;
import java.util.Locale;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
public class InfoCommand {
    LocaleExplore localeExplore;
    LocalDateTime today;
    DateTimeFormatter formatter;
    DateFormatSymbols symbols;
    String[] dayNames;
    String[] monthNames;
    String days="";
    String months="";
    Currency currency;
    public InfoCommand(LocaleExplore localeExplore) {
        this.localeExplore=localeExplore;
    }

    private void getInfo(){
        today = LocalDateTime.now();
        formatter= DateTimeFormatter
                .ofLocalizedDate(FormatStyle.FULL)
                .withLocale(localeExplore.locale);
        symbols = new DateFormatSymbols(localeExplore.locale);
        dayNames = symbols.getWeekdays();
        monthNames = symbols.getMonths();
        for ( String day: dayNames)
            days += day + " ";
        for(String month: monthNames )
            months+= month+" ";
        currency=Currency.getInstance(localeExplore.locale);
    }

    public void info() {
        System.out.println(localeExplore.message("locale.set", localeExplore.locale.toString()));
        System.out.println(localeExplore.message("info", localeExplore.locale.toString()));
        //Implement this method (see below)
            getInfo();
            JSONObject jsonObject=getJson(localeExplore.locale.toString().split("_")[1]);

        System.out.println("Country: "+ localeExplore.locale.getDisplayCountry(Locale.forLanguageTag("en_US")));
            System.out.println("Language: "+ localeExplore.locale.getDisplayLanguage(Locale.forLanguageTag("en_US")));
            System.out.println("Capital: "+jsonObject.get("capital"));
            System.out.println("Region: "+jsonObject.get("region"));
            System.out.println("Sub region: "+jsonObject.get("subregion"));
            System.out.println("Population: "+jsonObject.get("population"));
            System.out.println("Currency: "+ currency);
            System.out.println("Days of the week: "+days);
            System.out.println("Months of the year: "+months);
            System.out.println("Date: " + today.format(formatter));


    }
    private JSONObject getJson(String countryName){
        JSONObject jsonObject=null;
        try {
            URL url = new URL("https://restcountries.eu/rest/v2/alpha/" + countryName);
            HttpURLConnection con = null;
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            //add request header
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            int responseCode = con.getResponseCode();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            final StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);

            }
            in.close();

            Object obj = new JSONParser().parse(String.valueOf(response));
            jsonObject=(JSONObject)obj;
            return jsonObject;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        finally {
            return jsonObject;
        }
    }

    public void informatii() {
        System.out.println(localeExplore.message("locale.set", localeExplore.locale.toString()));
        System.out.println(localeExplore.message("info", localeExplore.locale.toString()));
        getInfo();
        JSONObject jsonObject=getJson(localeExplore.locale.toString().split("_")[1]);
        Currency currency= Currency.getInstance(localeExplore.locale);
            System.out.println("Tara: "+ localeExplore.locale.getDisplayCountry(Locale.forLanguageTag("ro")));
            System.out.println("Limba: "+ localeExplore.locale.getDisplayLanguage(Locale.forLanguageTag("ro")));
            System.out.println("Capitala: "+jsonObject.get("capital"));
            System.out.println("Regiunea: "+jsonObject.get("region"));
            System.out.println("Sub regiunea: "+jsonObject.get("subregion"));
            System.out.println("Populatie: "+jsonObject.get("population"));
            System.out.println("Valuta: "+ currency);
            System.out.println("Zilele saptamanii: "+days);
            System.out.println("Lunile anului: "+months);
            System.out.println("Data: " + today.format(formatter));

    }
}
