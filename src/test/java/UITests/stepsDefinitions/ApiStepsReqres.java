package UITests.stepsDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static java.nio.file.Paths.get;

public class ApiStepsReqres {

    public static RequestSpecification request;
    private static Response response;
    public HashMap<Object, Object > map = new HashMap<Object, Object>();


    @Given("On the Reqres website")
    public void onTheReqresWebsite() {
        baseURI = "http://reqres.in";
    }
    @When("Gets the users")
    public void getsTheUsers() {
        basePath = "/api/users";
        response = (Response) get(baseURI);
    }
    @Then("Status code should be 200")
    public void statusCodeShouldBe(){
        Assert.assertEquals(200, response.getStatusCode());
    }


    @When("An user is created")
    public void userIsCreated(){
        basePath = "api/users";
        map.put("Name", "Morpheus");
        map.put("Job", "leader");
        response = given().contentType(ContentType.JSON).body(map)
                .when()
                .post()
                .then()
                .statusCode(201).contentType(ContentType.JSON).extract().response();
    }
    @Then("Check if the user is created")
    public void checkIfTheUserIsCreated(){
        Assert.assertEquals(201, response.getStatusCode());
        System.out.println(response.getStatusCode());
    }

    @Then("Update user test")
    public void updateUserTest(){
        Assert.assertEquals(200, response.getStatusCode());
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());
    }
    @When("Delete the user test")
    public void deleteUser(){
        basePath = "/api/users/2";
        response = given()
                .delete()
                .then()
                .extract()
                .response();
    }
}
