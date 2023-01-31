import ApiTests.Methods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookStoreApiTests {
    private Methods methods;

    @Given("I create a user")
    public void iCreateAUser() {
        methods.createUser();
    }

    @And("I am an authorized user")
    public void iAmAnAuthorizedUser() {
        methods.AuthorizedSuccessful();
    }

    @And("I generate a token")
    public void iGenerateAToken() {
        methods.generateAndGetToken();

    }

    @When("I send a valid request for fetching all books")
    public void iSendAValidRequestForFetchingAllBooks() {
        Methods.getAllBooks();
    }

    @Then("I receive a list of books")
    public void iReceiveAListOfBooks() {
    }
}
