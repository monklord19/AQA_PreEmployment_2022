package ApiTests;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Assertions;
import java.io.FileWriter;
import java.io.IOException;
import static org.hamcrest.Matchers.*;

public class demoqaCucumber {

    static String UUID;
    static String username = "Weekend32";
    static String password = "Password@123";
    static String token;
    Response response;
    String book = "9781449325862";
    String modifiedBook = "9781593277574";
    static String baseURI =  RestAssured.baseURI = "https://demoqa.com";

    @Given("I am on demoqa page")
    public void iAmOnDemoqaPage() {
        RestAssured.baseURI = "https://demoqa.com";
    }

    @When("I enter my credentials to create account")
    public String iEnterMyCredentialsToCreateAccount() {
        RestAssured.baseURI = "https://demoqa.com";
        JSONObject request = new JSONObject();
        request.put("userName", username);
        request.put("password", password);
        RequestSpecification httpRequest = RestAssured.given();
        response = httpRequest.
                accept("accept: application/json").
                header("Content-Type", "application/json").
                body(request.toJSONString()).
                when().
                post("/Account/v1/User");
        UUID = response.then().extract().path("userID");
        return UUID;
    }

    @Then("I have an account")
    public void iHaveAnAccount() {

        response.then().
                statusCode(201).
                time(Matchers.lessThan(1000L)).
                body("username", equalTo(username)).
                log().all();
    }

    @When("I enter my credentials to get authorization")
    public void iEnterMyCredentialsToGetAuthorization() {
        RestAssured.baseURI = "https://demoqa.com";
        RequestSpecification httpRequest = RestAssured.given();
        JSONObject request = new JSONObject();
        request.put("userName", username);
        request.put("password", password);
        response = httpRequest.
                accept("accept: application/json").
                header("Content-Type", "application/json").
                body(request.toJSONString()).
                when().
                post("/Account/v1/Authorized");
    }

    @Then("I am authorized")
    public void iAmAuthorized() {
        int status = response.then().extract().statusCode();
        Assertions.assertEquals(200, status);
        response.then().body(equalTo("true")).log().all();
    }

    @When("I enter my credentials to get token")
    public String iEnterMyCredentialsToGetToken() {
        RestAssured.baseURI = "https://demoqa.com";
        RequestSpecification httpRequest = RestAssured.given();
        JSONObject request = new JSONObject();
        request.put("userName", username);
        request.put("password", password);
        response = httpRequest.
                accept("accept: application/json").
                header("Content-Type", "application/json").
                body(request.toJSONString()).
                when().
                post("/Account/v1/GenerateToken");
        return token;
    }

    @Then("I receive a token")
    public void iReceiveAToken() {
        RestAssured.baseURI = "https://demoqa.com";
        token = response.then().extract().path("token");
        response.then().
                body("status", equalTo("Success")).
                time(Matchers.lessThan(1000L)).
                statusCode(200).
                log().all();
    }

    @When("I enter my UserId")
    public void iEnterMyUserId() {
        RestAssured.baseURI = "https://demoqa.com";
        RequestSpecification httpRequest = RestAssured.given();
        response = httpRequest.
                header("Authorization", "Bearer " + token).
                header("Content-Type", "application/json").
                accept("accept: application/json").
                when().
                get("/Account/v1/User/" + UUID);
    }

    @Then("I get the user")
    public void iGetTheUser() {

        response.then().
                statusCode(200).
                time(Matchers.lessThan(1000L)).
                body("username", equalTo(username)).
                log().all();
    }

    @When("I want to get all books")
    public void iWantToGetAllBooks() {
        RequestSpecification httpRequest = RestAssured.given();
        response = httpRequest.
                accept("accept: application/json").
                when().
                get(baseURI + "/BookStore/v1/Books");
    }
    @Then("I successfully get all books")
    public void iSuccessfullyGetAllBooks() {
        response.then().
                statusCode(200).
                time(Matchers.lessThan(1000L)).
                body("books.isbn", contains("9781449325862", "9781449331818", "9781449337711", "9781449365035", "9781491904244", "9781491950296", "9781593275846", "9781593277574")).
                log().all();
    }

    @When("I want to get a book")
    public void iWantToGetABook() {
        RequestSpecification httpRequest = RestAssured.given();
        response = httpRequest.
                queryParam("ISBN", book).
                accept("accept: application/json").
                when().
                get(baseURI + "/BookStore/v1/Book");
    }
    @Then("I successfully get the book")
    public void iSuccessfullyGetTheBook() {
        response.then().
                statusCode(200).
                time(Matchers.lessThan(1000L)).
                body("title", equalTo("Git Pocket Guide")).
                log().all();
    }

    @When("I want to add books to user")
    public void iWantToAddBooksToUser() {
        RestAssured.baseURI = "https://demoqa.com";
        RequestSpecification httpRequest = RestAssured.given();

        JSONObject request = new JSONObject();
        request.put("userId", UUID);

        JSONObject lista = new JSONObject();
        lista.put("isbn", book);

        JSONArray array = new JSONArray();
        array.add(lista);
        request.put("collectionOfIsbns", array);

        try {
            FileWriter file = new FileWriter("C:/Users/Ferdi/Documents/AQA_Preemployment/AQA_PreEmployment_2022/src/test/resources/json_array_output.json");
            file.write(request.toJSONString());
            file.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        response = httpRequest.
                accept("accept: application/json").
                header("Authorization", "Bearer " + token).
                header("Content-Type", "application/json").
                body(request.toJSONString()).
                when().
                post(baseURI + "/BookStore/v1/Books");

    }
    @Then("I successfully add books to user")
    public void iSuccessfullyAddBooksToUser() {
        response.then().
                statusCode(201).
                time(Matchers.lessThan(1000L)).
                body("books.isbn", contains(book)).
                log().all();
    }

    @When("I want to update books")
    public void iWantToUpdateBooks() {
        RequestSpecification httpRequest = RestAssured.given();
        JSONObject request = new JSONObject();
        request.put("userId", UUID);
        request.put("isbn", modifiedBook);
        try {
            FileWriter file = new FileWriter("C:/Users/Ferdi/Documents/AQA_Preemployment/AQA_PreEmployment_2022/src/test/resources/json_array_output1.json");
            file.write(request.toJSONString());
            file.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        response = httpRequest.
                header("Authorization", "Bearer " + token).
                header("Content-Type", "application/json").
                body(request.toJSONString()).
                when().
                put(baseURI + "/BookStore/v1/Books/" + book);
    }
    @Then("I successfully update books")
    public void iSuccessfullyUpdateBooks() {
        response.then().
                statusCode(200).
                time(Matchers.lessThan(1000L)).
                log().all().
                body("books[0].isbn", equalTo(modifiedBook));
    }

    @When("I want to delete books from user")
    public void iWantToDeleteBooksFromUser() {
        RequestSpecification httpRequest = RestAssured.given();

        response = httpRequest.
                accept("accept: application/json").
                header("Authorization", "Bearer " + token).
                queryParam("UserId", UUID).
                when().
                delete(baseURI + "/BookStore/v1/Books");
    }
    @Then("I successfully delete books from user")
    public void iSuccessfullyDeleteBooksFromUser() {
        response.then().
                statusCode(204).
                time(Matchers.lessThan(1000L)).
                log().all();
    }

    @When("I want to delete books from inventory")
    public void iWantToDeleteBooksFromInventory() {
        RequestSpecification httpRequest = RestAssured.given();
        JSONObject request = new JSONObject();
        request.put("userId", UUID);
        request.put("isbn", book);
        response = httpRequest.
                queryParam("ISBN", book).
                accept("accept: application/json").
                when().
                delete(baseURI + "/BookStore/v1/Book");
    }
    @Then("I successfully delete books from inventory")
    public void iSuccessfullyDeleteBooksFromInventory() {
        response.then().
                statusCode(204).
                time(Matchers.lessThan(1000L)).
                log().all();
    }

    @When("I enter my UserId to Delete")
    public void iEnterMyUserIdToDelete() {
        RestAssured.baseURI = "https://demoqa.com";
        RequestSpecification httpRequest = RestAssured.given();
        response = httpRequest.
                header("Authorization", "Bearer " + token).
                header("Content-Type", "application/json").
                accept("accept: application/json").
                when().
                delete("/Account/v1/User/" + UUID);
    }

    @Then("I delete the user")
    public void iDeleteTheUser() {
        response.then().
                statusCode(204).
                time(Matchers.lessThan(1000L)).
                log().all();
    }

}

