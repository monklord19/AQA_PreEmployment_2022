import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Validatable;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;

import static io.restassured.RestAssured.given;

public class APITests {
    String BaseUrl;
    String endpoint;
    String body;
    ValidatableResponse response;

    @Given("user opens website {string}")
    public void userOpensWebsite(String link) {
        BaseUrl = link;
    }

    @When("user wants to get list users")
    public void userWantsToGetListUsers() {
        endpoint = "api/users?page=2";
        response =  given().queryParam("page", "2").when().get(BaseUrl + endpoint).then();
    }

    @Then("the response should be success")
    public void theResponseShouldBeSuccess() {
        response.log().body();
        response.assertThat().statusCode(200);
    }

    @When("user wants to get single list")
    public void user_wants_to_get_single_list() {
        endpoint = "api/users/2";
        response = given().when().get(BaseUrl + endpoint).then();
    }

    @When("user wants to create a user")
    public void userWantsToCreateAUser() {
        endpoint = "api/users";
        body = """ 
                {
                     "name": "Matei",
                     "job": "Bucatar sef"
                 }
                """;
        response = given().body(body).when().post(BaseUrl + endpoint).then();
    }
    @Then("the response should be created")
    public void theResponseShouldBeCreated() {
        response.log().body();
        response.assertThat().statusCode(201);
    }

    @When("user wants to get single user not found")
    public void userWantsToGetSingleUserNotFound() {
        endpoint = "api/users/23";
        response = given().when().get(BaseUrl + endpoint).then();
    }

    @Then("the response should be not found")
    public void theResponseShouldBeNotFound() {
        response.log().body();
        response.assertThat().statusCode(404);
    }


    @When("user wants to get resource list")
    public void userWantsToGetResourceList() {
        endpoint = "api/unknown";
        response = given().when().get(BaseUrl + endpoint).then();
    }

    @When("user wants to get single resource")
    public void userWantsToGetSingleResource() {
        endpoint = "api/unknown/2";
        response = given().when().get(BaseUrl + endpoint).then();
    }

    @When("user wants to get single resource not found")
    public void userWantsToGetSingleResourceNotFound() {
        endpoint = "api/unknown/23";
        response = given().when().get(BaseUrl + endpoint).then();
    }

    @When("user wants to update a user")
    public void userWantsToUpdateAUser() {
        endpoint = "api/users/2";
        body = """
                {
                    "name": "morpheus",
                    "job": "zion resident"
                }
                """;
        response = given().body(body).when().put(BaseUrl + endpoint).then();
    }

    @When("user wants to delete a user")
    public void userWantsToDeleteAUser() {
        endpoint = "api/users/2";
        response = given().when().delete(BaseUrl + endpoint).then();

    }

    @Then("the response should be no content")
    public void theResponseShouldBeNoContent() {
        response.assertThat().statusCode(204);
    }

    @When("user wants to get delayed response")
    public void userWantsToGetDelayedResponse() {
        endpoint = "api/users";
        response = given().queryParam("delay", "3").when().get(BaseUrl + endpoint).then();

    }

    @Then("the response should be success and greater than 3000L")
    public void theResponseShouldBeSuccessAndTheTimeDisplayed() {
        response.assertThat().statusCode(200);
        response.time(Matchers.greaterThan(3000L));
    }


}
