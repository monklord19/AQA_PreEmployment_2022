package Backend.Steps;

import Backend.apiEngine.Endpoints.CommonMethods;
import Backend.apiEngine.Endpoints.PostEndpoints;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.specification.RequestSpecification;

public class CommonSteps {
    @Given("I set request specifications")
    public void iSetRequestSpecifications() {
        CommonMethods.iSetTheRequestSpecifications();
    }


    @And("I am an authorized user")
    public void iAmAnAuthorizedUser() {
        PostEndpoints.generateToken();
        PostEndpoints.getToken();
//        CommonMethods.iSetRequestSpecificationsWithToken();
        String token= PostEndpoints.getToken();
        RequestSpecification requestSpecificationWithToken=CommonMethods.iSetTheRequestSpecifications().header("Authorization", "Bearer " + token);
    }


}
