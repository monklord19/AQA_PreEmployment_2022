package ApiTests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import java.util.ArrayList;

import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;


public class BookStoreApiSteps {
    public static final String BASE_URI = "https://demoqa.com/";
    public static final String BASE_PATH_BOOKSTORE_V1 = "/BookStore/v1/";
    public static ValidatableResponse response;
    private static String userID;
    private static String token;
    private static String isbnBook;
    private static ArrayList books;

    @Given("set base URI and PATH book store")
    public static void setup() {
        RestAssured.baseURI = BASE_URI;
        RestAssured.basePath = BASE_PATH_BOOKSTORE_V1;
    }

    @When("send POST request for registration of new user with username: {string} and password: {string}")
    public void sendPOSTRegistrationNewUser(String username, String password) {
        String body = """
                {
                  "userName": "%s",
                  "password": "%s"
                }
                """.formatted(username, password);
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("https://demoqa.com/Account/v1/User")
                .then()
                .log()
                .body();
        userID = response.extract().path("userID").toString();
    }

    @When("send POST request to generate token a for user with username: {string} and password: {string}")
    public void sendPOSTGenerateToken(String username, String password) {
        String body = """
                {
                  "userName": "%s",
                  "password": "%s"
                }
                """.formatted(username, password);
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("https://demoqa.com/Account/v1/GenerateToken")
                .then()
                .log()
                .body();
        token = response.extract().path("token").toString();
    }

    @When("send a GET request for list of books")
    public void sendGETListBooks() {
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get("/Books")
                .then()
                .log()
                .body();

        books = response.extract().path("books.isbn");
    }

    @Then("number of books is: {int}")
    public void numberOfBooksIs(int numberBooks) {
        response.assertThat().body("books.size()", equalTo(numberBooks));

    }

    @Then("status code is: {int}")
    public void userReceivesStatusCode(int statusCode) {
        response.statusCode(statusCode);
    }

    @When("send a GET request for book no.{int}")
    public void sendGETForOfABook(int bookNo) {
        String isbnBookNo = books.get(bookNo - 1).toString();
        response = given()
                .queryParam("ISBN", isbnBookNo)
                .contentType(ContentType.JSON)
                .when()
                .get("/Book")
                .then()
                .log()
                .body();
    }

    @When("send a POST request for adding book no.{int} on users list")
    public void sendPOSTAddingBookOnUsersList(int bookNo) {
        String isbnBookNo = books.get(bookNo - 1).toString();
        String body = """
                {
                  "userId": "userID",
                  "collectionOfIsbns": [
                    {
                      "isbn": "isbnBook"
                    }
                  ]
                }
                """.replace("userID", userID).replace("isbnBook", isbnBookNo);
        response = given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/Books")
                .then()
                .log()
                .body();
        System.out.println(body);
    }


}
