package UITests;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import UITests.BaseTest.*;

import java.io.IOException;

public class HooksDemo extends BaseTest{
    private final BaseTest baseTest;

    public HooksDemo(BaseTest baseTest) {
        this.baseTest = baseTest;
    }

    //@Before
    public void before() throws IOException {
        baseTest.setDriver();
        baseTest.getDriver().get("https://demoqa.com/");
    }

    //@After
    public void after() {
        baseTest.getDriver().quit();
    }

}
