package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private static Properties properties;


    public ConfigFileReader(){
        BufferedReader reader;
        String propertyFilePath = "configs//Configuration.properties";
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("config.properties not found at " + propertyFilePath);
        }
    }


    public static String getEmail() {
        String email = properties.getProperty("email");
        if(email != null) return email;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }

    public static String getPassword() {
        String psw = properties.getProperty("psw");
        if(psw != null) return psw;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }

    public static String getIdApple() {
        String idApple = properties.getProperty("idApple");
        if(idApple != null) return idApple;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }

    public static String getFbErrorMsg() {
        String fbErrorMsg = properties.getProperty("fbErrorMsg");
        if(fbErrorMsg != null) return fbErrorMsg;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }

    public static String getGoogleErrorMsg() {
        String googleErrorMsg = properties.getProperty("googleErrorMsg");
        if(googleErrorMsg != null) return googleErrorMsg;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }

    public static String getSpotifyErrorMsg() {
        String spotifyErrorMsg = properties.getProperty("spotifyErrorMsg");
        if(spotifyErrorMsg != null) return spotifyErrorMsg;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }

    public static String getAppleErrorMsg() {
        String appleErrorMsg = properties.getProperty("appleErrorMsg");
        if(appleErrorMsg != null) return appleErrorMsg;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }
}
