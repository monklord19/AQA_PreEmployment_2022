package ApiTests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class FirstApiTests {


    @Test
    public void getEmployees(){
        String endpoint ="http://dummy.restapiexample.com/employees";
        given().when().get(endpoint).then().log().body();
    }

    @Test
    public void getSpecificEmployee(){
        String endpoint ="https://dummy.restapiexample.com/api/v1/employee/1";
        var abc = given().when().get(endpoint).then().assertThat().body("status", equalTo("succes") );
        abc.log().body();
    }

    @Test
    public void updateEmployee() {
        String endpoint = "https://dummy.restapiexample.com/public/api/v1/update/21";
        String body = """
                {
                "name": "test",
                 "salary": "123",
                 "age": "23"
                 }
                 """;
        var response = given().body(body).when().post(endpoint).then().log().body();
        response.assertThat().body("status", equalTo("succes"));


    }
}
