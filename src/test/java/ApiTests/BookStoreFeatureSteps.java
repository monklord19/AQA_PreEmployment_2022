package ApiTests;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;

public class BookStoreFeatureSteps {

    private static Response response;
    public static String baseUrl = "https://demoqa.com/";

    @Given("I am on DemoQA")
    public void iAmOnDemoQA() {
        RestAssured.baseURI = baseUrl;
    }

    @When("I send a get request to get all the books")
    public void iSendAGetRequestToGetAllTheBooks() {
        String endpoint = baseUrl + "/BookStore/v1/Books";
        RequestSpecification request = RestAssured.given();
        response = request.accept("accept: application/json").when().get(endpoint);

    }

    @Then("I get all books")
    public void iGetAllBooks() {
        Assertions.assertEquals(200, response.getStatusCode());
    }

    @When("I send a post request to give book to an user by entering userID")
    public void iSendAPostRequestToGiveBookToAnUserByEnteringUserID() {
        
    }

    @Then("book will be assigned to user")
    public void bookWillBeAssignedToUser() {
        
    }

    @When("I send a get request to get one specific book by entering ISBN")
    public void iSendAGetRequestToGetOneSpecificBookByEnteringISBN() {

    }

    @Then("I get the specific book")
    public void iGetTheSpecificBook() {
    }
}
