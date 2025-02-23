package api.lists;

import io.qameta.allure.Step;
import models.lists.ArchiveList;
import models.lists.ListRequest;
import models.lists.ListResponse;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static specs.GeneralSpecification.requestSpec;
import static specs.GeneralSpecification.responseSpec;
import static helpers.EnvironmentHelper.key;
import static helpers.EnvironmentHelper.token;

public class ListsMethods {
    @Step("Create a list.")
    public ListResponse createList(String name, String idBoard) {
        ListRequest requestBody = new ListRequest();
        requestBody.setName(name);
        requestBody.setIdBoard(idBoard);

        return
            given()
                .spec(requestSpec)
                .queryParam("key", key)
                .queryParam("token", token)
                .body(requestBody)
                .when()
                .post("/lists/")
                .then()
                .spec(responseSpec)
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("schemas/lists/schemaForCreateListMethod.json"))
                .extract().as(ListResponse.class);

    }

    @Step("Archive a list.")
    public ListResponse archiveList(String id) {
        ArchiveList requestBody = new ArchiveList();
        requestBody.setValue(true);

        return
            given()
                .spec(requestSpec)
                .queryParam("key", key)
                .queryParam("token", token)
                .body(requestBody)
                .when()
                .put("/lists/" + id + "/closed")
                .then()
                .spec(responseSpec)
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("schemas/lists/schemaForArchiveListMethod.json"))
                .extract().as(ListResponse.class);
    }
}
