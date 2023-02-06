package utils;

import org.openqa.selenium.WebDriver;

public class BaseClass {
    public WebDriver driver;

    public void tearDown() {
        driver.close();
        driver.quit();

    }
}
