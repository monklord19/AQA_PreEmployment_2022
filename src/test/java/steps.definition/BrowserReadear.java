package steps.definition;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BrowserReadear {

    public Properties configProperties;
    public WebDriver driver;

    public BrowserReadear() throws IOException {
        // reads config.properties
        configProperties = new Properties();
        FileInputStream configPropFile = new FileInputStream("/Users/pitiriciuiulian/Documents/preemployment/AQA_PreEmployment_2022/src/main/config.properties");
        configProperties.load(configPropFile);

        String browser = configProperties.getProperty("browser");
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", configProperties.getProperty("chromepath"));
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", configProperties.getProperty("firefoxpath"));
            driver = new FirefoxDriver();
        }

    }
}