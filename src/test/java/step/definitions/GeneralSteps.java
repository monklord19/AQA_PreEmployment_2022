package step.definitions;

import io.cucumber.java.After;

public class GeneralSteps extends BaseClass {

    public GeneralSteps(TestContext context) {
        this.driver = context.driver;
    }

    @After
    public void closeBrowser() {
        super.close_browser();
    }
}
