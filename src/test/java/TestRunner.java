import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/featureFiles/"}, glue = {"src/test/java/UITests/stepsDefinitions"}
        //tags = "@RegressionTestsBAP"
)
public class TestRunner {
    @Before
public void setup() {
              System.setProperty("webdriver.chrome.driver", "C:\\Users\\user1\\Desktop\\chromedriver\\chromedriver.exe");
           }

}
