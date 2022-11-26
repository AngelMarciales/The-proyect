package Controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import com.google.gson.Gson;

import Views.Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

    private static final int PORT = 1234;
    private static final String HOST = "localhost";
    private DataInputStream input;
    private DataOutputStream output;
    private Socket socket;
    private Views views;

    public Controller() {
        try {
            socket = new Socket(HOST, PORT);
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
            views = new Views(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            output.writeUTF(new Gson().toJson("Admin"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    public static void main(String[] args) {
    }
}
