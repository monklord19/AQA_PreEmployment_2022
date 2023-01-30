package Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReqresApiSteps {

    private RequestSpecification request;
    private Response response;
    private String endpoint;
    private String body;

    @Given("User is connected to reqres in")
    public void userIsConnectedToReqresIn() {
        RestAssured.baseURI = "https://reqres.in/";
        Response response = RestAssured.get(baseURI);
    }

    @When("The user makes a request to get all users")
    public void theUserMakesARequestToGetAllUsers() {
        endpoint = "https://reqres.in/api/users?page=2";
        given().when().get(endpoint);
    }

    @Then("The users should be displayed")
    public void theUsersShouldBeDisplayed() {
        assertTrue(response.getBody().jsonPath().getList("page").contains(2));
    }

    @And("The response status code should be 200")
    public void theResponseStatusCodeShouldBe200(int statusCode){
        assertEquals(statusCode, response.getStatusCode());
    }

    @When("The user makes a request to get a single user")
    public void theUserMakesARequestToGetASingleUser(){
        endpoint = "https://reqres.in/api/users/2";
        given().when().get(endpoint);
    }

    @Then("The user should be displayed")
    public void theUserShouldBeDisplayed(){
        endpoint ="https://reqres.in/api/users/2";
        given().when().get(endpoint).then().log().body().statusCode(200);
    }

    @When("The user makes a request to get a user")
    public void theUserMakesARequestToGetAUser(){
        endpoint ="https://reqres.in/api/users/23";
        given().when().get(endpoint);
    }

    @Then("The user should not be displayed")
    public void theUserShouldNotBeDisplayed(){
        endpoint ="https://reqres.in/api/users/23";
        given().when().get(endpoint).then().log().body().statusCode(200);
    }

    @When("The user makes a request to get the list of resources")
    public void theUserMakesARequestToGetTheListOfResources(){
        endpoint ="https://reqres.in/api/unknown";
        given().when().get(endpoint);
    }

    @Then("The list should be displayed")
    public void theListShouldBeDisplayed(){
        endpoint ="https://reqres.in/api/unknown";
        given().when().get(endpoint).then().log().body().statusCode(200);
    }

    @When("The user makes a request to get a single resource")
    public void theUserMakesARequestToGetASingleResource(){
        endpoint ="https://reqres.in/api/unknown/2";
        given().when().get(endpoint);
    }

    @Then("The resource should be displayed")
    public void theResourceShouldBeDisplayed(){
        endpoint ="https://reqres.in/api/unknown/2";
        given().when().get(endpoint).then().log().body().statusCode(200);
    }

    @When("The user makes a request to get a resource")
    public void theUserMakesARequestToGetAResource(){
        endpoint ="https://reqres.in/api/unknown/23";
        given().when().get(endpoint);
    }

    @Then("The resource should not be displayed")
    public void theResourceShouldNotBeDisplayed(){
        endpoint ="https://reqres.in/api/unknown/23";
        given().when().get(endpoint).then().log().body().statusCode(200);
    }

    @When("The user makes a request to create an user")
    public void theUserMakesARequestToCreateAnUser(){
        endpoint = "https://reqres.in/api/users";
        body = """
                {
                "name":"morpheus",
                "job":"leader"
                }
                 """;
        given().body(body).when().post(endpoint);
    }

    @Then("The user is created")
    public void theUserIsCreated(){
        endpoint = "https://reqres.in/api/users";
        body = """
                {
                "name":"morpheus",
                "job":"leader"
                }
                 """;
        given().body(body).when().post(endpoint).then().log().body().statusCode(201);
    }

    @When("The user enter valid credentials")
    public void theUserEnterValidCredentials(){
        endpoint = "https://reqres.in/api/login";
        body = """
                {
                    "email":"eve.holt@reqres.in",
                    "password":"cityslicka"
                }
                 """;
        given().body(body).when().post(endpoint);

    }

    @Then("The user is logged in")
    public void theUserIsLoggedIn(){
        endpoint = "https://reqres.in/api/login";
        String body = """
                {
                    "email":"eve.holt@reqres.in",
                    "password":"cityslicka"
                }
                 """;
        given().body(body).when().post(endpoint).then().log().body().statusCode(201);
    }

    @When("The user update the name and the job")
    public void theUserUpdateTheNameAndTheJob(){
        endpoint = "https://reqres.in/api/users/2";
        body = """
                {
                "name":"Paul Pop",
                "job":"Master Chef"
                }
                 """;
        given().body(body).put(endpoint);
    }

    @Then("The user is updated")
    public void theUserIsUpdated(){
        endpoint = "https://reqres.in/api/users/2";
        String body = """
                {
                "name":"Paul Pop",
                "job":"Master Chef"
                }
                 """;
        given().body(body).put(endpoint).then().log().body().statusCode(200);
    }

    @When("Delete one user")
    public void deleteOneUser(){
        endpoint = "https://reqres.in/api/users/2";
        given().when().delete(endpoint);
    }

    @Then("The user is deleted")
    public void theUserIsDeleted(){
        endpoint = "https://reqres.in/api/users/2";
        given().when().delete(endpoint).then().log().body().statusCode(204);
    }







}

