package com.DemoQA.APITesting;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Test;



public class AuthorizedUser {

    @Test
    public void CreateAuthorizedUser() {
        RestAssured.baseURI = "https://bookstore.toolsqa.com";
        RequestSpecification request = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("userName", "Calina Maniu");
        requestParams.put("password", "CMcm123*");

        request.body(requestParams.toString());
        Response response = request.post("/Account/v1/User");
        //Assert.assertEquals(201,response.getStatusCode() );
        //Assert.assertEquals(response.getStatusCode(), 400);
        String userID = response.getBody().jsonPath().getString("userID");
    }


    @Test
    public void RegistrationSuccessful() {
        RestAssured.baseURI = "https://bookstore.toolsqa.com";
        RequestSpecification request = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        /*I have put a unique username and password as below,
        you can enter any as per your liking. */
        requestParams.put("UserName", "TOOLSQA-Test");
        requestParams.put("Password", "Test@@123");

        request.body(requestParams.toJSONString());
        Response response = request.post("/Account/v1/User");

        Assert.assertEquals(response.getStatusCode(), 201);
        // We will need the userID in the response body for our tests, please save it in a local variable
        String userID = response.getBody().jsonPath().getString("userID");
    }
}
