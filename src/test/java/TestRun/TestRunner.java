package TestRun;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/BDD_Features/demoQAFeatures.feature"}
        //tags = "@RegressionTestsBAP"
)
public class TestRunner {
}