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
import static org.asynchttpclient.Dsl.request;
import static org.hamcrest.CoreMatchers.equalTo;

public class SwaggerAccountStepDefs {

    public static final String BASE_URL = "https://demoqa.com/Account/v1";
    JsonObject createRequest = new JsonObject();
    static String username = "Daliana";
    static String password = "Bla!123@";
    private static Response responseCreateUser;
    private static Response responseAuthorize;
    private static Response responseGenerateToken;
    @Given("I am on the BookStore website")
    public void iAmOnTheBookStoreWebsite() {
        RestAssured.baseURI = BASE_URL + "/User";
        }

    @When("I a user with a specific username and password")
    public void iAUserWithASpecificUsernameAndPassword() {
        createRequest.add("userName", username);
        createRequest.add("password", password);
        System.out.println(createRequest);
        System.out.println(createRequest.toString());
        responseCreateUser = given().body(createRequest.toString()).when().post(RestAssured.baseURI).then().extract().response();
        System.out.println("Response body: " + responseCreateUser.getBody().asString());
        System.out.println("User ID is " + responseCreateUser.jsonPath().get("userID"));
    }

    @Then("The user is added")
    public void theUserIsAdded() {
        int statusCode = responseCreateUser.getStatusCode();
        if (statusCode==200) {
            System.out.println("The user was successfully created");
            Assert.assertNotNull(responseCreateUser.jsonPath().get("userName"));
            Assert.assertEquals("Daliana", responseCreateUser.jsonPath().get("username"));
        }
        if (statusCode==406) {
            System.out.println("The user already exists");
            Assert.assertEquals("User exists!", responseCreateUser.jsonPath().get("message"));
        }
    }

    @When("I authorize and generate token a user with a specific username and password")
    public void iAuthorizeAndGenerateTokenAUserWithASpecificUsernameAndPassword() {
        RestAssured.baseURI = BASE_URL;
        JsonObject request = new JsonObject();
        request.add("userName", username);
        request.add("password", password);
        responseAuthorize = given().header("Content-Type", "application/json").body(request.toString()).
                post(RestAssured.baseURI = BASE_URL + "/Authorized");
        responseGenerateToken = given().header("Content-Type", "application/json").body(request.toString()).
                post(RestAssured.baseURI = BASE_URL + "/GenerateToken");
        System.out.println("Token is " + responseGenerateToken.jsonPath().get("token"));
    }

    @Then("The user is authorized")
    public void theUserIsAuthorized() {
        int status = responseGenerateToken.then().extract().statusCode();
        Assertions.assertEquals(200, status);
        responseGenerateToken.then().body("status", equalTo("Success")).log().all();
    }
}
