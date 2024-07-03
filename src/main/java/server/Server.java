package server;

import client.ClientHandler;
import userInterface.ColorText;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;

    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void startServer() {
        try {

            System.out.println(ColorText.colorize("Server is running and waiting for client connections...", ColorText.CYAN));

            while (!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                System.out.println(ColorText.colorize("A new client has connected.", ColorText.GREEN));
                printAsciiArt(); // Display welcome message for the server


                // Welcome message to client
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println(ColorText.colorize("Welcome to the server!", ColorText.PURPLE));

                // Start a new thread to handle the client
                ClientHandler clientHandler = new ClientHandler(socket);
                Thread thread = new Thread(clientHandler);
                thread.start();
            }
        } catch (IOException | InterruptedException e) {
            // Print exception and stop server on error
            System.err.println(ColorText.colorize("Error accepting client connection: " + e.getMessage(), ColorText.RED));
            closeServerSocket();
        }
    }

    public void closeServerSocket() {
        try {
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
                System.out.println(ColorText.colorize("Server socket closed.", ColorText.YELLOW));
            }
        } catch (IOException e) {
            System.err.println(ColorText.colorize("Error closing server socket: " + e.getMessage(), ColorText.RED));
        }
    }

    public static void printAsciiArt() throws InterruptedException {
            String asciiArt =
                    """
                                                 `. ___
                                                __,' __`.                _..----....____
                                    __...--.'``;.   ,.   ;``--..__     .'    ,-._    _.-'
                              _..-''-------'   `'   `'   `'     O ``-''._   (,;') _,'
                            ,'________________                          \\`-._`-','
                             `._              ```````````------...___   '-.._'-:
                                ```--.._      ,.                     ````--...__\\-.
                                        `.--. `-`                       ____    |  |`
                                          `. `.                       ,'`````.  ;  ;`
                                            `._`.        __________   `.      \\'__/'
                                               `-:._____/______/___/____`.     \\  `
                                                           |       `._    `.    \\
                                                           `._________`-.   `.   `.___
                            """;
            System.out.println(asciiArt);
            String greenColor = "\033[32m";
            String blink = "\033[5m";
            String reset = "\033[0m";
            String text = "WELCOME TO GALACTIC SHOOTERS";

            while (true) {
            // Print the blinking text
            System.out.print("\r" + greenColor + blink + text + reset);
            Thread.sleep(500);

            // Print spaces to create the blink effect
            System.out.print("\r" + " ".repeat(text.length()));
            Thread.sleep(500);
        }

    }
    }





