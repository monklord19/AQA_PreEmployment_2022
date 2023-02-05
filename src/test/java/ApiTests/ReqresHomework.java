package ApiTests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class ReqresHomework {

    @Given("User is on reqres website")
    public void userIsOnReqresWebsite() {
        RestAssured.baseURI = "https://reqres.in/";

    }

    @When("User wants to get all users")
    public void userWantsToGetAllUsers() {
        given().get("/api/users?page=2");
    }

    @Then("Users information is displayed")
    public void usersInformationIsDisplayed() {
        given().get("/api/users?page=2").then().statusCode(200).body("data.id[0]",equalTo(7)).statusCode(200).log().body();
    }

    @When("User wants to get one single user")
    public void userWantsToGetOneSingleUser() {
        given().get("/api/users/2");
    }

    @When("User want to create an employee")
    public void userWantToCreateAnEmployee() {
        given().get("/api/users");
    }

    @Then("Employee is created")
    public void employeeIsCreated() {
    }

    @When("User want to update an employee")
    public void userWantToUpdateAnEmployee() {
        given().get("/api/users/2");
    }

    @Then("Employee is updated")
    public void employeeIsUpdated() {
        String body= """
                {
                 "name": "morpheus",
                 "job": "zion resident"
                }
                """;

        given().body(body).when().put("/api/users/2").then().log().body();
    }

    @When("User want to delete an employee")
    public void userWantToDeleteAnEmployee() {
        given().get("/api/users/2");
    }

    @Then("Employee is deleted")
    public void employeeIsDeleted() {
        given().when().delete("/api/users/2").then().log().body();
    }
}
