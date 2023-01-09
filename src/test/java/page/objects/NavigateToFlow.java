package page.objects;

import Locators.PageLocators;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class NavigateToFlow {

    WebDriver driver;
    PageLocators pageLocators;
    LoginFlow loginFlow;

    public NavigateToFlow(WebDriver driver) {
        this.driver = driver;
        pageLocators = new PageLocators(driver);
        loginFlow = new LoginFlow(driver);
    }

    public void Login(String url, String username, String password) {
        driver.get(url);
        loginFlow.setUsername(username);
        loginFlow.setPassword(password);
        loginFlow.clickLogin();
        loginFlow.checkHomePageOpened();

}

    public void ClickOnShoppingCart(){
    pageLocators.getShoppingCart().click();
    }

    public void CheckShoppingCartItems(){
        Assert.assertTrue(pageLocators.getPageTitle().isDisplayed());
    }

}


