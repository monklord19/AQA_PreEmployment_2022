package SaucedemoTesting.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.SaucedemoTesting.pageobjects.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;

public class LoginDemoSteps extends TestBase {
    private LoginPage login = PageFactory.initElements(driver, LoginPage.class);
    @When("User input {string} and {string}")
    public void userInputAnd(String username, String password) {
        login.getTxt_username().sendKeys(username);
        login.getTxt_password().sendKeys(password);
    }
    @And("User click on Login button")
    public void userClickOnLoginButton() {
        login.getBtn_login().click();
    }

    @Then("User is successfully logged in")
    public void userIsSuccessfullyLoggedIn() throws InterruptedException {
       driver.wait(5);
       Assert.assertTrue(login.getBtn_hamburger().isDisplayed());
    }
    @And("Press Enter key")
    public void pressEnterKey() {
        login.getBtn_login().sendKeys(Keys.ENTER);
    }

    @When("User input valid username as {string} and blank password")
    public void userInputValidUsernameAsAndBlankPassword(String usr) {
        login.getTxt_username().sendKeys(usr);
    }


    @Then("User should not be logged and should see a popup as {string}")
    public void userShouldNotBeLoggedAndShouldSeeAPopupAs(String pop1) {
        Assert.assertEquals(login.getErrorMessage().getText(),pop1);
    }
}
   
