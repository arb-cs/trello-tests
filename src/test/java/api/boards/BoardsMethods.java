package api.boards;

import io.qameta.allure.Step;
import models.board.CreateBoardRequest;
import models.board.CreateBoardResponse;
import models.board.DeleteBoardResponse;

import static io.restassured.RestAssured.given;
import static specs.GeneralSpecification.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static helpers.EnvironmentHelper.key;
import static helpers.EnvironmentHelper.token;

public class BoardsMethods {
    @Step("Create a board.")
    public CreateBoardResponse createBoard(String boardName, String boardDesc, boolean doCreateDefaultLists) {
        CreateBoardRequest requestBody = new CreateBoardRequest();
        requestBody.setName(boardName);
        requestBody.setDesc(boardDesc);
        requestBody.setDefaultLists(doCreateDefaultLists);

        return
            given()
                .spec(requestSpec)
                .queryParam("key", key)
                .queryParam("token", token)
                .body(requestBody)
                .when()
                .post("/boards/")
                .then()
                .spec(responseSpec)
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("schemas/boards/schemaForCreateBoardMethod.json"))
                .extract().as(CreateBoardResponse.class);
    }

    @Step("Get the created board.")
    public CreateBoardResponse getBoard(String boardId) {
        return
            given()
                .spec(requestSpec)
                .queryParam("key", key)
                .queryParam("token", token)
                .when()
                .get("/boards/" + boardId)
                .then()
                .spec(responseSpec)
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("schemas/boards/schemaForGetBoardMethod.json"))
                .extract().as(CreateBoardResponse.class);
    }

    @Step("Delete a board.")
    public DeleteBoardResponse deleteBoard(String boardId) {
        return
            given()
                .spec(requestSpec)
                .queryParam("key", key)
                .queryParam("token", token)
                .when()
                .delete("/boards/" + boardId)
                .then()
                .spec(responseSpec)
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("schemas/boards/schemaForDeleteBoardMethod.json"))
                .extract().as(DeleteBoardResponse.class);
    }
}
