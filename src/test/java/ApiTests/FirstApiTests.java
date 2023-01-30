package ApiTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;


public class FirstApiTests {
    @Test
    public void registartionSuccesful() {
        RestAssured.baseURI = "https://bookstore.toolsqa.com";
        RequestSpecification request = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("UserName", "toni-test");
        requestParams.put("Password", "Test!23.");
        request.body(requestParams.toJSONString());
        Response response = request.post("/Account/v1/User");
        Assert.assertEquals(response.getStatusCode(), 201);
        String userID = response.getBody().jsonPath().getString("userID");

    }


}




