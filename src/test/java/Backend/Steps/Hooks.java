package Backend.Steps;

import Backend.apiEngine.Routes.Routes;
import Backend.apiEngine.configs.BackendPropertiesReader;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;
import org.junit.Assert;

public class Hooks {
    public static RequestSpecification iSetTheRequestSpecifications() {
        String BASE_URL = BackendPropertiesReader.getInstance().getBaseUrl();
        System.out.println(BASE_URL);
        //RestAssured.baseURI = BASE_URL;
        RequestSpecification requestSpecificationSettings;
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri(BASE_URL);
        builder.setContentType(ContentType.JSON);
        requestSpecificationSettings = builder.build();
        RequestSpecification request = RestAssured.given().spec(requestSpecificationSettings);
        return request;
    }
    public static Response createUserAccount() {
        String userName = BackendPropertiesReader.getInstance().getUserName();
        String password = BackendPropertiesReader.getInstance().getPassword();
        JSONObject requestBody = new JSONObject();
        requestBody.put("userName", userName);
        requestBody.put("password", password);
        Routes createUserRoute = Routes.CreateUser;
        System.out.println(Routes.CreateUser.getUrl());
        Response createUserResponse = Hooks.iSetTheRequestSpecifications().body(requestBody).post(createUserRoute.getUrl());
        Assert.assertEquals(201,createUserResponse.getStatusCode());
        return createUserResponse;
    }
    public static String getUserId() {
        String responseAsString = Hooks.createUserAccount().asString();
        Assert.assertTrue(responseAsString.contains("userID"));
        String userId = JsonPath.from(responseAsString).get("userID");
        return userId;
    }
    public String generateAndGetToken() {
        String userName = BackendPropertiesReader.getInstance().getUserName();
        String password = BackendPropertiesReader.getInstance().getPassword();
        JSONObject requestBody = new JSONObject();
        requestBody.put("userName", userName);
        requestBody.put("password", password);
        Routes generateTokenRoute = Routes.GenerateToken;
        Response responseForToken = Hooks.iSetTheRequestSpecifications().body(requestBody).post(generateTokenRoute.getUrl());
        String responseAsString = responseForToken.asString();
        Assert.assertTrue(responseAsString.contains("token"));
        String token = JsonPath.from(responseAsString).get("token");
        return token;
    }

    public void AuthorizedSuccessful() {
        String userName = BackendPropertiesReader.getInstance().getUserName();
        String password = BackendPropertiesReader.getInstance().getPassword();
        JSONObject requestBody = new JSONObject();
        requestBody.put("userName", userName);
        requestBody.put("password", password);
        Routes authRoute = Routes.Authorize;
        Response response = Hooks.iSetTheRequestSpecifications().body(requestBody).post(authRoute.getUrl());
        Assert.assertTrue(response.asString().contains("true"));
        Assert.assertEquals(response.getStatusCode(), 200);
    }






}
