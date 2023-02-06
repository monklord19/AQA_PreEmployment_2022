package ApiTests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.json.JSONObject;

import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class AccountAPI {

    static String UUID;

    public String token;
    public String username = "AndreeaAio";
    public String password = "AmericaExpress67743";

    String book = "1234567";

    Response response;

    @Given("User is on DemoQA Swagger")
    public void userIsOnDemoQASwagger(){
        RestAssured.baseURI = "https://demoqa.com";
    }

    @When("User sent a post request to create an user")
    public String userSentAPostRequestToCreateAnUser(){
        baseURI = "https://demoqa.com";
        JSONObject request = new JSONObject();
        request.put("userName", username);
        request.put("password", password);
        RequestSpecification httpRequest = given();
        response = httpRequest.accept("accept: application/json").header("Content-Type", "application/json").body(request.toString()).when().post("/Account/v1/User");
       UUID = response.then().extract().path("userID");
        return UUID;
    }

    @Then("The response will be with username and password")
    public void theResponseWillBeWithUsernameAndPassword(){
        response.then().statusCode(201).body("username", equalTo(username)).log().all();
    }

    @When("User sent a post request to confirm user authorised")
    public void userSentAPostRequestToConfirmUserAuthorised(){
        baseURI = "https://demoqa.com";
        RequestSpecification httpRequest = given();
        JSONObject request = new JSONObject();
        request.put("userName", username);
        request.put("password", password);
        response = httpRequest.accept("accept: application/json").header("Content-Type", "application/json").body(request.toString()).when().post("/Account/v1/Authorized");
    }

    @Then("The response will be with body")
    public void theResponseWillBeWithBody(){
        int statusCode = response.then().extract().statusCode();
        assertEquals(201, statusCode);
    }

    @When("User sent a post request to generate token")
    public String userSentAPostRequestToGenerateToken(){
        baseURI = "https://demoqa.com";
        RequestSpecification httpRequest = given();
        JSONObject request = new JSONObject();
        request.put("userName", username);
        request.put("password", password);
        response = httpRequest.accept("accept: application/json").header("Content-Type", "application/json").body(request.toString()).when().post("/Account/v1/GenerateToken");

        return token;
    }

    @Then("The response will be with the body")
    public void theResponseWillBeWithTheBody(){
        RestAssured.baseURI = "https://demoqa.com";
        token = response.then().extract().path("token");
        response.then().body("status", equalTo("Success")).statusCode(200).log().all();
    }

    @When("Send a request to get user by Id")
    public void sendARequestToGetUserById(){
        RestAssured.baseURI = "https://demoqa.com";
        RequestSpecification httpRequest = RestAssured.given();
        response = httpRequest.header("Authorization", "Bearer " + token).header("Content-Type", "application/json").accept("accept: application/json").when().get("/Account/v1/User/" + UUID);
    }

    @Then("User appears")
    public void userAppears(){
        response.then().statusCode(200).time(Matchers.lessThan(1000L)).body("username", equalTo(username)).log().all();
    }

    @When("Send a request to get the books")
    public void sendAReuqestToGetTheBook(){
        RequestSpecification httpRequest = RestAssured.given();
        response = httpRequest.accept("accept: application/json").when().get(baseURI + "/BookStore/v1/Books");
    }

    @Then("The books are listed")
    public void theBooksAreListed(){
        response.then().statusCode(200).time(Matchers.lessThan(1000L)).body("books.isbn", equalTo("9781449325862" )).log().all();
    }

    @When("User sent a request to get a book")
    public void userSentARequestToGetABook(){
        RequestSpecification httpRequest = RestAssured.given();
        response = httpRequest.queryParam("ISBN", book).accept("accept: application/json").when().get(baseURI + "/BookStore/v1/Book");
    }

    @Then("The book is listed")
    public void theBookIsListed(){
        response.then().statusCode(200).time(Matchers.lessThan(1000L)).body("title", equalTo("Git Pocket Guide")).log().all();
    }

    @When("User sent a request to delete the books")
    public void userSentARequestToDeleteTheBooks(){
        RequestSpecification httpRequest = RestAssured.given();
        response = httpRequest.accept("accept: application/json").header("Authorization", "Bearer " + token).queryParam("UserId", UUID).when().delete(baseURI + "/BookStore/v1/Books");
    }

    @Then("The books are deleted")
    public void theBooksAreDeleted(){
        response.then().statusCode(204).time(Matchers.lessThan(1000L)).log().all();
    }

    @When("User sent a request to delete books from inventory")
    public void userSentARequestToDeleteABookFromInventory(){
        RequestSpecification httpRequest = RestAssured.given();
        JSONObject request = new JSONObject();
        request.put("userId", UUID);
        request.put("isbn", book);
        response = httpRequest.queryParam("ISBN", book).accept("accept: application/json").when().delete(baseURI + "/BookStore/v1/Book");
    }

    @Then("The books are deleted from inventory")
    public void theBookAreDeletedFromInventory(){
        response.then().statusCode(204).time(Matchers.lessThan(1000L)).log().all();
    }

    @When("Delete an user by userdId")
    public void deleteAnUserByUserId(){
        RestAssured.baseURI = "https://demoqa.com";
        RequestSpecification httpRequest = RestAssured.given();
        response = httpRequest.header("Authorization", "Bearer " + token).header("Content-Type", "application/json").accept("accept: application/json").when().delete("/Account/v1/User/" + UUID);
    }

    @Then("User will be deleted")
    public void userWillBeDeleted(){
        response.then().statusCode(204).time(Matchers.lessThan(1000L)).log().all();
    }

    @When("User sent a request to create a book")
    public void userSentARequestToCreateABook(){


    }

    @Then("The book is created")
    public void theBookIsCreated(){

    }





}
