package Backend.Steps;

import Backend.apiEngine.Endpoints.*;
import Configurations.BackendConfigs.BackendPropertiesReader;
import com.jayway.jsonpath.JsonPath;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class BookStoreSteps {
    //CREATE USER ACCOUNT

    @When("I send a valid request for creating a new user")
    public void iSendAValidRequestForCreatingANewUser() {
        Response createUserResponse = PostEndpoints.createUserAccount();
    }

    @Then("User is created")
    public void userIsCreated() {
        Response createUserResponse = PostEndpoints.createUserAccount();
        String userAccountResponseAsString = CommonMethods.setResponseAsString(createUserResponse);
        System.out.println("USER ACCOUNT RESPONSE:" + userAccountResponseAsString);
        CommonMethods.validateStatusCode(createUserResponse, 201);
        CommonMethods.validateResponseTime(createUserResponse, (long) 2500);
        String userName = BackendPropertiesReader.getInstance().getUserName();
        CommonMethods.assertThatBodyContainsASpecificValue(createUserResponse, "username", userName);
    }

    //GENERATE A TOKEN
    @When("I send a valid request for generating a token")
    public void iSendAValidRequestForGeneratingAToken() {
        Response generateTokenResponse = PostEndpoints.generateToken();
    }

    @Then("Token is successfully generated")
    public void tokenIsSuccessfullyGenerated() {
        Response generateTokenResponse = PostEndpoints.generateToken();
        String tokenResponseAsString = CommonMethods.setResponseAsString(generateTokenResponse);
        System.out.println("TOKEN REQUEST RESPONSE: " + tokenResponseAsString);
        CommonMethods.validateStatusCode(generateTokenResponse, 200);
        CommonMethods.validateResponseTime(generateTokenResponse, (long) 2000);
        CommonMethods.assertThatBodyContainsASpecificValue(generateTokenResponse, "result", "User authorized successfully.");
        CommonMethods.validateHeaders(generateTokenResponse, "content-type", "application/json; charset=utf-8");
        CommonMethods.validateHeaders(generateTokenResponse, "connection", "keep-alive");
    }
    //AUTHORIZE THE USER

    @When("I send a valid request for authorizing the user")
    public void iSendAValidRequestForAuthorizingTheUser() {
        Response authorizeUserResponse = PostEndpoints.authorizeUserAccount();
    }

    @Then("The user is authorized")
    public void theUserIsAuthorized() {
        Response authorizeUserResponse = PostEndpoints.authorizeUserAccount();
        String authorizeUserResponseAsString = authorizeUserResponse.asPrettyString();
        System.out.println("AUTHORIZE USER RESPONSE: " + authorizeUserResponseAsString);
        CommonMethods.validateStatusCode(authorizeUserResponse, 200);
        CommonMethods.validateResponseTime(authorizeUserResponse, (long) 2000);
        CommonMethods.validateHeaders(authorizeUserResponse, "content-type", "application/json; charset=utf-8");
        CommonMethods.validateHeaders(authorizeUserResponse, "connection", "keep-alive");
    }
    //GET A USER

    @When("I send a valid request for fetching a user")
    public void iSendAValidRequestForFetchingAUser() {
        Response getAUserResponse = GetEndpoints.getAUser();
    }

    @Then("User is successfully fetched")
    public void userIsSuccessfullyFetched() {
        Response getAUserResponse = GetEndpoints.getAUser();
        String getAUserResponseAsString = CommonMethods.setResponseAsString(getAUserResponse);
        System.out.println("GET A USE RESPONSE:" + getAUserResponseAsString);
        CommonMethods.validateStatusCode(getAUserResponse, 200);
        CommonMethods.validateResponseTime(getAUserResponse, (long) 2000);

    }

    //DELETE A USER
    @When("I send a valid request for deleting a user")
    public void iSendAValidRequestForDeletingAUser() {
        Response deleteUserResponse = DeleteEndpoints.deleteUser();

    }

    @Then("The user is deleted")
    public void theUserIsDeleted() {
        Response deleteUserResponse = DeleteEndpoints.deleteUser();
        String deleteUserResponseAsString = CommonMethods.setResponseAsString(deleteUserResponse);
        CommonMethods.setResponseAsString(deleteUserResponse);
        CommonMethods.validateStatusCode(deleteUserResponse, 200);
        CommonMethods.validateResponseTime(deleteUserResponse, (long) 2000);

    }


    //BOOKSTORE REQUESTS

    //GET ALL BOOKS FROM BOOKSTORE


    @When("I send a valid request for fetching all books")
    public void iSendAValidRequestForFetchingAllBooks() {
        Response getAllBooks = GetEndpoints.getAllBooks();
    }

    @Then("I receive a list of books")
    public void iReceiveAListOfBooks() {
        Response getAllBooks = GetEndpoints.getAllBooks();
        String responseAsString = CommonMethods.setResponseAsString(getAllBooks);
        System.out.println("GET A LIST OF BOOKS RESPONSE: " + responseAsString);
        CommonMethods.validateStatusCode(getAllBooks, 200);
        CommonMethods.validateResponseTime(getAllBooks, (long) 2500);
        CommonMethods.validateBodyNotNull(getAllBooks);
        String numberOfBooks = JsonPath.read(CommonMethods.setResponseAsString(getAllBooks), "$.books.length()").toString();
        System.out.println("The number of books in the bookStore is: " + numberOfBooks);
        CommonMethods.validateValuesFromResponseBody(getAllBooks, "books[1].title", "Learning JavaScript Design Patterns");
        CommonMethods.validateValuesFromResponseBody(getAllBooks, "books[5].author", "Eric Elliott");


    }

    // GET A SINGLE BOOK FROM BOOKSTORE
    @When("I send a valid request for fetching a book")
    public void iSendAValidRequestForFetchingABook() {
        Response getABookResponse = GetEndpoints.getABook();
    }

    @Then("I receive the book")
    public void iReceiveTheBook() {
        Response getABookResponse = GetEndpoints.getABook();
        String responseAsString = CommonMethods.setResponseAsString(getABookResponse);
        System.out.println(responseAsString);
        CommonMethods.validateStatusCode(getABookResponse, 200);
        CommonMethods.validateResponseTime(getABookResponse, (long) 2500);
        String isbnFromResponse = GetEndpoints.getBookISBN();
        System.out.println("ISBN extracted from response body is: " + isbnFromResponse);
        CommonMethods.assertThatBodyContainsASpecificValue(getABookResponse, "isbn", isbnFromResponse);
    }


    //ADD A BOOK TO READING LIST
    @When("I send a valid request for adding a book to reading list")
    public void iSendAValidRequestForAddingABookToReadingList() {
        Response addABookResponse = PostEndpoints.addABook();
    }

    @Then("The book is successfully added")
    public void theBookIsSuccessfullyAdded() {
        Response addABookResponse = PostEndpoints.addABook();
        String addBooksResponseAsString = CommonMethods.setResponseAsString(addABookResponse);
        System.out.println("ADD BOOK RESPONSE: " + addBooksResponseAsString);
        CommonMethods.validateStatusCode(addABookResponse, 201);
    }

    //DELETE A BOOK FROM READING LIST
    @When("I send a valid request for deleting a book")
    public void iSendAValidRequestForDeletingABook() {
        Response deleteABookResponse = DeleteEndpoints.deleteABook();

    }

    @Then("The book is successfully deleted")
    public void theBookIsSuccessfullyDeleted() {
        Response deleteABookResponse = DeleteEndpoints.deleteABook();
        String responseAsString = CommonMethods.setResponseAsString(deleteABookResponse);
        System.out.println("DELETE BOOK RESPONSE: " + responseAsString);
        CommonMethods.validateStatusCode(deleteABookResponse, 204);
        String userId = PostEndpoints.getUserId();
        CommonMethods.assertThatBodyContainsASpecificValue(deleteABookResponse, "userId", userId);

    }

    //DELETE BOOKS FROM READING LIST
    @When("I send a valid request for deleting multiple books")
    public void iSendAValidRequestForDeletingMultipleBooks() {
        Response deleteBooksResponse = DeleteEndpoints.deleteBooks();
    }

    @Then("The books are deleted")
    public void theBooksAreDeleted() {
        Response deleteBooksResponse = DeleteEndpoints.deleteBooks();
        String responseAsString = CommonMethods.setResponseAsString(deleteBooksResponse);
        System.out.println("DELETE BOOKS ");
        CommonMethods.validateStatusCode(deleteBooksResponse, 204);
        String userId = PostEndpoints.getUserId();
        CommonMethods.assertThatBodyContainsASpecificValue(deleteBooksResponse, "userId", userId);

    }

    //UPDATE A BOOK
    @When("I send a valid request for updating a book")
    public void iSendAValidRequestForUpdatingABook() {
        Response updateBookResponse = PutEndpoints.updateBookResponse();
    }

    @Then("The book is successfully updated")
    public void theBookIsSuccessfullyUpdated() {
        Response updateBookResponse = PutEndpoints.updateBookResponse();
        String updateBookResponseAsString = CommonMethods.setResponseAsString(updateBookResponse);
        System.out.println("UPDATE BOOK RESPONSE: " + updateBookResponseAsString);
        String userId = PostEndpoints.getUserId();
        CommonMethods.assertThatBodyContainsASpecificValue(updateBookResponse, "userId", userId);
        CommonMethods.validateStatusCode(updateBookResponse, 200);
    }
}
