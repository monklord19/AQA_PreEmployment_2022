package ApiTests.steps;

import ApiTests.apiEngine.endpoints.DeleteEndpoints;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.junit.Test;

public class ReqresDELETE {
    @Test
    public void deleteUser() {
        Response resp = DeleteEndpoints.deleteUser();
        ValidatableResponse vr;
        vr = resp.then();
        int statusCode = resp.getStatusCode();
        System.out.println(statusCode);
        vr.statusCode(Matchers.equalTo(204));
        vr.time(Matchers.lessThanOrEqualTo((long) 2000));
        String contentLength = resp.getHeader("Content-Length");
        System.out.println(contentLength);
        vr.header("Content-Length", Matchers.equalTo("0"));
    }
}
