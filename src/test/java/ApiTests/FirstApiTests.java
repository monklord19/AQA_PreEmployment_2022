package ApiTests;

import org.junit.Test;

import static io.restassured.RestAssured.given;

public class FirstApiTests {
    @Test
    public void getEmployee() {
        String endpoint = "https://dummy.restapiexample.com/api/v1/employees";
        given().when().get(endpoint).then().log().body();
    }

    @Test
    public void getSpecificEmployee() {
        String endpoint = "http://dummy.restapiexample.com/employee/1";
        given().when().get(endpoint).then().log().body();
    }
    @Test
    public void addEmployee(){
        String endpoint ="http://dummy.restapiexample.com/create";
        String body= """
                {"name":"test",
                "salary":"123",
                "age":"23"
                }
                """;
     given().body(body).when().post(endpoint).then().log().body();

    }
@Test
    public void updateEmployee(){
        String endpoint ="http://dummy.restapiexample.com/update/4118";
        String body = """
                {"name":"test",
                "salary":"123",
                "age":"23"}
                """;
        given().body(body).when().put(endpoint).then().log().body();
}

//    public void deleteEmplyee(){
//        String endpoint ="http://dummy.restapiexample.com/delete/4118";
//        given().when().delete(endpoint).then().
//}
}

