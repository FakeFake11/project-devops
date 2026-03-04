package tictactoe;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Color;

/**
 * Menu is the main class for the game tic-tac-toe.
 *
 * @author <name here>
 */

public class Menu extends JPanel {
    private JFrame window;
    // Need the file that has the game logic here

    /**
     *Creates menu panel that contains:
     <ul>
     *  <li>Title label</li>
     *  <li>Start button</li>
     *  <li>Quit button</li>
     *</ul>
     *
     * @param window the parent JFrame used as a container
     * @param TBD the game panel that starts when user presses start and chooses the players
     */
    public Menu(JFrame window) {
        this.window = window;
        // Need the file that has the game logic here "this.<file> = <file>;""
        initialize();
    }

    private int playerCount = 0;

    private void initialize() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // BoxLayout should make the items inside from top to bottom
        JLabel titleLabel = new JLabel("Tic-Tac-Toe");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centres the object


        JButton startButton = new JButton("Start");
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Centres the object
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog dialog = new JDialog(window, "Choose your players", true);

                JPanel dialogPanel = new JPanel();
                dialogPanel.setLayout(new BoxLayout(dialogPanel, BoxLayout.Y_AXIS));

                JLabel dialogLabel =  new JLabel("Choose how many players");


                JButton onePlayer = new JButton("1 Player");
                onePlayer.addActionListener(e -> {
                    playerCount = 1;
                    dialog.dispose();
                });

                JButton twoPlayer = new JButton("2 Players");
                 twoPlayer.addActionListener(e -> {
                    playerCount = 2;
                    dialog.dispose();
                });


                dialogLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                onePlayer.setAlignmentX(Component.CENTER_ALIGNMENT);
                twoPlayer.setAlignmentX(Component.CENTER_ALIGNMENT);

                dialogPanel.add(dialogLabel);
                dialogPanel.add(onePlayer);
                dialogPanel.add(twoPlayer);

                dialog.add(dialogPanel);

                dialog.pack();
                dialog.setLocationRelativeTo(window);
                dialog.setVisible(true);

                // Need to add the method to go to the game here "<file>.<method>(playercount);" (playercount is private field in menu class)
            }
        });

        JButton quitButton = new JButton("Quit"); // Button for quitting the game
        quitButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Centres the object
        quitButton.addActionListener(e -> System.exit(0));

        add(titleLabel);
        add(startButton);
        add(quitButton);
    }
}