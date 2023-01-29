//package stepDefinitions;
//
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.junit.Assert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.time.Duration;
//
////import static java.awt.SystemColor.window;
//
//public class SpotifyLoginSteps {
//    WebDriver driver = new ChromeDriver();
//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//    JavascriptExecutor js = (JavascriptExecutor) driver;
//
//    //1st scenario
//    @Given("User is on spotify homepage")
//    public void onSpotifyWebsite() {
//        driver.get("https://open.spotify.com/");
//        //driver.get("https://accounts.spotify.com/en/login?continue=https%3A%2F%2Fopen.spotify.com%2F");
//        driver.manage().window().maximize();
//    }
//
//    @When("The user clicks on the accept cookies button")
//    public void clickLoginButton() {
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("onetrust-accept-btn-handler"))).click();
//    }
//
//    @And("Clicks on the Log In button")
//    public void clickLogIn() {
//        driver.findElement(By.cssSelector(".ButtonInner-sc-14ud5tc-0.kuwYvr.encore-inverted-light-set")).click();
//    }
//
//    @And("User enters username")
//    public void enterUsername() {
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("login-username"))).sendKeys("test");
//    }
//
//    @And("User enters password")
//    public void enterPassword() {
//        driver.findElement(By.id("login-password")).sendKeys("test");
//    }
//
//    @And("Clicks the Log in button")
//    public void clickLogin() throws InterruptedException {
//        driver.findElement(By.id("login-button")).click();
//        Thread.sleep(500);
//    }
//
//    @Then("User should get an error message")
//    public void errorMessage() {
//        String mesajDeEroare = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[1]/span")).getText();
//        String mesajDeEroarePrimit = "Incorrect username or password.";
//        Assert.assertEquals(mesajDeEroare, mesajDeEroarePrimit);
//    }
//
//    //2nd scenario
//    @And("Clicks on the Apple button")
//    public void appleButton() {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/ul/li[2]/button"))).click();
//    }
//
//    @And("User enters email")
//    public void inputEmail() {
//        driver.findElement(By.id("account_name_text_field")).sendKeys("spot@gmail.com");
//    }
//
//    @And("Clicks the arrow button")
//    public void arrowButton() {
//        driver.findElement(By.id("sign-in")).click();
//    }
//
//    @And("User enters Apple password")
//    public void applePassword() {
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("password_text_field"))).sendKeys("apple");
//        //driver.findElement(By.id("password_text_field")).sendKeys("apple");
//    }
//
//    @Then("User should get an apple id error message")
//    public void appleErrorMessage() {
//        String errMsg = driver.findElement(By.cssSelector("//*[@id=\"signin\"]/div[1]/div[2]/div")).getText();
//        String errMsgReceived = "Your Apple ID or password was incorrect.";
//        Assert.assertEquals(errMsg, errMsgReceived);
//    }
//
//    //3rd scenario Fb login
//    @And("Clicks on the Facebook button")
//    public void fbButton() {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/ul/li[1]"))).click();
//    }
//
//    @And("Clicks on the Allow cookies button")
//    public void fbCookies() {
//        driver.findElement(By.xpath("//*[@id=\"u_0_b_3g\"]")).click();
//    }
//
//    @And("User enters facebook email")
//    public void fbEmail() {
//        driver.findElement(By.id("email")).click();
//    }
//
//    @And("User enters facebook password")
//    public void fbPass() {
//        driver.findElement(By.id("pass")).click();
//    }
//
//    @And("Clicks log in button")
//    public void fbLogin() {
//        driver.findElement(By.id("loginbutton")).click();
//    }
//
//    @Then("An error message should pop up")
//    public void fbErrMsg() {
//    }
//}
