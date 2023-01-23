package ApiTests;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class FirstApiTests {
    String BaseUrl = "https://reqres.in/";

    @Test
    public void GetListUsers() {
        String endpoint = "api/users";
        var response = given().queryParam("page", "2").when().get(BaseUrl + endpoint).then();
        response.log().body();
        response.assertThat().statusCode(200);
    }

    @Test
    public void GetSingleUsers() {
        String endpoint = "api/users/2";
        var response = given().when().get(BaseUrl + endpoint).then();
        response.log().body();
        response.assertThat().statusCode(200);
    }

    @Test
    public void GetSingleUsersNotFound() {
        String endpoint = "api/users/23";
        var response = given().when().get(BaseUrl + endpoint).then();
        response.log().body();
        response.assertThat().statusCode(404);
    }

    @Test
    public void GetListResource() {
        String endpoint = "api/unknown";
        var response = given().when().get(BaseUrl + endpoint).then();
        response.log().body();
        response.assertThat().statusCode(200);
    }

    @Test
    public void GetSingleResource() {
        String endpoint = "api/unknown/2";
        var response = given().when().get(BaseUrl + endpoint).then();
        response.log().body();
        response.assertThat().statusCode(200);
    }

    @Test
    public void GetResourceNotFound() {
        String endpoint = "api/unknown/23";
        var response = given().when().get(BaseUrl + endpoint).then();
        response.log().body();
        response.assertThat().statusCode(404);
    }

    @Test
    public void PostCreate() {
        String endpoint = "api/users";
        String body = """ 
                {
                     "name": "Matei",
                     "job": "Bucatar sef"
                 }
                """;
        var response = given().body(body).when().post(BaseUrl + endpoint).then();
        response.log().body();
        response.assertThat().statusCode(201);
    }

    @Test
    public void UpdateUser() {
        String endpoint = "api/users/2";
        String body = """
                {
                    "name": "morpheus",
                    "job": "zion resident"
                }
                """;
        var response = given().body(body).when().put(BaseUrl + endpoint).then();
        response.log().body();
        response.assertThat().statusCode(200);
        response.time(Matchers.lessThan(2000L));
    }

    @Test
    public void DeleteUser() {
        String endpoint = "api/users/2";
        var response = given().when().delete(BaseUrl + endpoint);
        response.then().assertThat().statusCode(204);
        System.out.println(response.getTime());
    }

@Test
    public void GetDelayedResponse() {
        String endpoint = "api/users";
        var response = given().queryParam("delay", "3").when().get(BaseUrl + endpoint);
        response.then().assertThat().statusCode(200);
        response.then().time(Matchers.greaterThan(3000L));
        System.out.println(response.getTime());
}
}
