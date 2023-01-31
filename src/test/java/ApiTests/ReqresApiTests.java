package ApiTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;



public class ReqresApiTests {

    @Test
    public void GetListUsers() {
        String getusers = "https://reqres.in/api/users?page=2";
        var list = given().when().get(getusers).then().assertThat().body("page", equalTo(2)).body("per_page", equalTo(6));
        list.log().body();
    }

    @Test
    public void SingleUser() {
        String singleuser = "https://reqres.in/api/users/2";
        given().when().get(singleuser).then().log().body();
    }


    @Test
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

    @Test
    public void RegisterSuccessful() {
        String register = "https://reqres.in/api/register";
        String regsuccesful = """
                {
                "email": "eve.holt@reqres.in",
                "password": "pistol"
                }
                """;
        given().when().post(register).then().log().body();
    }

    @Test
    public void DeleteUser() {
        String user = "https://reqres.in/api/user/2";
        given().when().delete(user).then().log().body();
    }

    public void Test1() {
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");

        System.out.println("Response : " + response.asString());
        System.out.println("Status Code : " + response.getStatusCode());
        System.out.println("Body : " + response.getBody().asString());
        System.out.println("Time taken : " + response.getTime());
        System.out.println("Header : " + response.getHeader("content-type"));

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }


    @Test
    public void Test2() {

        given().get("https://reqres.in/api/users?page=2").then().statusCode(200);
    }

    @Test
    public void Test3() {
        Response response = RestAssured.put("https://reqres.in/api/users/2");

        System.out.println("Response : " + response.asString());
        System.out.println("Status Code : " + response.getStatusCode());
        System.out.println("Body : " + response.getBody().asString());
        System.out.println("Time taken : " + response.getTime());
        System.out.println("Header : " + response.getHeader("content-type"));

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void Test4() {

        String url = "https://reqres.in/api/users/2";
        var time = given().when().get(url).then().assertThat().time(lessThan(500L));
    }

    @Test
    public void Test5 (){
    Response response = RestAssured.get("https://reqres.in/api/users?page=2");

    // Get the status code of the request.
    //If request is successful, status code will be 200

    int statusCode = response.getStatusCode();

    // Assert that correct status code is returned.
      Assert.assertEquals(statusCode,200);
}
}

