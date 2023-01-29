package steps.definition;

import ApiTests.MethodsFlow;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class ReqResSteps extends MethodsFlow {


    //steps for GET-SINGLE_USER
    @Given("Suppose I am an authorized user on Reqres site")
    public void supposeIAmAnAuthorizedUserOnReqresSite() {
        given().get("https://reqres.in");
        RegistrationSuccessful();

    }

    @When("A list of single user data is available")
    public void aListOfSingleUserDataIsAvailable() {
        Users();
    }
    @And("Respons time and status are ok")
    public void responsTimeAndStatusAreOk() {
        getStatus();
        getResponseTime();
    }

    @Then("A single user is generated")
    public void aSingleUserIsGenerated() {
        userIdentity();
    }

    //steps for GET_LIST_OF_USERS


    @Then("List of users is generated")
    public void listOfUsersIsGenerated() {
        Users();
    }

    //steps for POST_CREATE_WITH_JSON
    @Then("Users are created using JSON OBJECT")
    public void usersAreCreatedUsingJSONOBJECT() throws IOException {
        createUser();
        createUser0();
        createUser1();
        createUser2();

    }

    //steps for PUT_UPDATE_USER

    @Then("User is updated")
    public void userIsUpdated() {
        updateUsers();
    }

    //steps for PATCH_UPDATE_USER
    @Then("Update user complete")
    public void updateUserComplete() {
        updateUser();
    }
    //steps for DELETE_USER
    @Then("User is deleted")
    public void userIsDeleted() {
        deleteUser();
    }
}

