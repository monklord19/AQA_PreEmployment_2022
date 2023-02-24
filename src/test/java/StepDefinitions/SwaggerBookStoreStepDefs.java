package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class SwaggerBookStoreStepDefs {

    public static final String BASE_URL = "https://demoqa.com/BookStore";
    private static Response response;

    @Given("On the Swagger BookStore API")
    public void onTheSwaggerBookStoreAPI() {
        RestAssured.baseURI = BASE_URL;
    }

    @When("I send a GET request for the Speaking JavaScript book")
    public void iSendAGETRequestForTheSpeakingJavaScriptBook() {
        String isbnNo = "9781449365035";
        response = given().get("v1/Book?ISBN=" + isbnNo).then().extract().response();
        System.out.println("Response body: " + response.getBody().asString());
    }

    @Then("I check the status code")
    public void iCheckTheStatusCode() {
        Assertions.assertEquals(200, response.getStatusCode());
    }

    @And("The response body contains the isbn value and title")
    public void theResponseBodyContainsTheIsbnValueAndTitle() {
        Assert.assertNotNull(response.jsonPath().get("isbn"));
        Assert.assertNotNull(response.jsonPath().get("title"));
        Assert.assertEquals("9781449365035", response.jsonPath().get("isbn"));
        Assert.assertEquals("Speaking JavaScript", response.jsonPath().get("title"));
    }

    @When("I send a GET request for all books")
    public void iSendAGETRequestForAllBooks() {
        response = given().get("/v1/Books");
        System.out.println("Response body: " + response.getBody().asString());
    }

    @Then("I check status code")
    public void iCheckStatusCode() {
        Assertions.assertEquals(200, response.getStatusCode());
    }

    @And("I check the number of books retrieved")
    public void iCheckTheNumberOfBooksRetrieved() {
        response.then().body("books.size()", equalTo(8)).log().all();
    }

}
