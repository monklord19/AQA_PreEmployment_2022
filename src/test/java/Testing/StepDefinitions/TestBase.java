package Testing.StepDefinitions;

import org.Testing.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class TestBase {
    public WebDriver driver = DriverFactory.getDriver();
    public void assertErrorMessage(Object expected,Object actual){
        Assert.assertEquals(expected,actual);
    }

}