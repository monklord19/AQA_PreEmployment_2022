package ApiTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ReqresApiTests {

    @Test
    public void getAllUsers(){
        RestAssured.baseURI = "https://reqres.in/api/users?page=2";
        Response response = RestAssured.get(baseURI);
        given().when().get(baseURI).then().body("data.id[0]", equalTo(7)).statusCode(200).log().body();
    }

    @Test
    public void getSingleUser(){
        RestAssured.baseURI = "https://reqres.in/api/users/2";
        given().when().get(baseURI).then().body("data.id", equalTo(2)).log().body();
    }

    @Test
    public void getNotFoundUser(){
        RestAssured.baseURI = "https://reqres.in/api/users/-2";
        given().when().get(baseURI).then().log().body();
    }
    @Test
    public void updateSingleUser(){
        RestAssured.baseURI = "https://reqres.in/api/users/2";
        /*
        String body= """
                {
                 "name": "morpheus",
                 "job": "zion resident"
                }
                """;
        given().body(body).when().put(baseURI).then().log().body();
         */

        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "morpheus");
        requestParams.put("job", "zion resident");
        given().body(requestParams.toString()).when().put().then().statusCode(200).log().all();
    }

    @Test
    public void createSingleUser(){
        RestAssured.baseURI = "https://reqres.in/api/users";
        /*
        String body = """
               {
               "name":"Franci",
               "job":"qa",
               }
               """;
        given().body(body).when().post(baseURI).then().log().body();

         */

        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "Franci");
        requestParams.put("job", "qa");
        given().body(requestParams.toString()).when().post().then().statusCode(201).log().all();
    }

    @Test
    public void deleteSingleUser(){
        RestAssured.baseURI = "https://reqres.in/api/users/2";
        given().when().delete(baseURI).then().log().body();
    }
}
