package tests.ui.boards;

import api.boards.BoardsMethods;
import api.lists.ListsMethods;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import models.board.CreateBoardResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.BoardPage;
import pages.HomePage;
import pages.AtlassianSSOPage;
import pages.MainPage;
import tests.BaseTest;

import static helpers.EnvironmentHelper.password;
import static helpers.EnvironmentHelper.username;

// The steps involved in logging to the system are a forced evil.
// Since it was not possible to create an @WithLogin annotation due to Atlassian SSO.
// And I could not find an API method that I could have used to set cookies.

@Feature("Create boards using the user interface.")
@Owner("arb-cs")
@Tag("ui_tests")
public class BoardTests extends BaseTest {
    HomePage homePage = new HomePage();
    AtlassianSSOPage atlassianSSOPage = new AtlassianSSOPage();
    MainPage mainPage = new MainPage();
    BoardPage boardPage = new BoardPage();
    private final String boardName = "A test board that was created from UI.";

    @Test
    @DisplayName("Create a board.")
    @Severity(SeverityLevel.BLOCKER)
    public void createBoard() {
        homePage.openTheHomePage()
            .goToLoginPage();
        atlassianSSOPage.setEmail(username)
            .clickContinueOrLogInButton()
            .setPassword(password)
            .clickContinueOrLogInButton();
        mainPage.clickOnCreateNewBoardElement()
            .setBoardName(boardName)
            .clickOnCreateBoardButton();
        boardPage.checkThatTheBoardWasCreated(boardName);

        // Log out.
        mainPage.openUsersMenu()
            .logOut();
        atlassianSSOPage.logOutOfAtlassianAccount();
    }

    @Test
    @DisplayName("Create a list for the board.")
    @Severity(SeverityLevel.CRITICAL)
    public void createListForBoard() {
        BoardsMethods boardsMethods = new BoardsMethods();
        String boardDesc = "This is a board for UI tests. Yep, I'm cool.";
        String listName = "Todo.";
        CreateBoardResponse board = boardsMethods.createBoard(boardName, boardDesc, false);

        homePage.openTheHomePage()
            .goToLoginPage();
        atlassianSSOPage.setEmail(username)
            .clickContinueOrLogInButton()
            .setPassword(password)
            .clickContinueOrLogInButton();
        mainPage.openBoard();
        boardPage.clickListCreationItem()
            .setListName(listName)
            .clickOnCreateListButton()
            .listIsCreatedAndHasExpectedName(listName);

        // Clean up.
        boardsMethods.deleteBoard(board.getId());
        mainPage.openUsersMenu()
            .logOut();
        atlassianSSOPage.logOutOfAtlassianAccount();
    }

    @Test
    @DisplayName("Add a card to the list.")
    public void addDescriptionToTheCard() {
        BoardsMethods boardsMethods = new BoardsMethods();
        ListsMethods listsMethods = new ListsMethods();
        String boardDesc = "This is a board for UI tests. Yep, I'm cool.";
        String listName = "Todo.";
        String cardTitle = "You must learn Java.";
        CreateBoardResponse board = boardsMethods.createBoard(boardName, boardDesc, false);
        listsMethods.createList(listName, board.getId());

        homePage.openTheHomePage()
            .goToLoginPage();
        atlassianSSOPage.setEmail(username)
            .clickContinueOrLogInButton()
            .setPassword(password)
            .clickContinueOrLogInButton();
        mainPage.openBoard();
        boardPage.clickAddCardButtonOnList()
            .setCardTitle(cardTitle)
            .clickAddCardButton()
            .checkThatCardIsCreatedAndHasExpectedTitle(cardTitle);

        // Clean up.
        boardsMethods.deleteBoard(board.getId());
        mainPage.openUsersMenu()
            .logOut();
        atlassianSSOPage.logOutOfAtlassianAccount();
    }
}
