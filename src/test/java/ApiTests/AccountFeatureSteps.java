package ApiTests;


import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;


import static io.restassured.RestAssured.given;

public class AccountFeatureSteps {

    private static Response response;
    public static String baseUrl = "https://demoqa.com/";

    @Given("I am on DemoQA")
    public void iAmOnDemoQA() {
        RestAssured.baseURI = baseUrl;
    }
    @When("I send a post request to create new user with username: {string} and password: {string}")
    public void iSendAPostRequestToCreateNewUserWithUsernameAndPassword(String username, String password) {
        String endpoint = baseUrl + "/Account/v1/User";
        JSONObject requestParams = new JSONObject();

        requestParams.put("userName", "Adelin");
        requestParams.put("password", "Test@123");

        response = given().contentType(ContentType.JSON).body(requestParams.toJSONString()).when().post(endpoint).then().contentType(ContentType.JSON).extract().response();
        System.out.println("Response body is: " + response.getBody().asString());
    }

    @Then("the response status code is {int}")
    public void theResponseStatusCodeIs(int statusCode) {
        RequestSpecification request = given();
        Response response = request.post("/Account/v1/User");

        int status = response.getStatusCode();
        System.out.println("Status code is: " + status);

    }





}
