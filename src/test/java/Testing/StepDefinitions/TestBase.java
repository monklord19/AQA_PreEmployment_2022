package Testing.StepDefinitions;

import Testing.Locators.SpotifyLocators;
import org.Testing.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestBase  {
    public WebDriver driver = DriverFactory.getDriver();
    public void assertErrorMessage(Object expected,Object actual){
        Assert.assertEquals(expected,actual);
    }

}