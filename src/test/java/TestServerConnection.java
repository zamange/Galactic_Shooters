import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import server.Server;

import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServerConnection {

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
    public void testServerStartsOnCorrectPort() {
        // Check if the server is bound to port 1234
        assertEquals(1234, serverSocket.getLocalPort(), "Server should be started on port 1234.");
    }

    @Test
    public void testServerStopsSuccessfully() throws IOException {
        // Start the server in a separate thread
        new Thread(() -> server.startServer()).start();

        // Allow some time for the server to start
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Stop the server
        server.closeServerSocket();

        // Ensure the server socket is closed
        assertTrue(serverSocket.isClosed(), "Server socket should be closed after stop.");
    }

    @Test
    public void testClientConnection() throws IOException {
        // Start the server in a separate thread
        new Thread(() -> server.startServer()).start();

        // Allow some time for the server to start
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Simulate a client connecting to the server
        Socket clientSocket = new Socket("localhost", 1234);

        // Check if the client is connected to the server
        assertTrue(clientSocket.isConnected(), "Client should successfully connect to the server.");

        // Close client socket
        clientSocket.close();
    }
}
