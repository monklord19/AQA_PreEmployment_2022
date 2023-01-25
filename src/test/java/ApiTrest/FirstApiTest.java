package ApiTrest;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class FirstApiTest {

    @Test

    public void getEmployees() {
        RestAssured.baseURI  = "http://dummy.restapiexample.com/employees";
        RequestSpecification httpRequest = RestAssured.given();
        Response response =httpRequest.get("");
        Headers allHeaders = response.headers();
        for (Header header : allHeaders) {
            System.out.println (" " + header.getName()+"Value"+header.getValue());
        }


    }


    @Test
public void getSpecificEmployee() {
    String endpoint = "https://dummy.restapiexample.com/api/v1/employee/1";
    var asd = given().when().get(endpoint).then().assertThat().body("status",equalTo("succes"));
    asd.log().body();
}


@Test
public void addEmployee(){
        String endpoint = "https://dummy.restapiexample.com/api/v1/create";
        String body = """
                {
                {"name":"test",
                "salary":"123",
                "age":"23"}
                """;
        given().body(body).when().post(endpoint).then().log().body();

}

@Test
    public void updateEmployee(){
        String endpoint ="http://dummy.restapiexample.com/update";

    given().when().put(endpoint).then().assertThat().body("status",equalTo("succes"));
}

@Test
    public void deleteEmployee (){
        String endpoint = "http://dummy.restapiexample.com/delete";
        given().when().delete(endpoint).then().log().body();
    }


}