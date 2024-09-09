package server;

import client.ClientMain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Ensure this class is in an appropriate package, e.g., server or a separate ui package
public class StartGameScreen extends JFrame {

    public StartGameScreen() {
        // Set up the frame
        setTitle("Start Game");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window on the screen

        // Set layout manager
        setLayout(new BorderLayout());

        // Create a title label
        JLabel titleLabel = new JLabel("Galactic Shooters", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        titleLabel.setForeground(Color.WHITE);
        add(titleLabel, BorderLayout.NORTH);

        // Create a start button
        JButton startButton = new JButton("Start Game");
        startButton.setFont(new Font("Arial", Font.PLAIN, 24));
        startButton.setBackground(Color.GREEN);
        startButton.setFocusPainted(false);
        startButton.setPreferredSize(new Dimension(200, 100));
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });

        // Create a panel to hold the button and center it
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.setLayout(new GridBagLayout()); // Center the button
        buttonPanel.add(startButton);
        add(buttonPanel, BorderLayout.CENTER);

        // Set background color
        getContentPane().setBackground(Color.BLACK);

        // Make the window visible
        setVisible(true);
    }

    /**
     * This method is called when the "Start Game" button is pressed.
     * It launches the ClientMain class in a new thread.
     */
    private void startGame() {
        // Run ClientMain in a new thread to avoid blocking the GUI
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // Optionally, you can pass arguments if needed
                    ClientMain.main(new String[]{});
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(StartGameScreen.this,
                            "Failed to start the client.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }).start();

        // Optionally, you can disable the button or close the start screen
        // For example, close the start screen:
        dispose();
    }
}
