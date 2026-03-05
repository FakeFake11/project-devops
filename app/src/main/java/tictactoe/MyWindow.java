package tictactoe;

import javax.swing.*;
import java.awt.*;
import javax.swing.SwingUtilities;

/**
 * MyWindow handles the main GUI window for the Tic-Tac-Toe game.
 * It manages game state, user interactions, and delegates win logic to GameLogic.
 */

public final class MyWindow extends JFrame {

    /**
     * A boolean for checking whether it's
     * the player X's turn.
     */
    private boolean isXTurn = true;
    /**
     * The array of JButtons that form the tictactoe
     * grid.
     */
    private JButton[] buttons = new JButton[9];
    /**
     * The JLabel used for displaying which player's
     * turn it is.
     */
    private JLabel statusLabel;
    /**
     * The instance of class implementing Logic.
     * Used for checking the winner of the game
     * and resetting the board.
     */
    private Logic logic;
    private int moveCount = 0;
    private boolean isAiEnabled = true; // Temporary default for testing

    public void setIsXTurn(boolean isXTurn) { this.isXTurn = isXTurn; }
    public boolean getIsXTurn() { return isXTurn; }

    public MyWindow() {
        super("Tic-Tac-Toe");
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void initializeGame(int playerCount) {
        this.isAiEnabled = (playerCount == 1);
        this.moveCount = 0;
        this.getContentPane().removeAll();
        this.setLayout(new BorderLayout());

        statusLabel = new JLabel("Player X's Turn", JLabel.CENTER);
        JPanel gridPanel = new JPanel(new GridLayout(3, 3));
        logic = new GameLogic(this, statusLabel, buttons);

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton("");
            buttons[i].setFont(new Font("Arial", Font.BOLD, 55));
            buttons[i].setBackground(Color.GRAY);
            buttons[i].setForeground(Color.WHITE);

            final int index = i;
            buttons[i].addActionListener(e -> {
                if (buttons[index].getText().equals("")) {
                    buttons[index].setText(isXTurn ? "X" : "O");
                    moveCount++;

                    if (logic.checkWinner()) {
                        statusLabel.setText("Player " + (isXTurn ? "X" : "O") + " Wins!");
                        for (JButton b : buttons) b.setEnabled(false);
                        showEndGameOptions();
                    }
                    else if (moveCount == 9) {
                        statusLabel.setText("It's a Draw!");
                        showEndGameOptions();
                    }
                    else {
                        isXTurn = !isXTurn;
                        statusLabel.setText("Player " + (isXTurn ? "X" : "O") + "'s Turn");

                        if (isAiEnabled && !isXTurn) {
                            SwingUtilities.invokeLater(() -> performAiMove());
                        }
                    }
                }
            });
            gridPanel.add(buttons[i]);
        }

        add(gridPanel, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.NORTH);
        this.revalidate();
        this.repaint();
    }
    /**
    * Displays the end-of-game options, allowing the player to return to the menu.
    */
    private void showEndGameOptions() {
        JPanel bottomPanel = new JPanel();
        JButton menuButton = new JButton("Back to Menu");

        menuButton.addActionListener(e -> {
            this.getContentPane().removeAll();
            this.add(new Menu(this));
            this.revalidate();
            this.repaint();
        });

        bottomPanel.add(menuButton);
        this.add(bottomPanel, BorderLayout.SOUTH);
        this.revalidate();
        this.repaint();
    }
    /**
     * Executes AI move by retrieving a random available index 0-9
     * from the logic and simulating a button click.
     */
    private void performAiMove() {
    int moveIndex = logic.getRandomMove();
    if (moveIndex != -1) {
        buttons[moveIndex].doClick();
    }
}


}