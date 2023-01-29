package ApiTests;

import ApiTests.model.Requests.CreateUser;
import ApiTests.model.Requests.UpdateUser;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.jetbrains.annotations.NotNull;

public class Methods {
    public static RequestSpecification iSetTheRequestSpecifications() {
        String BASE_URL = ConfigReader.getInstance().getBaseUrl();
        RestAssured.baseURI = BASE_URL;
        RequestSpecification requestSpecificationSettings;
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri(BASE_URL);
        builder.addHeader("Content-Type", "application/json");
        requestSpecificationSettings = builder.build();
        return requestSpecificationSettings;
    }

    public static Response responseForUsersListRequest() {
        Routes route = Routes.ListUsersRoute;
        Response usersListResponse = RestAssured.when().get(route.getUrl());
        return usersListResponse;
    }

    public static Response responseForCreateRequest() {
        CreateUser createUserRequestBody = new CreateUser("morpheus", "leader");
        Routes routes = Routes.CreateUserRoute;
        Response CreateUserResponse = RestAssured.given().body(createUserRequestBody).when().post(routes.getUrl());
        return CreateUserResponse;
    }

    public static Response responseForDeleteUserRequest() {
        String id = ConfigReader.getInstance().getValidId();
        Routes routes = Routes.UpdateAndDeleteRoute;
        Response deleteResponse = RestAssured.when().delete(routes.getUrl() + id);
        return deleteResponse;
    }

    public static Response responseForPatchUpdate() {
        UpdateUser updateUserRequestBody = new UpdateUser("morpheus", "");
        String id = ConfigReader.getInstance().getValidId();
        Routes routes = Routes.UpdateAndDeleteRoute;
        Response patchUpdateResponse = RestAssured.given().body(updateUserRequestBody).when().patch(routes.getUrl() + id);
        return patchUpdateResponse;
    }

    public static Response responseForPutUpdate() {
        UpdateUser updateUserRequestBody = new UpdateUser("morpheus", "zion resident");
        String id = ConfigReader.getInstance().getValidId();
        Routes routes = Routes.UpdateAndDeleteRoute;
        Response putUpdateResponse = RestAssured.given().body(updateUserRequestBody).when().put(routes.getUrl() + id);
        return putUpdateResponse;
    }

    public void setResponseAsString(@NotNull Response response) {
        String responseAsString = response.asPrettyString();
        System.out.println("The response body is:" + responseAsString);
    }
}
