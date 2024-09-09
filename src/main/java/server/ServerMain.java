package server;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import java.io.IOException;
import java.net.ServerSocket;

public class ServerMain {
    public static void main(String[] args) {
        try {
            // Create a new server socket on port 1234
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Server started on port 1234.");

            // Initialize the server
            Server server = new Server(serverSocket);

            // Start the server in a new thread
            new Thread(new Runnable() {
                @Override
                public void run() {
                    server.startServer();
                }
            }).start();

            // Display the StartGameScreen on the EDT
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    new StartGameScreen();
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
            // Show an error dialog and exit
            SwingUtilities.invokeLater(() -> {
                JOptionPane.showMessageDialog(null,
                        "Failed to start the server socket.",
                        "Server Error",
                        JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            });
        }
    }
}
