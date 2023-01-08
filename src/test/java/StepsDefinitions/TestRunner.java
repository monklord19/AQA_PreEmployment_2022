package StepsDefinitions;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/FeatureFilesAndreeaC/*.feature", "src/test/resources/FeatureFiles/*.feature"},
        glue = {"StepsDefinitions","Pages"}

        //tags = "@RegressionTestsBAP"
)

public class TestRunner {
}
