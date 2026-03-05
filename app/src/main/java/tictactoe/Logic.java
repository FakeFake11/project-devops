package tictactoe;

/**
 * Logic interface defines the core game operations for Tic-Tac-Toe.
 * Any class implementing this interface should provide the rules
 * for determining the winner and resetting the game board.
 */
public interface Logic {
    boolean checkWinner();
    void resetBoard();
}