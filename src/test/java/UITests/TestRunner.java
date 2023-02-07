package UITests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/FeatureFilesAndreeaC/*.feature"},
        glue = {"src/test/java/UITests/*.java"},
        plugin = "pretty"

)



public class TestRunner {
}
