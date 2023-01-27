package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import static com.google.common.base.Predicates.equalTo;
import static io.restassured.RestAssured.given;


public class ReqresBDD {
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
        given().get("/api/users?page=2").then().assertThat().statusCode(200).log();
    }

    @When("I request to see a specific user's information")
    public void iRequestToSeeASpecificUserSInformation() {
    }


    @Then("The user is displayed")
    public void theUserIsDisplayed() {
    }
}
