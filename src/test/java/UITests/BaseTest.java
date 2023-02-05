package UITests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.io.FileInputStream;
import java.io.IOException;

import java.util.Properties;

public class BaseTest {
    public Properties configProperties;
    private WebDriver driver;
    public WebDriver getDriver(){
        return driver;
    }
    public void setDriver() throws IOException {
        configProperties = new Properties();
        FileInputStream configPropFile = new FileInputStream("src/test/resources/testFiles/config.properties");
        configProperties.load(configPropFile);

        String browser = configProperties.getProperty("browser");
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", configProperties.getProperty("chrome.driver.path"));
            driver = new ChromeDriver();;
        } else if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", configProperties.getProperty("firefox.driver.path"));
            driver = new FirefoxDriver();

        }

    }

    }


