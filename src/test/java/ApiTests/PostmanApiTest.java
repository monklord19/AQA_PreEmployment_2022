package ApiTests;

import Entities.User;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.junit.Test;
import java.io.*;
import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostmanApiTest {
    @Test
    public void GetAllUsers() {
        System.out.println("TEST Get all users");
        String endpoint = "https://reqres.in/api/users?page=2";
        var response = given().when().get(endpoint).then().log().body();
        response.assertThat().statusCode(200);
        response.assertThat().body("total_pages", equalTo(2)).log();
        response.time(lessThan(2000L)).log();
    }

    @Test
    public void GetSingleUser() {
        System.out.println("TEST Get single user");
        String endpoint = "https://reqres.in/api/users/2";
        var response = given().when().get(endpoint).then().log().body();
        response.assertThat().statusCode(200);
        response.assertThat().body("data.first_name", equalTo("Janet")).log();
        response.time(lessThan(2000L)).log();
    }

    @Test
    public void GetUserNotFound() {
        System.out.println("TEST Get user - not found");
        String endpoint = "https://reqres.in/api/users/23";
        given().when().get(endpoint).then().log().body();
    }

    @Test
    public void GetListResource() {
        System.out.println("TEST Get list resource");
        RestAssured.baseURI = "https://reqres.in/api/unknown";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("");
        Headers allHeaders = response.headers();
        for (Header header: allHeaders){
            System.out.println ("Key:"+header.getName( )+"Value:"+header.getValue());
        }
    }
    @Test
    public void GetSingleResource() {
        System.out.println("TEST Get single resource");
        String endpoint = "https://reqres.in/api/unknown/2";
        given().when().get(endpoint).then().log().body();
    }
    @Test
    public void GetListResourceNotFound() {
        System.out.println("TEST Get list resource - not found");
        String endpoint = "https://reqres.in/api/unknown/23";
        given().when().get(endpoint).then().log().body();
    }
    @Test
    public void CreateUser () {
        System.out.println("TEST Create user");
        String endpoint ="https://reqres.in/api/users";
        String body = """
              {"name":"morpheus1",
              "job":"leader"
             }
                """;
        var response = given().body(body).when().post(endpoint).then().log().body();
        response.assertThat().statusCode(201);
    }

    @Test
    public void CreateUserSerialization () {
        System.out.println("TEST Create user with serialization");
        String endpoint ="https://reqres.in/api/users";
        User deserializedUser = (User) UserSerializationTest.DeSerializeFromFileToObject("userSerialized");
        System.out.println("User name is " + deserializedUser.getName());
        System.out.println("User job is " + deserializedUser.getJob());
        var response = given().body(deserializedUser.toString()).when().post(endpoint).then().log().body();
        response.assertThat().statusCode(201);

    }

    @Test
    public void UpdateUser () {
        System.out.println("TEST Update user");
        String endpoint = "https://reqres.in/api/users/2";
        String body = """
                {
                    "name": "morpheus",
                    "job": "president"
                }
                """;
        var response = given().body(body).when().put(endpoint).then().log().body();
        response.assertThat().statusCode(200);
    }
    @Test
    public void UpdateUser2 () {
        System.out.println("TEST Update user2");
        String endpoint = "https://reqres.in/api/users/2";
        String body = """
                {
                    "name": "morpheus",
                    "job": "president"
                }
                """;
        var response = given().body(body).when().patch(endpoint).then().log().body();
        response.assertThat().statusCode(200);
    }

    @Test
    public void DeleteUser2 () {
        System.out.println("TEST Delete User2");
        String endpoint = "https://reqres.in/api/users/2";
        given().when().delete(endpoint).then().assertThat().statusCode(204);
    }
}

//   Instructions:
//   - Create API tests for all your requests from the Postman collection (include delete and put, if you haven't already)
//   - Use serialization: create a separate class that contains the body above and use that class. Update Test file.json and use the read method:
//         FileReader input = new FileReader ("input.json");
//   - Add tests (such as response time (assert))
