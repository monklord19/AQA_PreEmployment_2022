package com.BookStoreAPITesting;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class APITestingDemoQA {

    private static final String USER_ID = "63ed010e-277d-49aa-a9e2-49aac451c678";
    private static final String USERNAME = "Calina Maniu";
    private static final String PASSWORD = "CMcm123*";
    private static final String BASE_URL = "https://demoqa.com";
    private static final String ISBN = "9781449331818";

    private static String token;
    private static Response response;
    private static String jsonString;
    private static String bookId;
    private static String isbn;

// Background for Scenarios no. 2 to no. 10 - User is an Authorized user

    @Given("User is an authorized user")
    public void userIsAnAuthorizedUser() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();

        request.header("Content-Type", "application/json");
        response = request.body("{ \"userName\":\"" + USERNAME + "\", \"password\":\"" + PASSWORD + "\"}")
                .post("/Account/v1/GenerateToken");

        String jsonString = response.asString();
        token = JsonPath.from(jsonString).get("token");
    }


// Scenario No. 1 - Create a new user - POST/Account/User

    @Given("User is on demoQA website")
    public void userIsOnDemoQAWebsite() {
        RestAssured.baseURI ="https://demoqa.com";
    }

    @When("User creates a new user using the POST method")
    public void userCreatesANewUserUsingThePOSTMethod() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();

        request.header("Content-Type", "application/json");
        response = request.body("{ \"userName\":\"" + USERNAME + "\", \"password\":\"" + PASSWORD + "\"}")
                .post("/Account/v1/User");
        Response response = request.get("/Account/v1/User");
        ResponseBody body = response.getBody();
        System.out.println("Response Body is: " + body.asString());

        int statusCode = response.getStatusCode();
        Assert.assertEquals(200, statusCode);
        System.out.println("Status Code is: " + response.getStatusLine());
    }

    @And("Status Response is {int}")
    public void statusResponseIs(int arg0) {
        int statusCode = response.getStatusCode();
        Assert.assertEquals(200, statusCode);
        System.out.println("Status Code is: " + response.getStatusCode());
    }


// Scenario No. 2 - Generate Token - POST/Account/Generate Token

    @When("User generates token")
    public void UserGeneratesToken() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();

        request.header("Content-Type", "application/json");
        response = request.body("{ \"userName\":\"" + USERNAME + "\", \"password\":\"" + PASSWORD + "\"}")
                .post("/Account/v1/GenerateToken");

        String jsonString = response.asString();
        token = JsonPath.from(jsonString).get("token");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(200, statusCode);
        System.out.println("Status Code is: " + response.getStatusLine());
    }

    @Then("Token is generated successfully")
    public void tokenIsGeneratedSuccessfully() {
        int statusCode = response.getStatusCode();
        Assert.assertEquals(200, statusCode);
        System.out.println("Status Code is: " + response.getStatusLine());
        System.out.println("Generated Token is: " + token);
    }


// Scenario No. 3 - Authorize User - POST/Account/Authorized

    @When("User makes a POST method for authorization")
    public void userMakesAPOSTMethodForAuthorization() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();

        request.header("Content-Type", "application/json");
        response = request.body("{ \"userName\":\"" + USERNAME + "\", \"password\":\"" + PASSWORD + "\"}")
                .post("/Account/v1/Authorized");

        Response response = request.get("Account/v1/Authorized");
        ResponseBody body = response.getBody();
        System.out.println("Response Body is: " + body.asString());
    }

    @And("Status Response will be {int}")
    public void statusResponseWillBe(int arg0) {
        int statusCode = response.getStatusCode();
        Assert.assertEquals(200, statusCode);
        System.out.println("Status Code is: " + response.getStatusLine());
    }

    @And("Response header will be displayed")
    public void responseHeaderWillBeDisplayed() {
        String connection = response.header("connection");
        System.out.println("Connection is: " + connection);
        Assert.assertEquals("keep-alive",connection);

        String contentLength = response.header("content-length");
        System.out.println("Content-length is: " + contentLength);
        Assert.assertEquals("4", contentLength);

        String serverType = response.header("Server");
        System.out.println("Server value: " + serverType);
        Assert.assertEquals("nginx/1.17.10 (Ubuntu)",serverType);
    }


//Scenario No. 4 - Delete User - DELETE/Account/User

    @When("User deletes a user")
    public void userDeletesAUser() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();

        request.header("Content-Type", "application/json");
        response = request.body("{ \"userId\":\"" + USER_ID + "\"}")
                .delete("/Account//AccountV1UserByUserIdDelete");

        Response response = request.delete("/Account/AccountV1UserByUserIdDelete");
    }

    @Then("User is successfully deleted")
    public void userIsSuccessfullyDeleted(int arg0) {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        response = request.body("{ \"userName\":\"" + USERNAME + "\", \"password\":\"" + PASSWORD + "\"}")
                .delete("/Account/AccountV1UserByUserIdDelete");

        Response response = request.delete("/Account/AccountV1UserByUserIdDelete");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(200, statusCode);
        System.out.println("Status Code is: " + response.getStatusLine());
    }



// Scenario No. 5 - Get Book - GET/Account/User

    @When("User executes a GET request")
    public void userExecutesAGETRequest() {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        response = request.body("{ \"userId\":\"" + USER_ID + "\"}")
                .get("/Account/AccountV1UserByUserIdGet");

        Response response = request.get("/Account/Account/AccountV1UserByUserIdGet");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(200, statusCode);
        System.out.println("Status Code is: " + response.getStatusLine());
        ResponseBody body = response.body();
        System.out.println("Response Body is: " + body.asString());
    }

    @Then("Status response will be successful")
    public void statusResponseWillBeSuccessful() {
        int statusCode = response.getStatusCode();
        Assert.assertEquals(200, statusCode);
        System.out.println("Status Code is: " + response.getStatusLine());

        String contentType = response.header("contentType");
        System.out.println("Connection is: " + contentType);
        Assert.assertEquals("application/json; charset=utf-8",contentType);

        String contentLength = response.header("content-length");
        System.out.println("Content-length is: " + contentLength);
        Assert.assertEquals("4514", contentLength);
    }


// Scenario No. 6 - Get the list of available books - GET/BookStore/Books

    @When("User executes a GET request to get the list of available books")
    public void userExecutesAGETRequestToGetTheListOfAvailableBooks() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        Response response = request.get("/BookStore/v1/Books");
    }

    @Then("The list with all the available book will be displayed")
    public void theListWithAllTheAvailableBookWillBeDisplayed() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        Response response = request.get("/BookStore/v1/Books");
        System.out.println("All the available books: " + response.prettyPrint());
    }

    @And("Status will be {int}")
    public void statusWillBe(int arg0) {
        int statusCode = response.getStatusCode();
        System.out.println("Status received: " + response.getStatusLine());
        Assert.assertEquals(200, statusCode);
    }

    @And("The call will have a response header")
    public void theCallWillHaveAResponseHeader() {
        String contentLength = response.header("content-length");
        System.out.println("Content-length is: " + contentLength);
        Assert.assertEquals("278", contentLength);
    }


// Scenario No. 7 - Add a book to my list - POST/BookStore/Books

    @When("User executes a POST request to add a new book")
    public void userExecutesAPOSTRequestToAddANewBook() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");

        response = request.body("{ \"userId\": \"" + USER_ID + "\", " +
                        "\"collectionOfIsbns\": [ { \"isbn\": \"" + ISBN + "\" } ]}")
                .post("/BookStore/v1/Books");

        Response response = request.get("/BookStore/v1/Books");
        ResponseBody body = response.getBody();

        System.out.println("Response Body is: " + body.asString());

        int statusCode = response.getStatusCode();
        System.out.println("Status response is: " + response.getStatusLine());
        Assert.assertEquals( "HTTP/1.1 200 OK", response.getStatusLine());
    }

    @Then("The new book will be added and Response will be {int}")
    public void theNewBookWillBeAddedAndResponseWillBe(int arg0) {
        int statusCode = response.getStatusCode();
        System.out.println("Status response is: " + response.getStatusLine());
        Assert.assertEquals( "HTTP/1.1 200 OK", response.getStatusLine());
    }



// Scenario No. 8 - Delete a book - DELETE/BookStore/Books

    @When("User executes a DELETE request to delete a book")
    public void userExecutesADELETERequestToDELETEABook() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();

        request.header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");

        response = request.body("{ \"userId\": \"" + USER_ID + "\"}")
                .delete("/BookStore/v1/Book");
    }

    @Then("The book is successfully deleted")
    public void theBookIsSuccessfullyDeleted() {
        Assert.assertEquals(200, response.getStatusCode());

        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();

        request.header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");

        response = request.get("/Account/v1/User/" + USER_ID);
        Assert.assertEquals(200, response.getStatusCode());

        jsonString = response.asString();
        List<Map<String, String>> booksOfUser = JsonPath.from(jsonString).get("books");
        Assert.assertEquals(0, booksOfUser.size());

    }


// Scenario No. 9 - Get details about a particular book - GET/BookStore/Books

    @When("User executes a GET request to get details about a particular book")
    public void userExecutesAGETRequestToGetDetailsAboutAParticularBook() {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        response = request.body("{ \"isbn\":\"" + ISBN + "\"}")
                .get("/Account/AccountV1UserByUserIdGet");

        Response response = request.get("/Account/Account/AccountV1UserByUserIdGet");
        ResponseBody body = response.getBody();
        String bodyAsString = body.asString();
        System.out.println("Response Body is: " + body.asString());

        int statusCode = response.getStatusCode();
        Assert.assertEquals(200, statusCode);

    }

    @Then("The details are displayed")
    public void theDetailsAreDisplayed() {
        int statusCode = response.getStatusCode();
        Assert.assertEquals(200, statusCode);
        System.out.println("Status Code is: " + response.getStatusCode());

    }


// Scenario No. 10 - Replace a book - PUT/BookStore/Books

    @When("User executes a PUT request to update a particular book")
    public void userExecutesAPUTRequestToUpdateAParticularBook() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");

        response = request.body("{ \"userId\": \"" + USER_ID + "\", " +
                        "\"collectionOfIsbns\": [ { \"isbn\": \"" + ISBN + "\" } ]}")
                .put("/BookStore/v1/Books");

        Response response = request.get("/BookStore/v1/Books");
        ResponseBody body = response.getBody();

        System.out.println("Response Body is: " + body.asString());

        int statusCode = response.getStatusCode();
        System.out.println("Status response is: " + response.getStatusLine());
        Assert.assertEquals( "HTTP/1.1 200 OK", response.getStatusLine());
    }

    @Then("The book is successfully updated")
    public void theBookIsSuccessfullyUpdated() {
        System.out.println("Status response is: " + response.getStatusLine());
    }


}

