package tests.ui.login;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.AtlassianSSOPage;
import pages.MainPage;
import tests.BaseTest;

import static helpers.EnvironmentHelper.username;
import static helpers.EnvironmentHelper.password;

@Feature("Log into the system.")
@Owner("arb-cs")
@Tag("ui_tests")
public class LogInTests extends BaseTest {
    AtlassianSSOPage atlassianSSOPage = new AtlassianSSOPage();
    MainPage mainPage = new MainPage();
    HomePage homePage = new HomePage();

    @Test
    @DisplayName("Successful authentication into the service.")
    @Severity(SeverityLevel.BLOCKER)
    public void successfulLogIn() {
        homePage.openTheHomePage()
            .goToLoginPage();
        atlassianSSOPage.setEmail(username)
            .clickContinueOrLogInButton()
            .setPassword(password)
            .clickContinueOrLogInButton();
        mainPage.userIsLoggedIn()
            .openUsersMenu()
            .logOut();
        atlassianSSOPage.logOutOfAtlassianAccount();
    }

    @Test
    @DisplayName("Attempting to log in to the service with an empty email address.")
    @Severity(SeverityLevel.NORMAL)
    public void enterEmptyEmailTest() {
        homePage.openTheHomePage()
            .goToLoginPage();
        atlassianSSOPage.pressEnterForEmailField()
            .errorMessageWhenEmptyEmailContainsText("Enter an email address");
    }

    @Test
    @DisplayName("Attempting to log in to the service with an empty password.")
    @Severity(SeverityLevel.NORMAL)
    public void enterEmptyPasswordTest() {
        homePage.openTheHomePage()
            .goToLoginPage();
        atlassianSSOPage.setEmail(username)
            .clickContinueOrLogInButton()
            .pressEnterForPasswordField()
            .errorMessageWhenEmptyPasswordContainsText("Enter your password");
    }

    @Test
    @DisplayName("Attempting to log in to the service with an incorrect password.")
    @Severity(SeverityLevel.CRITICAL)
    public void enterIncorrectPasswordTest() {
        homePage.openTheHomePage()
            .goToLoginPage();
        atlassianSSOPage.setEmail(username)
            .clickContinueOrLogInButton()
            .setPassword("test")
            .clickContinueOrLogInButton()
            .authErrorMessageContainsText("Incorrect email address and / or password.");
    }
}
