package ApiTest;


import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

//import static com.google.common.base.Predicates.equalTo;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class FirstApiTests {
    @Test
    public void getEmployees(){
        String endpoint = "https://dummy.restapiexample.com/api/v1/employees";
        given().when().get(endpoint).then().log().body();
    }

    @Test
    public void getSpecificEmployee(){
        String endpoint = "https://dummy.restapiexample.com/api/v1/employee/1";
        var abc = given().when().get(endpoint).then().assertThat().body("status", equalTo("success"));
        abc.log();
    }

    @Test
    public void addEmployee(){
        String endpoint = "https://dummy.restapiexample.com/api/v1/create";
        String body = """
                {
                    "name":"test",
                    "salary":"123",
                    "age":23
                }
                """;
        var response = given().body(body).when().post(endpoint).then().log().body();
        response.assertThat().body("status", equalTo("success"));
    }

    @Test
    public void updateEmployee(){
        String endpoint = "https://dummy.restapiexample.com/api/v1/update/4118";
        String body = """       
                {
                "name":"test",
                "salary":"123",
                "age":123
                }
                """;
        var response = given().body(body).when().put(endpoint).then().log().body();
        response.assertThat().body("status", equalTo("success"));
    }




}
