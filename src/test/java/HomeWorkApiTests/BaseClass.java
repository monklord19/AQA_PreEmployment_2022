package HomeWorkApiTests;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class BaseClass {

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api";
    }

}
