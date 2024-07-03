package server;

import java.io.IOException;
import java.net.ServerSocket;

public class SeverMain {
    public static void main(String[] args) throws IOException {

        // Create a new server instance
        ServerSocket serverSocket = new ServerSocket(1234);
        Server server = new Server(serverSocket);
        server.startServer();
    }
}
