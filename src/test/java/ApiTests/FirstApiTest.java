package ApiTests;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class FirstApiTest {

    @Test
    public void getEmployees() {
        String endpoint = "https://dummy.restapiexample.com/";
        given().when().get(endpoint).then().log().body();
    }

    @Test
    public void getSpecificEmployee() {
        String endpoint  = "https://dummy.restapiexample.com/api/v1/employee/1";
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
        var response = given().body(body).when().post(endpoint).then().log().body();
        response.assertThat().body("status",equalTo("success"));
    }

    }

