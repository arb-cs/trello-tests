package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class AtlassianSSOPage {
    private final SelenideElement emailInputField = $("[data-testid=username]"),
        passwordInputField = $("[data-testid=password]"),
        logInOrSubmitButton = $("#login-submit"),
        userNameError = $("#form-login"),
        passwordError = $("#password-error"),
        formError = $("[data-testid=form-error]"),
        logOutAtlassian = $("[data-testid=logout-button]");

    @Step("Enter the user's email address.")
    public AtlassianSSOPage setEmail(String email) {
        emailInputField.setValue(email);
        return this;
    }

    @Step("Click on the continue button or log in.")
    public AtlassianSSOPage clickContinueOrLogInButton() {
        logInOrSubmitButton.click();
        return this;
    }

    @Step("Enter the user's password")
    public AtlassianSSOPage setPassword(String password) {
        passwordInputField.setValue(password);
        return this;
    }

    @Step("Check that there is an error when entering an incorrect password and the error text meets the requirements.")
    public AtlassianSSOPage authErrorMessageContainsText(String errorMessage) {
        formError.shouldHave(text(errorMessage));
        return this;
    }

    @Step("Press enter for the user email input field.")
    public AtlassianSSOPage pressEnterForEmailField() {
        emailInputField.pressEnter();
        return this;
    }

    @Step("Check that there is an error when the email address is not filled in and the error text is appropriate.")
    public AtlassianSSOPage errorMessageWhenEmptyEmailContainsText(String errorMessage) {
        userNameError.shouldHave(text(errorMessage));
        return this;
    }

    @Step("Press enter for the password input field.")
    public AtlassianSSOPage pressEnterForPasswordField() {
        passwordInputField.pressEnter();
        return this;
    }

    @Step("Check that there is an error when the password is incomplete and the error text matches the requirements.")
    public AtlassianSSOPage errorMessageWhenEmptyPasswordContainsText(String errorMessage) {
        passwordError.shouldHave(text(errorMessage));
        return this;
    }

    @Step("Log out of the Atlassion SSO system.")
    public void logOutOfAtlassianAccount() {
        logOutAtlassian.click();
    }
}
