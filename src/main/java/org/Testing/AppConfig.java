package org.Testing;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfig {
    private static Properties properties = new Properties();

    static {
        InputStream inputStream = org.Testing.AppConfig.class.getClassLoader().getResourceAsStream("configuration.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            System.out.println("Failed to load properties");
            ;
        }
    }

    private static String chromeDriverPath = properties.getProperty("chrome.driver.path");
    private static String geckoDriverPath = properties.getProperty("gecko.driver.path");
    private static String internetExplorerDriverPath = properties.getProperty("ie.driver.path");
    private static String edgeDriverPath = properties.getProperty("edge.driver.path");
    private static String siteUrl = properties.getProperty("site.url");
    private static String email = properties.getProperty("EMAIL");
    private static String password = properties.getProperty("PASSWORD");
    private static String appleId = properties.getProperty("APPLE_ID");
    private static String errorFacebook = properties.getProperty("ERROR_FACEBOOK");
    private static String errorGoogle = properties.getProperty("ERROR_GOOGLE");
    private static String errorSpotify = properties.getProperty("ERROR_SPOTIFY");
    private static String errorApple = properties.getProperty("ERROR_APPLE");


    public static String getChromeDriverPath() {
        return chromeDriverPath;
    }

    public static String getGeckoDriverPath() {
        return geckoDriverPath;
    }

    public static String getInternetExplorerDriverPath() {
        return internetExplorerDriverPath;
    }

    public static String getEdgeDriverPath() {
        return edgeDriverPath;
    }

    public static String getSiteUrl() {
        return siteUrl;
    }

    public static String getEmail() {
        return email;
    }

    public static String getPassword() {
        return password;
    }

    public static String getAppleId() {
        return appleId;
    }

    public static String getErrorFacebook() {
        return errorFacebook;
    }

    public static String getErrorGoogle() {
        return errorGoogle;
    }

    public static String getErrorSpotify() {
        return errorSpotify;
    }

    public static String getErrorApple() {
        return errorApple;
    }
}



