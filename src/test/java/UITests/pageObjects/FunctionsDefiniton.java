package UITests.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FunctionsDefiniton {

    WebDriver driver;
    public FunctionsDefiniton(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindAll({
            @FindBy( id = "user-name"),
            @FindBy(id = "login-username"),
            @FindBy(id= "account_name_text_field"),
            @FindBy(id ="email")
    })
    @CacheLookup

    WebElement username;

    @FindAll({
            @FindBy(id = "password"),
            @FindBy(id = "login-password"),
            @FindBy(id= "password_text_field"),
            @FindBy(id = "pass")
    })
    @CacheLookup
    WebElement password;

    @FindAll({
            @FindBy(id = "login-button"),
            @FindBy(xpath = "//div[@class='_xkt']")
    })
    @CacheLookup
    WebElement loginButton;

    @FindAll({
            @FindBy(xpath = "//h3[@data-test = 'error']"),
            @FindBy(xpath = "//span[@class = 'Message-sc-15vkh7g-0 jHItEP']"),
            @FindBy(xpath = "//div[@class ='o6cuMc']"),
            @FindBy(xpath = "//div[@class='_4rbf _53ij']")
    })
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

    @FindBy(id="impressiveRadio")
    @CacheLookup
    WebElement radioButton;

    @FindBy(className = "text-success")
    @CacheLookup
    WebElement labelText;

    @FindBy(xpath = "//button[@data-testid='google-login']")
    @CacheLookup
    WebElement googleLoginButton;

    @FindBy(xpath = "//button[@data-testid='apple-login']")
    @CacheLookup
    WebElement appleLoginButton;

    @FindBy(xpath = "//button[@data-testid='facebook-login']")
    @CacheLookup
    WebElement facebookLoginButton;

    @FindBy(xpath = "//input[@type='email']")
    @CacheLookup
    WebElement email;

    @FindBy(id = "sign-in")
    @CacheLookup
    private WebElement buttonNext;

    @FindAll({
            @FindBy(id = "headingText"),
            @FindBy(id = "alertInfo")
    })
    @CacheLookup
    private WebElement mainText;


   @FindBy(xpath="//button[@data-cookiebanner='accept_button']")
   @CacheLookup
   private WebElement cookie;

    public WebElement getCookie()
    {
        return cookie;
    }
    public WebElement getMainText()
    {
        return mainText;
    }

    public WebElement getButtonNext()
    {
        return buttonNext;
    }
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

    public void setCredentials(String text)
    {
        if(password!=null)
        {
            password.clear();
            password.sendKeys(text);
        }
        else if(username!=null)
        {
            username.clear();
            username.sendKeys(text);
        }
    }

    public void setCredentials(String user,String pass)
    {
        username.clear();
        username.sendKeys(user);
        password.clear();
        password.sendKeys(pass);
    }
    public void pressLoginButton() throws InterruptedException {
        loginButton.click();
        Thread.sleep(9000);
    }
    public void errorMessage(String message) throws InterruptedException
    {
        Thread.sleep(6000);
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
    public void clickRadioButton()
    {
        radioButton.click();
    }

    public void checkLabelText(String text)
    {
        Assert.assertEquals(labelText.getText(), text);
    }

    public void clickGoogleLogin() throws InterruptedException
    {
        Thread.sleep(1000);
        googleLoginButton.click();
    }

    public void setEmailOrUsername(String text) throws InterruptedException
    {
        email.sendKeys(text);
        Thread.sleep(3000);
    }
    public void clickNext() throws InterruptedException
    {
        Thread.sleep(1000);
        getButtonNext().click();
    }
    public void checkText(String text) throws InterruptedException{

        Thread.sleep(1000);
        Assert.assertEquals(getMainText().getText(), text);
    }

    public void clickAppleLogin() throws InterruptedException
    {
        Thread.sleep(1000);
        appleLoginButton.click();
        Thread.sleep(3000);
    }

    public void appleSetIdAndPassword(String Id,String Password) throws InterruptedException
    {
        setUsername(Id);
        Thread.sleep(3000);
        clickNext();
        Thread.sleep(3000);

        setPassword(Password);
        Thread.sleep(3000);
        try {
            clickNext();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            WebElement buttonNxt= driver.findElement(By.id("sign-in"));
            buttonNxt.click();
        }
        Thread.sleep(3000);
    }
    public void clickFacebookLogin() throws InterruptedException
    {
        Thread.sleep(1000);
        facebookLoginButton.click();
        Thread.sleep(3000);
    }

    public void clickCookie() throws InterruptedException
    {
        Thread.sleep(1000);
        try {
            getCookie().click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            WebElement cookie= driver.findElement(By.id("u_0_b_lH"));
            cookie.click();
        }
        Thread.sleep(1000);
    }



}
