import Initial.InitialClass;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/BackendFeature"}
        //tags = "@RegressionTestsBAP"
)

public class TestRunnerAPI {
}