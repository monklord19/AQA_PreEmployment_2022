package Backend.Steps;

import Backend.apiEngine.Endpoints.CommonMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class CommonSteps {
    @Given("I set request specifications")
    public void iSetRequestSpecifications() {
        CommonMethods.iSetTheRequestSpecifications();
    }


    @And("I am an authorized user")
    public void iAmAnAuthorizedUser() {
        CommonMethods.iSetRequestSpecificationsWithToken();
    }


}
