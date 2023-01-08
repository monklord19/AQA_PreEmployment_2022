package Testing.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.Testing.AppConfig;
import Testing.pageobjects.LoginPage;
import org.openqa.selenium.support.PageFactory;

public class CommonSteps extends TestBase{
    private LoginPage login = PageFactory.initElements(driver, LoginPage.class);

        @Given("User opens login page")
        public void userOpensLoginPage() {
            driver.get(AppConfig.getSiteUrl());
        }
        @And("User is logged")
        public void userIsLogged() {
            login.getTxt_username().sendKeys("standard_user");
            login.getTxt_password().sendKeys("secret_sauce");
            login.getBtn_login().click();
        }



}

