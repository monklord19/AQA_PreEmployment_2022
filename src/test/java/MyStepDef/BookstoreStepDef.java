package MyStepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponseOptions;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.ArrayList;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class BookstoreStepDef {


    public Response response;
    public RequestSpecification request;
    String endpoint;
    private static String userId;
    private static String token;
    private static String isbnBook;

    private static ArrayList books;


    @Given("User is on demoqa addres")
    public void userIsOnDemoqaAddres() {


        RestAssured.baseURI = "https://demoqa.com";
        request = given();
        endpoint = "BookStore/v1/Books";
    }

    @When("User sends a get request")
    public void userSendsAGetRequest() {
        RequestSpecification httpRequest = given();
        response = httpRequest.request(Method.GET, "https://demoqa.com/BookStore/v1/Books");
        response.getStatusCode();
        response.getTime();
        response.getBody().asString();
        response.getStatusLine();


//        endpoint = "/BookStore/v1/Books";
//        response = (Response) given().when().get(baseURI+endpoint).then();

    }

    @Then("User receives status cod {int}")
    public void userReceivesStatusCod(int arg0) {


        int statusCod = response.getStatusCode();
        System.out.println("Response status code is" + statusCod);
        System.out.println("Response Body is =>  " + response.asString());
        System.out.println("Time" + response.getTime());
        System.out.println("Line" + response.getStatusLine());

        Headers header = response.getHeaders();
        System.out.println("Headers for Response are" + header);

        Assert.assertEquals(String.valueOf(statusCod) /*actual value*/, 200 /*expected value*/, "Correct status code returned");

//        response.log().body();
//        response.assertThat().statusCode(200);

        long statusReceived = 0;
        Assert.assertEquals(statusReceived, response.getStatusCode());

    }


    @When("User sends request list of books")
    public void userSendsRequestListOfBooks() {


        String body = """
                {
                  "userName": "me123",
                  "password": "1234"
                }
                """;
        given().contentType(ContentType.JSON).body(body).when().post("https://demoqa.com/Account/v1/GenerateToken").then().log().body();

        given().contentType(ContentType.JSON).when().get("books.isbn").then().log().body();


    }

    @Then("User receives no books")
    public void userReceivesNoBooks() {
        assertThat().body("books.size()", equalTo("number Books"));
    }

    private ValidatableResponseOptions assertThat() {
        return null;
    }


    @When("send POST request to generate token a for user with username: {string} and password: {string}")
    public void sendPOSTRequestToGenerateTokenAForUserWithUsernameMeAndPassword(String username, String password) {

        String body = """
                {
                  "username": "me123",
                  "password": "1234"
                }
                """;
        response = (Response) RestAssured.given().contentType(ContentType.JSON).body(body).when().post("https://demoqa.com/Account/v1/User")
                .then()
                .log()
                .body();
        String responseBody = response.getBody().asString();
        String userID = get("/person").path("person.userId");
//        String user_Id = given().when().then().extract().path("user_id");
//        RestAssured assertThat = new RestAssured();
//        when().then().extract().jsonPath().getLong("user_id"), equalTo(userId);


    }

    @When("User wants to add book number {int}")
    public void userWantsToAddBookNo(int bookNumber) {
        String isbnBookNumber = books.get(bookNumber - 1).toString();
        response = (Response) given()
                .queryParam("ISBN", "9781449365035", isbnBookNumber)
                .contentType(ContentType.JSON)
                .when()
                .get("/Book")
                .then()
                .log()
                .body();


    }

    @When("User sends post request  to add book")
    public void userSendsPostRequestToAddBook() {
        String body = """
                            {
                              "userId": "userID",
                              "collectionOfIsbns": [
                                {
                                  "isbn": "9781491950296
                                }
                    ]
                }
                """;
        given().header("Authorization10","Bearer" + token).contentType(ContentType.JSON).request().body(body)
                .when().post("Books").then().log().body();
        System.out.println("Status code is"+response.getStatusCode());


    }

    @When("User sends put request to add book no {int}")
    public void userSendsPutRequestToAddBookNo(int bookNo) {
        String bodynew = """
                            {
                              "userId": "userID",
                              "collectionOfIsbns": [
                                {
                                  "isbn": "9781491950296
                                }
                    ]
                }
                """;
        response= request.body(bodynew).put("/BookStore/v1/Books/9781449325862");
        given().header("Authorization", "Bearer " + token).contentType(ContentType.JSON).body(bodynew)
                .when()
                .post("/Books")
                .then()
                .log()
                .body();
        System.out.println("Status code is"+response.getStatusCode());
//        Assertions.assertEquals(201,response.getStatusCode());
        response.then().assertThat().statusCode(201);


    }
}