package com.DemoQA.APITesting;

import static io.restassured.RestAssured.given;

public class APITestsToDelete {

    public void PostUser() {
        String postuser = "https://reqres.in/api/users";
        String newuserbody = """
               {
               "name": "morpheus",
               "job": "leader"
               }
               """;
        given().when().post(postuser).then().log().body();
    }


}
