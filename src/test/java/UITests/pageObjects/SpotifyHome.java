package UITests.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpotifyHome {
    public WebDriver driver;
    public SpotifyHome(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "[class='ButtonInner-sc-14ud5tc-0 kuwYvr encore-inverted-light-set']")
    public WebElement logInSpotify;
    public void clickLogInSpotify() {
        logInSpotify.click();
    }
}
