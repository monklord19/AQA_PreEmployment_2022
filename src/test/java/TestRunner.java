import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/FeatureFiles/Proiect.feature"},
        tags = "@WebTablesEditCierra"
        //tags = "@CheckRadioButton"



)
public class TestRunner {
}
