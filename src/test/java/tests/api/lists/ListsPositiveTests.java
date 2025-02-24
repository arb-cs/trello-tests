package tests.api.lists;

import api.boards.BoardsMethods;
import api.lists.ListsMethods;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import models.board.CreateBoardResponse;
import models.lists.ListResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.api.BaseTest;

import static org.assertj.core.api.Assertions.assertThat;

@Feature("List Actions.")
@Owner("arb-cs")
@Tag("api_tests")
public class ListsPositiveTests extends BaseTest {
    @Test
    @DisplayName("Verifying that a list is being created.")
    @Severity(SeverityLevel.CRITICAL)
    public void createList() {
        // Arrange
        BoardsMethods boardsMethods = new BoardsMethods();
        ListsMethods listsMethods = new ListsMethods();
        String boardName = "Test Board";
        String boardDesc = "This is a test board!";
        CreateBoardResponse board = boardsMethods.createBoard(boardName, boardDesc, true);
        String listName = "Test List";

        // Act
        ListResponse list = listsMethods.createList(listName, board.getId());

        // Assert
        assertThat(list.getName()).isEqualTo(listName);
        assertThat(list.isClosed()).isFalse();

        // Clean Up
        listsMethods.archiveList(list.getId());
        boardsMethods.deleteBoard(board.getId());
    }

    @Test
    @DisplayName("Verifying that the list is being archived.")
    public void archiveList() {
        BoardsMethods boardsMethods = new BoardsMethods();
        ListsMethods listsMethods = new ListsMethods();
        String boardName = "Test Board";
        String boardDesc = "This is a test board!";
        CreateBoardResponse board = boardsMethods.createBoard(boardName, boardDesc, true);
        String listName = "Test List";
        ListResponse list = listsMethods.createList(listName, board.getId());

        ListResponse response = listsMethods.archiveList(list.getId());

        assertThat(response.isClosed()).isTrue();

        // Clean Up
        boardsMethods.deleteBoard(board.getId());
    }
}
