package UITests;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginSteps {
    @Given("^I open the webSite$")
    public void iOpenTheWebSite() {
    }

    @Then("^I should be logged$")
    public void iShouldBeLogged() {
    }

    @And("I should see an succcessfuly  popup")
    public void iShouldSeeAnSucccessfulyPopup() {

    }

    @When("I enter the {string} and {string}")
    public void iEnterTheUserNameAndPassword(String userName,String Passowrd) {
    }
}
