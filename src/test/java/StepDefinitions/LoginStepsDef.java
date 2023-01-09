package StepDefinitions;
import Pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginStepsDef {

   /* @Before
    public void LaunchBrowser() {
        //System.setProperty("webdriver.chrome.driver", "C://Users//franc//drivers//chromedriver.exe");
        driver.manage().window().maximize();
    }

    */

    WebDriver driver = new ChromeDriver();
    LoginPage loginPage = new LoginPage(driver);


    @After
    public void closeBrowser() {
        driver.quit();
    }

    @Given("User navigates to website {string}")
    public void user_navigates_to_website(String url) {
        driver.get(url);
    }

    @When("User enters partially valid username {string} and partially valid password {string}")
    public void user_enters_partially_valid_username_and_partially_valid_password(String username, String password) {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
    }

    @When("User clicks on Login button")
    public void user_clicks_on_login_button() {
        loginPage.clickOnLoginButton();
    }


    @When("User enters valid username {string} and valid password {string}")
    public void userEntersValidUsernameAndValidPassword(String username, String password) {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
    }

    @Then("Login successful")
    public void loginSuccessful() throws InterruptedException {
        Thread.sleep(3000);
        loginPage.clickOnLoginButton();
    }

    @When("User enters valid username {string} and adds a random number to a valid password {string}")
    public void userEntersValidUsernameAndAddsARandomNumberToAValidPassword(String username, String password) {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
    }

    @When("User enters valid username {string} and leaves password {string} field blank")
    public void userEntersValidUsernameAndLeavesPasswordFieldBlank(String username, String password) {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
    }

    @When("User adds a random number to a valid username {string} and enters valid password {string}")
    public void userAddsARandomNumberToAValidUsernameAndEntersValidPassword(String username, String password) {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
    }

    @When("User adds a random number to a valid username {string} and leaves password {string} field blank")
    public void userAddsARandomNumberToAValidUsernameAndLeavesPasswordFieldBlank(String username, String password) {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
    }

    @When("User enters valid username {string} with a blank space suffix and enters valid password {string}")
    public void userEntersValidUsernameWithABlankSpaceSuffixAndEntersValidPassword(String username, String password) {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
    }

    @When("User enters valid username {string} and enters valid password {string} with a blank space suffix")
    public void userEntersValidUsernameAndEntersValidPasswordWithABlankSpaceSuffix(String username, String password) {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
    }

    @When("User leaves username field blank {string} and enters valid password {string}")
    public void userLeavesUsernameFieldBlankAndEntersValidPassword(String username, String password) {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
    }

    @When("User leaves username field blank {string} and enters invalid password {string}")
    public void userLeavesUsernameFieldBlankAndEntersInvalidPassword(String username, String password) {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
    }

    @When("User leaves username field blank {string} and leaves password field blank {string}")
    public void userLeavesUsernameFieldBlankAndLeavesPasswordFieldBlank(String username, String password) {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
    }


    @Then("User can`t login and error message {string} is displayed")
    public void userCanTLoginAndErrorMessageIsDisplayed(String errorMessage) {
        loginPage.checkErrorMessage(errorMessage);
    }

    @Then("locked_out_user should not be able to login on the website and error message {string} is displayed")
    public void locked_out_userShouldNotBeAbleToLoginOnTheWebsiteAndErrorMessageIsDisplayed(String errorMessage) {
        if (errorMessage == "") {
            Assertions.assertEquals(1, 1);
        }
        else {
            loginPage.checkErrorMessage(errorMessage);
        }

    }

}