package HomeWorkApiTests;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;

public class GetSingleUser {
    String endPointSingleUser = "https://reqres.in/api/users/2";


    @Test
    public void responseTime(){
       var response = given().when().get(endPointSingleUser).then().log().body();
       response.assertThat().time(lessThan(600l));
    }
    @Test
    public void statusCode(){
       var response = given().when().get(endPointSingleUser).then().log().body();
       response.assertThat().statusCode(200);
    }
    @Test
    public void getSingleUserIdNumber(){
        given().when().get(endPointSingleUser).then().assertThat().body("data.id",equalTo(2));
    }
    @Test
    public void getUserFirstName(){
        var response = given().when().get(endPointSingleUser).then().log().body();
        response.assertThat().body("data.first_name",equalTo("Janet"));
    }
    @Test
    public void getUserLastName(){
        var response = given().when().get(endPointSingleUser).then().log().body();
        response.assertThat().body("data.last_name",equalTo("Weaver"));
    }    @Test
    public void getUserEmail(){
        var response = given().when().get(endPointSingleUser).then().log().body();
        var emailAdd = "janet.weaver@reqres.in";
        response.assertThat().body("data.email",equalTo(emailAdd));
    }

};
