package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = ".//src/test/resources/FeatureFiles",
        glue = "StepsDefinitions",
        plugin = {"pretty", "html:test-output"}
)

public class TestRunner {


}

