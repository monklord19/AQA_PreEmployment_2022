package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class sauceLogin {

    WebDriver driver;
    By sauceUsername = By.id("user-name");
    By saucePass = By.id("password");
    By sauceWrongPass = By.id("password");
    By sauceLoginButton = By.id("login-button");
    By addToCartBikeLight = By.id("add-to-cart-sauce-labs-bike-light");
    By sauceCartButton = By.id("shopping_cart_container");
    By assertBikeLight = By.id("item_0_title_link");

    public sauceLogin(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(sauceUsername).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(saucePass).sendKeys(password);
    }

    public void enterWrongPassword(String wrongPassword) {
        driver.findElement(sauceWrongPass).sendKeys(wrongPassword);
    }

    public void clickLogin() { driver.findElement(sauceLoginButton).click(); }
    public void addToCartBikeLight() { driver.findElement(addToCartBikeLight).click(); }

    public void clickCartIcon() { driver.findElement(sauceCartButton).click();}

    public void assertBikeLight() {
        String itemReceived = driver.findElement(By.id("item_0_title_link")).getText();
        String assertBikeLight = "Sauce Labs Bike Light";
        Assert.assertEquals(itemReceived, assertBikeLight);
    }

    //String mesajDeEroare = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[1]/span")).getText();
//        String mesajDeEroarePrimit = "Incorrect username or password.";
//        Assert.assertEquals(mesajDeEroare, mesajDeEroarePrimit);

    public void loginValidUser(String username, String password) {
        driver.findElement(sauceUsername).sendKeys(username);
        driver.findElement(saucePass).sendKeys(password);
        driver.findElement(sauceLoginButton).click();
    }
}
