import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/FeatureFiles/"},
        glue = {"Testing/StepDefinitions"},
        plugin = {"pretty", "html:target/HtmlReports"})

public class TestRunner {
}
