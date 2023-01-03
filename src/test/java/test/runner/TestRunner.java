package test.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = ".//src/test/resources/features/Login.feature",
        glue = "step.definitions",
        dryRun = false,
        plugin = {"pretty", "html:test-output"}
)

public class TestRunner {
}

