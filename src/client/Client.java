package client;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by amalaugustinejose on 04/02/17.
 */
public class Client {
    public static void main(String[] args) {
        Socket socket = null;
        int portNumber = 5678;
        try {
            socket = new Socket("localhost", portNumber);
            Thread.sleep(1000);
            Thread server = new Thread(new ServerThread(socket));
            server.start();
        } catch (IOException e) {
            System.err.println("Fatal Connection Error");
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.err.println("Fatal Connection Error");
            e.printStackTrace();
        }
    }
}
