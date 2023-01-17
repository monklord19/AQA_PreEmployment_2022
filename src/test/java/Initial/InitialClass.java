package Initial;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class InitialClass {
    WebDriver driver;

    @BeforeMethod
    public void setupApplication(){
        Reporter.log("Browser is open", true);
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void closeAplication(){
        driver.quit();
        Reporter.log("Browser is close", true);

   }
}
