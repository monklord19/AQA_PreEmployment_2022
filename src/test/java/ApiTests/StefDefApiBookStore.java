package ApiTests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static com.thegoate.rest.RestResult.statusCode;
import static io.restassured.RestAssured.given;

public class StefDefApiBookStore {
    
    public Response response;
    public RequestSpecification request;
    String endpoint;



     

    @Given("User is on demoqa address")
    public  void userIsOnDemoqaAddress() {


//        RestAssured.baseURI = "";
//        request = given();


    }

    @When("User sends a get request")
    public void userSendsAGetRequest() {
        RequestSpecification httpRequest = given();
        response = httpRequest.request(Method.GET,"https://demoqa.com/BookStore/v1/Books");
        response.getStatusCode();
        response.getTime();

//        endpoint = "/BookStore/v1/Books";
//        response = (Response) given().when().get(baseURI+endpoint).then();

    }

    @Then("User receives status code {int}")
    public void userReceivesStatusCode(int arg0) {

//        int statusCode = response.getStatusCode;
        System.out.println("Response status code is" + statusCode);
        System.out.println("Response Body is =>  " + response.asString());

//        response.log().body();
//        response.assertThat().statusCode(200);


//        long statusReceived = 0;
//        Assert.assertEquals(statusReceived, response.getStatusCode());
    }
}