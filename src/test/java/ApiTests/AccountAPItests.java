package ApiTests;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountAPItests {
    private Response response;
    public String username = "AndreeaAio";
    public String password = "AmericaExpress67743";

    @Before
    public void setup() {
        RestAssured.baseURI = "https://demoqa.com/";
    }

    @Given("A payload for creating a new user")
    public void givenPayload() {
        String payload = "{\"username\":\"password\"}";
        response = RestAssured.given()
                .contentType("application/json")
                .body(payload)
                .post("/swagger/#/");
    }

    @When("The POST request for creating a user is sent")
    public void whenPostRequestSent() {
        // The request has already been sent in the previous step
    }

    @Then("The response status code is 201")
    public void thenResponseStatusCode() {
        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);
    }

    @Then("The response body contains the new user's information")
    public void thenResponseBodyContainsUserInfo() {
        String body = response.getBody().asString();
        assertTrue(body.contains("testuser"));
        assertTrue(body.contains("teshadhgdgh"));
    }


}
