package MyStepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class ApiAccountBookStoreStepDef {

    public Response response;
    public RequestSpecification request;
    String endpoint;




    @Given("User is on demoqa address")
    public void userIsOnDemoqaAddress() {


        RestAssured.baseURI = "https://demoqa.com";
        request = given();
    }



    @When("User sends a post request for new user as username:{string} and password:{string}")
    public void userSendsAPostRequestForNewUserAsUsernameAndPassword(String username, String password) {
        endpoint = "/Account/v1/";
        String body = """
                {
                  "userName": "Anto",
                  "password": "mures"
                }
                """;
         given().contentType(ContentType.JSON).body(body).when().post("/User1207").then().log().body().statusCode(201);


//        RestAssured.baseURI ="https://demoqa.com/Account/v1";
//        RequestSpecification request = RestAssured.given();
//        JSONObject requestParams = new JSONObject();
//        requestParams.put("userName", "Anto");
//        requestParams.put("password", "mures");
//        request.body(requestParams.toJSONString());
//        Response response = request.put("/User");
//        ResponseBody body = response.getBody();
//        System.out.println(response.getStatusLine());
//        System.out.println(body.asString());

    }

    @When("User sends post request to generate token with valid credentials")
    public void userSendsPostRequestToGenerateTokenWithValidCredentials() {
        endpoint = "/Account/v1/";
        String body = """
                {
                  "userName": "Anto",
                  "password": "mures"
                }
                """;
        given().contentType(ContentType.JSON).body(body).when().post("/token").then().log().body().statusCode(200);

    }


    @When("User sends post request authorized")
    public void userSendsPostRequestAuthorized() {
        String body = """
                {
                  "userName": "Anto",
                  "password": "mures"
                }
                """;
        given().contentType(ContentType.JSON).body(body).when().post("Authorization 10").then().log().body().statusCode(200);

    }

    @When("User send  delete account")
    public void userSendDeleteAccount() {

        given().header("Authorization 10", "token").contentType(ContentType.JSON).when().delete("/Account/v1/User"+"user1207").then().log().body().statusCode(204);
    }
    @Then("User receives status code {int}")
    public void userReceivesStatusCode(int arg0) {


        int statusCode = response.getStatusCode();
        System.out.println("Response status code is" + statusCode);
        System.out.println("Response Body is =>  " + response.asString());
        System.out.println("Time" + response.getTime());
        System.out.println("Line" + response.getStatusLine());

        Headers header = response.getHeaders();
        System.out.println("Headers for Response are" + header);

        Assert.assertEquals(String.valueOf(statusCode) /*actual value*/, 200 /*expected value*/, "Correct status code returned");

//        response.log().body();
//        response.assertThat().statusCode(200);

//        long statusReceived = 0;
//        Assert.assertEquals(statusReceived, response.getStatusCode());
    }
}


