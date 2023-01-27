package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
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

    @Then("response time is less than {int} milliseconds")
    public void responseTimeIsUnder(int responseTime) {
        Assert.assertTrue(responseTime > response.time());
    }

    @When("user sends a get request list resources for page {int}")
    public void userSendsAGetRequestForListResources(int pageNumber) {
        response = request.queryParam("page",pageNumber).get();
    }

    @Then("user receives number of page and is: {string}")
    public void userReceivesNumberOfPageIs(String pageNumber) {
        Assert.assertEquals(pageNumber, getJsonPath(response, "page"));
    }

    @Then("user receives number of users on this page and is: {string}")
    public void userReceivesNumberOfUsersOnThisPageIs(String numberOfUsersOnPage) {
        Assert.assertEquals(numberOfUsersOnPage,getJsonPath(response,"data.size()"));
    }

    @Then("user receives the total number of pages and is: {string}")
    public void userReceivesTheNumberOfPagesAndIs(String totalPages) {
        Assert.assertEquals(totalPages,getJsonPath(response,"total_pages"));
    }

    @When("user sends delete request for user number: {string}")
    public void userSendsDeleteRequestForUserNumber(String userNumber) {
        response = request.delete(userNumber);
    }

    @When("user sends post request with new name and job")
    public void userSendsPostRequestWith() {
        String body = """
            {
            "name": "Radu",
            "job": "Tech"
                }
            """;
        response = request.contentType(ContentType.JSON).body(body).post();
    }

}
