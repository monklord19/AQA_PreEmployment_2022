import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:reports/report.html",
                "json:reports/cucumber.json"
        },
        features="src/test/resources/FrontendFeatureFiles/frontend.feature",
        glue="steps"
)
public class TestRunner {
}
