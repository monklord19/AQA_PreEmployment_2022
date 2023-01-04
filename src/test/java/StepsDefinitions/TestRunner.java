package StepsDefinitions;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/FeatureFilesAndreeaC/Login.feature", "src/test/resources/FeatureFilesAndreeaC/AddCart.feature"}


        //tags = "@RegressionTestsBAP"
)
public class TestRunner {
}
