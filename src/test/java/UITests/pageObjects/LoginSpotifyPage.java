package UITests.pageObjects;

import org.openqa.selenium.By;

public class LoginSpotifyPage {
    public String url = "https://accounts.spotify.com/ro-RO/login";
    public By usernameInput = By.id("login-username");
    public By loginContainer = By.cssSelector("div[data-testid=\"login-container\"]");
    public By passwordInput = By.id("login-password");
    public By errorMessageContainer = By.cssSelector("span[class^=\"Message-sc\"]");
    public By loginButton = By.id("login-button");
}