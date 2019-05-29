package app;

import commands.SetLocaleCommand;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.*;

public class LocaleExplore {
    public final String baseName = "res/Messages";
    public final String baseName2 = "res/Commands";
    public Locale locale;
    public ResourceBundle resourceBundle;
    public ResourceBundle resourceBundle2;

    public String message(String key, String ... arguments) {
        String pattern = resourceBundle.getString(key);
        String message = new MessageFormat(pattern).format(arguments);
        return message;
    }

    public String message2(String key, String ... arguments) {
        String pattern = resourceBundle2.getString(key);
        String message = new MessageFormat(pattern).format(arguments);
        return message;
    }
    public void run() {
        SetLocaleCommand setLocaleCommand= new SetLocaleCommand(this);
        setLocaleCommand.set("en-US");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(message("prompt"));
                String command = scanner.nextLine();
                if (command.equals("exit")) break;
                String[] params = command.trim().split("\\s+");
                if (params[0].equals(message2("set-locale.command"))) {
                    Class setClass = Class.forName(message2("set-locale.impl"));
                    Method set = setClass.getMethod(message2("set-locale.command"), String.class);
                    Object setObj = setClass.getDeclaredConstructor(this.getClass()).newInstance(this);
                    set.invoke(setObj, params[1]);
                } else if (params[0].equals(message2("info.command"))) {
                    Class infoClass = Class.forName(message2("info.impl"));
                    Method info = infoClass.getMethod(message2("info.command"));
                    Object infoObj = infoClass.getDeclaredConstructor(this.getClass()).newInstance(this);
                    info.invoke(infoObj);
                } else if (params[0].equals(message2("locale.command"))) {
                    Class localeClass = Class.forName(message2("locale.impl"));
                    Method locale = localeClass.getMethod(message2("locale.command"));
                    Object localeObj = localeClass.getDeclaredConstructor(this.getClass()).newInstance(this);
                    locale.invoke(localeObj);
                } else
                    System.out.println(message("invalid"));
            }catch (Exception e )
            {
                e.printStackTrace();
            }

        }
    }

    public static void main(String args[]){
        new LocaleExplore().run();
    }
}
