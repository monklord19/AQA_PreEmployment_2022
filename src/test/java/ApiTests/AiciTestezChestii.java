package ApiTests;

import ApiTests.apiEngine.Requests.AuthorizationRequest;
import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonObject;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.testng.annotations.Test;

public class AiciTestezChestii {
    @Test
    public void testezChestii(){

        String BASE_URL = BackendPropertiesReader.getInstance().getBaseUrl();
        RestAssured.baseURI = BASE_URL;
        RequestSpecification requestSpecificationSettings;
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri(BASE_URL);
        builder.addHeader("Content-Type:", " application/json");
        requestSpecificationSettings = builder.build();
        RequestSpecification request=RestAssured.given().spec(requestSpecificationSettings);
        String userName = BackendPropertiesReader.getInstance().getUserName();
        String password = BackendPropertiesReader.getInstance().getPassword();
        AuthorizationRequest authRequestBody = new AuthorizationRequest(userName, password);
        Routes createUserRoute = Routes.CreateUser;
        Response createUserResponse = request.body(authRequestBody).post(createUserRoute.getUrl());
        String responseAsString=createUserResponse.asPrettyString();
        System.out.println(responseAsString);
        Assert.assertEquals(201,createUserResponse.getStatusCode());

    }
}
