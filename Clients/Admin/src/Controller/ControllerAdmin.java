package Controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import com.google.gson.Gson;

import Views.Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerAdmin implements ActionListener {

    private static final int PORT = 1234;
    private static final String HOST = "localhost";
    private DataInputStream input;
    private DataOutputStream output;
    private Socket socket;
    private Views views;

    public ControllerAdmin() {
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
            output.writeUTF("Admin");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            String source = event.getActionCommand();
            switch (source) {
                case "Añadir funcion":
                    output.writeUTF("Añadir funcion");
                    views.dialogBuy.setVisible(true);
                    break;
                case "Añadir pelicula":
                    output.writeUTF("Añadir pelicula");
                    views.dialogBillBoard.setVisible(true);
                    break;
                case "Borrar funcion":
                    output.writeUTF("Borrar funcion");
                    views.dialogCancel.setVisible(true);
                    break;
                case "Editar funcion":
                    output.writeUTF("Editar funcion");
                    views.dialogRanking.setVisible(true);
                    break;
                case "Salir":
                    output.writeUTF("Salir");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        ControllerAdmin cA = new ControllerAdmin();
        cA.run();
    }
}
