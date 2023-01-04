package SaucedemoTesting.StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.SaucedemoTesting.DriverFactory;

public class Hooks {
    @Before
    public void setup() {
        String browser=System.getProperty("browser","chrome");
        DriverFactory.initWebDriver(browser);

    }
    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver())
                    .getScreenshotAs(OutputType.BYTES);

            scenario.attach( screenshot,"image/png","My screenshot");
        }
        DriverFactory.getDriver().quit();
    }
}
