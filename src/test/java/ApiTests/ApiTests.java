package ApiTests;

import Utils.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;

import java.io.*;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class ApiTests {
    String BaseUrl = "https://demoqa.com";
    String endpoint;
    String token = "";
    RequestSpecification httpRequest = RestAssured.given();
    Response response;
    int statusCode;
    String userId = "51361007-2f2c-44ba-a94a-b626fe7ad2d9";
    HashMap<Object, Object> body = new HashMap<Object, Object>();
    String path = "src/test/java/Utils/DynamicUserData.json";
    JSONObject  userData;
    User user;
    private void saveUserData() {
        try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
            out.write(userData.toJSONString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void getUserData() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        userData = (JSONObject) parser.parse(new FileReader(path));
    }
    @Given("user enters on DemoQA Swagger")
    public void userEntersOnDemoQASwagger() {
        RestAssured.baseURI = BaseUrl;
    }

    @When("user sends valid post request to check is authorized")
    public void userSendsValidPostRequestToCheckIsAuthorized() throws IOException, ParseException {
        endpoint = "/Account/v1/Authorized";
        getUserData();
        body.put("userName", userData.get("userName"));
        body.put("password", userData.get("password"));

        response = given()
                .header("Content-type", "application/json")
                .and()
                .body(body)
                .when()
                .post(endpoint);
    }

    @Then("user is authorized")
    public void userIsAuthorized() {
        response.then().assertThat().statusCode(200);
        response.then().log().body();
    }
    @When("user sends valid post request to generate token")
    public void userSendsValidPostRequestToGenerateToken() throws IOException, ParseException {
        endpoint = "/Account/v1/GenerateToken";
        getUserData();
        body.put("userName", userData.get("userName"));
        body.put("password", userData.get("password"));
        response = given()
                .header("Content-type", "application/json")
                .and()
                .body(body)
                .when()
                .post(endpoint);
        statusCode = response.statusCode();
    }

    @Then("token is generated")
    public void tokenIsGenerated() {
        Assert.assertTrue(statusCode == 200);
        JsonPath jsonPathEvaluator = response.then().extract().jsonPath();
        token = jsonPathEvaluator.get("token");
        System.out.println("token: " + token);
        Assert.assertFalse(token.equals(""));
        userData.put("token", token);
        saveUserData();
    }

    @When("user sends valid post request to get user info")
    public void userSendsValidPostRequestToGetUserInfo() throws IOException, ParseException {
        endpoint = "/Account/v1/Login";
        getUserData();
        body.put("userName", userData.get("userName"));
        body.put("password", userData.get("password"));
        response = given()
                .header("Content-type", "application/json")
                .and()
                .body(body)
                .when()
                .post(endpoint);
    }

    @Then("userId is generated")
    public void useridIsGenerated() {
        response.then().assertThat().statusCode(200);
        JsonPath jsonPathEvaluator = response.then().extract().jsonPath();
        userId = jsonPathEvaluator.get("userId");
        System.out.println("userId: " + userId);
        Assert.assertFalse(userId.equals(""));

    }

    @When("user sends valid post request to create new user")
    public void userSendsValidPostRequestToCreateNewUser() {
        endpoint = "/Account/v1/User";
        user = new User();
        body.put("userName",  user.getUserName());
        body.put("password", user.getPassword());
        System.out.println(body);
        response = given()
                .header("Content-type", "application/json")
                .and()
                .body(body)
                .when()
                .post(endpoint);
    }

    @Then("new user is created")
    public void newUserIsCreated() {
        response.then().log().body();
        response.then().assertThat().statusCode(201);
        JsonPath jsonPathEvaluator = response.then().extract().jsonPath();
        userId = jsonPathEvaluator.get("userID");
        userData = new JSONObject(body);
        userData.put("userId", userId);
        System.out.println("userId: " + userId);
        Assert.assertFalse(userId.equals(""));
        saveUserData();
    }

    @When("user sends valid post request to delete user")
    public void userSendsValidPostRequestToDeleteUser() throws IOException, ParseException {
        getUserData();
        endpoint = "/Account/v1/User/" + userData.get("userId");
        response = given()
                .header("Content-type", "application/json")
                .header("Authorization", "Bearer " + userData.get("token"))
                .when()
                .delete(endpoint);
    }

    @Then("user is deleted if exists")
    public void userIsDeletedIfExists() {
        response.then().log().body();
        response.then().assertThat().statusCode(204);
    }
    @When("user sends valid post request to get user details")
    public void userSendsValidPostRequestToGetUserDetails() throws IOException, ParseException {
        getUserData();
        endpoint = "/Account/v1/User/" + userData.get("userId");
        response = given()
                .header("Content-type", "application/json")
                .header("Authorization", "Bearer " + userData.get("token"))
                .when()
                .get(endpoint);
    }

    @Then("user details are retrieved")
    public void userDetailsAreRetrieved() {
        response.then().assertThat().statusCode(200);
        JsonPath jsonPathEvaluator = response.then().extract().jsonPath();
        response.then().log().body();
        String userName = jsonPathEvaluator.get("username");
        Assert.assertTrue(userName.equals(userData.get("userName")));
    }

    @When("user sends valid get request to get books details")
    public void userSendsValidGetRequestToGetBooksDetails() {
        String endpoint = "/BookStore/v1/Books";
        response = given()
                .header("Content-type", "application/json")
                .when()
                .get(endpoint);
    }

    @Then("books details are retrieved")
    public void booksDetailsAreRetrieved() {
        response.then().log().body();
        response.then().assertThat().statusCode(200);
    }
    @When("user sends valid post request to add books into collection")
    public void userSendsValidPostRequestToAddBooksIntoCollection() throws IOException, ParseException {
        endpoint = "/BookStore/v1/Books";
        user = new User();
        getUserData();
        body.put("userId", userData.get("userId"));
        JSONArray isbns = new JSONArray();
        JSONObject book = new JSONObject();
        book.put("isbn", user.getRandomBook());
        isbns.add(book);
        userData.put("isbn", book.get("isbn"));
        saveUserData();
        body.put("collectionOfIsbns", isbns);
        System.out.println(body);
        response = given()
                .header("Content-type", "application/json")
                .header("Authorization", "Bearer " + userData.get("token"))
                .and()
                .body(body)
                .when()
                .post(endpoint);
    }

    @Then("books are added into  user's collection")
    public void booksAreAddedIntoUserSCollection() {
        response.then().assertThat().statusCode(201);
        response.then().log().body();
    }

    @When("user sends delete request to delete books from the collection")
    public void userSendsDeleteRequestToDeleteBooksFromTheCollection() throws IOException, ParseException {
        getUserData();
        endpoint = "/BookStore/v1/Books" +"?UserId="+ userData.get("userId");
        System.out.println(endpoint);
        response = given()
                .header("Content-type", "application/json")
                .header("Authorization", "Bearer " + userData.get("token"))
                .when()
                .delete(endpoint);
    }

    @Then("books are deleted from the user's collection")
    public void booksAreDeletedFromTheUserSCollection() {
        response.then().log().body();
        response.then().assertThat().statusCode(204);
    }


    @When("user sends valid get request to get book details")
    public void userSendsValidGetRequestToGetBookDetails() throws IOException, ParseException {
        user = new User();
        endpoint = "/BookStore/v1/Book" +"?ISBN="+ user.getRandomBook();
        response = given()
                .header("Content-type", "application/json")
                .when()
                .get(endpoint);
    }

    @Then("book details are retrieved")
    public void bookDetailsAreRetrieved() {
        response.then().log().body();
        response.then().assertThat().statusCode(200);
    }

    @When("user sends valid post request to update book in the list")
    public void userSendsValidPostRequestToUpdateBookInTheList() throws IOException, ParseException {
        user = new User();
        getUserData();
        endpoint = "/BookStore/v1/Books/" + userData.get("isbn");
        body.put("userId", userData.get("userId"));
        body.put("isbn", user.getRandomBook());
        System.out.println(body);
        response = given()
                .header("Content-type", "application/json")
                .header("Authorization", "Bearer " + userData.get("token"))
                .and()
                .body(body)
                .when()
                .put(endpoint);
    }

    @Then("book list is updated")
    public void bookListIsUpdated () {
        response.then().log().body();
        response.then().assertThat().statusCode(200);
    }
}