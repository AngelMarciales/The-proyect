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

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            String source = event.getActionCommand();
            switch (source) {
                case "Añadir funcion":
                    views.setVisible(false);
                    views.functionPanel.setVisible(true);
                    output.writeUTF(new Gson().toJson("Añadir funcion"));
                    String[] lista = new Gson().fromJson(input.readUTF(), String[].class);
                    views.addFilmItems(lista);
                    String[] rooms = new String[] { "1", "2", "3" };
                    views.addRoomItems(rooms);
                    break;
                case "Aceptar1":
                    String[] newFunction = new String[6];
                    newFunction[0] = views.getID();
                    newFunction[1] = views.getFormat();
                    newFunction[2] = views.getFilm();
                    newFunction[3] = views.getHour();
                    newFunction[4] = String.valueOf(views.getCost());
                    newFunction[5] = views.getRoom();
                    output.writeUTF(new Gson().toJson(newFunction, String[].class));
                    views.setVisible(true);
                    views.functionPanel.setVisible(false);
                    break;
                case "Añadir pelicula":
                    output.writeUTF("Añadir pelicula");
                    views.setVisible(false);
                    views.filmPanel.setVisible(true);
                    break;
                case "Aceptar2":
                    String[] newFilm = new String[3];
                    newFilm[0] = views.getName();
                    newFilm[1] = views.getDirector();
                    newFilm[2] = views.getURLImage();
                    output.writeUTF(new Gson().toJson(newFilm, String[].class));
                    views.setVisible(true);
                    views.functionPanel.setVisible(false);
                    break;
                case "Borrar funcion":
                    output.writeUTF("Borrar funcion");
                    views.setVisible(false);
                    views.deleteFunctionPanel.setVisible(true);
                    break;
                case "Aceptar3":
                    output.writeInt(views.getDeleteID());
                    views.setVisible(true);
                    views.deleteFunctionPanel.setVisible(false);
                    break;
                case "Editar funcion":
                    output.writeUTF("Editar funcion");
                    views.setVisible(false);
                    views.editFunctionPanel.setVisible(true);
                    break;
                case "Aceptar4":
                    output.writeInt(views.getDeleteID());
                    views.setVisible(true);
                    views.deleteFunctionPanel.setVisible(false);
                    break;
                case "Salir":
                    output.writeUTF("Salir");
                    System.exit(0);
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new ControllerAdmin();
    }
}
