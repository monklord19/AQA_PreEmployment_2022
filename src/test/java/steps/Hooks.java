package steps;

import demopageobjects.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;

public class Hooks extends BaseClass {

    private final BaseClass baseClass;

    public Hooks(BaseClass baseClass) {
        this.baseClass = baseClass;
    }

    @Before("not @api")
    public void before() {
        baseClass.setDriver();
        baseClass.getDriver().get("https://demoqa.com/");
    }

    @After("not @api")
    public void after() {
        baseClass.getDriver().quit();
    }


}
