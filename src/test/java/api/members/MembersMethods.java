package api.members;

import io.qameta.allure.Step;
import models.members.GetMemberResponse;

import static helpers.EnvironmentHelper.key;
import static helpers.EnvironmentHelper.token;
import static io.restassured.RestAssured.given;
import static specs.GeneralSpecification.requestSpec;
import static specs.GeneralSpecification.responseSpec;

public class MembersMethods {
    // This method is only needed for now to remove the board at the end of one UI test.
    @Step("Get info about a member.")
    public GetMemberResponse getMember() {
        return
            given()
                .spec(requestSpec)
                .queryParam("key", key)
                .queryParam("token", token)
                .when()
                .get("member/me")
                .then()
                .spec(responseSpec)
                .statusCode(200)
                .extract().as(GetMemberResponse.class);
    }
}
