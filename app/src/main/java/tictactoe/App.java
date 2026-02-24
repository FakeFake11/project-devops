package tictactoe;

import javax.swing.SwingUtilities;

public final class App {
    /**
     * Private constructor for App.
     */
    private App() {

    }
    /**
     * Entry point for the app.
     */
    public static void main (final String[] args) {
        SwingUtilities.invokeLater(() -> {
            MyWindow window = new JFrame("window");
            window.setVisible(true);
        });
    }
}
