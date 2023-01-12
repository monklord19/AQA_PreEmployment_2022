package page.objects;

import locators.AboutPageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AboutPage {

    WebDriverWait wait;
    WebDriver driver;

    AboutPageLocators aboutLocators;

    public AboutPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        aboutLocators = new AboutPageLocators(driver);
    }

    public void clickAboutButton() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(aboutLocators.getAboutButton()));
        aboutLocators.getAboutButton().click();
    }

    public void checkAboutPageOpened() {
        Assert.assertEquals(driver.getTitle(), "Cross Browser Testing, Selenium Testing, Mobile Testing | Sauce Labs");
    }

}
