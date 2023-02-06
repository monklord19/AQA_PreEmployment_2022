import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/FeatureFiles/SwaggerBookStoreQA.feature",
        glue = "BookSoreApi"
        //tags = "@RegressionTestsBAP"
)
public class TestRunner {

}