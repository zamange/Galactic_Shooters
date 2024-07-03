package client;

import entry.FramesPerSecond;
import entry.Input;
import entry.Widget;
import objects.Background;
import objects.Bomber;
import objects.Fighter;
import render.Renderer;
import update.Updater;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of your spaceship ");
        String username = scanner.nextLine();

        try {
            // Connect to the server
            Socket socket = new Socket("localhost", 1234);
            System.out.println("Connected to server.");

            // Start the SpaceInvasion game for this client
            startSpaceInvasion(socket, username);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void startSpaceInvasion(Socket socket, String username) {
        try {
            // Initialize the game environment
            Widget widget = new Widget("SpaceInvasion", Widget.getFrameWidth(), Widget.getFrameHeight());
            Renderer renderer = new Renderer();
            Updater updater = new Updater();
            widget.addKeyListener(new Input());
            widget.add(renderer);
            widget.packWidget();
            widget.setVisible(true);

            // Game objects
//            Bomber bomber = new Bomber(Widget.getFrameWidth() / 2 - 50, Widget.getFrameHeight() - 150);
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
            }

            // Clean up resources
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
