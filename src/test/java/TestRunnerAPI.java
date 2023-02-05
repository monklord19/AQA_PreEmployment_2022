import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:reports/api_report.html",
                "json:reports/api_cucumber.json"
        },
        features="src/test/resources/BackendFeatureFiles",
        glue="apisteps"
)
public class TestRunnerAPI {
}
