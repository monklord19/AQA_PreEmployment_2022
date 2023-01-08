package Testing.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class LoginPage {
  @FindBy(id = "user-name")
  private WebElement txt_username;
  @FindBy(id="password")
  private WebElement txt_password;
   @FindBy(id="login-button")
   private WebElement btn_login;
   @FindBy(className = "bm-burger-button")
   private WebElement btn_hamburger;
   @FindBy(xpath ="//h3[@data-test = 'error']" )
   private WebElement errorMessage;
   @FindBy(xpath = "//a[@id = 'logout_sidebar_link']")
   private WebElement btn_logout;
    public WebElement getTxt_username() {
        return txt_username;
    }

    public WebElement getTxt_password() {
        return txt_password;
    }

    public WebElement getBtn_login() {
        return btn_login;
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }
    public WebElement getBtn_hamburger() {
        return btn_hamburger;

    }
}