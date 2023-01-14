package Testing.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions( features = "src/test/resources/FeatureFilesMG/",
        glue = {"Testing/StepDefinitions"},
        plugin={"pretty","html:target/HtmlReports"})

public class Runner {
}