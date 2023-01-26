package ApiTests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;


public class RegresApiHomework {


    @Test
    public void GetSingleUsers() {
        String endpoint = "https://reqres.in/api/users/2";
        var response = given().when().get(endpoint).then().log().body();
        response.assertThat().statusCode(200);

    }

        @Test
        public void GetSingleUsersNotFound() {
            String endpoint = "https://reqres.in/api/users/23";
            var response = given().when().get(endpoint).then().log().body();
            response.assertThat().statusCode(404);

        }

    @Test
    public void GetListResource() {
        String endpoint = "https://reqres.in/api/unknown";
        var response = given().when().get(endpoint).then().log().body();
        response.assertThat().statusCode(200);
    }


    @Test
    public void PostCreate() {
        String endpoint = "https://reqres.in/api/users";
        String body = """ 
                {
                     "name": "morpheus",
                     "job": "leader"
                 }
                """;
        var response = given().body(body).when().post(endpoint).then().log().body();
        response.assertThat().statusCode(201);
    }


    @Test
    public void PutUpdateUser() {
        String endpoint = "https://reqres.in/api/users/2";
        String body = """
                {
                    "name": "morpheus",
                    "job": "zion resident"
                }
                """;
        var response = given().body(body).when().put(endpoint).then().log().body();
        response.assertThat().statusCode(200);

    }

    @Test
    public void DeleteUser() {
        String endpoint = "https://reqres.in/api/users/2";
        var response = given().when().delete(endpoint).then().log().body();
        response.assertThat().statusCode(204);

    }
//    @Test
//    public void PostRegisterSuccessful() {
//
//        String endpoint = "https://reqres.in/api/register";
//        String body = """
//                {
//                "email": "eve.holt@reqres.in",
//                    "password": "pistol"
//                    }
//                """;
//        var response = given().body(body).when().post(endpoint).then().log().body();
//        response.assertThat().body("email",equalTo("eve.holt@reqres.in"));
//       response.assertThat().statusCode(200);
//    }
//
//
//    @Test
//    public void PostLoginSuccessful() {
//        String endpoint = "https://reqres.in/api/login";
//        String body= """
//                {
//                "email": "eve.holt@reqres.in",
//                "password": "cityslicka"
//                }
//                """;
//        var response = given().body(body).when().post(endpoint).then().log().body();
//        response.assertThat().statusCode(200);
//
//    }

    }