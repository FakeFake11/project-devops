package tictactoe;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Color;

public class Menu extends JPanel {
    Public MenuFrame() {
        initialize();
    }

    private void initialize() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5))
        JButton startButton = new JButton("Start");
        add(startButton);

        JButton quitButton = new JButton("Quit");
        add(quitButton);
    }
}