import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import pages.LoginPage;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/Features/"},
        tags = "@ValidLogin",
        glue = {"steps"}
)
public class TestRunner {
}
