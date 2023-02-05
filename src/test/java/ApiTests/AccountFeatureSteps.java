package ApiTests;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.requestSpecification;

public class AccountFeatureSteps {

    public static String baseUrl = "https://demoqa.com/swagger/#/";

    @Given("User is on DemoQA Swagger")
    public void userIsOnDemoQASwagger() {
        String endpoint = baseUrl;

    }

    @When("User send a post req for new user with username: adelin and password: moldovan")
    public void userSendAPostReqForNewUserWithUsernameAndPassword(String username, String password) {
        String body = """
                {
                  "userName": "%s",
                  "password": "%s"
                }
                """.formatted(username, password);
    }

    @Then("the respone status code is {int}")
    public void theResponeStatusCodeIs(int arg0) {
    }
}
