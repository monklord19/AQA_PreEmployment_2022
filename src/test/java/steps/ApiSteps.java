package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;


public class ApiSteps {
    public static final String BASE_URL = "https://reqres.in";
    public static final String BASE_PATH_USERS = "/api/users/";
    public static RequestSpecification request;
    public Response response;

    @Given("user is on API address")
    public static void setup() {
        RestAssured.baseURI = BASE_URL;
        RestAssured.basePath = BASE_PATH_USERS;
        request = RestAssured.given();
    }

    public String getJsonPath(Response response, String key) {
        String resp = response.asString();
        JsonPath js = new JsonPath(resp);
        return js.get(key).toString();
    }

    @When("user sends a get request for user {string}")
    public void userSendsAGetRequestForTheSecondUser(String userNumber) {
        response = request.get(userNumber);
    }

    @Then("user receives status code {int}")
    public void userReceivesStatusCode(int statusReceived) {
        Assert.assertEquals(statusReceived, response.getStatusCode());
    }

    @Then("user receives first name:{string}")
    public void userReceivesLastName(String firstName) {
        Assert.assertEquals(firstName, getJsonPath(response, "data.first_name"));
    }

    @Then("user receives last name:{string}")
    public void userReceivesLastNameWeaver(String lastName) {
        Assert.assertEquals(lastName, getJsonPath(response, "data.last_name"));
    }

    @Then("user receives id:{string}")
    public void userReceivesId(String id) {
        Assert.assertEquals(id, getJsonPath(response, "data.id"));
    }

    @Then("user receives email:{string}")
    public void userReceivesEmailJanetWeaverReqresIn(String emailAddress) {
        Assert.assertEquals(emailAddress, getJsonPath(response, "data.email"));
    }

    @Then("response time is less than {int} miliseconds")
    public void responseTimeIsUnder(int responseTime) {
        Assert.assertTrue(responseTime > response.time());
    }

}
