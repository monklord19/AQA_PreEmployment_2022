package Steps;

import Config.PropertyFile;
import PageObjects.BookStoreApiPage;
import com.google.gson.Gson;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertFalse;


public class BookStoreApiDefs {
    BookStoreApiPage bookStoreApiPage;
    SingletonClass singleton = SingletonClass.getInstance();
    WebDriver driver = singleton.getDriver();
    public static final String BASE_URL = "https://demoqa.com";
    public static final String BASE_PATH = "/BookStore";
    static RequestSpecification request;
    private Response response;
    private String userID;
    private String randomEndpointUserName;
    private static String jsonString;
    private static String bookId;
    PropertyFile pfe = new PropertyFile();
    String username = pfe.getUsername();
    String password = pfe.getPassword();

    @Before
        public void setupBookStoreApiDefs(){
            driver.manage().window().maximize();
            bookStoreApiPage = new BookStoreApiPage(driver);
        }

    @After
    public void tearDownBookStoreApiDefs() {
        driver.quit();
    }

    @Given("DemoQA login page")
    public void loginPage(){
        driver.get("https://demoqa.com/login");
    }

    @When("User is created and logged in via API")
    public void userIsCreatedAndLoggedIn() {
        Gson gson = new Gson();
        String body = "{\"userName\":\"" + username + "\",\"password\":\"" + password + "\"}";
        String responseCreateUser = given().body(body).contentType(bookStoreApiPage.contentType()).when().post(bookStoreApiPage.endpointCreateUser()).thenReturn().asString();
        Map<String, Object> mapCreateUser = gson.fromJson(responseCreateUser, Map.class);
        assertFalse(mapCreateUser.containsKey("code"));
        for (Map.Entry<String, Object> entry : mapCreateUser.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        userID = (String) mapCreateUser.get("userID");
    }

    @Then("User has token and authorized")
    public void userHasTokenAndAuthenticated() {
        Gson gson = new Gson();
        String body = "{\"userName\":\"" + username + "\",\"password\":\"" + password + "\"}";
        String responseGenerateToken = given().body(body).contentType(bookStoreApiPage.contentType()).when().post(bookStoreApiPage.endpointGenerateToken()).thenReturn().asString();
        String responseAuthorized = given().body(body).contentType(bookStoreApiPage.contentType()).when().post(bookStoreApiPage.endpointAuthorize()).thenReturn().asString();
        Boolean userIsAuthorized = gson.fromJson(responseAuthorized, Boolean.class);
        Assert.assertTrue(userIsAuthorized);
    }

    @And("User is deleted via API")
    public void deleteUserViaApi(){
        String body = "{\"userName\":\"" + username + "\",\"password\":\"" + password + "\"}";
        String basicAuth = Base64.getEncoder().encodeToString((username + ":" + password).getBytes());
        String actualUrl = "https://demoqa.com/Account/v1/User/" + userID;
        Response response = given().header("Authorization", "Basic " + basicAuth).body(body).contentType(bookStoreApiPage.contentType()).when().delete(actualUrl);
        Assert.assertEquals(204, response.getStatusCode());
    }

    @When("User is created, logged in and authorized via API")
    public void userIsCreatedLoggedAndAuthorized() {
        Gson gson = new Gson();
        String body = "{\"userName\":\"" + username + "\",\"password\":\"" + password + "\"}";
        String responseCreateUser = given().body(body).contentType(bookStoreApiPage.contentType()).when().post(bookStoreApiPage.endpointCreateUser()).thenReturn().asString();
        Map<String, Object> mapCreateUser = gson.fromJson(responseCreateUser, Map.class);
        assertFalse(mapCreateUser.containsKey("code"));
        for (Map.Entry<String, Object> entry : mapCreateUser.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        userID = (String) mapCreateUser.get("userID");
        String responseGenerateToken = given().body(body).contentType(bookStoreApiPage.contentType()).when().post(bookStoreApiPage.endpointGenerateToken()).thenReturn().asString();
        String responseAuthorized = given().body(body).contentType(bookStoreApiPage.contentType()).when().post(bookStoreApiPage.endpointAuthorize()).thenReturn().asString();
        Boolean userIsAuthorized = gson.fromJson(responseAuthorized, Boolean.class);
        Assert.assertTrue(userIsAuthorized);
    }

    @Then("Get user details via API")
    public void getUserViaApi(){
        String body = "{\"userName\":\"" + username + "\",\"password\":\"" + password + "\"}";
        String basicAuth = Base64.getEncoder().encodeToString((username + ":" + password).getBytes());
        String actualUrl = "https://demoqa.com/Account/v1/User/" + userID;
        Response response = given().header("Authorization", "Basic " + basicAuth).body(body).contentType(bookStoreApiPage.contentType()).when().get(actualUrl);
        Assert.assertEquals(200, response.getStatusCode());
    }

    @Given("On API address")
    public void apiAddress(){
        RestAssured.baseURI = BASE_URL;
        RestAssured.basePath = BASE_PATH;
        request = RestAssured.given();
    }

    @When("Retrieve all books")
        public void retrieveAllBooks(){
        response = request.get("/v1/Books");
        String responseBody = response.getBody().asString();
        System.out.println(responseBody);
    }

    @Then("Response body should contain a JSON array of all books")
    public void responseBody(){
        JsonPath jsonPath = response.jsonPath();
        Map<String, ?> books = jsonPath.get("");
        if (books.size() > 0) {
            System.out.println("Data exists in the response");
        } else {
            System.out.println("Data does not exist in the response");
        }
        String responseText = response.getBody().asString();
        assertThat(responseText, containsString("books"));
    }

    @Given("An authorized user")
    public void authorizedUser(){
        Gson gson = new Gson();
        randomEndpointUserName = username + (new Random().nextInt());
        String body = "{\"userName\":\"" + randomEndpointUserName + "\",\"password\":\"" + password + "\"}";
        String responseCreateUser = given().body(body).contentType(bookStoreApiPage.contentType()).when().post(bookStoreApiPage.endpointCreateUser()).thenReturn().asString();
        Map<String, Object> mapCreateUser = gson.fromJson(responseCreateUser, Map.class);
        assertFalse(mapCreateUser.containsKey("code"));
        for (Map.Entry<String, Object> entry : mapCreateUser.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        userID = (String) mapCreateUser.get("userID");
        String responseGenerateToken = given().body(body).contentType(bookStoreApiPage.contentType()).when().post(bookStoreApiPage.endpointGenerateToken()).thenReturn().asString();
        String responseAuthorized = given().body(body).contentType(bookStoreApiPage.contentType()).when().post(bookStoreApiPage.endpointAuthorize()).thenReturn().asString();
        Boolean userIsAuthorized = gson.fromJson(responseAuthorized, Boolean.class);
        Assert.assertTrue(userIsAuthorized);
    }

    @When("A list of books are available")
    public void getISBNForFirstBook(){
        RestAssured.baseURI = BASE_URL;
        RestAssured.basePath = BASE_PATH;
        request = RestAssured.given();
        response = request.get("/v1/Books");
        jsonString = response.asString();
        List<Map<String, String>> books = JsonPath.from(jsonString).get("books");
        Assert.assertTrue(books.size() > 0);
        bookId = books.get(0).get("isbn");
        System.out.println(bookId);
    }

    @Then("Add a book to reading list")
    public void addBookToReadingList(){
        RestAssured.baseURI = BASE_URL;
        RestAssured.basePath = BASE_PATH;
        request = RestAssured.given();
        String body = "{\"userName\":\"" + randomEndpointUserName + "\",\"password\":\"" + password + "\"}";
        String basicAuth = Base64.getEncoder().encodeToString((randomEndpointUserName + ":" + password).getBytes());
        request.header("Authorization", "Basic " + basicAuth).header("Content-Type", "application/json");
        response = request.body("{ \"userId\": \"" + userID + "\", " + "\"collectionOfIsbns\": [ { \"isbn\": \"" + bookId + "\" } ]}").post("v1/Books");
        Assert.assertEquals(201, response.getStatusCode());
    }

    @And("Delete book from reading list by query param using userID")
    public void deleteBookFromReadingListByQueryParam() {
        RestAssured.baseURI = BASE_URL;
        RestAssured.basePath = BASE_PATH;
        request = RestAssured.given();
        String basicAuth = Base64.getEncoder().encodeToString((randomEndpointUserName + ":" + password).getBytes());
        request.header("Authorization", "Basic " + basicAuth).header("Content-Type", "application/json");
        response = request.queryParam("UserId", userID).delete("/v1/Books");
        Assert.assertEquals(204, response.getStatusCode());
    }

    @When("Retrieve a book by ISBN from the list")
    public void retrieveBookByIsbn(){
        response = request.queryParam("ISBN", "9781449325862").get("/v1/Book");
        System.out.println(response.asString());
    }

    @Then("Book should retrieve")
    public void bookShouldRetrieve(){
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @And("Delete a book from reading list by ISBN and userID")
    public void deleteBookByIsbnAndUserId(){
        RestAssured.baseURI = BASE_URL;
        RestAssured.basePath = BASE_PATH;
        request = RestAssured.given();
        String basicAuth = Base64.getEncoder().encodeToString((randomEndpointUserName + ":" + password).getBytes());
        request.header("Authorization", "Basic " + basicAuth).header("Content-Type", "application/json");
        response = request.body("{ \"isbn\": \"" + bookId + "\", \"userId\": \"" + userID + "\"}").delete("/v1/Book");
        Assert.assertEquals(204, response.getStatusCode());
    }

    @And("Replace book from reading list")
    public void replaceBookFromReadingList(){
        RestAssured.baseURI = BASE_URL;
        RestAssured.basePath = BASE_PATH;
        request = RestAssured.given();
        String body = "{\"userName\":\"" + randomEndpointUserName + "\",\"password\":\"" + password + "\"}";
        String basicAuth = Base64.getEncoder().encodeToString((randomEndpointUserName + ":" + password).getBytes());
        request.header("Authorization", "Basic " + basicAuth).header("Content-Type", "application/json");
        List<Map<String, String>> books = JsonPath.from(jsonString).get("books");
        String newBookId = books.get(1).get("isbn");
        response = request.body("{ \"userId\": \"" + userID + "\", " + "\"isbn\": \"" + newBookId + "\" }").put("/v1/Books/" + bookId);
        Assert.assertEquals(200, response.getStatusCode());
        String isbn = JsonPath.from(response.asString()).get("books[0].isbn");
        Assert.assertEquals("9781449331818", isbn);
    }
}
