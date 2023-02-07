package Frontend.Steps;

import Configurations.FrontendConfigs.DriverFactory;
import org.openqa.selenium.WebDriver;

public class TestBase {
    public WebDriver driver = DriverFactory.getDriver();

}

