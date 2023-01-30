package StepsDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ResponseBody;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.junit.Assert;


import java.io.File;
import java.util.Map;

import static ApiTests.ReqresEndpoint.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class ReqresSteps {
    public static final String BASE_URL = "https://reqres.in/api";
    public static final String BASE_PATH_USERS = "/users/";
    File fileBody=new File("src/test/java/ApiPayload/Payload.json");
    File fileBody2=new File("src/test/java/ApiPayload/Payload2.json");
    File fileBody3=new File("src/test/java/ApiPayload/Payload3.json");
    public static RequestSpecification request;
    public Response response;
    public Response responseGetUser;
@Before
    @Given("user is on API address")
    public void user_is_on_api_address() {
        RestAssured.baseURI = BASE_URL;
        RestAssured.basePath = BASE_PATH_USERS;
        request = RestAssured.given();
    }

    @When("I send valid request with payload")
    public void iSendValidRequestWithJSONObject() {
        UserBody user=new UserBody("AndreeaC","Tester");
        response= given().auth().none()
                .header("Content-Type","application/json")
                .contentType(ContentType.JSON)
                .when().body(user)
                .post("https://reqres.in/api/users");

    }
    @Then("User is created")
    public void userIsCreated() {
        response.then().assertThat().body("name",equalTo("AndreeaC"))
                .body("job",equalTo("Tester"))
                .statusCode(201);
        System.out.println(response.asString());
        long time = response.getTime();
        System.out.println(time);
        org.testng.Assert.assertTrue(time<2000);

    }
    @When("I send a get user by id request")
    public void iSendAGetUserByIdRequest() {
        response =  given().when().get("https://reqres.in/api/users/2");
    }

    @Then("User is listed")
    public void userIsListed() {
        response.then().assertThat().body("data.id",equalTo(2));
        response.then().assertThat().statusCode(200);

        System.out.println(response.asString());
        long time = response.getTime();
        System.out.println(time);
        org.testng.Assert.assertTrue(time<2000);
    }


    @When("I send valid body")
    public void iSendValidBody() {
        response = given().auth().none()
                .header("Content-Type","application/json")
                .contentType(ContentType.JSON).
                body(fileBody2).when().put(getUser);

    }

    @Then("User is updated")
    public void userIsUpdated() {
        response.then().assertThat().statusCode(200);
        response.then().assertThat().body("name",equalTo("morpheus"));
        System.out.println(response.asString());
        long time = response.getTime();
        System.out.println(time);
        org.testng.Assert.assertTrue(time<2000);
    }

    @When("I send valid patch request and body")
    public void iSendValidPatchRequestAndBody() {
        response = given().auth().none()
                .header("Content-Type","application/json")
                .contentType(ContentType.JSON).
                body(fileBody2).when().patch(getUser);
    }

    @When("I send delete request")
    public void iSendDeleteRequest() {
        response =given().when().delete(getUser);

    }

    @Then("User is deleted")
    public void userIsDeleted() {
        response.then().assertThat().statusCode(204);
        System.out.println(response.asString());
        long time = response.getTime();
        System.out.println(time);
        Assert.assertTrue(time<2000);
    }

    @When("I send valid credentials")
    public void iSendValidCredentials() {
        response = given().auth().none()
                .header("Content-Type","application/json")
                .contentType(ContentType.JSON).body(fileBody3)
                .when().post("/register");
        
    }

    @Then("I am successfully registered")
    public void iAmSuccessfullyRegistered() {
        response.then().assertThat().statusCode(201);
        System.out.println(response.asString());
        long time = response.getTime();
        System.out.println(time);
        org.testng.Assert.assertTrue(time<1600);
    }

    @When("I send a get user by wrong id")
    public void iSendAGetUserByWrongId() {
        response =given().when().get(notFoundUser);

    }

    @Then("Messege not found is displayed")
    public void MessegeNotFoundIsDisplayed() {
        response.then().assertThat().statusCode(404);
    }

    @When("I send a get list resource request")
    public void iSendAGetListResourceRequest() {
        response =given().when().get("https://reqres.in/api/unknown");

    }

    @Then("List is displayed")
    public void listIsDisplayed() {
        System.out.println(response.asString());
        response.then().assertThat().statusCode(200);
        response.then().assertThat().body("total_pages",equalTo(2));
        response.then().assertThat().body("data.name[1]",equalTo("fuchsia rose"));

        long time = response.getTime();
        System.out.println(time);
        org.testng.Assert.assertTrue(time<1600);
    }

    @When("I send a get single resource request")
    public void iSendAGetSingleResourceRequest() {
        response =given().when().get("https://reqres.in/api/unknown/2");
    }

    @Then("Resource is displayed")
    public void resourceIsDisplayed() {
        System.out.println(response.asString());
        response.then().assertThat().statusCode(200);
        response.then().assertThat().body("data.year",equalTo(2001));
    }

    @When("I send a get request")
    public void iSendAGetRequest() {
        response = given().when().get("https://reqres.in/api/users?page=2");
    }

    @Then("All users displayed")
    public void allUsersDisplayed() {
        int statusCode = response.getStatusCode();
        System.out.println("Print status code:--->" + statusCode);

        org.testng.Assert.assertEquals(statusCode, 200,
                "Correct status code returned");
        long time = response.getTime();
        System.out.println(time);
        org.testng.Assert.assertTrue(time < 2000);
        ResponseBody body = response.body();
        String bodyObj = body.asString();
        Assert.assertTrue(bodyObj.contains("page"));
        Assert.assertTrue(bodyObj.contains("per_page"));
        Assert.assertTrue(bodyObj.contains("total"));
        Assert.assertTrue(bodyObj.contains("total_pages"));
        Assert.assertTrue(bodyObj.contains("data"));

        Map<String, String> data = response.jsonPath().getMap("data[1]");
        System.out.println(data.get("first_name"));
        Assert.assertEquals(data.get("first_name"), "Lindsay");

    }
}
