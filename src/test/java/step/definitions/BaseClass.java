package step.definitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

    public WebDriver driver;
    public WebDriverWait wait;

    protected void close_browser() {
            driver.close();
            driver.quit();
            driver = null;


    }
}
