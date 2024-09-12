import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import server.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import static org.junit.jupiter.api.Assertions.*;

public class TestClientConnection {
    private Server server;
    private ServerSocket serverSocket;

    @BeforeEach
    public void setUp() throws IOException {
        // Set up a ServerSocket on port 1234 for testing
        serverSocket = new ServerSocket(1234);
        server = new Server(serverSocket);
    }

    @AfterEach
    public void tearDown() throws IOException {
        if (!serverSocket.isClosed()) {
            server.closeServerSocket();
        }
    }

    @Test
    public void testClientConnection() throws IOException {
        
        // Simulate a client connecting to the server
        Socket clientSocket = new Socket("localhost", 1234);

        // Check if the client is connected to the server
        assertTrue(clientSocket.isConnected(), "Client should successfully connect to the server.");

        // Close client socket
        clientSocket.close();
    }


    @Test
    public void testMultipleClients() throws IOException {
        // Simulate multiple clients connecting to the server
        Socket clientSocket1 = new Socket("localhost", 1234);
        Socket clientSocket2 = new Socket("localhost", 1234);
        Socket clientSocket3 = new Socket("localhost", 1234);

        // Check if the clients are connected to the server
        assertTrue(clientSocket1.isConnected(), "Client 1 should successfully connect to the server.");
        assertTrue(clientSocket2.isConnected(), "Client 2 should successfully connect to the server.");
        assertTrue(clientSocket3.isConnected(), "Client 3 should successfully connect to the server.");

        // Close client sockets
        clientSocket1.close();
        clientSocket2.close();
        clientSocket3.close();
    }
    }
