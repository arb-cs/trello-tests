package tests.api.boards;

import api.boards.BoardsMethods;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import models.board.CreateBoardResponse;
import models.board.DeleteBoardResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.api.BaseTest;

import static org.assertj.core.api.Assertions.assertThat;

@Feature("Creating boards.")
@Owner("arb-cs")
@Tag("api_tests")
public class BoardsPositiveTests extends BaseTest {
    @Test
    @DisplayName("Create a board.")
    @Severity(SeverityLevel.BLOCKER)
    public void successfulBoardCreation() {
        // Arrange
        String boardName = "Test.";
        String boardDesc = "This is a test board.";
        BoardsMethods boardsMethods = new BoardsMethods();

        // Act
        CreateBoardResponse response = boardsMethods.createBoard(boardName, boardDesc, true);

        // Assert
        assertThat(response.getName()).isEqualTo(boardName);
        assertThat(response.getDesc()).isEqualTo(boardDesc);

        //Delete a board in the end of the test.
        String boardId = response.getId();
        boardsMethods.deleteBoard(boardId);
    }


    @Test
    @DisplayName("Get a board.")
    @Severity(SeverityLevel.BLOCKER)
    public void getBoard() {
        String boardName = "Test.";
        String boardDesc = "This is a test board.";
        BoardsMethods board = new BoardsMethods();
        CreateBoardResponse response = board.createBoard(boardName, boardDesc, true);
        String boardId = response.getId();

        board.getBoard(boardId);

        assertThat(response.getName()).isEqualTo(boardName);
        assertThat(response.getDesc()).isEqualTo(boardDesc);

        board.deleteBoard(boardId);
    }

    @Test
    @DisplayName("Delete a board.")
    @Severity(SeverityLevel.NORMAL)
    public void deleteBoard() {
        String boardName = "Test.";
        String boardDesc = "This is a test board.";
        BoardsMethods boardsMethods = new BoardsMethods();
        CreateBoardResponse response = boardsMethods.createBoard(boardName, boardDesc, true);
        String boardId = response.getId();

        DeleteBoardResponse deletedBoard = boardsMethods.deleteBoard(boardId);

        assertThat(deletedBoard.get_value()).isEqualTo(null);
    }
}
