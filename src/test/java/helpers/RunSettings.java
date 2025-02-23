package helpers;

import com.codeborne.selenide.Configuration;
import io.restassured.RestAssured;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static helpers.EnvironmentHelper.*;

public class RunSettings {
    private RunSettings() {
    }

    public static void configure() {
        if (remote != null) {
            Configuration.remote = remote;
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.of(
                "enableVNC", true,
                "enableVideo", true
            ));

            Configuration.browserCapabilities = capabilities;
        }

        Configuration.baseUrl = baseUrl;
        Configuration.browser = browser;
        Configuration.browserVersion = browserVersion;
        Configuration.browserSize = browserSize;
        Configuration.pageLoadStrategy = pageLoadStrategy;
        RestAssured.baseURI = baseURI;
        RestAssured.basePath = basePath;
    }
}
