package Controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import Models.Cinema;

public class Server {

    private static final int PORT = 13240;
    private ServerSocket serverSocket;
    private Socket socket;
    private Cinema cinema;

    public Server() {
        try {
            cinema = new Cinema();
            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            while (true) {
                socket = serverSocket.accept();
                new ClientThreads(socket, cinema).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server controller = new Server();
        controller.run();
    }
    
}
