package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpotifyHomePage extends MainPage {
    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement acceptCookies;
    @FindBy(css = "[class='ButtonInner-sc-14ud5tc-0 kuwYvr encore-inverted-light-set']")
    private WebElement loginButton;
    public SpotifyHomePage (WebDriver driverWeb) {
        super(driverWeb);
    }
    public void clickAcceptCookies() {
        acceptCookies.click();
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}
