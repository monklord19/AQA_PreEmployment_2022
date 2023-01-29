package ApiTests;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private Properties properties;
    private static ConfigReader configReader;

    //configReader prevents any other class from instantiating
    private ConfigReader() {
        BufferedReader reader;
        String propertyFilePath = "src/test/resources/properties.properties";
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);//reads a property list of key and element pairs from the input character stream in a simple line-oriented format
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("properties.properties not found at " + propertyFilePath);
        }
    }

    public static ConfigReader getInstance() {
        if (configReader == null) {
            configReader = new ConfigReader();
        }
        return configReader;
    }

    public String getBaseUrl() {
        String baseUrl = properties.getProperty("BASE_URL");
        if (baseUrl != null) return baseUrl;
        else throw new RuntimeException("base_Url not specified in the properties.properties file.");
    }

    public String getPage() {
        String page = properties.getProperty("PAGE");
        return page;
    }
    public String getValidId() {
        String validId = properties.getProperty("VALID_ID");
        return validId;
    }
    public String getInvalidId() {
        String invalidId = properties.getProperty("INVALID_ID");
        return invalidId;
    }
    public String getDelay() {
        String delay = properties.getProperty("DELAY");
        return delay;
    }


}

