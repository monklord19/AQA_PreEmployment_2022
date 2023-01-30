package apiSteps;

import io.cucumber.java.en.And;
import io.restassured.RestAssured;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.*;


public class reqresSteps {

    @Given("On reqres site")
    public void on_reqres_site(){
        RestAssured.baseURI = "https://reqres.in/";
        Response response = RestAssured.get(baseURI);
    }


    @When("I want to see all users")
    public void iWantToSeeAllUsers(){
        given().get("/api/users?page=2");
    }

    @Then("Users informations are displayed")
    public void usersInformationsAreDisplayed(){
        given().get("/api/users?page=2").then().assertThat().statusCode(200).log();
    }

    @And("Status code should be equal to {int}")
    public void statusCodeShouldBeEqualTo(int status){
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "/api/users?page=2");

        int statusCode = response.getStatusCode();
        Assertions.assertEquals(status, statusCode);
    }

    @When("I create a new user")
    public void iCreateANewUser(){
        given().get("/api/users");
    }

    @Then("Request status should be {int}")
    public void requestStatusShouldBe(int arg0){


    }

    @And("User is created")
    public void userIsCreated(){
        String body = """
                {
                "name":"morpheus",
                "job":"leader"
                }
                 """;
        given().body(body).when().post("https://reqres.in/api/users").then().log().body().statusCode(201);
    }

    @When("I delete user")
    public void iDeleteUser(){
        when().delete("/api/users/2");
    }

    @Then("User is deleted")
    public void userIsDeleted(){
        String endpoint = "https://reqres.in/api/users/2";
        given().when().delete(endpoint).then().log().body().statusCode(204);
    }

    @Then("Status code for creating user should be equal to {int}")
    public void statusCodeForCreatingUserShouldBeEqualTo(int status){

    }

    @When("I want to see user's informations")
    public void iWantToSeeUserSInformations(){
        given().get("/api/users/2").then().assertThat().statusCode(200).log();
    }

    @Then("User informations are displayed")
    public void userInformationsAreDisplayed(){
        given().get("/api/users/2").then().assertThat().statusCode(200).log();
    }
}
