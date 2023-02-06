package StepDefinitions;

import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;

public class SwaggerAccountStepDefs {

    public static final String BASE_URL = "https://demoqa.com/Account/v1";
    JsonObject createRequest = new JsonObject();
    private static Response response;
    @Given("I am on the reqres website")
    public void iAmOnTheReqresWebsite() {
        RestAssured.baseURI = BASE_URL + "/User";
        }

    @When("I a user with a specific username and password")
    public void iAUserWithASpecificUsernameAndPassword() {
        createRequest.add("userName", "Daliana");
        createRequest.add("password", "Bla!123@");
        System.out.println(createRequest);
        System.out.println(createRequest.toString());
        response = given().body(createRequest.toString()).when().post(RestAssured.baseURI).then().extract().response();
        System.out.println("Response body: " + response.getBody().asString());
    }

    @Then("The user is added")
    public void theUserIsAdded() {
        int statusCode = response.getStatusCode();
        if (statusCode==200) {
            System.out.println("The user was successfully created");
            Assert.assertNotNull(response.jsonPath().get("Daliana"));
            Assert.assertEquals("Daliana", response.jsonPath().get("username"));
        }
        if (statusCode==406) {
            System.out.println("The user already exists");
            Assert.assertEquals("User exists!", response.jsonPath().get("message"));
        }
    }
}
