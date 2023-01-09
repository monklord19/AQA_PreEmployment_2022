package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SpotifyHomePage {
    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement acceptCookiesButton;
    @FindBy(className = "ButtonInner-sc-14ud5tc-0 kuwYvr encore-inverted-light-set")
    private WebElement loginButton;


    WebDriver driver;

    public SpotifyHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void clickAcceptCookiesButton() {

        acceptCookiesButton.click();
    }

    public void clickLoginButton() {
        loginButton.click();
    }

}
