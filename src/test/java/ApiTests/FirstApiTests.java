package ApiTests;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class FirstApiTests {
    @Test
    public void getEmployees(){
        String endPoint = "http://dummy.restapiexample.com/employees";
        given().when().get(endPoint).then().log().body();
    }
    @Test
    public void getSpecificEmployee(){
        String endPoint = "https://dummy.restapiexample.com/api/v1/employee/1";
        var asd = given().when().get(endPoint).then().assertThat().body("status",equalTo("success"));
        asd.log().body();
    }
    @Test
    public void addNewEmployee(){
        String endPoint = "http://dummy.restapiexample.com/create";
        String body = """
                {
                "name":"test",
                "salary":"123",
                "age":"23"
                }
                """;
        var response = given().body(body).when().post(endPoint).then().log().body();
        response.assertThat().body("status",equalTo("success"));
    }
    @Test
    public void updateRecord(){
        String endPoint = "https://dummy.restapiexample.com/api/v1/update/21";
        String body = """
                {"name":"test",
                 "salary":"123",
                 "age":"23"}
                """;
        var response = given().body(body).when().put(endPoint).then().log().body();
        response.assertThat().body("status",equalTo("success"));

    }
    @Test
    public void deleteEmplyee(){
        String endPoint = "https://dummy.restapiexample.com/api/v1/delete/21";
    }
}
