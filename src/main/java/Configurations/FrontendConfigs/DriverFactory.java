package Configurations.FrontendConfigs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {
   private static WebDriver driver;
    public static WebDriver initWebDriver(String browser){
        switch (browser) {
            default:
                System.out.println("Using default browser: Chrome");
            case "chrome":
                System.setProperty("webdriver.chrome.driver", FrontendPropertiesReader.getChromeDriverPath());
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver",FrontendPropertiesReader.getGeckoDriverPath() );
                driver = new FirefoxDriver();
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", FrontendPropertiesReader.getEdgeDriverPath());

        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }
    public static WebDriver getDriver() {
        return driver;
    }
}








