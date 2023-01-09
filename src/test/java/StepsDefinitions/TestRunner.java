package StepsDefinitions;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/FeatureFiles/*.feature"},
        glue = {"src/test/java/StepsDefinitions"},
        tags = "@LoginwithGoogle or @LoginwithSpotify or @LoginwithApple"

        //tags = "@RegressionTestsBAP"
)

public class TestRunner {
}
