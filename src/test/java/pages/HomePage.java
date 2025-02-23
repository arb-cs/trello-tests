package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class HomePage {
    private final SelenideElement logIn = $("[data-uuid=MJFtCCgVhXrVl7v9HA7EH_login]");

    @Step("Open the home page.")
    public HomePage openTheHomePage() {
        open("");
        return this;
    }

    @Step("Open the log in page.")
    public HomePage goToLoginPage() {
        logIn.click();
        return this;
    }
}
