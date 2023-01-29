import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Validatable;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class APITests {
    String BaseUrl;
    String endpoint;
    ValidatableResponse response;
    @Given("user opens website {string}")
    public void userOpensWebsiteHttpsReqresIn() {
        BaseUrl =  "https://reqres.in/";

    }

    @When("user wants to get list users")
    public void userWantsToGetListUsers() {
        endpoint = "api/users?page=2";
        response =  given().queryParam("page", "2").when().get(BaseUrl + endpoint).then();
    }

    @Then("the response should be success")
    public void theResponseShouldBeSuccess() {
        response.assertThat().statusCode(200);
    }

    @When("user wants to get  single list")
    public void userWantsToGetSingleList() {
    }

    @When("user wants to create a user")
    public void userWantsToCreateAUser() {
    }

    @Then("the response should be {string}")
    public void theResponseShouldBe(int arg0) {
    }
}
