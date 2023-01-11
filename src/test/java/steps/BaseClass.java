package steps;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseClass {

    static WebDriver driver = new ChromeDriver();

    @Before
    public void openBrowser() {
        driver.manage().window().maximize();
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }


}
