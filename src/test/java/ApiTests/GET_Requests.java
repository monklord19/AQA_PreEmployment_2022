package ApiTests;

import io.restassured.RestAssured;

import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GET_Requests {
    @BeforeClass
    public static void setup(){
    RestAssured.baseURI = "https://demoqa.com/BookStore/v1";}
    @Test
    public void GetBooks(){
        var asd =  given().when().get("/Books").then().log().body();

        asd.assertThat().statusCode(200);
        asd.time(Matchers.lessThan(1500L));
        asd.assertThat().body("books[0].isbn",equalTo("9781449325862"));

    }

}
