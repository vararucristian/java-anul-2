package commands;

import app.LocaleExplore;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class LocaleCommand {
    LocaleExplore localeExplore;

    public LocaleCommand(LocaleExplore localeExplore) {
        this.localeExplore=localeExplore;
    }
    public void locale() {
        System.out.println(localeExplore.message("locales"));
        Locale currentLocale = Locale.getDefault();
        System.out.println(currentLocale);
        String[]langs = Locale.getISOLanguages();
        for(String lang:langs)
        {
            String baseName = "res/Messages_"+lang;
            Locale language = Locale.forLanguageTag(lang);
            try {
                ResourceBundle resourceBundle = ResourceBundle.getBundle(baseName, language);
                if(resourceBundle!=null)
                {
                    System.out.println(lang);
                }
            }catch(MissingResourceException e) {};
        }
    }
    public void localizari() {
        System.out.println(localeExplore.message("locales"));
        Locale currentLocale = Locale.getDefault();
        System.out.println(currentLocale);
        String[]langs = Locale.getISOLanguages();
        for(String lang:langs)
        {
            String baseName = "res/Messages_"+lang;
            Locale language = Locale.forLanguageTag(lang);
            try {
                ResourceBundle resourceBundle = ResourceBundle.getBundle(baseName, language);
                if(resourceBundle!=null)
                {
                    System.out.println(lang);
                }
            }catch(MissingResourceException e) {};
        }
    }
}
