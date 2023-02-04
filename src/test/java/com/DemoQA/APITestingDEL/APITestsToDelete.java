package com.DemoQA.APITestingDEL;

import org.junit.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class APITestsToDelete {

 @Test
    public void PostUser() {
        String postuser = "https://reqres.in/api/users";
        String newuserbody = """
               {
               "name": "calina",
               "job": "maniu"
               }
               """;
        given().when().post(postuser).then().log().body();
    }


    @Test
    public void getEmployees() {
        String endpoint = "https://dummy.restapiexample.com/";
        given().when().get(endpoint).then().log().body();
    }

    @Test
    public void getSpecificEmployee() {
        String endpoint  = "https://dummy.restapiexample.com/api/v1/employee/1";
        var asd = given().when().get(endpoint).then().assertThat().body("status",equalTo("success")).body("data.id",equalTo(1));
        asd.log().body();
    }


    @Test
    public void addEmployee(){
        String endpoint = "https://dummy.restapiexample.com/api/v1/create";
        String body = """
               {
               "name":"testttt",
               "salary":"111123",
               "age":"32"
               }
               """;
        var response = given().body(body).when().post(endpoint).then().log().body();
        response.assertThat().body("status",equalTo("success"));
    }

    @Test
    public void addUser(){
        String endpoint = "http://bookstore.toolsqa.com/swagger/Account/v1/User";
        given().when().post(endpoint).then().log().body();
    }

}
