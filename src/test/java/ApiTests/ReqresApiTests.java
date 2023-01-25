package ApiTests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ReqresApiTests {

    @Test
    public void getAllUsers(){
        String endpoint = "https://reqres.in/api/users?page=2";
        given().when().get(endpoint).then().log().body();
    }

    @Test
    public void getSingleUser(){
        String endpoint = "https://reqres.in/api/users/2";
        given().when().get(endpoint).then().log().body();
    }

    @Test
    public void getNotFoundUser(){
        String endpoint = "https://reqres.in/api/users/-2";
        given().when().get(endpoint).then().log().body();
    }
    @Test
    public void updateSingleUser(){
        String endpoint = "https://reqres.in/api/users/2";
        String body= """
                {
                 "name": "morpheus",
                 "job": "zion resident"
                }
                """;
        var response = given().body(body).when().put(endpoint).then().log().body();
    }

    @Test
    public void createSingleUser(){
        String endpoint = "https://reqres.in/api/users";
        String body = """
               {
               "name":"Franci",
               "job":"qa",
               }
               """;
        var response= given().body(body).when().post(endpoint).then().log().body();
    }

    @Test
    public void deleteSingleUser(){
        String endpoint = "https://reqres.in/api/users/2";
        given().when().delete(endpoint).then().log().body();
    }
}
