package ApiTests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class DemoqaApiTests {
    @Test
    public void createUserPost() {
        RestAssured.baseURI = "http://bookstore.toolsqa.com";

        String credentiale = "{\r\n" +
                "   \"userName\": \"Test102\", \r\n" +
                "   \"password\": \"Testing1!\"\r\n" +
                "}";
        RequestSpecification httpReq = RestAssured.given();
        httpReq.header("Content-Type", "application/json");
        Response response = httpReq.body(credentiale).post("/Account/v1/User");
        int statusCode = response.getStatusCode();
        System.out.println("Status primit " + statusCode);
    }

    //Backend calls Proiect2022
    private static final String user_id = "36ba87c3-66aa-47ab-84da-d1d163748251";
    private static final String username = "test33";
    private static final String password = "Testing1!";
    private static final String base_url = "https://demoqa.com";
    public static String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6InRlc3QzMyIsInBhc3N3b3JkIjoiVGVzdGluZzEhIiwiaWF0IjoxNjc1NzY1NzMzfQ.HyP9yMibAw4FTVUINaYXVeHk7fYu10Aco2tWcvdlWtE";
    public static Response response;
    public static String jsonString;
    public static String book_Id;

    @Given("User is on homepage")
    public void homepage() {
        RestAssured.baseURI = base_url;
    }

    @When("User inputs valid credentials and generates token")
    public void inputCreds() {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        response = request.body("{ \"userName\":\"" + username + "\", \"password\":\"" + password + "\"}")
                .post("/Account/v1/GenerateToken");
    }

    @Then("User should be authorized")
    public void authorizedUser() {
        int statusCode = response.getStatusCode();
        System.out.println("Status primit " + response.getStatusLine());
        Assert.assertEquals(statusCode, 200);
    }

    //GET all books
    @When("Gets all the books")
    public void allTheBooks() {
        RestAssured.baseURI = base_url;
        RequestSpecification request = RestAssured.given();
        response = request.get("/BookStore/v1/Books");
        System.out.println(response.prettyPrint());
    }

    @Then("All the books should be displayed")
    public void allBooksAreDisplayed() {
        jsonString = response.asString();
        List<Map<String, String>> books = JsonPath.from(jsonString).get("books");
        Assert.assertTrue(books.size() > 0);
        book_Id = books.get(0).get("isbn");

        int statusCode = response.getStatusCode();
        System.out.println("Status primit " + response.getStatusLine());
        Assert.assertEquals(statusCode, 200);
    }

    //POST a book
    @When("User adds a book")
    public void addAbook() {
        RestAssured.baseURI = base_url;
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");

        response = request.body("{ \"userId\": \"" + user_id + "\", " +
                        "\"collectionOfIsbns\": [ { \"isbn\": \"" + book_Id + "\" } ]}")
                .post("/BookStore/v1/Books");
        System.out.println("Status primit " + response.getStatusLine());
        Assert.assertEquals(201, response.getStatusCode());
    }

    @Then("The book should be added")
    public void assertStatusCode() {
    }

    //DELETE books
    @When("User deletes books")
    public void deleteBooks() {
        RestAssured.baseURI = base_url;
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");
        response = request.body("{ \"userId\": \"" + user_id + "\", " +
                        "\"collectionOfIsbns\": [ { \"isbn\": \"" + book_Id + "\" } ]}")
                .delete("/BookStore/v1/Books");
    }

    @Then("The books should be deleted")
    public void assertDeletedBooks() {
        System.out.println("Status primit " + response.getStatusLine());
        Assert.assertEquals(204, response.getStatusCode());
    }

    //GET a book
    @When("User gets a specific book")
    public void getAbook() {
        RequestSpecification request = RestAssured.given();
        response = request.get("/BookStore/v1/Book?ISBN=9781449325862");
        System.out.println(response.prettyPrint());
    }

    @Then("Book information should be displayed")
    public void getBook() {
        int statusCode = response.getStatusCode();
        System.out.println("Status primit " + response.getStatusLine());
        Assert.assertEquals(statusCode, 200);
    }

    //DELETE a book
    @When("User removes a book")
    public void deleteAbook() {
        RestAssured.baseURI = base_url;
        RequestSpecification request = RestAssured.given();

        request.header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");

        response = request.body("{ \"isbn\": \"" + book_Id + "\", \"userId\": \"" + user_id + "\"}")
                .delete("/BookStore/v1/Book");
    }

    @Then("The book should be removed")
    public void assertBookRemoved() {
        RequestSpecification request = RestAssured.given();

        request.header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");

        response = request.get("/Account/v1/User/" + user_id);
        Assert.assertEquals(204, response.getStatusCode());

        jsonString = response.asString();
        List<Map<String, String>> booksOfUser = JsonPath.from(jsonString).get("books");
        Assert.assertEquals(0, booksOfUser.size());
    }

    //PUT a book
    @When("User updates a book")
    public void updateBook() {
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");

        response = request.body("{ \"isbn\": \"" + "\", \"userId\": \"" + user_id + "\"}")
                .put("/BookStore/v1/Books/9781449325862");
    }

    @Then("The book should be updated")
    public void updatedBook() {
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }
}