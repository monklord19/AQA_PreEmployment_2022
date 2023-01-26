package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

import static pageObjects.LoginPageLocators.loginId;


public class LoginPage {
    WebDriver driver;
    LoginPageLocators loginLocators;

    public LoginPage(WebDriver driver) {
        this.driver=driver;
        loginLocators=new LoginPageLocators(driver);

    }
public void initialize(){
        loginLocators.initialize();
}
    public void setUsername(String usern) {


        loginLocators.getUsername().clear();
        loginLocators.getUsername().sendKeys(usern);
    }

    public void setPassword(String pass) {
        loginLocators.getPassword().clear();

        loginLocators.getPassword().sendKeys(pass);


    }


    public void setLoginButton(String loginId) {
        loginLocators.getLoginButton().click();


    }

    public void setErrorText(String errorMessageXpath) {

        loginLocators.getErrorText().clear();
        loginLocators.getErrorText().sendKeys(errorMessageXpath);
    }

    public void setHamburgerButton(String hamburgerButtonCls) {

        loginLocators.getHamburgerButton().clear();
        loginLocators.getHamburgerButton().sendKeys(hamburgerButtonCls);


    }

    public void setElement(String element) {
//        loginLocators.getElement().clear();
//        loginLocators.getElement().sendKeys(element);
    }


    public void clickOnLogin() {
//        loginLocators.getLoginButtonSpotify().click();
    }

    public void setUser(String uname) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        wait.until(ExpectedConditions.visibilityOf(loginLocators.getUsernameSpotify()));
//        loginLocators.getUsernameSpotify().clear();
//        loginLocators.getUsernameSpotify().sendKeys(uname);
    }

    public void setPass(String psw) {
//        loginLocators.getPassSpotify().clear();
//        loginLocators.getPassSpotify().sendKeys(psw);
    }

    public void clickOnLoginSpotify() {
//        loginLocators.getLogInSpotify().click();
    }

    public void checkSErrorMessage(String eMessage) {

//        wait.until(ExpectedConditions.visibilityOf(loginLocators.getErrorMessage()));
//        Assert.assertEquals(loginLocators.getErrorMessage().getText(), eMessage);
    }

    public void checkErrorMessage(String msg) {
//        loginLocators.
    }
}