package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by amalaugustinejose on 04/02/17.
 */
public class ChatServer {

    static ServerSocket serverSocket = null;

    static ClientThread[] clients = null;


    public static void main(String[] args) {
        int portNumber = 5678;
        serverSocket = null;
        try {
            serverSocket = new ServerSocket(portNumber);
            System.out.println("Server socket created");
        } catch (IOException e) {
            System.err.println("Could not listen on port: " + portNumber);
            System.exit(1);
        }
    }

    public static void acceptClients() {
        clients = new ArrayList<ClientThread>();
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                ClientThread client = new ClientThread(socket);
                Thread thread = new Thread(socket);
                thread.start();
                clients.add(client);
            } catch (IOException e) {
                System.out.println("Accept failed on port: ");
            }
        }
    }
}

