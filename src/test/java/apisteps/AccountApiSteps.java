package apisteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;

import java.util.ArrayList;

import static org.hamcrest.Matchers.*;

public class AccountApiSteps {

    public static String userID;
    public static String token;
    public static ArrayList userBookList;
    public static ValidatableResponse response;

    @Given("set BASE URI")
    public void setBaseURI() {
        RestAssured.baseURI = "https://demoqa.com/";
    }

    @When("send a POST request for registration of new user with username: {string} and password: {string}")
    public void sendPOSTRegistration(String username, String password) {
        String body = """
                {
                  "userName": "%s",
                  "password": "%s"
                }
                """.formatted(username, password);
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/Account/v1/User")
                .then()
                .statusCode(201)
                .log()
                .body();
        userID = response.extract().path("userID").toString();
    }

    @Then("status code is {int}")
    public void userReceivesStatusCode(int statusCode) {
        response.statusCode(statusCode);
    }

    @When("send POST request to generate token for user with username: {string} and password: {string}")
    public void send_POST_generate_token(String username, String password) {
        String body = """
                {
                  "userName": "%s",
                  "password": "%s"
                }
                """.formatted(username, password);
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/Account/v1/GenerateToken")
                .then()
                .statusCode(200)
                .log()
                .body();
        token = response.extract().path("token").toString();
    }

    @When("send a POST request for confirmation of authorization with username: {string} and password: {string}")
    public void sendPOSTAuthorization(String username, String password) {
        String body = """
                {
                  "userName": "%s",
                  "password": "%s"
                }
                """.formatted(username, password);
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/Account/v1/Authorized")
                .then()
                .statusCode(200)
                .log()
                .body();
    }
    @Then("response contains: {string}")
    public void responseContainsTrue(String confirmation) {
        response.assertThat().body(containsString(confirmation));
    }
    @When("send a GET request for account details for userID")
    public void sendGETRequestAccountDetails() {
        response = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .when()
                .get("/Account/v1/User/{userID}", userID)
                .then()
                .log()
                .body();
        userBookList = response.extract().path("books.isbn");
    }

    @When("send a DELETE request for userID")
    public void sendDELETEUserID() {
        response = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .when()
                .delete("/Account/v1/User/{userID}", userID)
                .then()
                .statusCode(204)
                .log()
                .body();

    }

    @And("response body contains path: {string}, value: {string}")
    public void responseBodyContainsUsername(String path, String value) {
        response.assertThat().body(path, equalTo(value));
    }


}
