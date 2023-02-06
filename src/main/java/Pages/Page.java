package Pages;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Page {
    WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

}
