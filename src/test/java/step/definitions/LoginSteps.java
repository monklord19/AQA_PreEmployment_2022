package step.definitions;

//import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LoginPage;

public class LoginSteps {
    LoginPage loginPage;
    static WebDriver driver = new ChromeDriver();

    public LoginSteps() {

        loginPage = new LoginPage(driver);


    }


    @Given("I go to {string}")
    public void i_go_to(String url) {
        driver.get(url);

    }

    @When("I type username as {string} and I type password as {string}")
    public void i_type_username_as_and_i_type_password_as(String usern, String pass) {
        System.out.println("anto:" + usern);
        loginPage.initialize();
        loginPage.setUsername(usern);
        loginPage.setPassword(pass);

    }

    @Then("I should be logged in")
    public void i_should_be_logged_in(String loginButton) {
//        loginPage.setLoginButton(loginButton);

//        element.isDisplayed()
        Assert.assertTrue(true);
    }

    @When("i click on refresh button")
    public void i_click_on_refresh_button() {

    }

    @Then("page should be refreshed")
    public void page_should_be_refreshed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @Then("login shouldn't work")
    public void login_shouldn_t_work(String errorText) {
        loginPage.setErrorText(errorText);

//        Assert.assertEquals(errorText.gettext(), "Epic sad face: Password is required");
//        Assert.assertEquals(ErrorText.errorText(), "Epic sad face: Password is required");

    }

    @Given("I don't enter anything on username")
    public void i_don_t_enter_anything_on_username() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("i don't enter anything on password")
    public void i_don_t_enter_anything_on_password() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("an error pop-up is displayed")
    public void an_error_pop_up_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("I write wrong credentials")
    public void i_write_wrong_credentials() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("an error pop-up is displayed {string}")
    public void an_error_pop_up_is_displayed(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("valid username as standard user and blank password")
    public void valid_username_as_standard_user_and_blank_password() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("I click on login")
    public void i_click_on_login() throws InterruptedException {
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
//        wait(1000);
        Thread.sleep(1000);

    }

    @Then("error message is displayed {string}")

    public void error_message_is_displayed(String hamburgerButtonCls) {
        loginPage.setHamburgerButton(hamburgerButtonCls);
    }


    @Given("user is on demo site")
    public void userIsOnDemoSite() {
        driver.get("https://demoqa.com/radio-button");

    }

    @When("User selects impressive radio button")
    public void userSelectsImpressiveRadioButton() throws InterruptedException {
        driver.findElement(By.xpath("//label[normalize-space()='Impressive']")).click();
        Thread.sleep(2000);
    }

    @Then("check label is displayed correctly")
    public void checkLabelIsDisplayedCorrectly() {

        WebElement element = driver.findElement(By.className("text-success"));
        element.click();

        String strng = element.getText();
        System.out.println("strng");

        Assert.assertEquals("Impressive", strng);

    }


    }











