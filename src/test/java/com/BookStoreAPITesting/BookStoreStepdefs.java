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
import org.json.simple.JSONObject;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class BookStoreStepdefs {

    private static final String USER_ID = "63ed010e-277d-49aa-a9e2-49aac451c678";
    private static final String USERNAME = "Calina Maniu";
    private static final String PASSWORD = "CMcm123*";
    private static final String BASE_URL = "https://demoqa.com";
    private static final String ISBN = "9781593277574";

    private static String token;
    private static Response response;
    private static String jsonString;
    private static String bookId;

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

// Scenario No. 1 - Account - POST new user

    @Given("User is on demoQA website")
    public void userIsOnDemoQAWebsite() {
        RestAssured.baseURI ="https://demoqa.com";
    }


    @When("User creates a new user")
    public void userCreatesANewUser() {
        RequestSpecification request = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("userName", "Calina Maniu");
        requestParams.put("password", "CMcm123*");
        request.body(requestParams.toJSONString());
        Response response = request.post("Account/v1/User");
        ResponseBody body = response.getBody();
    }


    @Then("Registration is successful")
    public void registrationIsSuccessful() {
        RequestSpecification request = RestAssured.given();
        Response response = request.post("Account/v1/User");
        ResponseBody body = response.getBody();
        String bodyAsString = body.asString();
        System.out.println("Response body is: " + body.asString());
    }


    @And("Status Response is {int}")
    public void statusResponseIs(int arg0) {
        RequestSpecification request = RestAssured.given();
        Response response = request.post("Account/v1/User");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(200, statusCode);
        System.out.println("Status Code is: " + response.getStatusLine());
    }


// Scenario No. 2 - Account - Generate Token

    @When("Authorized user generates token")
    public void authorizedUserGeneratesToken() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();

        request.header("Content-Type", "application/json");
        response = request.body("{ \"userName\":\"" + USERNAME + "\", \"password\":\"" + PASSWORD + "\"}")
                .post("/Account/v1/GenerateToken");

        String jsonString = response.asString();
        token = JsonPath.from(jsonString).get("token");

    }

    @Then("Token is generated successfully")
    public void tokenIsGeneratedSuccessfully() {
        System.out.println("Generated Token is: " + token);

    }

    @And("Status Response equals {int}")
    public void statusResponseEquals(int arg0) {
        RequestSpecification request = RestAssured.given();
        Response response = request.post("Account/v1/GenerateToken");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(200, statusCode);
        System.out.println("Status Code is: " + response.getStatusLine());

    }

// Scenario No. 3 - Account - Authorize
    @When("User makes a POST method for authorization")
    public void userMakesAPOSTMethodForAuthorization() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();

        request.header("Content-Type", "application/json");
        response = request.body("{ \"userName\":\"" + USERNAME + "\", \"password\":\"" + PASSWORD + "\"}")
                .post("/Account/v1/Authorized");

        Response response = request.post("Account/v1/Authorized");
    }


    @And("Status Response will be {int}")
    public void statusResponseWillBe(int arg0) {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        response = request.body("{ \"userName\":\"" + USERNAME + "\", \"password\":\"" + PASSWORD + "\"}")
                .post("/Account/v1/Authorized");

        Response response = request.post("Account/v1/Authorized");
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


// Scenario No. 4 - Account - Delete

    @When("User deletes a user")
    public void userDeletesAUser() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();

        request.header("Content-Type", "application/json");
        response = request.body("{ \"userId\":\"" + USER_ID + "\"}")
                .delete("/Account//AccountV1UserByUserIdDelete");

        Response response = request.delete("/Account/AccountV1UserByUserIdDelete");
    }

    @Then("User is successfully deleted with status {int}")
    public void userIsSuccessfullyDeletedWithStatus(int arg0) {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        response = request.body("{ \"userName\":\"" + USERNAME + "\", \"password\":\"" + PASSWORD + "\"}")
                .delete("/Account/AccountV1UserByUserIdDelete");

        Response response = request.delete("/Account/AccountV1UserByUserIdDelete");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(200, statusCode);
        System.out.println("Status Code is: " + response.getStatusLine());
    }
        @And("Response header will appear")
        public void responseHeaderWillAppear() {

        }


// Scenario No. 5 - Account - Get

    @When("User executes a GET request")
    public void userExecutesAGETRequest() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();

        request.header("Content-Type", "application/json");
        response = request.body("{ \"userName\":\"" + USERNAME + "\", \"password\":\"" + PASSWORD + "\"}")
                .post("/Account/v1/GenerateToken");

        String jsonString = response.asString();
        token = JsonPath.from(jsonString).get("token");



        request.header("Content-Type", "application/json");
        response = request.body("{ \"userId\":\"" + USER_ID + "\"}")
                .get("/Account/AccountV1UserByUserIdGet");

        Response response = request.get("/Account/AccountV1UserByUserIdDelete");

    }

    @Then("Status response will be successful")
    public void statusResponseWillBeSuccessful() {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        response = request.body("{ \"userName\":\"" + USERNAME + "\", \"password\":\"" + PASSWORD + "\"}")
                .get("/Account/AccountV1UserByUserIdGet");

        Response response = request.get("/Account/A/Account/AccountV1UserByUserIdGet");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(200, statusCode);
        System.out.println("Status Code is: " + response.getStatusLine());
        ResponseBody body = response.body();
        System.out.println("Response Body is: " + body.asString());
    }


// Scenario No. 6 - BookStore - Get

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


// Scenario No. 7 - BookStore - Post

    @When("User executes a POST request to add a new list")
    public void userExecutesAPOSTRequestToAddANewList() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("userId", "TQ123");
        requestParams.put("isbn", "9781449325862");

        request.header("Content-Type", "application/json");
        request.body(requestParams.toJSONString());

        Response response = request.post("BookStore/v1/Books");
        System.out.println("The status received: " + response.statusLine());
    }

    @Then("The new list will be added")
    public void theNewListWillBeAdded() {
    }

    @And("Status response will be {int}")
    public void ResponseWillBe(int arg0) {
    }


    @And("Response will be {int}")
    public void responseWillBe(int arg0) {
    }


// Scenario No. 8 - BookStore - Delete

    @When("User executes a DELETE request to delete a book")
    public void userExecutesADELETERequestToDELETEABook() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();

        request.header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");

        response = request.body("{ \"isbn\": \"" + bookId + "\", \"userId\": \"" + USER_ID + "\"}")
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
    }


// Scenario No. 9 - BookStore - GET

    @When("User executes a GET request to get details about a particular book")
    public void userExecutesAGETRequestToGetDetailsAboutAParticularBook() {
        RestAssured.baseURI= "https://bookstore.toolsqa.com/BookStore/v1";
        RequestSpecification httpRequest = RestAssured.given();
        Response res = httpRequest.queryParam("ISBN","9781449365035").get("/Book");
        ResponseBody body = res.body();
        String javaBook = body.asString();
        JsonPath book = new JsonPath(javaBook);
        String title = book.getString("title");
        System.out.println("The book title is - "+title);
    }

    @Then("The details are displayed")
    public void theDetailsAreDisplayed() {
        int statusCode = response.getStatusCode();
        Assert.assertEquals(200, statusCode);
        System.out.println("Status Code is: " + response.getStatusLine());

    }


// Scenario No. 10 - BookStore - Put
    @When("User executes a PUT request to replace a particular book")
    public void userExecutesAPUTRequestToReplaceAParticularBook() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();

        request.header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");

        response = request.body("{ \"userId\": \"" + USER_ID + "\", " +
                        "\"collectionOfIsbns\": [ { \"isbn\": \"" + bookId + "\" } ]}")
                .post("/BookStore/v1/Books");
    }

    @Then("The book is successfully replaced")
    public void theBookIsSuccessfullyReplaced() {
        int statusCode = response.getStatusCode();
        Assert.assertEquals(200, statusCode);
        System.out.println("Status Code is: " + response.getStatusLine());
    }
}

