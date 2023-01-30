package Steps;

import PageObjects.ReqresPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class ReqresDefs {
    ReqresPage reqresPage;
    SingletonClass singleton = SingletonClass.getInstance();
    WebDriver driver = singleton.getDriver();
    public static final String BASE_URL = "https://reqres.in/";
    public static final String BASE_PATH = "/api";
    static RequestSpecification request;
    private Response response;

    @Before
    public void setUpReqres() {
        reqresPage = new ReqresPage(driver);
    }

    @After
    public void tearDownReqres() {
        driver.quit();
    }

    @Given("On API address")
    public void apiAddress(){
        RestAssured.baseURI = BASE_URL;
        RestAssured.basePath = BASE_PATH;
        request = RestAssured.given();
    }

    @When("Send a get request for page 2")
    public void userSendsGetRequestPage2(){
        response = request.get("/users?page=2");
        String responseBody = response.getBody().asString();
        System.out.println(responseBody);
    }

    @When("Sends a get request for the second user")
    public void userSendsGetRequestSecondUser() {
        response = request.get("/users/2");
        String responseBody = response.getBody().asString();
        System.out.println(responseBody);
    }

    @And("Check number of properties in the 'data' object")
    public void checkNumberOfDataInSupportObject(){
        JsonPath jsonPath = response.jsonPath();
        Map<String, ?> data = jsonPath.get("data");
        Assert.assertEquals(2, data.size());
    }

    @And("Check number of properties in the 'support' object")
    public void checkNumberOfPropertiesInSupportObject(){
        JsonPath jsonPath = response.jsonPath();
        Map<String, ?> support = jsonPath.get("support");
        Assert.assertEquals(2, support.size());
    }

    @Then("Receive status code {int} and the response time")
    public void statusCode(int status){
        Assert.assertEquals(status,response.getStatusCode());
        System.out.println(status);
        long responseTime = response.getTime();
        System.out.println("Response Time: " + responseTime + "ms");
    }

    @When("Send a get request for the no. 23 user")
    public void userSendsGetRequestNo23User(){
        response = request.get("/users/23");
        String responseBody = response.getBody().asString();
        System.out.println(responseBody);
    }

    @When("Send a get request for unknown page")
    public void userSendsGetRequestUnknownPage(){
        response = request.get("/unknown");
        String responseBody = response.getBody().asString();
        System.out.println(responseBody);
    }

    @And("Check number of values")
    public void checkNumberOfValues(){
        JsonPath jsonPath = response.jsonPath();
        int numberOfValues = jsonPath.getList("data").size();
        Assert.assertTrue(numberOfValues > 0);
        System.out.println(numberOfValues);
    }

    @When("Send a get request for unknown page for id 2")
    public void userSendsGetRequestUnknownPageId2(){
        response = request.get("/unknown/2");
        String responseBody = response.getBody().asString();
        System.out.println(responseBody);
        JsonPath jsonPath = response.jsonPath();
        boolean dataExists = jsonPath.get("data").toString().contains("id");
        Assert.assertTrue(dataExists);
    }

    @And("Check number of id properties")
    public void checkNumberOfIdProperties(){
        String responseBody = response.getBody().asString();
        JsonPath jsonPath = new JsonPath(responseBody);
        Assert.assertTrue(jsonPath.get("data").toString().length() > 0);
        Assert.assertEquals(1, jsonPath.getMap("data").keySet().stream().filter(key -> key.equals("id")).count());
    }

    @When("Send a get request for unknown page for id 23")
    public void userSendsGetRequestUnknownPageId23(){
        response = request.get("/unknown/23");
        String responseBody = response.getBody().asString();
        System.out.println(responseBody);
    }

    @And("Check data")
    public void checkData() {
        if (response.jsonPath().get("data") != null) {
            System.out.println("Data exists in the response");
        } else {
            System.out.println("Data does not exist in the response");
        }
    }

    @When("Send a post request for name and job")
    public void sendPostRequest(){
        request.header("Content-Type", "application/json");
        request.body("{\"name\":\"morpheus" + "\",\"job\":\"leader\"}");
        response = request.post("/users");
    }

    @And("Response body should contains name, job, id and createdAt")
    public void responseBody(){
        JsonPath jsonPathEvaluator = response.jsonPath();
        System.out.println("Response body: " + response.getBody().asString());
        Assert.assertNotNull(jsonPathEvaluator.get("name"));
        Assert.assertNotNull(jsonPathEvaluator.get("job"));
        Assert.assertNotNull(jsonPathEvaluator.get("id"));
        Assert.assertNotNull(jsonPathEvaluator.get("createdAt"));
    }

    @When("Send a put request for name and job")
    public void updateRequestByPut(){
        request.header("Content-Type", "application/json");
        request.body("{\"name\":\"morpheus" + "\",\"job\":\"zion resident\"}");
        response = request.put("/users/2");
    }

    @And("Response body should contains name, job and createdAt")
    public void responseUpdateBody(){
        JsonPath jsonPathEvaluator = response.jsonPath();
        System.out.println("Response body: " + response.getBody().asString());
        Assert.assertNotNull(jsonPathEvaluator.get("name"));
        Assert.assertNotNull(jsonPathEvaluator.get("job"));
        Assert.assertNotNull(jsonPathEvaluator.get("updatedAt"));
    }

    @When("Send a patch request for name and job")
    public void patchRequestByPatch(){
        request.header("Content-Type", "application/json");
        request.body("{\"name\":\"morpheus" + "\",\"job\":\"zion resident\"}");
        response = request.patch("/users/2");
    }

    @When("Send a delete request to an API")
    public void deleteRequest(){
        request.header("Content-Type", "application/json");
        response = request.delete("/users/2");
    }

    @When("Send register request to an API")
    public void registerRequest(){
        request.header("Content-Type", "application/json");
        request.body("{\"email\":\"eve.holt@reqres.in" + "\",\"password\":\"pistol\"}");
        response = request.post("/register");
    }

    @And("Check body if contains id and token")
    public void checkBody(){
        request.header("Content-Type", "application/json");
        request.body("{\"id\":\"4" + "\",\"token\":\"QpwL5tke4Pnpja7X4\"}");
        response = request.get("/register");
    }

    @When("Send a register request without password to an API")
    public void registerRequestWihoutPassword(){
        request.header("Content-Type", "application/json");
        request.body("{\"email\":\"sydney@fife\"}");
        response = request.post("/register");
    }

    @When("Send a login request to an API")
    public void loginRequest(){
        request.header("Content-Type", "application/json");
        request.body("{\"email\":\"eve.holt@reqres.in" + "\",\"password\":\"cityslicka\"}");
        response = request.post("/login");
    }

    @When("Send a login request without password to an API")
    public void loginRequestWithoutPassword(){
        request.header("Content-Type", "application/json");
        request.body("{\"email\":\"sydney@fife\"}");
        response = request.post("/login");
    }

    @When("Send a get request to an delayed API")
    public void delayedResponseRequest(){
        response = request.get("/users?delay=3");
        String responseBody = response.getBody().asString();
        System.out.println(responseBody);
    }

    @Then("Receive status code {int} and the delayed response time")
    public void statusAndDelayedResponseTime(int status){
        Assert.assertEquals(status,response.getStatusCode());
        System.out.println(status);
        long expectedResponseTime = 200;
        long actualResponseTime = response.getTime();
        Assert.assertTrue(actualResponseTime > expectedResponseTime);
        System.out.println("Response Time: " + actualResponseTime + "ms");
    }
}


