package ApiTests;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ReqresApiTests {

    @Test
    public void GetListUsers() {
        String getusers = "https://reqres.in/api/users?page=2";
        var list = given().when().get(getusers).then().assertThat().body("page",equalTo(2)).body("per_page",equalTo(6));
        list.log().body();
    }



    @Test
    public void SingleUser() {
        String singleuser = "https://reqres.in/api/users/2";
        given().when().get(singleuser).then().log().body();
    }

    @Test
    public void PostUser(){
        String postuser = "https://reqres.in/api/unknown/2";
        String body = """
                 {
                 "name": "morpheus",
                 "job": "leader"
                     }
                """;
        var response = given().body(body).when().post(postuser).then().log().body();
        response.assertThat().body("name",equalTo("morpheus"));
    }
}