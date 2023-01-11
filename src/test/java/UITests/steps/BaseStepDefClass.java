package UITests.steps;
import org.openqa.selenium.WebDriver;


public class BaseStepDefClass  {
    public WebDriver driver;

    protected void close_browser() {
        driver.close();
        //driver.quit();
        driver = null;

    }

}
