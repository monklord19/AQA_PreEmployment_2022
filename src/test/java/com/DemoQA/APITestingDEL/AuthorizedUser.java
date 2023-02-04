package com.DemoQA.APITestingDEL;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Test;


public class AuthorizedUser {

    @Test
    public void CreateAuthorizedUser() {
        RestAssured.baseURI ="https://bookstore.toolsqa.com";
        RequestSpecification request = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("userName", "CM");
        requestParams.put("password", "PPPbdgfj11*");
        request.body(requestParams.toJSONString());
        Response response = request.post("/Account/v1/User");
        ResponseBody body = response.getBody();
        System.out.println(response.getStatusLine());
        System.out.println(body.asString());
    }


    @Test
    public void RegistrationSuccessful() {
        RestAssured.baseURI = "https://bookstore.toolsqa.com";
        RequestSpecification request = RestAssured.given();

        JSONObject requestParams = new JSONObject();

        requestParams.put("UserName", "Maniu Calina Claudia");
        requestParams.put("Password", "K3cnmlvdd*");

        request.body(requestParams.toJSONString());
        Response response = request.post("https://demoqa.com/swagger/#/Account/AccountV1UserPost");

        //Assert.assertEquals(response.getStatusCode(), 201);

        String userID = response.getBody().jsonPath().getString("userID");
    }
}
