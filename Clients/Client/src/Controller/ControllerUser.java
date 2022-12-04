package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import com.google.gson.Gson;
import ClientViews.Views;

public class ControllerUser implements ActionListener {

    private static final int PORT = 1234;
    private static final String HOST = "localhost";
    private DataInputStream input;
    private DataOutputStream output;
    private Socket socket;
    private Views views;

    public ControllerUser() throws UnknownHostException, IOException {
        socket = new Socket(HOST, PORT);
        output = new DataOutputStream(socket.getOutputStream());
        input = new DataInputStream(socket.getInputStream());
        views = new Views(this);
        output.writeUTF("Cliente");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String source = e.getActionCommand();
        switch (source) {
            case "Comprar Boleta":
                try {
                    views.dialogBuy.setVisible(true);
                    output.writeUTF(new Gson().toJson("Comprar Boleta"));
                    String[] filmList = new Gson().fromJson(input.readUTF(), String[].class);
                    views.addItems(filmList);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                break;
            case "Ver Cartelera":
                try {
                    output.writeUTF(new Gson().toJson("Ver Cartelera"));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                views.dialogBillBoard.setVisible(true);
                break;
            case "Ver Rankings":
                try {
                    views.dialogRanking.setVisible(true);
                    output.writeUTF(new Gson().toJson("Ver Rankings"));
                    String[] filmList = new Gson().fromJson(input.readUTF(), String[].class);
                    int[] popularity = new Gson().fromJson(input.readUTF(), int[].class);
                    views.setRanking(filmList, popularity);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                break;
            case "Salir":
                try {
                    output.writeUTF(new Gson().toJson("Salir"));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                System.exit(0);
                break;
            case "Buscar Funcion":
                try {
                    output.writeUTF(new Gson().toJson("Buscar Funcion"));
                    output.writeUTF(new Gson().toJson(views.getTxtComboBox()));
                    int[] id = new Gson().fromJson(input.readUTF(), int[].class);
                    String[] format = new Gson().fromJson(input.readUTF(), String[].class);
                    String[] filmName = new Gson().fromJson(input.readUTF(), String[].class);
                    String[] hour = new Gson().fromJson(input.readUTF(), String[].class);
                    int[] room = new Gson().fromJson(input.readUTF(), int[].class);
                    int[] cost = new Gson().fromJson(input.readUTF(), int[].class);
                    views.setFunctions(id, format, filmName, hour, cost, room);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                break;
        }
    }

    public static void main(String[] args) {
        try {
            new ControllerUser();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
