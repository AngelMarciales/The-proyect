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

    // private static final int PORT = 13240;
    // private static final String HOST = "localhost";
    // private DataInputStream input;
    // private DataOutputStream output;
    // private Socket socket;
    private Views views;

    public ControllerAdmin() {
        try {
            // socket = new Socket(HOST, PORT);
            // input = new DataInputStream(socket.getInputStream());
            // output = new DataOutputStream(socket.getOutputStream());
            views = new Views(this);
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
                    views.setVisible(false);
                    views.functionPanel.setVisible(true);
                    // output.writeUTF(new Gson().toJson("Añadir funcion"));
                    // String[] lista = new Gson().fromJson(input.readUTF(), String[].class);
                    // views.addFilmItems(lista);
                    String[] rooms = new String[] { "1", "2", "3", "4", "5" };
                    views.addRoomItems(rooms);
                    break;
                case "Aceptar1":
                    // output.writeUTF(new Gson().toJson("Aceptar2"));
                    String[] newFunction = new String[6];
                    newFunction[0] = views.getID();
                    newFunction[1] = views.getFormat();
                    newFunction[2] = views.getFilm();
                    newFunction[3] = views.getHour();
                    newFunction[4] = String.valueOf(views.getCost());
                    newFunction[5] = views.getRoom();
                    // output.writeUTF(new Gson().toJson(newFunction, String[].class));
                    views.setVisible(true);
                    views.functionPanel.setVisible(false);
                    break;
                case "Añadir pelicula":
                    views.setVisible(false);
                    views.filmPanel.setVisible(true);
                    break;
                case "Aceptar2":
                    // output.writeUTF(new Gson().toJson("Aceptar3"));
                    String[] newFilm = new String[3];
                    newFilm[0] = views.getName();
                    newFilm[1] = views.getDirector();
                    newFilm[2] = views.getURLImage();
                    // output.writeUTF(new Gson().toJson(newFilm, String[].class));
                    views.setVisible(true);
                    views.functionPanel.setVisible(false);
                    break;
                case "Borrar funcion":
                    views.setVisible(false);
                    views.deleteFunctionPanel.setVisible(true);
                    break;
                case "Aceptar3":
                    // output.writeUTF(new Gson().toJson("Aceptar4"));
                    // output.writeInt(views.getDeleteID());
                    views.setVisible(true);
                    views.deleteFunctionPanel.setVisible(false);
                    break;
                case "Editar funcion":
                    views.setVisible(false);
                    views.editFunctionPanel.setVisible(true);
                    break;
                case "Aceptar4":
                    // output.writeUTF("Aceptar5");
                    String[] editedFunction = new String[6];
                    editedFunction[0] = views.getEditedID();
                    editedFunction[1] = views.getEditedFormat();
                    editedFunction[2] = views.getEditedFilm();
                    editedFunction[3] = views.geteditedHour();
                    editedFunction[4] = views.getEditedCost();
                    editedFunction[5] = views.getEditedRoom();
                    // output.writeUTF(new Gson().toJson(editedFunction, String[].class));
                    views.editFunctionPanel.setVisible(false);
                    views.setVisible(true);
                    break;
                case "Salir":
                    // output.writeUTF("Salir");
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
