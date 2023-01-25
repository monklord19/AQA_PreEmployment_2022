package ApiTests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ReqresApiTests {
    @Test
    public void getUsers(){
        String endpoint ="https://reqres.in/api/users?page=2";
        var page = given().when().get(endpoint).then().assertThat().body("page", equalTo(2));
        page.log().body();
    }

    @Test
    public void getSingleUser(){
        String endpoint ="https://reqres.in/api/users/2";
        given().when().get(endpoint).then().log().body();

    }

    @Test
    public void getUserNotFound(){
        String endpoint ="https://reqres.in/api/users/23";
        given().when().get(endpoint).then().log().body();

    }

    @Test
    public void getListResource(){
        String endpoint ="https://reqres.in/api/unknown";
        given().when().get(endpoint).then().log().body();

    }

    @Test
    public void getSingleResource(){
        String endpoint ="https://reqres.in/api/unknown/2";
        given().when().get(endpoint).then().log().body();

    }

    @Test
    public void getSingleResourceNotFound(){
        String endpoint ="https://reqres.in/api/unknown/23";
        given().when().get(endpoint).then().log().body();

    }

    @Test
    public void postCreateUser(){
        String endpoint = "https://reqres.in/api/users";
        String body = """
                {
                "name":"morpheus",
                "job":"leader"
                }
                 """;
        given().body(body).when().post(endpoint).then().log().body().statusCode(201);
    }

    @Test
    public void postLoginSuccessfully(){
        String endpoint = "https://reqres.in/api/login";
        String body = """
                {
                    "email":"eve.holt@reqres.in",
                    "password":"cityslicka"
                }
                 """;
        given().body(body).when().post(endpoint).then().log().body();
    }

    @Test
    public void putUpdateUser(){
        String endpoint = "https://reqres.in/api/users/2";
        String body = """
                {
                "name":"Paul Pop",
                "job":"Master Chef"
                }
                 """;
        given().body(body).put(endpoint).then().log().body().statusCode(200);
    }

    @Test
    public void deleteUser(){
        String endpoint = "https://reqres.in/api/users/2";
        given().when().delete(endpoint).then().log().body().statusCode(204);
    }








}
