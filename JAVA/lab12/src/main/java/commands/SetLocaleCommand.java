package commands;

import app.LocaleExplore;

import java.util.Locale;
import java.util.ResourceBundle;

public class SetLocaleCommand {
    LocaleExplore localeExplore;

    public SetLocaleCommand(LocaleExplore localeExplore) {
        this.localeExplore=localeExplore;
    }

    public void set(String languageTag) {
        localeExplore.locale = Locale.forLanguageTag(languageTag);
        localeExplore.resourceBundle = ResourceBundle.getBundle(localeExplore.baseName, localeExplore.locale);
        localeExplore.resourceBundle2 = ResourceBundle.getBundle(localeExplore.baseName2, localeExplore.locale);
        System.out.println(localeExplore.message("locale.set", languageTag));
    }
    public void seteaza(String languageTag) {
        localeExplore.locale = Locale.forLanguageTag(languageTag);
        localeExplore.resourceBundle = ResourceBundle.getBundle(localeExplore.baseName, localeExplore.locale);
        localeExplore.resourceBundle2 = ResourceBundle.getBundle(localeExplore.baseName2, localeExplore.locale);
        System.out.println(localeExplore.message("locale.set", languageTag));
    }
}
