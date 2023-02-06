package apisteps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.Assert;
import java.util.ArrayList;
import static io.restassured.RestAssured.given;
import static apisteps.AccountApiSteps.userBookList;
import static apisteps.AccountApiSteps.token;
import static apisteps.AccountApiSteps.userID;
import static apisteps.AccountApiSteps.response;
import static org.hamcrest.Matchers.*;


public class BookStoreApiSteps {
    public static ArrayList bookList;

    @When("send a GET request for list of books")
    public void sendGETListBooks() {
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get("/BookStore/v1/Books")
                .then()
                .statusCode(200)
                .log()
                .body();

        bookList = response.extract().path("books.isbn");
    }

    @Then("number of books is: {int}")
    public void numberOfBooksIs(int numberBooks) {
        response.assertThat().body("books.size()", equalTo(numberBooks));

    }

    @When("send a GET request for book no.{int}")
    public void sendGETForOfABook(int bookNo) {
        String isbnBookNo = bookList.get(bookNo - 1).toString();
        response = given()
                .queryParam("ISBN", isbnBookNo)
                .contentType(ContentType.JSON)
                .when()
                .get("/BookStore/v1/Book")
                .then()
                .statusCode(200)
                .log()
                .body();

    }

    @When("send a POST request for adding book no.{int} on users list")
    public void sendPOSTAddingBookOnUsersList(int bookNo) {
        String isbnBookNo = bookList.get(bookNo - 1).toString();
        String body = """
                {
                  "userId": "%s",
                  "collectionOfIsbns": [
                    {
                      "isbn": "%s"
                    }
                  ]
                }
                """.formatted(userID, isbnBookNo);
        response = given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/BookStore/v1/Books")
                .then()
                .statusCode(201)
                .log()
                .body();
    }

    @When("send a DELETE request for book no.{int} from user list")
    public void sendDELETERequestForBook(int bookNo) {
        String isbnBookNo = userBookList.get(bookNo - 1).toString();
        String body = """
                {
                  "isbn": "%s",
                  "userId": "%s"
                }
                """.formatted(isbnBookNo, userID);
        response = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .delete("/BookStore/v1/Book")
                .then()
                .statusCode(204)
                .log()
                .body();
    }

    @When("send a PUT request for replacing book no.{int} from user books list with book no.{int} from book store books list")
    public void sendPUTRequestForBook(int userBookNoToReplace, int bookNo) {
        String isbnBookNoToReplace = userBookList.get(userBookNoToReplace - 1).toString();
        String isbnBookNo = bookList.get(bookNo - 1).toString();
        String body = """
                {
                  "userId": "%s",
                  "isbn": "%s"
                }
                """.formatted(userID, isbnBookNo);
        response = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .put("/BookStore/v1/Books/{isbnBookNoToReplace}", isbnBookNoToReplace)
                .then()
                .statusCode(200)
                .log()
                .body();
    }

    @When("send a DELETE request for all books from user list")
    public void sendDELETEAllBooksFromUserList() {
        response = RestAssured.given()
                .queryParam("UserId", userID)
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .when()
                .delete("/BookStore/v1/Books")
                .then()
                .statusCode(204)
                .log()
                .body();
    }
    @When("{string} not present in user's book list")
    public void valueNotPresentInList(String value){
        ArrayList list = response.extract().path("books.title");
        Assert.assertFalse(list.contains(value));

    }
    @When("{string} is present in user's book list")
    public void valueIsPresentInList(String value){
        ArrayList list = response.extract().path("books.title");
        Assert.assertTrue(list.contains(value));

    }

}
