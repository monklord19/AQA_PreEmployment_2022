package ApiTests;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;

public class FirstApiTest {

    @Test

    public void getEmployees() {
        String endpoint = "http://dummy.restapiexample.com/api/v1/employees";
        given().when().get(endpoint).then().log().body();
    }

    @Test
    public void getSpecificEmployee() {
        String endpoint = "\thttps://dummy.restapiexample.com/api/v1/employee/1";
        var Employee = given().when().get(endpoint).then().assertThat().body("status", equalTo("success"));
        Employee.log().body();
    }

    @Test
    public void createEmployees() {
        String endpoint = "https://dummy.restapiexample.com/api/v1/create";
        String body = """
                {
                    "status": "success",
                    "data": {
                        "name": "test",
                        "salary": "123",
                        "age": "23",
                        "id": 25
                    }
                }
                                """;
        var response = given().body(body).when().post(endpoint).then().log().body();
        response.assertThat().body("status", equalTo("success"));
    }

    @Test
    public void updateEmployees() {
        String endpoint = "https://dummy.restapiexample.com/api/v1/update/21";
        String body = """	
                {
                    "status": "success",
                    "data": {
                        "name": "test",
                        "salary": "123",
                        "age": "23",
                        "id": 25
                    }
                }
                                """;
        var update = given().body(body).when().put(endpoint).then().log().body();
        update.assertThat().body("status", equalTo("success"));
    }

    @Test
    public void deleteEmployees() {
        String endpoint = "https://dummy.restapiexample.com/api/v1/delete/2";
        String body = """	                	
                {
                    "status": "success",
                    "message": "successfully! deleted Records"
                }
                                                """;
        var update = given().body(body).when().delete(endpoint).then().log().body();
        update.assertThat().body("status", equalTo("success"));
    }

}
