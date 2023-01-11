package Steps;
import PageObjects.CartPage;
import PageObjects.InventoryPage;
import PageObjects.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertTrue;
import Steps.SingletonClass;

public class MyStepDefs {
//    WebDriver driver;
    LoginPage loginObjects;
    InventoryPage inventoryObjects;
    CartPage cartPage;
    SingletonClass singleton = SingletonClass.getInstance();
    WebDriver driver = singleton.getDriver();
    private long duration = 0;

    @Before
    public void myStepDefsSetUp() {
        loginObjects = new LoginPage(driver);
        inventoryObjects = new InventoryPage(driver);
        cartPage = new CartPage(driver);
    }

//    @After
//    public void myStepDefsTearDown() {
//        driver.quit();
//    }

    @Given("On sauce website")
    public void onSauceWebsite() {
        loginObjects.openBrowser("https://www.saucedemo.com/");
    }

    @When("User enters valid credential {string} and {string}")
    public void userEntersValidCredentials(String userName, String password) {
        this.duration = 0;
        loginObjects.getUserNameLabel().sendKeys(userName);
        loginObjects.getPasswordLabel().sendKeys(password);
        loginObjects.getLoginButton().click();
        long startTime = System.currentTimeMillis();
        duration = System.currentTimeMillis() - startTime;
    }

    @Then("User should be logged with success {string}")
    public void userShouldBeLoggedIn(String success) {
        boolean isPresent = !driver.findElements(By.id("logout_sidebar_link")).isEmpty();
        if (Boolean.parseBoolean(success)) {
            assertTrue(isPresent);
        } else {
            Assert.assertFalse(isPresent);
        }
    }

    @Then("Loading takes less then or equal to {int} seconds")
    public void loadTakesLessThen(int seconds) {
        int durationSeconds = (int) ((duration / 1000) % 60);
        assertTrue(durationSeconds <= seconds);
    }

    @Then("Loading takes more then or equal to {int} seconds")
    public void loadTakesMoreThen(int seconds) {
        int durationSeconds = (int) ((duration / 1000) % 60);
        assertTrue(durationSeconds >= seconds);
    }

    @And("User adds all products")
    public void userAddsFirstNumberOfProducts() {
        List<WebElement> inventoryList = inventoryObjects.getInventoryItemsBuyButtons();
        for (WebElement item : inventoryList) {
            inventoryObjects.addItemToCart(item);
        }
    }

    @Then("User goes to cart and has all products")
    public void userGoesToCartAndHasAllProducts() {
        List<WebElement> inventoryList = inventoryObjects.getInventoryItemsNamesElements();
        List<String> inventoryNames = new ArrayList<>();
        for (WebElement item : inventoryList) {
            inventoryNames.add(item.getText());
        }

        cartPage.goToCartPage();

        List<String> cartNames = new ArrayList<>();
        List<WebElement> cartList = cartPage.getCartItemsNamesElements();
        for (WebElement item : cartList) {
            cartNames.add(item.getText());
        }

        for (String cartName : cartNames) {
            boolean found = false;
            for (String inventoryName : inventoryNames) {
                if (inventoryName.equals(cartName)) {
                    found = true;
                }
            }
            assertTrue(found);
        }

        for (String inventoryName : inventoryNames) {
            boolean found = false;
            for (String cartName : cartNames) {
                if (inventoryName.equals(cartName)) {
                    found = true;
                }
            }
            assertTrue(found);
        }
    }
    @Given("On demo website")
    public void onDemoWebsite() {
        driver.get("https://demoqa.com/radio-button");
    }

    @When("User selects impressive radio button")
    public void userSelectsImpressiveRadioButton (){
        driver.findElement(By.xpath("//label[text()='Impressive']")).click();
    }

    @Then("Check label is displayed correctly")
    public void checkLabelIsDisplayedCorrectly () {
        WebElement radioElement = driver.findElement(By.xpath("//label[text()='Impressive']"));
        boolean selectState = radioElement.isEnabled();
        if (selectState == false) {
            radioElement.click();
        }
    }
}
