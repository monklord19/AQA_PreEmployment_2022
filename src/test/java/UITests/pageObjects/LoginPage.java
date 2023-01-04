package UITests.pageObjects;

import org.openqa.selenium.By;

public class LoginPage {
    public static final By usernameInput = By.cssSelector("#user-name");
    public static final By passwordInput = By.id("password");
    public static final By errorMessageContainer = By.className("error-message-container");

    public static final By loginButton = By.id("login-button");


    public By getUsernameInput() {
        return usernameInput;
    }

    public By getPasswordInput() {
        return passwordInput;
    }

    public By getErrorMessageContainer() {
        return errorMessageContainer;
    }

    public By getLoginButton() {
        return loginButton;
    }
}
