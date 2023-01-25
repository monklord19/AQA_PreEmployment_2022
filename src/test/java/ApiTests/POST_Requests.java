package ApiTests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.codec.binary.Base64;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.File;

public class POST_Requests {

    @Test
    public void AddUser(){
        RestAssured.baseURI = "https://demoqa.com/";
        File fileBody=new File("src/test/java/Util/PayloadUser");

        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Content-Type","application/json");
        Response response =httpRequest.body(fileBody).post("Account/v1/User");
        int statusCode = response.getStatusCode();
        System.out.println("Status is" +statusCode);
    }
    @Test
    public void AddBookWithBearerToken(){
        RestAssured.baseURI = "https://demoqa.com/";
        RequestSpecification request = RestAssured.given();
        String credentials ="""
                             {
                             "userName": "AndreeaCazan",
                             "password": "Mimi@@234"
                             }
                             """;
        request.header("Content-Type","application/json");

        Response responseFromToken =request.body(credentials).post("Account/v1/GenerateToken");
        responseFromToken.prettyPrint();

        String jsonString = responseFromToken.getBody().asString();
        String tokenGenerated = JsonPath.from(jsonString).get("token");

        request.header("Authorization","Bearer "+tokenGenerated)
                .header("Content-Type","application/json");

        String addBookDetails= """
                {
                  "userId": "a821501d-f417-4837-85b9-ce717b3df167",
                  "collectionOfIsbns": [
                    {
                      "isbn": "9781449337711"
                    }
                  ]
                }
                """;

        Response addBookResponse= request.body(addBookDetails).post("BookStore/v1/Books");
        System.out.println("Status code is"+addBookResponse.getStatusCode());
        Assertions.assertEquals(201,addBookResponse.getStatusCode());
        addBookResponse.prettyPrint();


    }
    @Test
    public void POSTBookWhithBasicAuthentification(){
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1";
        RequestSpecification request = RestAssured.given();
        String credentials ="AndreeaCazan:Mimi@@234";
        byte[] encodedCredentials = Base64.encodeBase64(credentials.getBytes());
        request.header("Authorization","Basic "+encodedCredentials);
        String load= """
                {
                  "userId": "a821501d-f417-4837-85b9-ce717b3df167",
                  "collectionOfIsbns": [
                    {
                      "isbn": "9781449331818"
                    }
                  ]
                }
                """;
        request.header("Content-Type","application/json");
        Response response= request.body(load).post("Books");
        System.out.println("Status code is"+response.getStatusCode());
        response.prettyPrint();


    }

}
