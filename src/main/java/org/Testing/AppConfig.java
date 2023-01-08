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
    private static String edgeDriverPath=properties.getProperty("edge.driver.path");
    private static String siteUrl = properties.getProperty("site.url");

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
}

