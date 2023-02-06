package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONObject;
import org.junit.Assert;

import java.util.HashMap;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.given;

public class DemoQaAPISteps {
    private static final String USER_ID = "64f5906e-cd78-484a-a959-f21eac54400c";
    private static final String USERNAME = "Anto.Toni1234";
    private static final String PASSWORD = "Test@@123";
    private static final String BASE_URL = "https://bookstore.toolsqa.com";
    private static final String randomUsername = RandomStringUtils.randomAlphabetic(8);
    private static String token;
    private static Response response;
    private static String bookId;
    private static String newUserToken;
    public HashMap<Object, Object> map = new HashMap<Object, Object>();
    JSONObject requestParams = new JSONObject();
    private Object userId;

    @Before("not @tokenScenario")
    public void getToken(){
        RestAssured.baseURI = BASE_URL;
        map.put("userName", USERNAME);
        map.put("password", PASSWORD);
        response = given().contentType(ContentType.JSON).body(map)
                .when().post("/Account/v1/GenerateToken").then()
                .contentType(ContentType.JSON).extract().response();
        String jsonString = response.asString();
        token = JsonPath.from(jsonString).get("token");
    }
    @Given("General Url")
    public void generalUrl() {
        RestAssured.baseURI = BASE_URL;

    }

    @When("Generate token")
    public void generateToken() {
        RestAssured.baseURI = BASE_URL;
        map.put("userName", USERNAME);
        map.put("password", PASSWORD);
        response = given().contentType(ContentType.JSON).body(map)
                .when().post("/Account/v1/GenerateToken").then()
                .contentType(ContentType.JSON).extract().response();
        String jsonString = response.asString();
        token = JsonPath.from(jsonString).get("token");
    }

    @Then("Status code 200")
    public void statusCode() {

        Assert.assertEquals(200, response.getStatusCode());
    }

    //Authorize users test
    @Given("The endpoint is provided")
    public void theEndpointIsProvided() {
        basePath = "/Account/v1/Authorized";
    }

    @When("User is authorized")
    public void userIsAuthorized() {
        map.put("userName", USERNAME);
        map.put("password", PASSWORD);
        response = given().contentType(ContentType.JSON).body(map)
                .when().post().then().extract().response();
    }

    @Then("The body is printed and status code checked")
    public void theBodyIsPrintedAndStatusCodeChecked() {
        Assert.assertEquals(200, response.getStatusCode());
        response.then().log().body();
    }


    //Create user
    @Given("Provide the endpoint")
    public void provideTheEndpoint() {
        basePath = "/Account/v1/User";
    }

    @When("Create the user")
    public void createTheUser() {

        RequestSpecification request = RestAssured.given();
        map.put("userName", randomUsername);
        map.put("password", "Test@@123");
        response = given().contentType(ContentType.JSON).body(map)
                .when().post();
        this.userId = response.jsonPath().get("userID");
    }

    @Then("Print body and check status code")
    public void printBodyAndCheckStatusCode() {
        response.then().log().body();
        Assert.assertEquals(201, response.getStatusCode());
    }

    @And("Create new token for the user")
    public void createNewTokenForTheUser() {
        map.put("userName", randomUsername);
        map.put("password", "Test@@123");
        response = given().contentType(ContentType.JSON).body(map)
                .when().post(BASE_URL + "/Account/v1/GenerateToken").then().extract().response();
        String jsonString = response.asString();
        newUserToken = JsonPath.from(jsonString).get("token");
    }


    @When("Delete created user")
    public void deleteCreateUser() {
        RequestSpecification request = RestAssured.given();
        RestAssured.baseURI = BASE_URL;
        request.header("Authorization", "Bearer " + newUserToken)
                .header("Content-Type", "application/json");
        response = request.delete(BASE_URL + "/Account/v1/User/{userID}", userId);
    }

    @Then("Check if user is deleted")
    public void checkIfUserIsDeleted() {
        response.then().statusCode(204);
    }

    //UserCalledById
    @Given("Endpoint is provided and call is made")
    public void endpointIsProvidedAndCallIsMade() {
        response = given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .when()
                .get("/Account/v1/User/{userID}", USER_ID);
    }

    @When("Print Body")
    public void printBody() {
        response.then().log().body();
    }

    @Then("Check the status code and print body")
    public void checkTheStatusCodeAndPrintBody() {
        Assert.assertEquals(200, response.getStatusCode());
    }

    //print All books
    @Given("Provide endpoint")
    public void provideEndpoint() {
        RequestSpecification request = RestAssured.given();
        response = request.get("/BookStore/v1/Books");
    }

    @When("Print all the books")
    public void printAllBooks() {
        response.then().log().body();
    }

    @Then("Check status code")
    public void checkStatusCode() {
        Assert.assertEquals(200, response.getStatusCode());
    }

    //Get First book
    @Given("Endpoint provided and call is made")
    public void endpointProvidedAndCallIsMade() {
        response = given()
                .queryParam("ISBN", "9781449325862")
                .contentType(ContentType.JSON)
                .when()
                .get("/BookStore/v1/Book");
    }

    @When("Print the body")
    public void printTheBody() {
        response.then().log().body();
    }

    @Then("Check the status code")
    public void checkTheStatusCode() {
        Assert.assertEquals(200, response.getStatusCode());
    }


    @Given("Endpoint provided")
    public void endpointProvided() {
        RestAssured.baseURI = BASE_URL;
    }

    @When("Post request is sent  and book is added")
    public void postRequestIsSentAndBookIsAdded() {
        System.out.println(token);
        RequestSpecification request = RestAssured.given();
        bookId = "9781593277574";
        String body = """
                {
                  "userId": "%s",
                  "collectionOfIsbns": [
                    {
                      "isbn": "%s"
                    }
                  ]
                }
                """.formatted(USER_ID, bookId);
        request.header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");
        response = request.body(body)
                .post("/BookStore/v1/Books");
    }

    @Then("Status code is checked and body is printed")
    public void statusCodeIsCheckedAndBodyIsPrinted() {
        response.then().log().body();
        Assert.assertEquals(201, response.getStatusCode());
    }

    @When("Delete added book from collection")
    public void deleteAddedBookFromCollection() {

        map.put("isbn", bookId);
        map.put("userId", USER_ID);
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");
        response = request.body(map).delete("/BookStore/v1/Book");
    }

    @Then("Check deleted book")
    public void checkDeletedBook() {
        Assert.assertEquals(204, response.getStatusCode());
    }


    @Given("The put request is made and book is changed")
    public void thePutRequestIsMadeAndBookIsChanged() {
        map.put("userId", USER_ID);
        map.put("isbn", "9781491950296");
        bookId = "9781449337711";
        response =  given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON).body(map).when()
                .put("/BookStore/v1/Books/{ISBN}", bookId);

    }


    @When("Delete all books call")
    public void deleteAllBooksCall() {
        System.out.println(token);
        response = given().
                header("Authorization", "Bearer " + token)
                .queryParam("UserId", USER_ID)
                .contentType(ContentType.JSON)
                .when()
                .delete("/BookStore/v1/Books");

    }

    @Then("Check all books are deleted")
    public void checkAllBooksAreDeleted() {
        response.then().statusCode(204);
    }


    @When("Post request is sent  and {string} is added")
    public void postRequestIsSentAndIsAdded(String idBooks) {
        RequestSpecification request = RestAssured.given();
        bookId = idBooks;
        String body = """
                {
                  "userId": "%s",
                  "collectionOfIsbns": [
                    {
                      "isbn": "%s"
                    }
                  ]
                }
                """.formatted(USER_ID, bookId);
        request.header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");
        response = request.body(body)
                .post("/BookStore/v1/Books");
    }

    @Then("Check books are added")
    public void checkBooksAreAdded() {
        response.then().log().body();
    }
}
