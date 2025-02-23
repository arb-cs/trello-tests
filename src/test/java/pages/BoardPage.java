package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class BoardPage {
    private final SelenideElement boardDisplayedName = $("[data-testid=board-name-display]"),
        addListElement = $("[data-testid=list-composer-button]"),
        listNameInput = $("[data-testid=list-name-textarea]"),
        createListButton = $("[data-testid=list-composer-add-list-button]"),
        listName = $("[data-testid=list-name]"),
        addListCardButton = $("[data-testid=list-add-card-button]"),
        cardTitleInput = $("[data-testid=list-card-composer-textarea]"),
        addCardButton = $("[data-testid=list-card-composer-add-card-button]"),
        cardName = $("[data-testid=card-name]");

    @Step("The board is created and its name is equal to the name that was set when it was created.")
    public BoardPage checkThatTheBoardWasCreated(String boardName) {
        boardDisplayedName.shouldHave(Condition.text(boardName));
        return this;
    }

    @Step("Click on the list creation item.")
    public BoardPage clickListCreationItem() {
        addListElement.click();
        return this;
    }

    @Step("Set a list's name.")
    public BoardPage setListName(String listName) {
        listNameInput.setValue(listName);
        return this;
    }

    @Step("Click on the button to create the list.")
    public BoardPage clickOnCreateListButton() {
        createListButton.click();
        return this;
    }

    @Step("Checks that the list is created with the name that was entered at creation.")
    public BoardPage listIsCreatedAndHasExpectedName(String name) {
        listName.shouldHave(Condition.text(name));
        return this;
    }

    @Step("Click Add a card button on a list.")
    public BoardPage clickAddCardButtonOnList() {
        addListCardButton.click();
        return this;
    }

    @Step("Set card's title or link.")
    public BoardPage setCardTitle(String title) {
        cardTitleInput.setValue(title);
        return this;
    }

    @Step("Click on the add card button.")
    public BoardPage clickAddCardButton() {
        addCardButton.click();
        return this;
    }

    @Step("Check that the card is created with the expected name.")
    public BoardPage checkThatCardIsCreatedAndHasExpectedTitle(String title) {
        cardName.shouldHave(Condition.text(title));
        return this;
    }
}
