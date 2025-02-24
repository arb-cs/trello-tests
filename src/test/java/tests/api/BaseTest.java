package tests.api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import static helpers.EnvironmentHelper.basePath;
import static helpers.EnvironmentHelper.baseURI;

public class BaseTest {
    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = baseURI;
        RestAssured.basePath = basePath;
    }
}
