package tests.api.boards;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import models.board.CreateBoardResponse;
import models.board.CreateNegativeBoardRequest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import tests.api.BaseTest;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static specs.GeneralSpecification.requestSpec;
import static specs.GeneralSpecification.responseSpec;
import static helpers.EnvironmentHelper.key;
import static helpers.EnvironmentHelper.token;

@Feature("Creating boards.")
@Owner("arb-cs")
@Tag("api_tests")
public class BoardsNegativeTests extends BaseTest {
    @ParameterizedTest
    @ValueSource(ints = {
        -1, 0, 246812
    })
    @Step("Call the method to create a Board with an invalid type in the parameter.")
    public void createBoardWithIncorrectParamInBody(int name) {
        CreateNegativeBoardRequest requestBody = new CreateNegativeBoardRequest();
        requestBody.setName(name);

        CreateBoardResponse response =
            given()
                .spec(requestSpec)
                .queryParam("key", key)
                .queryParam("token", token)
                .body(requestBody)
                .when()
                .post("/boards/")
                .then()
                .spec(responseSpec)
                .statusCode(400)
                .extract().as(CreateBoardResponse.class);

        assertThat(response.getMessage()).isEqualTo("invalid value for name");
        assertThat(response.getError()).isEqualTo("ERROR");
    }

    @Test
    @Step("Call the method to create a Board with an empty body.")
    public void createBoardWhenBodyIsEmpty() {
        CreateBoardResponse response =
            given()
                .spec(requestSpec)
                .queryParam("key", key)
                .queryParam("token", token)
                .body("{}")
                .when()
                .post("/boards/")
                .then()
                .spec(responseSpec)
                .statusCode(400)
                .extract().as(CreateBoardResponse.class);

        assertThat(response.getMessage()).isEqualTo("invalid value for name");
        assertThat(response.getError()).isEqualTo("ERROR");
    }
}
