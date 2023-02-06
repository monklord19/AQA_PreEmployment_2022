package Backend.Steps;

import Backend.apiEngine.Endpoints.*;
import Configurations.BackendConfigs.BackendPropertiesReader;
import com.jayway.jsonpath.JsonPath;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class BookStoreSteps {

    //ACCOUNT REQUESTS

    //CREATE USER ACCOUNT

    @When("I send a valid request for creating a new user")
    public void iSendAValidRequestForCreatingANewUser() {
        PostEndpoints.createUserAccount();
    }

    @Then("User is created")
    public void userIsCreated() {
        Response userAccountResponse = PostEndpoints.createUserAccount();
        String userAccountResponseAsString = CommonMethods.setResponseAsString(userAccountResponse);
        System.out.println("USER ACCOUNT RESPONSE:" + userAccountResponseAsString);
        CommonMethods.validateStatusCode(userAccountResponse, 201);
        CommonMethods.validateResponseTime(userAccountResponse, (long) 2500);
        String userName = BackendPropertiesReader.getInstance().getUserName();
        CommonMethods.assertThatBodyContainsASpecificValue(userAccountResponse, "username", userName);
    }

    //AUTHORIZE THE USER

    @When("I send a valid request for authorizing the user")
    public void iSendAValidRequestForAuthorizingTheUser() {
        PostEndpoints.authorizeUserAccount();
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

    //GENERATE A TOKEN
    @When("I send a valid request for generating a token")
    public void iSendAValidRequestForGeneratingAToken() {
        PostEndpoints.generateToken();
    }

    @Then("Token is successfully generated")
    public void tokenIsSuccessfullyGenerated() {
        Response tokenResponse = PostEndpoints.generateToken();
        String tokenResponseAsString = CommonMethods.setResponseAsString(tokenResponse);
        System.out.println("TOKEN REQUEST RESPONSE: " + tokenResponseAsString);
        String token = PostEndpoints.getToken();
        CommonMethods.validateStatusCode(tokenResponse, 200);
        CommonMethods.validateResponseTime(tokenResponse, (long) 2000);
        CommonMethods.assertThatBodyContainsASpecificValue(tokenResponse, "status", "Success");
        CommonMethods.assertThatBodyContainsASpecificValue(tokenResponse, "result", "User authorized successfully.");
        CommonMethods.validateHeaders(tokenResponse, "content-type", "application/json; charset=utf-8");
        CommonMethods.validateHeaders(tokenResponse, "connection", "keep-alive");
    }
    //GET A USER

    @When("I send a valid request for fetching a user")
    public void iSendAValidRequestForFetchingAUser() {
        GetEndpoints.getAUser();
    }

    @Then("User is successfully fetched")
    public void userIsSuccessfullyFetched() {
        Response getAUserResponse = GetEndpoints.getAUser();
        String getAUserResponseAsString = CommonMethods.setResponseAsString(getAUserResponse);
        System.out.println("GET A USE RESPONSE:"+ getAUserResponseAsString);
    }

    //DELETE A USER
    @When("I send a valid request for deleting a user")
    public void iSendAValidRequestForDeletingAUser() {
        DeleteEndpoints.deleteUser();
    }

    @Then("The user is deleted")
    public void theUserIsDeleted() {
        Response deleteUserResponse = DeleteEndpoints.deleteUser();
        System.out.println("DELETE USER RESPONSE: " + deleteUserResponse);
//        CommonMethods.validateStatusCode(deleteUserResponse,200);

    }


    //BOOKSTORE REQUESTS

    //GET ALL BOOKS FROM BOOKSTORE

    @When("I send a valid request for fetching all books")
    public void iSendAValidRequestForFetchingAllBooks() {
        GetEndpoints.getAllBooks();
    }

    @Then("I receive a list of books")
    public void iReceiveAListOfBooks() {
        Response getBooksResponse = GetEndpoints.getAllBooks();
        String responseAsString = CommonMethods.setResponseAsString(getBooksResponse);
        System.out.println("GET A LIST OF BOOKS RESPONSE: " + responseAsString);
        CommonMethods.validateStatusCode(getBooksResponse, 200);
        CommonMethods.validateResponseTime(getBooksResponse, (long) 2500);
        CommonMethods.validateBodyNotNull(getBooksResponse);
        String numberOfBooks = JsonPath.read(CommonMethods.setResponseAsString(getBooksResponse), "$.books.length()").toString();
        System.out.println("The number of books in the bookStore is: " + numberOfBooks);
        CommonMethods.validateValuesFromResponseBody(getBooksResponse, "books[1].title", "Learning JavaScript Design Patterns");
        CommonMethods.validateValuesFromResponseBody(getBooksResponse, "books[5].author", "Eric Elliott");

    }

    // GET A SINGLE BOOK FROM BOOKSTORE
    @When("I send a valid request for fetching a book")
    public void iSendAValidRequestForFetchingABook() {
        GetEndpoints.getABook();
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
        PostEndpoints.addABook();
    }

    @Then("The book is successfully added")
    public void theBookIsSuccessfullyAdded() {
        Response addBooksResponse=PostEndpoints.addABook();
        String addBooksResponseAsString=CommonMethods.setResponseAsString(addBooksResponse);
        System.out.println("ADD BOOK RESPONSE: "+addBooksResponseAsString);
    }

    //DELETE A BOOK FROM READING LIST
    @When("I send a valid request for deleting a book")
    public void iSendAValidRequestForDeletingABook() {
        DeleteEndpoints.deleteABook();

    }

    @Then("The book is successfully deleted")
    public void theBookIsSuccessfullyDeleted() {
        Response deleteBookResponse=DeleteEndpoints.deleteABook();
        String responseAsString=CommonMethods.setResponseAsString(deleteBookResponse);
        System.out.println("DELETE BOOK RESPONSE: "+ responseAsString);
        CommonMethods.validateStatusCode(deleteBookResponse,204);

    }

    //DELETE BOOKS FROM READING LIST
    @When("I send a valid request for deleting multiple books")
    public void iSendAValidRequestForDeletingMultipleBooks() {
        DeleteEndpoints.deleteBooks();
    }

    @Then("The books are deleted")
    public void theBooksAreDeleted() {
        Response deleteBooksResponse=DeleteEndpoints.deleteBooks();
        String responseAsString=CommonMethods.setResponseAsString(deleteBooksResponse);
        System.out.println("DELETE BOOKS ");
    }

    //UPDATE A BOOK
    @When("I send a valid request for updating a book")
    public void iSendAValidRequestForUpdatingABook() {
        PutEndpoints.updateBookResponse();
    }

    @Then("The book is successfully updated")
    public void theBookIsSuccessfullyUpdated() {
        Response updateABookResponse=PutEndpoints.updateBookResponse();
        String updateBookResponseAsString=CommonMethods.setResponseAsString(updateABookResponse);
        System.out.println("UPDATE BOOK RESPONSE: "+ updateBookResponseAsString);
        String userId=PostEndpoints.getUserId();
        CommonMethods.assertThatBodyContainsASpecificValue(updateABookResponse,"userId",userId);
        CommonMethods.validateStatusCode(updateABookResponse,200);
    }
}
