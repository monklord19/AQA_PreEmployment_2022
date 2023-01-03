package locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AboutPageLocators {

    WebDriver driver;

    public AboutPageLocators(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static final String ABOUT_BUTTON_ID = "about_sidebar_link";

    @FindBy(id = AboutPageLocators.ABOUT_BUTTON_ID)
    @CacheLookup
    private
    WebElement aboutButton;

    public WebElement getAboutButton() {
        return aboutButton;
    }
}
