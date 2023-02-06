package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.codec.binary.Base64;
import org.junit.jupiter.api.Assertions;

public class BookStoreAPIStepDef {

    private static String token;
    private static Response response;

    @Given("User is on Demoqa Swagger website")
    public void userIsOnDemoqaSwaggerWebsite() {
        RestAssured.baseURI = "https://demoqa.com";
    }

    @When("User enters username and password for the post request")
    public void userEntersUsernameAndPasswordForThePostRequest() {
        RequestSpecification httpRequest = RestAssured.given();
        String payload = """
                {
                          "userName":"FrancescaU",
                          "password":"Password123!"
                          }
                      """;
        httpRequest.header("Content-Type", "application/json")
                    .header("accept", "application/json");
        response =  httpRequest.body(payload).post("/Account/v1/User");
    }

    @Then("User is created")
    public void userIsCreated() {
        String responseBodyForCreatedUser = response.getBody().asString();
        response.prettyPrint();
        Assertions.assertEquals(201, response.getStatusCode());
        Assertions.assertTrue(responseBodyForCreatedUser.contains("FrancescaU"));
    }

    @When("User enters username and password to generate token")
    public void userEntersUsernameAndPasswordToGenerateToken() {
        RequestSpecification request = RestAssured.given();
        String payload = """
                {
                    "userName": "FrancescaU",
                    "password": "Password123!"
                }""";
        request.header("Content-Type", "application/json");
        response = request.body(payload).post("/Account/v1/GenerateToken");
    }

    @Then("Token is generated")
    public void tokenIsGenerated() {
        String jsonString = response.getBody().asString();
        response.prettyPrint();
        token = JsonPath.from(jsonString).get("token");
        String responseBody = response.getBody().asString();
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertTrue(responseBody.contains("User authorized successfully."));
    }

    @When("User enters username and password to verify authorization")
    public void userEntersUsernameAndPasswordToVerifyAuthorization() {
        RequestSpecification request = RestAssured.given();
        String payload = """
                {
                    "userName": "FrancescaU",
                    "password": "Password123!"
                }""";
        request.header("Content-Type", "application/json");
        response = request.body(payload).post("/Account/v1/Authorized");
    }

    @Then("Authorization status is displayed")
    public void authorizationStatusIsDisplayed() {
        response.prettyPrint();
        Assertions.assertEquals(200, response.getStatusCode());
        String responseBody = response.getBody().asString();
        Assertions.assertTrue(responseBody.contains("true"));
    }

    @When("User sends GET request for all books")
    public void userSendsGETRequestForAllBooks() {
        RequestSpecification request = RestAssured.given();
        response = request.get("/BookStore/v1/Books");
    }

    @Then("Collection of books is displayed")
    public void collectionOfBooksIsDisplayed() {
        response.prettyPrint();
        Assertions.assertEquals(200, response.getStatusCode());
        String responseBody = response.getBody().asString();
        Assertions.assertTrue(responseBody.contains("Git Pocket Guide"));
    }

    @When("User enters userId and two isbn for the post request")
    public void userEntersUserIdAndTwoIsbnForThePostRequest() {
        RequestSpecification request = RestAssured.given();
        String payload = """
                  {
                      "userName": "FrancescaU",
                      "password": "Password123!"
                  }""";

        request.header("Content-Type", "application/json");
        Response responseFromGenerateToken = request.body(payload).post("/Account/v1/GenerateToken");

        responseFromGenerateToken.prettyPrint();
        String jsonString = responseFromGenerateToken.getBody().asString();
        String tokenGenerated = JsonPath.from(jsonString).get("token");
        request.header("Authorization", "Bearer "+tokenGenerated)
                .header("Content-Type", "application/json");
        String bookIsbns = """
                  {
                    "userId": "38edb9ed-d642-4b17-a2c0-34b48f954956",
                    "collectionOfIsbns": [
                      {
                        "isbn": "9781449325862",
                        "isbn": "9781449331818"
                      }
                    ]
                  }""";
        response = request.body(bookIsbns).post("/BookStore/v1/Books");
    }

    @Then("Created books are displayed")
    public void createdBooksAreDisplayed() {
        response.prettyPrint();
        Assertions.assertEquals(201, response.getStatusCode());
        String addedBooksResponse = response.getBody().asString();
        Assertions.assertTrue(addedBooksResponse.contains("9781449331818"));
    }

    @When("User sends GET request for single book")
    public void userSendsGETRequestForSingleBook() {
        RequestSpecification request = RestAssured.given();
        response = request.get("/BookStore/v1/Book?ISBN=9781449325862");
    }

    @Then("Requested book is displayed")
    public void requestedBookIsDisplayed() {
        response.prettyPrint();
        Assertions.assertEquals(200, response.getStatusCode());
        String responseBody = response.getBody().asString();
        Assertions.assertTrue(responseBody.contains("Git Pocket Guide"));
    }

    @When("User sends PUT request to update a book")
    public void userSendsPUTRequestToUpdateABook() {
        RequestSpecification request = RestAssured.given();
        String credentials = "FrancescaU:Password123!";
        byte[] encodedCredentials =  Base64.encodeBase64(credentials.getBytes());
        String encodedCredentialsAsString = new String(encodedCredentials);
        request.header("Authorization","Basic "+encodedCredentialsAsString)
                .header("Content-Type", "application/json");
        String replacementDetails = """
                {
                  "userId": "38edb9ed-d642-4b17-a2c0-34b48f954956",
                  "isbn": "9781449331818"
                }""";
        response = request.body(replacementDetails).put("/BookStore/v1/Books/9781449331818");
    }

    @Then("Book is updated")
    public void bookIsUpdated() {
        response.prettyPrint();
        Assertions.assertEquals(200, response.getStatusCode());
        String updatedBooksResponse = response.getBody().asString();
        Assertions.assertTrue(updatedBooksResponse.contains("9781449331818"));
    }

    @When("User sends DELETE request to delete a book")
    public void userSendsDELETERequestToDeleteABook() {
        RequestSpecification request = RestAssured.given();
        String removedBookDetails = """
                {
                  "isbn": "9781449331818",
                  "userId": "38edb9ed-d642-4b17-a2c0-34b48f954956"
                }""";
        String credentials = "FrancescaU:Password123!";
        byte[] encodedCredentials =  Base64.encodeBase64(credentials.getBytes());
        String encodedCredentialsAsString = new String(encodedCredentials);
        request.header("Authorization","Basic "+encodedCredentialsAsString)
                .header("Content-Type", "application/json");
        response = request.body(removedBookDetails).delete("/BookStore/v1/Book");
    }

    @Then("Book is deleted")
    public void bookIsDeleted() {
        Assertions.assertEquals(204, response.getStatusCode());
    }

    @When("User sends DELETE request to delete all books")
    public void userSendsDELETERequestToDeleteAllBooks() {
        RequestSpecification request = RestAssured.given();
        String credentials = "FrancescaU:Password123!";
        byte[] encodedCredentials =  Base64.encodeBase64(credentials.getBytes());
        String encodedCredentialsAsString = new String(encodedCredentials);
        request.header("Authorization","Basic "+encodedCredentialsAsString)
                .header("Content-Type", "application/json");
        response = request.delete("/BookStore/v1/Books?UserId=38edb9ed-d642-4b17-a2c0-34b48f954956");
    }

    @Then("All books are deleted")
    public void allBooksAreDeleted() {
        Assertions.assertEquals(204, response.getStatusCode());
    }

}
