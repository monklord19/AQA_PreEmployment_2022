package apiSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class bookStoreApi {

    public static final String username = "Silviaa1";
    public static final String password = "Pass123#";
    public String userId = "4e52567d-9855-401e-820d-da982b6f3cdd";
    public static String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6IlN" +
            "pbHZpYWExIiwicGFzc3dvcmQiOiJQYXNzMTIzIyIsImlhdCI6" +
            "MTY3NTcyOTgzMH0.3D-vQ5rtzj-wYkiqgHSfQ_EGvTz_fuoFUSb9mQcR3K0";

    public static final String userBaseURL = "https://demoqa.com/Account/v1";
    public static final String bookStoreBaseURL = "https://demoqa.com/BookStore/v1";
    public Response response;
    public RequestSpecification request;
    public static Map<String, String> userPasswords = new HashMap<>();

    static{
        userPasswords.put("userName", username);
        userPasswords.put("password", password);
    }


    @When("The response is received")
    public void theResponseIsReceived(){
        response = RestAssured.get(bookStoreBaseURL + "/Books");
    }

    @Then("The response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int statusCode){
        Assert.assertEquals(response.getStatusCode(), statusCode);
    }

    @And("The response should contain a list of all books")
    public void theResponseShouldContainAListOfAllBooks(){
        response.then().log().body();
    }


    @When("I have a valid username and password and I make a post request")
    public void iHaveAValidUsernameAndPasswordAndIMakeAPostRequest(){
        RestAssured.baseURI = userBaseURL;
        response = RestAssured.given()
                .contentType("application/json")
                .body(userPasswords)
                .post("/GenerateToken");
    }

    @Then("I should receive a response with a valid token")
    public void iShouldReceiveAResponseWithAValidToken(){
        response.then().statusCode(200);
        token = response.jsonPath().getString("token");
        System.out.println("Token: " + token);


    }


    @And("I should have status code {int}")
    public void iShouldHaveStatusCode(int statusCode){
        given().get(userBaseURL + "/GenerateToken").then().assertThat().statusCode(statusCode);
    }

    @Given("I have a valid token")
    public void iHaveAValidToken(){
        System.out.println("Token=" + " " + token);
        System.out.println("userId=" + " " + userId);

    }

    @When("I make a POST request to with my token")
    public void iMakeAPOSTRequestToWithMyToken(){

        given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get(userBaseURL + "/Authorized")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Then("I should receive a response indicating that I am authorized")
    public void iShouldReceiveAResponseIndicatingThatIAmAuthorized(){
    }

    @And("Status code should be {int}")
    public void statusCodeShouldBe(int arg0){
    }


    @Given("I set the API endpoint as {string}")
    public void iSetTheAPIEndpointAs(String endpoint){
        RestAssured.baseURI = bookStoreBaseURL + endpoint;
        request = RestAssured.given();
    }

    @When("I send a GET request with ISBN as {string}")
    public void iSendAGETRequestWithISBNAs(String isbn){
        response = request.param("ISBN", isbn).get();
    }

    @Then("I should receive a {int} status code for it")
    public void iShouldReceiveAStatusCodeForIt(int statusCode){
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(actualStatusCode, statusCode);
    }

    @And("The response body should contain the book details with ISBN {string}")
    public void theResponseBodyShouldContainTheBookDetailsWithISBN(String ISBN){
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains(ISBN));
        response.then().log().body();
    }


    @When("I send a POST request to {string}")
    public void iSendAPOSTRequestTo(String url){
        RestAssured.baseURI = "https://demoqa.com/Account/v1/User";

        String payload = "{\"userName\":\"" + userPasswords.get("userName") + "\",\"password\":\"" + userPasswords.get("password") + "\"}";

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(payload)
                .post();

        int statusCode = response.getStatusCode();
        System.out.println("Status code: " + statusCode);

        String responseBody = response.getBody().asString();
        System.out.println("Response body: " + responseBody);

        JsonPath jsonPath = new JsonPath(responseBody);
        userId = jsonPath.getString("userID");
    }

    @Then("The response status code for it should be {int}")
    public void theResponseStatusCodeForItShouldBe(int statusCode){
        int statusCode1 = response.getStatusCode();
        Assert.assertEquals(statusCode, statusCode1);

    }

    @And("The response body should contain the created user details")
    public void theResponseBodyShouldContainTheCreatedUserDetails(){

    }


    @When("I send a GET request")
    public void iSendAGETRequest(){
        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get(userBaseURL + "/User/" + userId)
                .then()
                .extract()
                .response();


        int statusCode = response.getStatusCode();
        assert statusCode == 200;
        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);
    }

    @And("The response body should contain the user information")
    public void theResponseBodyShouldContainTheUserInformation(){
        System.out.println("Response Body: ");
    }

    @Then("The response code should be {int}")
    public void theResponseCodeShouldBe(int status){
        //int statusCode = response.getStatusCode();
        //assert statusCode == status;

        System.out.println("Response Body: ");
    }

    @When("I send a DELETE request")
    public void iSendADELETERequest(){
        RequestSpecification request = RestAssured.given();
        RestAssured.baseURI = userBaseURL;
        request.header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");
        response = request.delete(userBaseURL + "/User/{userID}", userId);
    }

    @Then("The response status for it code should be {int}")
    public void theResponseStatusForItCodeShouldBe(int statusCode){
        response.then().statusCode(statusCode);
    }

    @And("The response body should contain a success message indicating that the user was deleted")
    public void theResponseBodyShouldContainASuccessMessageIndicatingThatTheUserWasDeleted(){
        response.then().statusCode(200);
        Assert.assertThat(response.jsonPath().getString("message"), equalTo("User deleted successfully"));
    }

    @When("The user adds {string} book to their list")
    public void theUserAddsBookToTheirList(String isbn){
        RequestSpecification request = RestAssured.given();
        String body = """
                {
                  "userId": "%s",
                  "collectionOfIsbns": [
                    {
                      "isbn": "%s"
                    }
                  ]
                }
                """.formatted(userId, isbn);
        request.header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");
        response = request.body(body)
                .post(bookStoreBaseURL + "/Books");
    }

    @Then("The book should be added to the user's list with status code {int}")
    public void theBookShouldBeAddedToTheUserSListWithStatusCode(int statusCode){
        response.then().log().body();
        Assert.assertEquals(statusCode, response.getStatusCode());
    }

    @When("I delete {string} book from the user's list")
    public void iDeleteBookFromTheUserSList(String isbn){
        String body = """
                {
                  "isbn": "%s",
                  "userId": "%s"
                }
                """.formatted(isbn, userId);

        response = (Response) RestAssured.given().
                header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .delete("/Book")
                .then()
                .statusCode(204)
                .log()
                .body();
    }

    @Then("The book should be deleted from user's list")
    public void theBookShouldBeDeletedFromUserSList(){
        response.then().log().body();
        Assert.assertEquals(204, response.getStatusCode());
    }

    @When("I delete all books from user's list")
    public void iDeleteAllBooksFromUserSList(){
        RequestSpecification request = RestAssured.given();
        response = request.
                accept("accept: application/json").
                header("Authorization", "Bearer " + token).
                queryParam("UserId", userId).
                when().
                delete(bookStoreBaseURL + "/Books/");
    }

    @Then("The books shouldn't be on his list anymore")
    public void theBooksShouldnTBeOnHisListAnymore(){
        response.then().log().body();
        Assert.assertEquals(204, response.getStatusCode());
    }
}
