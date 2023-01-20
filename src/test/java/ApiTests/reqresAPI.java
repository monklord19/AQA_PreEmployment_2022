package ApiTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLOutput;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class reqresAPI {

    @Test
    public void getUser() {
          RestAssured.baseURI = "https://reqres.in/api/users?page=2";
          Response response = RestAssured.get(baseURI);
          System.out.println(response.getTime());
          given().get("https://reqres.in/api/users?page=2").then().statusCode(200).body("data.id[1]", equalTo(8)).time(Matchers.lessThan(1000L)).log().all();
    }

    @Test
    public void getSingleUser() {
//        String endpoint = "https://reqres.in/api/users/2";
//        var singleUser = given().when().get(endpoint).then().assertThat().body("status", equalTo("success"));
//        singleUser.log().body();
        given().get("https://reqres.in/api/users/2").then().statusCode(200).body("data.id", equalTo(2)).time(Matchers.lessThan(1000L)).log().all();
    }

    @Test
    public void createEmployees() {
//        String endpoint = "https://dummy.restapiexample.com/api/v1/create";
//        String body = """
//                {
//                    "status": "success",
//                    "data": {
//                        "name": "test",
//                        "salary": "123",
//                        "age": "23",
//                        "id": 25
//                    }
//                }
//                                """;
//        var response = given().body(body).when().post(endpoint).then().log().body();
//        response.assertThat().body("status", equalTo("success"));

        JSONObject request = new JSONObject();
        request.put("name", "Ferdi");
        request.put("job", "engineer");
        System.out.println(request);
        System.out.println(request.toJSONString());
        given().body(request.toJSONString()).when().post("https://reqres.in/api/users").then().statusCode(201).time(Matchers.lessThan(1000L));

    }

    @Test
    public void updateEmployees() {

        JSONObject request = new JSONObject();
        request.put("name", "Jack");
        request.put("job", "Teacher");
        System.out.println(request);
        System.out.println(request.toJSONString());
        given().body(request.toJSONString()).when().put("https://reqres.in/api/users/2").then().statusCode(200).time(Matchers.lessThan(1000L)).log().all();
    }

    @Test
    public void patchEmployees() {
        JSONObject request = new JSONObject();
        request.put("name", "Jack");
        request.put("job", "Teacher");
        System.out.println(request);
        System.out.println(request.toJSONString());
        given().body(request.toJSONString()).when().patch("https://reqres.in/api/users/2").then().statusCode(200).time(Matchers.lessThan(1000L)).log().all();
    }

    @Test
    public void deleteEmployees() {
        when().delete("https://reqres.in/api/users/2").then().statusCode(204).time(Matchers.lessThan(1000L)).log().all();
    }

}
