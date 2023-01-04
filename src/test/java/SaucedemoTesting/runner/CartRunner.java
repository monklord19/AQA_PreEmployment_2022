package SaucedemoTesting.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions( features = "src/test/resources/FeatureFilesMG/CartDemo.feature",
        glue = {"SaucedemoTesting/StepDefinitions"},
        plugin={"pretty","html:target/HtmlReports"}
)

public class CartRunner {
}