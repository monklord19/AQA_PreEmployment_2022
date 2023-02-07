package Backend.apiEngine.Endpoints;

import Configurations.BackendConfigs.BackendPropertiesReader;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;

public class CommonMethods {
    public static RequestSpecification iSetTheRequestSpecifications() {
        String BASE_URL = BackendPropertiesReader.getInstance().getBaseUrl();
        RequestSpecification requestSpecificationSettings;
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri(BASE_URL);
        builder.setContentType(ContentType.JSON);
        builder.addHeader("Content-Type", "application/json");
        requestSpecificationSettings = builder.build();
        RequestSpecification request = RestAssured.given().spec(requestSpecificationSettings);
        return request;
    }

    public static RequestSpecification iSetRequestSpecificationsWithToken() {
        String token = PostEndpoints.getToken();
        RequestSpecification requestSpecificationWithToken = CommonMethods.iSetTheRequestSpecifications().header("Authorization", "Bearer " + token);
        return requestSpecificationWithToken;
    }

    public static String setResponseAsString(Response response) {
        String responseAsString = response.asPrettyString();
        return responseAsString;
    }

    public static ValidatableResponse validateStatusCode(Response response, Integer statusCode) {
        ValidatableResponse validateResponse = response.then();
        validateResponse.statusCode(Matchers.equalTo(statusCode));
        return validateResponse;
    }

    public static ValidatableResponse validateResponseTime(Response response, Long responseTime) {
        ValidatableResponse validateResponse = response.then();
        validateResponse.time(Matchers.lessThanOrEqualTo(responseTime));
        return validateResponse;
    }

    public static ValidatableResponse validateBodyNotNull(Response response) {
        ValidatableResponse validatableResponse = response.then();
        validatableResponse.assertThat().body(Matchers.notNullValue());
        return validatableResponse;
    }

    public static ValidatableResponse validateValuesFromResponseBody(Response response, String keyName, String keyValue) {
        ValidatableResponse validatableResponse = response.then();
        validatableResponse.body(keyName, Matchers.equalTo(keyValue));
        return validatableResponse;
    }

    public static ValidatableResponse assertThatBodyContainsASpecificValue(Response response, String key, String value) {
        ValidatableResponse validatableResponse = response.then();
        validatableResponse.assertThat().body(key, Matchers.containsString(value));
        return validatableResponse;
    }

    public static ValidatableResponse validateHeaders(Response response, String headerKey, String headerValue) {
        ValidatableResponse validatableResponse = response.then();
        validatableResponse.header(headerKey, Matchers.equalTo(headerValue));
        return validatableResponse;
    }

}
