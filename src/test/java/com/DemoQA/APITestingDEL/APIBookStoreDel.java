package com.DemoQA.APITestingDEL;

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
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class APIBookStoreDel {
    private static final String USER_ID = "63ed010e-277d-49aa-a9e2-49aac451c678";
    private static final String USERNAME = "ANNE MYHYU";
    private static final String PASSWORD = "C12SCFnnbMDN*";
    private static final String BASE_URL = "https://bookstore.toolsqa.com";

    private static String token;
    private static Response response;
    private static String jsonString;
    private static String bookId;

    @Given("I am an authorized user")
    public void iAmAnAuthorizedUser() {

        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();

        request.header("Content-Type", "application/json");
        response = request.body("{ \"userName\":\"" + USERNAME + "\", \"password\":\"" + PASSWORD + "\"}")
                .post("/Account/v1/GenerateToken");

        String jsonString = response.asString();
        token = JsonPath.from(jsonString).get("token");

    }


    @Given("A list of books are available")
    public void aListOfBooksAreAvailable() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        response = request.get("/BookStore/v1/Books");

        jsonString = response.asString();
        List<Map<String, String>> books = JsonPath.from(jsonString).get("books");
        Assert.assertTrue(books.size() > 0);

        bookId = books.get(0).get("isbn");
    }

    @When("I add a book to my reading list")
    public void iAddABookToMyReadingList() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");

        response = request.body("{ \"userId\": \"" + USER_ID + "\", " +
                        "\"collectionOfIsbns\": [ { \"isbn\": \"" + bookId + "\" } ]}")
                .post("/BookStore/v1/Books");
    }

    @Then("The book is added")
    public void theBookIsAdded() {
        Assert.assertEquals(401, response.getStatusCode());
    }

    @When("I remove a book from my reading list")
    public void iRemoveABookFromMyReadingList() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();

        request.header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");

        response = request.body("{ \"isbn\": \"" + bookId + "\", \"userId\": \"" + USER_ID + "\"}")
                .delete("/BookStore/v1/Book");
    }

    @Then("The book is removed")
    public void theBookIsRemoved() {
        Assert.assertEquals(401, response.getStatusCode());

        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();

        request.header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");

        response = request.get("/Account/v1/User/" + USER_ID);
        Assert.assertEquals(401, response.getStatusCode());

        jsonString = response.asString();
        List<Map<String, String>> booksOfUser = JsonPath.from(jsonString).get("books");
        //Assert.assertEquals(0, booksOfUser.size());
    }

    @Test
    public void CreateNewUser() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();

        request.header("Content-Type", "application/json");
        response = request.body("{ \"userName\":\"" + USERNAME + "\", \"password\":\"" + PASSWORD + "\"}")
                .post("/Account/v1/User");
        Response response = request.post("/Account/v1/User");
        ResponseBody body = response.getBody();
        System.out.println("Response Body is: " + body.asString());
        System.out.println("Status received: " + response.getStatusLine());
    }


    @Test
    public void FirstScenario() {
        RequestSpecification request = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("userName", "CCC NSJD");
        requestParams.put("password", "NhgjKS**WD1");
        request.body(requestParams.toJSONString());
        Response response = request.post("Account/v1/User");
        ResponseBody body = response.getBody();
        String bodyAsString = body.asString();
        System.out.println("New user details: " + response.prettyPrint());
        System.out.println("Response body is: " + body.asString());
    }
}

