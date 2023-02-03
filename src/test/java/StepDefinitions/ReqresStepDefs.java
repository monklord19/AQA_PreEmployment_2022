package StepDefinitions;

import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class ReqresStepDefs {

    public static RequestSpecification request;
    private static Response response;
    JsonObject createRequest = new JsonObject();
    public static final String BASE_URL = "https://reqres.in";

    //List all users (get method)
    @Given("I am on the reqres website")
    public void iAmOnTheReqresWebsite() {
        RestAssured.baseURI = BASE_URL;
    }

    @When("I request a list of users")
    public void iRequestAListOfUsers() {
        given().get("/api/users?page=2");
    }

    @Then("The users information is listed")
    public void theUsersInformationIsListed() {
        given().get("/api/users?page=2").then().statusCode(200).body("total_pages", Matchers.equalTo(2)).time(Matchers.lessThan(2000L));
    }
//    See a specific user (get method)
    @When("I request to see a specific user's information")
    public void iRequestToSeeASpecificUserSInformation() {
        given().get("/api/users/2");
    }

    @Then("The user is displayed")
    public void theUserIsDisplayed() {
        given().get("/api/users/2").then().statusCode(200).body("data.id", Matchers.equalTo(2)).time(Matchers.lessThan(2000L));
    }

    //Create a user (post method)
    @When("I add a user with a specific name and job title to the users list")
    public void iAddAUserWithASpecificNameAndJobTitleToTheUsersList() {
        RestAssured.baseURI = BASE_URL + "/api/users";
        createRequest.add("name", "morpheus");
        createRequest.add("job", "leader");
        System.out.println(createRequest);
        System.out.println(createRequest.toString());
        System.out.println("baseURI " + RestAssured.baseURI);
        response = given().body(createRequest.toString()).when().post(RestAssured.baseURI).then().statusCode(201).extract().response();
        System.out.println("Response body: " + response.getBody().asString());
    }

    @Then("The user is added")
    public void theUserIsAdded() {
        System.out.println("The user was successfully added via Post method");
        Assertions.assertEquals(201, response.getStatusCode());
        Assert.assertNotNull(response.jsonPath().get("createdAt"));
        Assert.assertNotNull(response.jsonPath().get("id"));
        System.out.println("Response time: " + response.time());
        Assert.assertTrue(response.time()<2000L);
    }

    //Update a user (put method)
    @When("I want to update a user")
    public void iWantToUpdateAUser() {
        RequestSpecification request = RestAssured.given();
        String informationForUpdate = """
                {
                "name": "morpheus",
                "job": "zion resident"
                }
                """;
        Response updateUser = request.body(informationForUpdate).put("/api/users/2");
    }

    @Then("I check that user is updated")
    public void iCheckThatUserIsUpdated() {
        System.out.println("The user was successfully updated via Put method");
        RestAssured.baseURI = BASE_URL + "/api/users/2";
        RequestSpecification request = RestAssured.given();
        String informationForUpdate = """
                {
                "name": "morpheus",
                "job": "zion resident"
                }
                """;
        Response updateUser = request.body(informationForUpdate).put("/api/users/2");
        Assertions.assertEquals(200, updateUser.getStatusCode());
        System.out.println("The response code is: " + updateUser.getStatusCode());
        String responseBody = updateUser.getBody().asString();
        System.out.println("Response body for the updated user is:" + responseBody);
    }

    // Delete a user from the list (delete method)

//    @When("I want to delete a user")
//    public void iWantToDeleteAUser() {
//        request.header("Content-Type", "application/json");
//        response = request.delete("/users/2");
//    }
//
//
//    @Then("I check the user is deleted")
//    public void iCheckTheUserIsDeleted() {
//        Assert.assertEquals(204,response.getStatusCode());
//        System.out.println("204");
//        long responseTime = response.getTime();
//        System.out.println("Response Time: " + responseTime + "ms");
//    }

}