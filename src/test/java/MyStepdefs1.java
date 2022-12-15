import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyStepdefs1 {
    @Given("On sauce website")
    public void onSauceWebsite() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

/*
    @Given("user open the login page")
    public void userOpenTheLoginPage() {
    }

    @And("the Username text box is empty")
    public void theUsernameTextBoxIsEmpty() {
    }

    @And("the Password text box is empty")
    public void thePasswordTextBoxIsEmpty() {
    }
*/
    @Given("user is on login page")
    public void userIsOnLoginPage() {

    }

    @When("user enters username and password")
    public void userEntersUsernameAndPassword() {
    }

    @And("user clicks on login")
    public void userClicksOnLogin() {
    }

    @Then("user is navigated to the home page")
    public void userIsNavigatedToTheHomePage() {
    }

//    @Given("the following user:")
//    public void theFollowingUser() {
//    }
//
//    @When("user type {string} in {string} text box")
//    public void userTypeInUsernameTextBox(String arg0) {
//    }
//
//    @And("user click on {string} button")
//    public void userClickOnLOGINButton() {
//    }
//
//    @Then("user should be logged in")
//    public void userShouldBeLoggedIn() {
//    }
//
//    @Then("username text box should show an error")
//    public void usernameTextBoxShouldShowAnError() {
//    }
//
//    @And("password text box should show an error")
//    public void passwordTextBoxShouldShowAnError() {
//    }
//
//    @And("a red pop-up text box containing {string} should appear")
//    public void aRedPopUpTextBoxContainingShouldAppear(String arg0) {
//    }
//
//    @And("a pop up that recommends you to change password immediately should appear")
//    public void aPopUpThatRecommendsYouToChangePasswordImmediatelyShouldAppear() {
//    }
//
//    @Then("the login page its frozen for a few seconds")
//    public void theLoginPageItsFrozenForAFewSeconds() {
//    }
//
//    @When("user type valid username")
//    public void userTypeValidUsername() {
//    }
//
//    @And("user add a white space after the username")
//    public void userAddAWhiteSpaceAfterTheUsername() {
//    }
//
//    @And("user type valid password for the current user")
//    public void userTypeValidPasswordForTheCurrentUser() {
//    }
//
//    @When("user type anything in username text box")
//    public void userTypeAnythingInUsernameTextBox() {
//    }
//
//    @And("password text box is empty")
//    public void passwordTextBoxIsEmpty() {
//    }
//
//    @And("user click on {string}")
//    public void userClickOnLOGIN() {
//    }
//
//    @When("user type anything in password text box")
//    public void userTypeAnythingInPasswordTextBox() {
//    }
//
//    @And("username text box is empty")
//    public void usernameTextBoxIsEmpty() {
//    }
//
//    @When("user type a valid username")
//    public void userTypeAValidUsername() {
//    }
//
//    @And("user type a different password that the correct one")
//    public void userTypeADifferentPasswordThatTheCorrectOne() {
//    }
//
//    @When("user type a different username that the correct one")
//    public void userTypeADifferentUsernameThatTheCorrectOne() {
//    }
//
//    @And("user type a valid password")
//    public void userTypeAValidPassword() {
//    }
}
