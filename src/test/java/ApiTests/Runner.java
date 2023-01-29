package ApiTests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions( features = "src/test/resources/FeatureFilesMG/Reqres.feature",
        glue={"ApiTests.steps"},
        plugin={"pretty","html:target/HtmlReports"})

public class Runner {
}