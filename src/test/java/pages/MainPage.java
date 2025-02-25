package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private final SelenideElement userMenu = $("[data-testid=header-member-menu-avatar]"),
        accountMenuLogout = $("[data-testid=account-menu-logout]"),
        createBoardTile = $("[data-testid=create-board-tile]"),
        createBoardTitleInput = $("[data-testid=create-board-title-input]"),
        createBoardButton = $("[data-testid=create-board-submit-button]"),
        testBoard = $("[title=\"A test board that was created from UI.\"]");

    @Step("Checking that the user is logged in.")
    public MainPage userIsLoggedIn() {
        userMenu.shouldBe(Condition.visible);
        return this;
    }

    @Step("Open user's menu.")
    public MainPage openUsersMenu() {
        userMenu.click();
        return this;
    }

    @Step("Log out of the trello.")
    public MainPage logOut() {
        accountMenuLogout.scrollIntoView(false).click();
        return this;
    }

    @Step("Click on the board creation element.")
    public MainPage clickOnCreateNewBoardElement() {
        createBoardTile.scrollIntoView(true).click();
        return this;
    }

    @Step("Enter the name of the board.")
    public MainPage setBoardName(String boardName) {
        createBoardTitleInput.setValue(boardName);
        return this;
    }

    @Step("Click on the board creation button.")
    public MainPage clickOnCreateBoardButton() {
        createBoardButton.click();
        return this;
    }

    @Step("Open the board.")
    public MainPage openBoard() {
        testBoard.click();
        return this;
    }
}
