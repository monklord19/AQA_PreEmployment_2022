package Frontend;

import Configurations.FrontendConfigs.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public void setup() {
        String browser = System.getProperty("browser", "chrome");
        DriverFactory.initWebDriver(browser);
    }

    @After
    public void tearDown() {
        DriverFactory.getDriver().quit();
    }
}
