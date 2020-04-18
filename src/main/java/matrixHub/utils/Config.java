package matrixHub.utils;

import arc.util.Log;

import java.io.*;
import java.util.Properties;

public class Config {

    public static void main() {

        // Создаём папку если не существует
        final File dir1 = new File("config/mods/MatrixHub");
        if (!dir1.exists()) {
            dir1.mkdir();
        }

        final File dir2 = new File("config/mods/MatrixHub/bundles");
        if (!dir2.exists()) {
            dir2.mkdir();
        }

        File file1 = new File("config/mods/MatrixHub/config.properties");
        if (!file1.exists()) {
            Log.warn("The config file was successfully generated.");
            Log.warn("Don't forget to change the token in the config.");

            try (InputStream in = Config.class
                    .getClassLoader()
                    .getResourceAsStream("config.properties");
                 OutputStream out = new FileOutputStream("config/mods/MatrixHub/config.properties")) {
                int data;
                while ((data = in.read()) != -1) {
                    out.write(data);
                }
            } catch (IOException exc) {
                exc.printStackTrace();
            }
        }

        File file2 = new File("config/mods/MatrixHub/bundles/ru_RU.properties");
        if(!file2.exists()) {
            try (InputStream in = Config.class
                    .getClassLoader()
                    .getResourceAsStream("bundles/ru_RU.properties");
                 OutputStream out = new FileOutputStream("config/mods/MatrixHub/bundles/ru_RU.properties")) {
                int data;
                while ((data = in.read()) != -1) {
                    out.write(data);
                }
            } catch (IOException exc) {
                exc.printStackTrace();
            }
        }

        File file4 = new File("config/mods/MatrixHub/bundles/en_US.properties");
        if(!file4.exists()) {
            try (InputStream in = Config.class
                    .getClassLoader()
                    .getResourceAsStream("bundles/en_US.properties");
                 OutputStream out = new FileOutputStream("config/mods/MatrixHub/bundles/en_US.properties")) {
                int data;
                while ((data = in.read()) != -1) {
                    out.write(data);
                }
            } catch (IOException exc) {
                exc.printStackTrace();
            }
        }

        File file5 = new File("config/maps/Hub.msav");
        if(!file5.exists()) {
            try (InputStream in = Config.class
                    .getClassLoader()
                    .getResourceAsStream("Hub.msav");
                 OutputStream out = new FileOutputStream("config/maps/Hub.msav")) {
                int data;
                while ((data = in.read()) != -1) {
                    out.write(data);
                }
            } catch (IOException exc) {
                exc.printStackTrace();
            }
        }

    }

    public static String get(String nameStr) {
        String out = "CONFIG_ERROR";
        FileInputStream fileInputStream;
        Properties prop = new Properties();
        try {
            fileInputStream = new FileInputStream("config/mods/MatrixHub/config.properties");
            prop.load(fileInputStream);
            out = prop.getProperty(nameStr);
            out = new String(out.getBytes("ISO-8859-1"), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out;
    }
}
