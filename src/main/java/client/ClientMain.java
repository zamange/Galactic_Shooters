package client;

import entry.FramesPerSecond;
import entry.Input;
import entry.Widget;
import objects.Background;
import objects.Bomber;
import objects.Fighter;
import render.Renderer;
import update.Updater;

import javax.swing.*;
import java.io.IOException;
import java.net.Socket;

public class ClientMain {
    public static void main(String[] args) {
        // Optionally, get the username via a dialog instead of Scanner
        String username = JOptionPane.showInputDialog(null,
                "Enter the name of your spaceship:",
                "Username",
                JOptionPane.PLAIN_MESSAGE);

        if (username == null || username.trim().isEmpty()) {
            // Handle empty input, possibly exit or set a default username
            JOptionPane.showMessageDialog(null,
                    "Username cannot be empty.",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Connect to the server
            Socket socket = new Socket("localhost", 1234);
            System.out.println("Connected to server.");

            // Start the SpaceInvasion game for this client
            startSpaceInvasion(socket, username);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Failed to connect to the server.",
                    "Connection Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void startSpaceInvasion(Socket socket, String username) {
        try {
            // Initialize the game environment
            Widget widget = new Widget("Galactic Shooters", Widget.getFrameWidth(), Widget.getFrameHeight());
            Renderer renderer = new Renderer();
            Updater updater = new Updater();
            widget.addKeyListener(new Input());
            widget.add(renderer);
            widget.packWidget();
            widget.setVisible(true);

            // Game objects
            // Bomber bomber = new Bomber(Widget.getFrameWidth() / 2 - 50, Widget.getFrameHeight() - 150);
            Fighter fighter = new Fighter(Widget.getFrameWidth() / 2 + 50, Widget.getFrameHeight() - 250);
            new Background(0);
            new Background(-Widget.getFrameHeight());

            // Game loop
            boolean runGame = true;
            FramesPerSecond.calcBeginTime();
            while (runGame) {
                renderer.repaint();
                updater.update();
                FramesPerSecond.calcDeltaTime();

                // Implement a condition to stop the game loop, e.g., when the window is closed
                if (!widget.isVisible()) {
                    runGame = false;
                }

                // Optionally, add sleep to control FPS
                try {
                    Thread.sleep(16); // Approx. 60 FPS
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Clean up resources
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "An error occurred during the game.",
                    "Game Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
