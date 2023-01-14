package UITests.steps;

import UITests.pageObjects.FunctionsDefiniton;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MyStepdefs1 extends BaseStepDefClass {
    WebDriver driver = new ChromeDriver();
    FunctionsDefiniton loginPage=new FunctionsDefiniton(driver);
    @Given("open the loginPage")
    public void onSauceWebsite() {

        driver.get("https://www.saucedemo.com/");

    }
    @When("I type the username {string} and the password {string}")
    public void iTypeTheUsernameAndThePassword(String username, String password)  {
       // loginPage.setUsername(username);
        //loginPage.setPassword(password);
        loginPage.setCredentials(username,password);

    }

    @After
    public void close_browser() {
        driver.close();
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
    @When("I add a backpack to cart")
    public void iAddABackpackToCart() {
        loginPage.addBackpackToCart();
    }
    @And("A pop-up saying {string} should appear")
    public void aPopUpSayingShouldAppear(String errorMessages) throws InterruptedException {
        loginPage.errorMessage(errorMessages);
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

    @When("I click the login with google option")
    public void iClickTheLoginWithGoogleOption() throws InterruptedException {
        loginPage.clickGoogleLogin();
    }
    @Then("A new page opens up, where the text {string} should appear")
    public void aNewPageOpensUpWhereTheTextShouldAppear(String text) throws InterruptedException{
        loginPage.checkText(text);
    }
    @And("I type in the email or username {string} and press Next")
    public void iTypeInTheEmailOrUsernameAndPressNext(String text) throws InterruptedException{
        loginPage.setEmailOrUsername(text);
        loginPage.clickNext();
    }
    @When("I click the login with apple option")
    public void iClickTheLoginWithAppleOption() throws InterruptedException {
        loginPage.clickAppleLogin();

    }
    @And("I try to login with the Id {string} and password {string}")
    public void iTryToLoginWithTheIdAndPassword(String text1, String text2) throws InterruptedException {
        loginPage.appleSetIdAndPassword(text1, text2);
    }

    @When("I click the login with facebook option")
    public void iClickTheLoginWithFacebookOption() throws InterruptedException{
        loginPage.clickFacebookLogin();
    }

    @And("I click on allow cookies")
    public void iClickOnAllowCookies() throws InterruptedException{
        loginPage.clickCookie();
    }

    @Given("on spotify website")
    public void onSpotifyWebsite() {
        driver.get("https://accounts.spotify.com/en/login?continue=https");
    }

    @Given("on luma website")
    public void onLumaWebsite() {
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @When("I hover over gear field and press the bags option")
    public void iHoverOverGearFieldAndPressTheBagsOption() throws InterruptedException{
        loginPage.clickOnBagsField();
    }


    @And("I scroll and hover over the item {string} and click on add to cart")
    public void iScrollAndHoverOverTheItemAndClickOnAddToCart(String text) throws InterruptedException{
        loginPage.addBagToCart(text);
    }

    @Then("Product should be added to cart with the name {string}")
    public void productShouldBeAddedToCartWithTheName(String text) throws InterruptedException{
         loginPage.verifyObjecInCart(text);
    }




}
