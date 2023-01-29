package ApiTests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;

public class ReqresSteps {
    private final Methods methods = new Methods();

    @Given("The request specifications")
    public void theRequestSpecifications() {
        RestAssured.given().spec(Methods.iSetTheRequestSpecifications());
    }

    @When("I send a valid request to fetch users")
    public void iSendAValidRequestToFetchUsers() {
        Response usersListResponse = Methods.responseForUsersListRequest();
        methods.setResponseAsString(usersListResponse);

    }

    @Then("I receive a list of users")
    public void iReceiveAListOfUsers() {
        ValidatableResponse validatableResponse = Methods.responseForUsersListRequest().then();
        validatableResponse.statusCode(Matchers.equalTo(200));

    }

    @When("I send a valid request with payload to create user")
    public void iSendAValidRequestWithPayloadToCreateUser() {
        Response createUserResponse = Methods.responseForCreateRequest();
        methods.setResponseAsString(createUserResponse);

    }

    @Then("The new user must be created")
    public void theNewUserMustBeCreated() {
        ValidatableResponse validatableResponse = Methods.responseForCreateRequest().then();
        validatableResponse.statusCode(Matchers.equalTo(201));
        validatableResponse.time(Matchers.lessThanOrEqualTo((long) 2000));
    }

    @When("I send a valid request for deleting a user")
    public void iSendAValidRequestForDeletingAUser() {
        Response deleteResponse = Methods.responseForDeleteUserRequest();
        methods.setResponseAsString(deleteResponse);
    }

    @Then("The user must be deleted")
    public void theUserMustBeDeleted() {
        ValidatableResponse validatableResponse = Methods.responseForDeleteUserRequest().then();
        validatableResponse.statusCode(Matchers.equalTo(204));
        validatableResponse.time(Matchers.lessThanOrEqualTo((long) 2000));
    }

    @When("I send a valid request with payload for updating a user")
    public void iSendAValidRequestWithPayloadForUpdatingAUser() {
        Response putUpdateResponse = Methods.responseForPutUpdate();
        methods.setResponseAsString(putUpdateResponse);
    }

    @Then("The user is updated")
    public void theUserIsUpdated() {
        ValidatableResponse validatableResponse = Methods.responseForPutUpdate().then();
        validatableResponse.statusCode(Matchers.equalTo(200));
    }

    @When("I send a valid request with payload for partially update a user")
    public void iSendAValidRequestWithPayloadForPartiallyUpdateAUser() {
        Response patchUpdateResponse = Methods.responseForPatchUpdate();
        methods.setResponseAsString(patchUpdateResponse);
    }

    @Then("The user is partially updated")
    public void theUserIsPartiallyUpdated() {
        ValidatableResponse validatableResponse = Methods.responseForPatchUpdate().then();
        validatableResponse.statusCode(Matchers.equalTo(200));
    }
}