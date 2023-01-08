package step.definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.objects.AboutPage;
import page.objects.LoginPage;

public class AboutSteps extends BaseClass {
    LoginPage loginPage;
    AboutPage aboutPage;

    public AboutSteps(TestContext context) {
        this.driver = context.driver;
        aboutPage = new AboutPage(driver);
    }

    @When("user clicks on About button")
    public void userClicksOnAboutButton() {
        loginPage = new LoginPage(driver);
        loginPage.clickHamburgerBtn();
        aboutPage.clickAboutButton();
    }

    @Then("About page opens")
    public void aboutPageOpens() {
        aboutPage.checkAboutPageOpened();
    }

}
