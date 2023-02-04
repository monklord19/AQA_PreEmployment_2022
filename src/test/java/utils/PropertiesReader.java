package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    private Properties properties;

    public PropertiesReader() {
        BufferedReader reader;
        String properties_file_path = "config.properties";
        try {
            properties = new Properties();
            reader = new BufferedReader(new FileReader(properties_file_path));
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getBrowser() {
        String browser = properties.getProperty("browser");
        if (browser != null) {
            return browser;
        } else {
            // default browser
            return "chrome";
        }

    }
}
