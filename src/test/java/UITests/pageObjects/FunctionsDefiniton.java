package UITests.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Instant;

public class FunctionsDefiniton {

    WebDriver driver;
    WebDriverWait wait;
    public FunctionsDefiniton(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    @CacheLookup
    WebElement username;
    @FindBy(id = "password")
    @CacheLookup
    WebElement password;
    @FindBy(id = "login-button")
    @CacheLookup
    WebElement loginButton;
    @FindBy(xpath = "//h3[@data-test = 'error']")
    @CacheLookup
    WebElement errorMessage;

    @FindBy(id="add-to-cart-sauce-labs-backpack")
    @CacheLookup
    WebElement addBackpack;

    @FindBy(className = "shopping_cart_link")
    @CacheLookup
    WebElement openCart;

    @FindBy(className = "inventory_item_name")
    @CacheLookup
    WebElement itemName;

    @FindBy(id="react-burger-menu-btn")
    @CacheLookup
    WebElement menuButton;

    @FindBy(id="logout_sidebar_link")
    @CacheLookup
    WebElement logoutButton;

    public void setUsername(String usernameValue)
    {
        username.clear();
        username.sendKeys(usernameValue);
    }
    public void setPassword(String passwordValue)
    {
        password.clear();
        password.sendKeys(passwordValue);
    }
    public void pressLoginButton() throws InterruptedException {
        loginButton.click();
        Thread.sleep(3000);
    }
    public void errorMessage(String message)
    {
        Assert.assertEquals(errorMessage.getText(), message);
    }
    public void refreshPage()
    {
        driver.navigate().refresh();
    }

    public void addBackpackToCart()
    {
        addBackpack.click();
    }

    public void openShoppingCart() throws InterruptedException
    {
        openCart.click();
        Thread.sleep(3000);
    }

    public void checkItemName(String itemTitle)
    {
        Assert.assertEquals(itemName.getText(), itemTitle);
    }

    public void clickMenuButton() throws InterruptedException
    {
        menuButton.click();
        Thread.sleep(1000);

    }

    public void clickLogout()throws InterruptedException
    {


        logoutButton.click();
        Thread.sleep(3000);
    }

    public void checkEmptyUsernameAndPassword() throws InterruptedException
    {
        Thread.sleep(6000);
        Assert.assertEquals(username.getText(), "");
        Assert.assertEquals(password.getText(),"");

    }
}
