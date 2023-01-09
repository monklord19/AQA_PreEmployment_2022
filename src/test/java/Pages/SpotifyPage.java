package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SpotifyPage {
    WebDriver driver = new ChromeDriver();

    public void URL () {
        driver.get("https://accounts.spotify.com/en/login?continue=https%3A%2F%2Fopen.spotify.com%2F");
        driver.manage().window().maximize();

    }

    public void enterInvalidUser(String invalidUser) {
        driver.findElement(By.id("login-username")).sendKeys(invalidUser);

    }

    public void enterInvalidPassword(String invalidPassword) {

        driver.findElement(By.id("login-password")).sendKeys(invalidPassword);

    }

    public void warningMessage() {
        WebElement warningMessage = driver.findElement(By.cssSelector("div[role='alert'] > .Message-sc-15vkh7g-0.jHItEP"));
        Assert.assertEquals("Incorrect username or password.", warningMessage.getText());
        System.out.println("Warning message is displayed");
    }

    public void loginButton () {
        driver.findElement(By.cssSelector("[class='Type__TypeElement-goli3j-0 dmuHFl sc-hKwDye fXzRSj']")).click();
    }

}

