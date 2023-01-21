package ApiTests;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.specification.RequestSpecification;
import org.asynchttpclient.Response;
import org.junit.Test;
import static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.given;

public class FirstApiTests {
    @Test
    public void getEmployees(){
        String endpoint = "http://dummy.restapiexample.com/api/v1/employee/1";
//        RestAssured.baseURI = "http://dummy.restapiexample.com/employees";
//        RequestSpecification httpRequest = RestAssured.given();
//        Response response = (Response) httpRequest.get("");
//        Headers allHeaders = response.getHeaders();
        given().when().get(endpoint).then().log().body();
    }
    @Test
    public void getSpecificEmplyee(){
        String endpoint = "http://dummy.restapiexample.com/api/v1/employee/1";
        //given().when().get(endpoint).then().assertThat().statusCode(200);
        //given().when().get(endpoint).then().log().body();
        var asd =given().when().get(endpoint).then().assertThat().body("status",equalTo("success"))
                .body("data.id",equalTo(1));
        asd.log().body();
    }
    @Test
    public void addEmployee(){
        String endpoint = "http://dummy.restapiexample.com/create";
        String body = """
                {
                "name":"test",
                "salary":"123",
                "age":"23"
                }
                """;
        var response = given().body(body).when().post(endpoint).then().log().body();
       // response.assertThat().body("status",equalTo("success"));
    }
    @Test
    public void updateEmployee(){
        String endpoint = "http://dummy.restapiexample.com/update/719";
        String body = """
                {
                "name":"test",
                "salary":"123",
                "age":"23"
                }
                """;
        var response = given().body(body).when().put(endpoint).then().log().body();
        // response.assertThat().body("status",equalTo("405"));
    }
    @Test
    public void deleteEmployee(){
        String endpoint = "http://dummy.restapiexample.com/delete/719";

        var response = given().when().delete().then().log().body();
        // response.assertThat().body("status",equalTo("405"));
    }
}
