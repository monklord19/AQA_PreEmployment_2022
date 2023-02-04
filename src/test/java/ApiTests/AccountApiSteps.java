package ApiTests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class AccountApiSteps {

    public static final String BASE_URI = "https://demoqa.com/";
    public static final String BASE_PATH_ACCOUNT_V1 = "/Account/v1/";
    private static String userID;
    private static String token;
    public ValidatableResponse response;

    @Given("set base URI and PATH account")
    public static void setup() {
        RestAssured.baseURI = BASE_URI;
        RestAssured.basePath = BASE_PATH_ACCOUNT_V1;
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
                .post("/User")
                .then()
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
                .post("/GenerateToken")
                .then()
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
                .post("/Authorized")
                .then()
                .log()
                .body();
    }

    @When("send a GET request for account details for userID")
    public void sendGETRequestAccountDetails() {
        response = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .when()
                .get("/User/{userID}", userID)
                .then()
                .log()
                .body();
    }

    @When("send a DELETE request for userID")
    public void sendDELETEUserID() {
        response = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .when()
                .delete("/User/{userID}", userID)
                .then()
                .log()
                .body();

    }
}
