package BookStoreApi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.io.IOUtils;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.testng.asserts.Assertion;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class SwaggerBookStoreFlow {
    Response response;
    Response generateToken;
    Response addBook;
    Response updatedBook;

    @AfterClass
    public static void getStatus(String baseURI) {

        int status = given().when().get(baseURI).getStatusCode();
        if (status == 200 || status == 201) {
            System.out.println("Status is " + status + " OK");
            Assert.assertTrue(true);

        } else if (status == 204) {
            System.out.println("Success status but no content" + status);
            Assert.assertTrue(true);

        } else if (status == 400 || status == 401 || status == 403 || status == 404) {
            System.out.println("Status is" + status + "invalid request to go through");
            Assert.assertTrue(true);
        } else {
            System.out.println("Unknown request");
        }

    }

    @AfterClass
    public static void getResponseTime() {
        long startTime = System.nanoTime();
        Response response = RestAssured.get(baseURI);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;
        if (duration < 300) {
            System.out.println("Response time " + duration + " ms");
            Assert.assertEquals(200, response.getStatusCode());
        } else {

            System.out.println("Invalid response to go through");

        }
    }
    // flor for #1 scenario

    public void createUserForTest(){
        RestAssured.baseURI = "https://demoqa.com/";
        String payload = "{\n" +
                "  \"userName\": \"Pitiriciu Iulian_test5\",\n" +
                "  \"password\": \"Test123@!\"\n" +
                "}";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Content-Type","application/json");
        response =  httpRequest
                .body(payload)
                .when()
                .post("/Account/v1/User");

        response.prettyPrint();

    }
    // create user using Json
    public void createUserForTestv2() throws IOException {

        FileInputStream fileInputStream = new FileInputStream(new File("src/main/resources/CreateUser.json"));

        RestAssured.baseURI = "https://reqres.in";
        given()
                .header("Content-Type","application/json")
                .and()
                .body(IOUtils.toString(fileInputStream,"UTF-8"))
                .when()
                .post("/Account/v1/User");

    }
    public void getCreateUserResponse(){
        int statusCode = response.getStatusCode();
        System.out.println("Response status code is " + statusCode);

    }

    //flow for #2 scenario

    public void generateTokenAndAuthorization(){
        RestAssured.baseURI = "https://demoqa.com/";
        RequestSpecification request = RestAssured.given();
        String payload = "{\n" +
                "  \"userName\": \"Pitiriciu Iulian_test5\",\n" +
                "  \"password\": \"Test123@!\"\n" +
                "}";
        request.header("Content-type","application/json");
        generateToken = request
                .body(payload)
                .when()
                .post("/Account/v1/GenerateToken");
        System.out.println("Response Status Code is " + generateToken.getStatusCode());

        // authorize user

        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post("/Account/v1/Authorized");


        int statusCode = response.getStatusCode();
        Assert.assertEquals(200,statusCode);

        String body = response.getBody().asString();
        Assert.assertTrue(body.contains("true"));
        System.out.println("Respons is: " + body);

    }

    public void responseToken(){
        generateToken.prettyPrint();
        int statusCode = generateToken.getStatusCode();
        Assert.assertEquals(200, statusCode);

        String body = generateToken.getBody().asString();
        Assert.assertTrue(body.contains("User authorized successfully."));

    }

    //flow for #3 scenario

    public void authorizedStatusCode(){
        int statusCode = response.getStatusCode();
        Assert.assertEquals(200, statusCode);
    }

    //flow for #4 scenario
    public void deleteUserID() {
        RestAssured.baseURI = "https://demoqa.com/";

        RequestSpecification request = RestAssured.given();

         String userID = "f509f3ea-635a-4568-a3dd-f4b63dc5e5c6";
        String credentials = "Pitiriciu Iulian_test5:Test123@!";
        byte[] encoderCredentials = Base64.getEncoder().encode(credentials.getBytes());
        String encoderCredentialsAsString = new String(encoderCredentials);
        request.header("Authorization","Basic" + encoderCredentialsAsString)
                .header("Content-Type", "application/json");

      response = request
                .body(userID)
                .when()
                .delete("Account/v1/User/f509f3ea-635a-4568-a3dd-f4b63dc5e5c6" );



    }

    public void responseDeleteUserID(){
        System.out.println("Response Status code is " + response.getStatusCode());
        Assertions.assertEquals(200,response.getStatusCode());

    }

    //flow for #5 scenario

    public void getUserById() {
        RestAssured.baseURI = "https://demoqa.com/";

        RequestSpecification request = RestAssured.given();

        String userID = "f509f3ea-635a-4568-a3dd-f4b63dc5e5c6";
        String credentials = "Pitiriciu Iulian_test5:Test123@!";
        byte[] encoderCredentials = Base64.getEncoder().encode(credentials.getBytes());
        String encoderCredentialsAsString = new String(encoderCredentials);
        request.header("Authorization","Basic" + encoderCredentialsAsString)
                .header("Content-Type", "application/json");

        response = request
                .body(userID)
                .when()
                .get("/Account/v1/User/f509f3ea-635a-4568-a3dd-f4b63dc5e5c6");

        System.out.println("Response status Code is: " + response.getStatusCode());


    }

    public void responseUser(){
        Assert.assertEquals(200,response.statusCode());
    }

    //flow for #6 scenario

    public void getBooksDetails() {
        RestAssured.baseURI = "https://demoqa.com/";
        RequestSpecification httpRequest = RestAssured.given();
        response = httpRequest.request(Method.GET, "");
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("No Starch Press"));

    }

    public void detailsBooks() {
        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response=>" + response.prettyPrint());

    }

    //flow for #7 scenario
    public void bookDetail() {
        RestAssured.baseURI = "https://demoqa.com/";
        RequestSpecification request = RestAssured.given();

        String credentials = "Pitiriciu Iulian_test5:Test123@!";

        byte[] encoderCredentials = Base64.getEncoder().encode(credentials.getBytes());
        String encoderCredentialsAsString = new String(encoderCredentials);
        request.header("Authorization", "Basic" + encoderCredentialsAsString);
        String payload = "{\n" +
                "  \"userId\"f509f3ea-635a-4568-a3dd-f4b63dc5e5c6\"\",\n" +
                "  \"collectionOfIsbns\": [\n" +
                "    {\n" +
                "      \"isbn\": \"9781593277574\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        request.header("Content-Type", "application/json");
        response = request
                .body(payload)
                .when()
                .post("/BookStore/v1/Books");
        System.out.println("Respons Status Code is " + response.getStatusCode());
        response.prettyPrint();

    }

    public void responseBody(){
        ResponseBody responseBody = response.getBody();
        responseBody.prettyPrint();
        Assert.assertEquals(201, response.getStatusCode());
    }

    //flow for #8 scenario
    public void generateBooks(){
        RestAssured.baseURI = "https://demoqa.com/";
        RequestSpecification request = RestAssured.given();
        String payload = "{\n" +
                "  \"userName\": \"Pitiriciu Iulian_test5\",\n" +
                "  \"password\": \"Test123@!\"\n" +
                "}";
        request.header("Content-type","application/json");
        generateToken = request.body(payload).post("/Account/v1/GenerateToken");
        String jsonString = generateToken.getBody().asString();
        String generatedToken = JsonPath.from(jsonString).get("token");
        request.header("Authorization","Bearer" + generatedToken)
                .header("Content-type","application/json");

        String addBooks = "{\n" +
                "  \"userId\": \"f509f3ea-635a-4568-a3dd-f4b63dc5e5c6\",\n" +
                "  \"collectionOfIsbns\": [\n" +
                "    {\n" +
                "      \"isbn\": \"9781491950296\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        addBook = request.
                body(addBooks)
                .when()
                .post("BookStore/v1/Books");
        System.out.println("Response status code is " + addBook.getStatusCode());


    }
    public void booksDetails() {
        String body = addBook.getBody().asString();
        System.out.println(body);
        Assert.assertTrue(body.contains("isbn"));
        Assert.assertEquals(201,response.getStatusCode());
    }

    //flow for #9 scenario

        public void deteleBook() {
            RestAssured.baseURI = "https://demoqa.com/";
            RequestSpecification request = RestAssured.given();

            String deleteBook = "{\n" +
                    "  \"isbn\": \"9781491950296\",\n" +
                    "  \"userId\": \"f509f3ea-635a-4568-a3dd-f4b63dc5e5c6\"\n" +
                    "}";
            String credentials = "Pitiriciu Iulian_test5:Test123@!";

            byte[] encoderCredentials = Base64.getEncoder().encode(credentials.getBytes());
            String encoderCredentialsAsString = new String(encoderCredentials);
            request
                    .header("Authorization", "Basic" + encoderCredentialsAsString)
                    .header("Content-Type", "application/json");

            response = request.body(deleteBook)
                    .when()
                    .delete("/BookStore/v1/Book");
            System.out.println("Response status Code is: " + response.getStatusCode());
        }

            public void statusDelete(){
                Assert.assertEquals(204,response.getStatusCode());
            }


    // flow for #10 scenario
    public void updateBook(){
        RestAssured.baseURI = "https://demoqa.com/";
        RequestSpecification request = RestAssured.given();
        String credentials = "Pitiriciu Iulian_5:Test123@!";
        byte[] encoderCredentials = Base64.getEncoder().encode(credentials.getBytes());
        String encoderCredentialsAsString = new String(encoderCredentials);
        request.header("Authorization","Basic" + encoderCredentialsAsString)
                .header("Content-Type", "application/json");

        String updatedDetails = "{\n" +
                "  \"userId\": \"f509f3ea-635a-4568-a3dd-f4b63dc5e5c6\",\n" +
                "  \"collectionOfIsbns\": [\n" +
                "    {\n" +
                "      \"isbn\": \"9781491950296\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
       updatedBook = request.
               body(updatedDetails)
               .when()
               .put("/BookStore/v1/Books/9781449325862");

    }

    public void responseUpdatedBook(){
        Assert.assertEquals(200,updatedBook.getStatusCode());
    }

    //flow for #11 scenario

    public void getUserByISBN() {
        RestAssured.baseURI = "https://demoqa.com/";

        RequestSpecification request = RestAssured.given();

        String isbn = "9781491950296";
        String credentials = "Pitiriciu Iulian_test5:Test123@!";
        byte[] encoderCredentials = Base64.getEncoder().encode(credentials.getBytes());
        String encoderCredentialsAsString = new String(encoderCredentials);
        request.header("Authorization","Basic" + encoderCredentialsAsString)
                .header("Content-Type", "application/json");

        response = request
                .body(isbn)
                .when()
                .get("/Account/v1/User/9781491950296");

        System.out.println("Response status Code is: " + response.getStatusCode());


    }

    public void responseISN(){
        Assert.assertEquals(200,response.statusCode());
    }

    public void deleteBooksID(){
        RestAssured.baseURI = "https://demoqa.com/";

        RequestSpecification request = RestAssured.given();

        String userID = "f509f3ea-635a-4568-a3dd-f4b63dc5e5c6";
        String credentials = "Pitiriciu Iulian_test5:Test123@!";
        byte[] encoderCredentials = Base64.getEncoder().encode(credentials.getBytes());
        String encoderCredentialsAsString = new String(encoderCredentials);
        request.header("Authorization","Basic" + encoderCredentialsAsString)
                .header("Content-Type", "application/json");

        response = request
                .body(userID)
                .when()
                .delete("/Bookstore/v1/Books" );
    }

    public void responseDeleteBooksID(){
        System.out.println("Response Status code is " + response.getStatusCode());
        Assertions.assertEquals(204,response.getStatusCode());

    }

    }







