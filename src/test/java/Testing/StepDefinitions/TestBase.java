package Testing.StepDefinitions;

import org.Testing.DriverFactory;
import org.openqa.selenium.WebDriver;

public class TestBase {
    public WebDriver driver = DriverFactory.getDriver();
}