package StepDefinitions;

import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.restassured.RestAssured.given;

public class ReqresStepDefs {

    WebDriver driver = new ChromeDriver();
    @Given("I am on the reqres website")
    public void iAmOnTheReqresWebsite() {
        RestAssured.baseURI = "https://reqres.in/";
    }

    @When("I request a list of users")
    public void iRequestAListOfUsers() {
        given().get("/api/users?page=2");
    }

    @Then("The users information is listed")
    public void theUsersInformationIsListed() {
        given().get("/api/users?page=2").then().statusCode(200).body("data.id", Matchers.equalTo(8)).time (Matchers.lessThan(2000L)).log();
    }


    @When("I request to see a specific user's information")
    public void iRequestToSeeASpecificUserSInformation() {
        given().get("/api/users/2");
    }

    @Then("The user is displayed")
    public void theUserIsDisplayed() {
        given().get("/api/users/2").then().statusCode(200).body("data.id", Matchers.equalTo(8)).time(Matchers.lessThan(2000L));
    }

    @When("I add a user with a specific name and job title to the users list")
    public void iAddAUserWithASpecificNameAndJobTitleToTheUsersList() {
        RestAssured.baseURI = "https://reqres.in/";
        JsonObject createRequest = new JsonObject();
        createRequest.add("name", "Daliana");
        createRequest.add("job", "AQA");
        System.out.println(createRequest);
        System.out.println(createRequest.toString());
       // given().body(createRequest.toString()).when().post("https://reqres.in/api/users");
    }


    @Then("The user is added")
    public void theUserIsAdded() {
        JsonObject createRequest = new JsonObject();
        createRequest.add("name", "Daliana");
        createRequest.add("job", "AQA");
        System.out.println(createRequest);
        System.out.println(createRequest.toString());
        given().body(createRequest.toString()).when().post("/api/users");
    }
}