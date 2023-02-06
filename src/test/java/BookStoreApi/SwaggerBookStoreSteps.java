package BookStoreApi;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;


import static io.restassured.RestAssured.*;

public class SwaggerBookStoreSteps extends SwaggerBookStoreFlow{

    //steps for #1 scenario
    @Given("I have the BASE URL")
    public void iHaveTheBASEURL() {
        RestAssured.baseURI = "https://demoqa.com/";

    }

    @When("I make a post request to create a user")
    public void iMakeAPostRequestToCreateAUser() {
        createUserForTest();

    }

    @Then("I receive the response for user creation")
    public void iReceiveTheResponseForUserCreation() {
        getCreateUserResponse();
    }


    // steps for #2 scenario
    @When("I make a post request to generate a token and authorized user")
    public void iMakeAPostRequestToGenerateATokenAndAuthorizedUser() {
        generateTokenAndAuthorization();
    }
    @Then("I receive the generated token")
    public void iReceiveTheGeneratedToken() {
        responseToken();
    }

    //steps for #3 scenario
    @When("I make a post request to authorize user")
    public void iMakeAPostRequestToAuthorizeUser() {
        generateTokenAndAuthorization();
    }
    @Then("I should receive correct status code")
    public void iShouldReceiveCorrectStatusCode() {
        authorizedStatusCode();
    }

    //steps for #4 scenario
    @When("I make a detele request to delete userID")
    public void iMakeADeteleRequestToDeleteUserID() {
        deleteUserID();
    }
    @Then("I receive status for deleting userID")
    public void iReceiveStatusForDeletingUserID() {
        responseDeleteUserID();
    }

    //steps for #5 scenario
    @When("I make a get request to get a user by UserId")
    public void iMakeAGetRequestToGetAUserByUserId() {
        getUserById();
    }

    @Then("I receive the user")
    public void iReceiveTheUser() {
        responseUser();
    }

    //steps for #6 scenario
    @When("I make a post request to get the books details")
    public void iMakeAPostRequestToGetTheBooksDetails() {
        getBooksDetails();
    }

    @Then("I receive the informations")
    public void iReceiveTheInformations() {
        detailsBooks();
        getStatus(baseURI);
        getResponseTime();
    }

    //steps for #7 scenario
    @When("I make a post request to send book to a user")
    public void iMakeAPostRequestToSendBookToAUser() {
        bookDetail();
    }

    @Then("I should see the response")
    public void iShouldSeeTheResponse() {
        responseBody();
    }

    //steps for #8 scenario
    @When("I make a post request to generate books details")
    public void iMakeAPostRequestToGenerateBooksDetails() {
        generateBooks();
    }

    @Then("I receive the books details")
    public void iReceiveTheBooksDetails() {
        booksDetails();
    }

    // steps for #9 scenario
    @When("I make a delete requst to delete book from user")
    public void iMakeADeleteRequstToDeleteBookFromUser() {
        deteleBook();

    }
    @Then("I receive the response")
    public void iReceiveTheResponse() {
        statusDelete();
    }

    //steps for #10 scenario
    @When("I make a put request to update a book")
    public void iMakeAPutRequestToUpdateABook() {
        updateBook();
    }

    @Then("Book is updated")
    public void bookIsUpdated() {
        responseUpdatedBook();
    }

    //steps for #11 scenario

    @When("I make a get request to get the isbn")
    public void iMakeAGetRequestToGetTheIsbn() {
        getUserByISBN();
    }

    @Then("I get isbn")
    public void iGetIsbn() {
        responseISN();
    }

    //steps for #12 scenario
    @When("I make a delete request")
    public void iMakeADeleteRequest() {
        deleteBooksID();
    }

    @Then("Book is deleted")
    public void bookIsDeleted() {
        responseDeleteBooksID();
    }

}
