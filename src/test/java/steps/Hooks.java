package steps;

import demoPageObjects.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseClass {

    private final BaseClass baseClass;

    public Hooks(BaseClass baseClass) {
        this.baseClass = baseClass;
    }

    @Before
    public void before() {
        baseClass.setDriver();
        baseClass.getDriver().get("https://demoqa.com/");
    }

    @After
    public void after() {
        baseClass.getDriver().quit();
    }

}
