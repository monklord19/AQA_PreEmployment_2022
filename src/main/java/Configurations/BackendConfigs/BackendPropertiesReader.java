package Configurations.BackendConfigs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BackendPropertiesReader {
    private Properties properties;
    private static BackendPropertiesReader configReader;

    private BackendPropertiesReader() {
        BufferedReader reader;
        String filePath = "src/main/resources/BackendProperties.properties";
        try {
            reader = new BufferedReader(new FileReader(filePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("BackendProperties.properties not found at " + filePath);
        }
    }

    public static BackendPropertiesReader getInstance() {
        if (configReader == null) {
            configReader = new BackendPropertiesReader();
        }
        return configReader;
    }

    public String getBaseUrl() {
        String baseUrl = properties.getProperty("BASE_URL");
        if (baseUrl != null) return baseUrl;
        else throw new RuntimeException("Base url not specified in the properties.properties file.");
    }
    public String getUserName(){
        String userName= properties.getProperty("UserName");
        if (userName!=null) return userName;
        else throw new RuntimeException("userName not specified in .properties file");
    }
    public String getPassword(){
        String password=properties.getProperty("Password");
        if(password!=null) return password;
        else throw new RuntimeException("Password not specified in .properties file");
    }

}

