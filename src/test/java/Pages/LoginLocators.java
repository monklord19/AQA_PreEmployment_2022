package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginLocators {
    WebDriver driver;
    public LoginLocators(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static final String bookStore_xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[6]";

    public static final String login_xpath = "//*[@id=\"item-0\"]";








}
