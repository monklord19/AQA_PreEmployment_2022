package Frontend.Steps;

import Configurations.FrontendConfigs.FrontendPropertiesReader;
import io.cucumber.java.en.Given;

public class CommonSteps extends TestBase{
    @Given("I am on demoQa url")
    public void iAmOnDemoQaUrl() {
        driver.get(FrontendPropertiesReader.getBase_url());
    }
}

