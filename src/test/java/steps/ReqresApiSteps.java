package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class ReqresApiSteps {
    public static RequestSpecification request;
    private static Response response;
    public HashMap<Object, Object> map = new HashMap<Object, Object>();
    JSONObject requestParams = new JSONObject();

    @Given("On the reqres page")
    public void onTheReqresPage() {
        baseURI = "https://reqres.in";


    }

    @When("Gets the users")
    public void getsTheUsers() {
        basePath = "/api/users";
        response = (Response) get(baseURI);
    }

    @Then("Status code is 200")
    public void statusCodeIs() {

        Assert.assertEquals(200, response.getStatusCode());
    }
//Create user

    @When("User is created")
    public void userIsCreated() {
        basePath = "/api/users";
        map.put("Name", "Morpheus");
        map.put("job", "leader");

        response = given().contentType(ContentType.JSON).body(map)
                .when().post().then().statusCode(201).contentType(ContentType.JSON).extract().response();

    }

    @Then("Check user is created")
    public void checkUserIsCreated() {
        Assert.assertEquals(201, response.getStatusCode());
        System.out.println(response.getStatusCode());
    }
//Update user

    @When("User is updated")
    public void userIsUpdated() {
        basePath = "/api/users/2";
        map.put("Name", "John");
        map.put("job", "teacher");
        response = given().contentType(ContentType.JSON).body(map)
                .when().put().then().extract().response();
    }

    @Then("check updated user")
    public void checkUpdatedUser() {
        Assert.assertEquals(200, response.getStatusCode());
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());
    }

    // Partially update

    @When("Update name")
    public void updateName() {
        basePath = "/api/users/2";
        map.put("Name", "Jonny");
        response = given().contentType(ContentType.JSON).body(map)
                .when().patch().then().extract().response();
    }

    @Then("Check the partially update")
    public void checkThePartiallyUpdate() {
        System.out.println(response.getStatusCode());
        Assert.assertEquals(200,response.getStatusCode());
    }
//del user
    @When("delete the user")
    public void deleteTheUser() {
        basePath = "/api/users/2";
        response= given().delete().then().extract().response();
    }

    @Then("Check status code")
    public void checkStatusCode() {
        Assert.assertEquals(204,response.getStatusCode());
    }
}
