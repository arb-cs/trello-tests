package tests;

import helpers.AllureAttachments;
import helpers.RunSettings;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;

import static helpers.EnvironmentHelper.isRemote;

public class BaseTest {
    @BeforeAll
    public static void setUp() {
        RunSettings.configure();
    }

    @BeforeEach
    public void beforeEachTestPerform() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    public void afterEachTestPerform() {
        AllureAttachments.screenshotAs("Last screenshot");
        AllureAttachments.pageSource();
        AllureAttachments.browserConsoleLogs();

        if (!isRemote) {
            AllureAttachments.addVideo();
        }

        Selenide.closeWebDriver();
    }
}
