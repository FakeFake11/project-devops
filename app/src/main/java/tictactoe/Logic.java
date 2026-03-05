package tictactoe;

/**
 * Logic interface defines the core game operations for Tic-Tac-Toe.
 * Any class implementing this interface should provide the rules
 * for determining the winner and resetting the game board.
 */
public interface Logic {
    /**
     * A method for checking the game's winner.
     */
    boolean checkWinner();
    /**
     * A method for resetting the board or the
     * game's state.
     */
    void resetBoard();
}