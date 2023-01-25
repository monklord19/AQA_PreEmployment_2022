package ApiTests;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class FirstApiTests {

    @Test
    public void getEmployees(){
        RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1/employees";
        RequestSpecification httpRequest = given();
        Response response = httpRequest.get("");
        Headers allHeaders = response.headers();
        for(Header header:allHeaders){
            System.out.println("Key:"+header.getName()+"Value"+header.getValue());
        }
    }
    @Test
    public void getSpecificEmployee(){
        String endpoint ="https://dummy.restapiexample.com/api/v1/employee/1";
        var asd = given().when().get(endpoint).then().assertThat().body("status",equalTo("success")).body("data.id",equalTo(1));
        asd.log().body();
    }
    @Test
    public void addEmployee(){
        String endpoint = "https://dummy.restapiexample.com/api/v1/create";
        String body = """
               {
               "name":"test",
               "salary":"123",
               "age":"23"
               }
               """;
        var response= given().body(body).when().post(endpoint).then().log().body();
        response.assertThat().body("status",equalTo("success"));
    }
    @Test
    public void updateEmployee(){
        String endpoint = "https://dummy.restapiexample.com/public/api/v1/update/4118";
        String body= """
               {
               "name":"test",
               "salary":"123",
               "age":"23"
               }
               """;
        var response = given().body(body).when().put(endpoint).then().log().body();
        response.assertThat().body("status",equalTo("success"));
    }
    @Test
    public void deleteEmployee(){
        String endpoint = "https://dummy.restapiexample.com/public/api/v1/delete/4118";
        given().when().delete(endpoint).then().log().body();
    }
}
