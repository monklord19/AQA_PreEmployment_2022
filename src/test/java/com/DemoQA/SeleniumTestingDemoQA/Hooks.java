package com.DemoQA.SeleniumTestingDemoQA;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import com.DemoQA.BaseClass;

public class Hooks extends BaseClass {

    WebDriver driver;

    @Before
    public void setup(){

        initializeDriver();
    }


    @After
    public void close() {
        closeDriver();
    }
}
