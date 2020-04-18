package matrixHub.utils;

import java.io.*;
import java.util.Properties;

public class ConfigTranslate {

    public static String get(String nameStr) {
        String out = "TRANSLATE_ERROR";
        FileInputStream fileInputStream;
        Properties prop = new Properties();
        try {
            fileInputStream = new FileInputStream("config/mods/MatrixHub/bundles/"+Config.get("language")+".properties");
            prop.load(fileInputStream);
            if (prop.getProperty(nameStr) != null) {
                out = prop.getProperty(nameStr);
                out = new String(out.getBytes("ISO-8859-1"), "UTF-8");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out;
    }

}
