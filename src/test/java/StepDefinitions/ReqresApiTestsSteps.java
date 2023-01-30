package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ReqresApiTestsSteps {
    @Given("User is on Reqres website")
    public void userIsOnReqresWebsite() {
        RestAssured.baseURI = "https://reqres.in" ;
    }

    @When("User wants to get all users")
    public void userWantsToGetAllUsers() {
        given().get("/api/users?page=2");
    }

    @Then("All users are displayed")
    public void allUsersAreDisplayed() {
        given().get("/api/users?page=2").then().statusCode(200).body("data.id[0]", equalTo(7)).statusCode(200).log().body();
    }

    @When("User wants to get single user")
    public void userWantsToGetSingleUser() {
        given().get("/api/users/2");
    }

    @Then("One user is displayed")
    public void oneUserIsDisplayed() {
        given().when().get("/api/users/2").then().body("data.id", equalTo(2)).log().body();
    }

    @When("User wants to get not found user")
    public void userWantsToGetNotFoundUser() {
        given().get("/api/users/-2");
    }

    @Then("Nothing is displayed because user is not found")
    public void nothingIsDisplayedBecauseUserIsNotFound() {
        given().when().get("/api/users/-2").then().statusCode(404).log().body();
    }

    @When("User wants to update one user")
    public void userWantsToUpdateOneUser() {
        given().get("/api/users/2");
    }

    @Then("Information for selected user is updated")
    public void informationForSelectedUserIsUpdated() {
        String body= """
                {
                 "name": "morpheus",
                 "job": "zion resident"
                }
                """;

        given().body(body).when().put("/api/users/2").then().log().body();
    }

    @When("User wants to create another user")
    public void userWantsToCreateAnotherUser() {
        given().get("/api/users");
    }

    @Then("User is created")
    public void userIsCreated() {
        String body = """
               {
               "name":"Franci",
               "job":"qa",
               }
               """;
        given().body(body).when().post("/api/users").then().log().body();
    }

    @When("User wants to delete another user")
    public void userWantsToDeleteAnotherUser() {
        given().get("/api/users/2");
    }

    @Then("User is deleted")
    public void userIsDeleted() {
        given().when().delete("/api/users/2").then().log().body();
    }
}
