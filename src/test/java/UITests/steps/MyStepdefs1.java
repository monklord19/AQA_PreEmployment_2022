package UITests.steps;

import UITests.pageObjects.FunctionsDefiniton;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class MyStepdefs1 {
    WebDriver driver = new ChromeDriver();
    FunctionsDefiniton loginPage=new FunctionsDefiniton(driver);

    @Given("open the loginPage")
    public void onSauceWebsite() {

        driver.get("https://www.saucedemo.com/");

    }

    @When("I type the username {string} and the password {string}")
    public void iTypeTheUsernameAndThePassword(String username, String password)  {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
    }

    @And("I click on login")
    public void iClickOnLogin() throws InterruptedException {
        loginPage.pressLoginButton();
    }

    @Then("I should be logged in")
    public void iShouldBeLoggedIn() {
        driver.navigate().to("https://www.saucedemo.com/inventory.html");
    }

    @And("I press the refresh button of the webpage")
    public void iPressTheRefreshButtonOfTheWebpage() {
        loginPage.refreshPage();
    }
    @And("A pop-up saying {string} should appear")
    public void aPopUpSayingShouldAppear(String errorMessages) throws InterruptedException {
        loginPage.errorMessage(errorMessages);
    }
    @After
    public void close_browser() {
        driver.close();
    }
    @When("I add a backpack to cart")
    public void iAddABackpackToCart() {
        loginPage.addBackpackToCart();
    }
    @And("I open the shopping cart")
    public void iOpenTheShoppingCart() throws InterruptedException {
        loginPage.openShoppingCart();
    }


    @Then("Item in cart should be called {string}")
    public void itemInCartShouldBeCalled(String itemTitle) {
       loginPage.checkItemName(itemTitle);
    }

    @Given("User is logged in")
    public void userIsLoggedIn() throws InterruptedException {
        onSauceWebsite();
        iTypeTheUsernameAndThePassword("standard_user","secret_sauce" );
        iClickOnLogin();

    }


    @When("I click on the menu button")
    public void iClickOnTheMenuButton() throws InterruptedException {
        loginPage.clickMenuButton();
    }

    @And("I press logout")
    public void iPressLogout() throws InterruptedException {
        loginPage.clickLogout();
    }

    @Then("The username and password fields should be empty")
    public void theUsernameAndPasswordFieldsShouldBeEmpty() throws InterruptedException{

        loginPage.checkEmptyUsernameAndPassword();
    }

    @Given("On demo site")
    public void onDemoSite() {
        driver.get("https://demoqa.com/radio-button");
    }

    @When("User selects Impressive radio button")
    public void userSelectsImpressiveRadioButton() {
        loginPage.clickRadioButton();
    }

    @Then("check label is displayed correctly")
    public void checkLabelIsDisplayedCorrectly() {
        loginPage.checkLabelText("Impressive");
    }

    @Given("on spotify website")
    public void onSpotifyWebsite() {
        driver.get("https://accounts.spotify.com/en/login?continue=https");
    }


    @When("I click the login with google option")
    public void iClickTheLoginWithGoogleOption() throws InterruptedException {
        loginPage.clickGoogleLogin();
    }

    @And("I am on the google accounts page")
    public void iAmOnTheGoogleAccountsPage() {
        driver.get("https://accounts.google.com/o/oauth2/v2/auth/identifier?response_type=code&access_type=offline&client_id=1046568431490-ij1gi5shcp2gtorls09frkc56d4mjbe2.apps.googleusercontent.com&state=AQDa0d8ucMNRzTJRz2AWGCfjGJXyzRAP9OU%2F2Vz808ZG2d0035wLTGON6hvd4C5jMzKehNlqHewnDuUncdqjiKiMxN3sP5J8m1CBplN1AaXw3%2BliUfgsRLjRRsS3%2BNDOyie3Lp3wMq8ZsWEzoGwP6rzpLKemN3hTpsXmre9q5EldJ2c68TEWjeY2UIq%2FnNTq0KLWt0%2FWSuq%2B7eT3kwayUsJQdRMo%2B4R2OHYa64bAuBSXe7IA4g%3D%3D&scope=profile%20email%20openid&redirect_uri=https%3A%2F%2Faccounts.spotify.com%2Flogin%2Fgoogle%2Fredirect&service=lso&o2v=2&flowName=GeneralOAuthFlow");
    }


    @And("I type in the email {string} and press Next")
    public void iTypeInTheEmailAndPressNext(String emailAccount) throws InterruptedException{
        loginPage.setEmail(emailAccount);
        loginPage.clickNext();
    }

    @Then("A new page opens up, where the text {string} should appear")
    public void aNewPageOpensUpWhereTheTextShouldAppear(String text) throws InterruptedException{
        loginPage.checkText(text);
    }
}
