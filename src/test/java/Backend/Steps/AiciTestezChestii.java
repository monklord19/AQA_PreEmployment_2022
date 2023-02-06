package Backend.Steps;

import Backend.apiEngine.Requests.CreateUserAccountRequest;
import Backend.apiEngine.Routes.Routes;
import Configurations.BackendConfigs.BackendPropertiesReader;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;
import org.testng.annotations.Test;

public class AiciTestezChestii {
    @Test
    public void testezChestii() {
        String BASE_URL = "https://demoqa.com/";
        RequestSpecification requestSpecificationSettings;
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri(BASE_URL);
        builder.setContentType(ContentType.JSON);
        builder.addHeader("Content-Type", "application/json");
        requestSpecificationSettings = builder.build();
//        RequestSpecification request = RestAssured.given().spec(requestSpecificationSettings).header("Authorization", "Bearer " + token);
        String userName = BackendPropertiesReader.getInstance().getUserName();
        String password = BackendPropertiesReader.getInstance().getPassword();
        CreateUserAccountRequest createUser=new CreateUserAccountRequest(userName,password);
        Routes createUserRoute = Routes.CreateUser;
        Response response = RestAssured.given().spec(requestSpecificationSettings).body(createUser).when().post(createUserRoute.getUrl());
        String res = response.asPrettyString();
        System.out.println(res);
    }

}
