package step.definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class ApiSteps {


    public static RequestSpecification request;
    public Response response;


    @Given("User is on API address")
    public void userIsOnAPIAddress() {

        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api/";
        request = given();

    }


    @When("User sends a get request for  user {string}")
    public void userSendsAGetRequestForTheSecondUser(String userNumber) {
        response = request.get("users/" + userNumber);
    }

    @Then("User receives status code {int}")
    public void userReceivesStatusCode(int statusReceived) {

        Assert.assertEquals(statusReceived, response.getStatusCode());
    }


    @When("user sends delete request for user number: {string}")
    public void userSendsDeleteRequestForUserNumber(String userNumber) {
        response = request.delete("users/" + userNumber);
    }





    @When("The user makes a request to create an user")
    public void theUserMakesARequestToCreateAnUser(){
       var endpoint = "https://reqres.in/api/users";
        String body = """
                {
                "name":"morpheus",
                "job":"leader"
                }
                 """;
        given().body(body).when().post(endpoint);
    }

    @Then("The user is created")
    public void theUserIsCreated(){
        var endpoint = "https://reqres.in/api/users";
        String body = """
                {
                "name":"morpheus",
                "job":"leader"
                }
                 """;
        given().body(body).when().post(endpoint).then().log().body().statusCode(201);
    }


        @When("user sends post login request with username and password")
    public void userSendsPostLoginRequestWithUsernameAndPassword() {

        var endpoint = "https://reqres.in/api/login";

        String body = """
                {
                    "email": "eve.holt@reqres.in",
                    "password": "cityslicka"
                }
                """;

          response= given().body(body).when().post(endpoint);
    }
    @Then("The user is logged in")
    public void theUserIsLoggedIn(){
        var endpoint = "https://reqres.in/api/login";
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
        var endpoint = "https://reqres.in/api/users/2";
        String body = """
                {
                "name":"Irina Maier",
                "job":"Software Tester"
                }
                 """;
        given().body(body).put(endpoint);
    }

    @Then("The user is updated")
    public void theUserIsUpdated(){
        var endpoint = "https://reqres.in/api/users/2";
        String body = """
                {
                "name":"Irina Maier",
                "job":"Software Tester"
                }
                 """;
        given().body(body).put(endpoint).then().log().body().statusCode(200);
    }

}