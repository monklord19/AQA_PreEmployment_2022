package com.DemoQA;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
        //path of feature file
        features = {"src/test/resources/FeatureFiles"},
        //path of step definition file
        glue = {"src/test/java/com/DemoQA/SeleniumTesting/Steps"},
        plugin = {
                "pretty",
                "html:target/cucumber.html",
                "json:target/cucumber.json"
        }
)
public class TestRunner {
}
