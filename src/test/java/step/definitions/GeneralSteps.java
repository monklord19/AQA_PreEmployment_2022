package step.definitions;

import io.cucumber.java.After;

public class GeneralSteps extends BaseClass {

    public GeneralSteps(TestContext context) {
        this.driver = context.driver;
    }

    @After
    public void close_browser() {
        super.close_browser();
    }
}
