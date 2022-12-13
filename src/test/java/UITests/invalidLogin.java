package UITests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class invalidLogin {
    @Given("I open other website")
    public void iOpenOtherWebsite() {
    }
    @When("I will enter an invalid userName and password")
    public void iWillEnterAnInvalidUserNameAndPassword() {
    }

    @Then("I shouldn`t be able to login")
    public void iShouldnTBeAbleToLogin() {
    }

    @When("I will enter an invalid <userName> and <password>")
    public void iWillEnterAnInvalidUserNameAndPasswordWithExample(String username,String password) {

    }
}
