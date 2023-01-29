import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/FeatureFiles/Postman.feature"}
        //tags = "@LoginUsingSpotifyAcc"
        //tags = "@LoginUsingAppleAcc"
        //tags = "@LoginUsingFbAcc"
        //tags = "@LumaAddToCartBag"
)
public class TestRunner {
}
