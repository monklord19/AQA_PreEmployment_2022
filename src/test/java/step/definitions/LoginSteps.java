package step.definitions;

import io.cucumber.java.en.*;
import page.objects.LoginPage;

public class LoginSteps extends BaseClass {
    LoginPage loginPage;

    public LoginSteps(TestContext context) {
        this.driver = context.driver;
        loginPage = new LoginPage(driver);
    }

    @Given("user navigates to {string}")
    public void userNavigatesTo(String url) {
        driver.get(url);
    }

    @When("user enters username as {string} and password as {string}")
    public void userEntersUsernameAsAndPasswordAs(String username, String password) {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
    }

    @When("user clicks on login")
    public void userClicksOnLogin() {
        loginPage.clickLogin();
    }

    @Then("Home page opens")
    public void homePageOpens() {
        loginPage.checkHomePageOpened();
    }

    @Then("error message is displayed {string}")
    public void errorMessageIsDisplayed(String msg) {
        loginPage.checkErrorMessage(msg);
    }

    @When("user presses Enter key")
    public void userPressesEnterKey() {
        loginPage.enterKeyLogin();
    }

    @Given("user is logged in")
    public void userIsLoggedIn() {
        userNavigatesTo("https://www.saucedemo.com/");
        userEntersUsernameAsAndPasswordAs("standard_user", "secret_sauce");
        userClicksOnLogin();
        homePageOpens();
    }

    @When("user clicks on hamburger button")
    public void userClicksOnHamburgerButton() {
        loginPage.clickHamburgerBtn();
    }

    @When("user clicks on Logout button")
    public void userClicksOnLogoutButton() {
        loginPage.clickLogoutButton();
    }

    @Then("Login page reopens")
    public void loginPageReopens() {
        loginPage.checkLoginPageOpened();
    }

    @When("user signs out")
    public void userSignsOut() {
        loginPage.clickHamburgerBtn();
        loginPage.clickLogoutButton();
    }

    @When("user clicks on Go back button")
    public void userClicksOnGoBackButton() {
        driver.navigate().back();
    }

    @Then("user remains on Login page")
    public void userRemainsOnLoginPage() {
        loginPage.checkLoginPageOpened();
    }

    //steps for Spotify login
    @Given("user clicks on Log in")
    public void userClicksOnLogIn() {
        loginPage.clickOnLogin();
    }

    @When("user enters for Spotify username as {string} and password as {string}")
    public void userEntersForSpotifyUsernameAsAndPasswordAs(String usern, String pass) {
        loginPage.setUser(usern);
        loginPage.setPass(pass);
    }

    @And("user clicks on Spotify login")
    public void userClicksOnSpotifyLogin() {
        loginPage.clickOnLoginSpotify();
    }

    @Then("Spotify error message is displayed {string}")
    public void spotifyErrorMessageIsDisplayed(String msg) {
        loginPage.checkSErrorMessage(msg);
    }

    @Given("user navigates to Spotify {string}")
    public void userNavigatesToSpotify(String url) {
        driver.get(url);
    }

    @When("user clicks on Continue with Apple")
    public void userClicksOnContinueWithApple() {
        loginPage.clickOnContinueWithApple();
    }

    @When("user enters for appleId as {string} and password as {string}")
    public void userEntersForAppleIdAsAndPasswordAs(String appleId, String pass) {
        loginPage.setAppleId(appleId);
        loginPage.clickOnSignInIcon();
        loginPage.setApplePass(pass);
        loginPage.clickOnSignInIcon();
    }

    @Then("error message appears {string}")
    public void errorMessageAppears(String msg) {
        loginPage.checkAppleErrorMsg(msg);
    }


}
