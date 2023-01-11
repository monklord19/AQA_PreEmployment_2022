package opensauce.pageObjects;

import selenium.BaseClass;
import selenium.Utils.BrowserUtils;

public class LoginPage extends BaseClass {

    private static String txtUsername = "//*[@id=\"user-name\"]";
    private static String txtPassword = "//*[@id=\"password\"]";
    private static String txtLogin = "//*[@id=\"login-button\"]";

    public static void enterUsername(String username) {
        BrowserUtils.enterText(txtUsername,username);

    }

    public static void enterPassword(String password) {
        BrowserUtils.enterText(txtPassword,password);

    }

    public static void clickLogin() {
        BrowserUtils.clickElement(txtLogin);

    }
}
