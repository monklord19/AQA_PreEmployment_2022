package SaucedemoTesting.StepDefinitions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.SaucedemoTesting.DriverFactory;

public class TestBase {

    public WebDriver driver = DriverFactory.getDriver();

    // useful when running tests in Firefox
    protected void waitForPageToLoad(long timeout) {
        long waited = 0;
        long pauseMillis = 500;
        do {
            try {
                Thread.sleep(pauseMillis);
            } catch (InterruptedException e) {
                System.out.println("Wait process interrupted.");
            }
            waited += pauseMillis;
        }
        while (waited <= timeout && !((JavascriptExecutor) driver)
                .executeScript("return document.readyState")
                .equals("complete"));
    }

}