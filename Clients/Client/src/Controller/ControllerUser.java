package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import com.google.gson.Gson;
import ClientViews.Views;

public class ControllerUser implements ActionListener {

    private static final int PORT = 13240;
    private static final String HOST = "localhost";
    private DataInputStream input;
    private DataOutputStream output;
    private Socket socket;
    private Views views;
    private Room rooms;
    private ArrayList<Integer> positions = new ArrayList<>();

    public ControllerUser() throws UnknownHostException, IOException {
        socket = new Socket(HOST, PORT);
        output = new DataOutputStream(socket.getOutputStream());
        input = new DataInputStream(socket.getInputStream());
        views = new Views(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String source = e.getActionCommand();
        int aux = 0;
        if (source.contains("Chair")) {
            aux = Integer.parseInt(source.split(":")[1]);
            source = "Chair";
        }
        try {
            switch (source) {
                case "Comprar Boleta":
                    views.dialogBuy.setVisible(true);
                    output.writeUTF(new Gson().toJson("Comprar Boleta"));
                    String[] filmList = new Gson().fromJson(input.readUTF(), String[].class);
                    views.addItems(filmList);
                    break;
                case "Ver Cartelera":
                    views.dialogBillBoard.setVisible(true);
                    output.writeUTF(new Gson().toJson("Ver Cartelera"));
                    String[] filmList2 = new Gson().fromJson(input.readUTF(), String[].class);
                    String[] routes = new Gson().fromJson(input.readUTF(), String[].class);
                    String[] names = new Gson().fromJson(input.readUTF(), String[].class);
                    views.addItems2(filmList2);
                    views.addTarjet(routes, names);
                    break;
                case "Ver Rankings":
                    views.dialogRanking.setVisible(true);
                    output.writeUTF(new Gson().toJson("Ver Rankings"));
                    String[] filmList3 = new Gson().fromJson(input.readUTF(), String[].class);
                    int[] popularity = new Gson().fromJson(input.readUTF(), int[].class);
                    views.setRanking(filmList3, popularity);
                    break;
                case "Salir":
                    output.writeUTF(new Gson().toJson("Salir"));
                    System.exit(0);
                    break;
                case "Buscar Funcion":
                    output.writeUTF(new Gson().toJson("Buscar Funcion"));
                    output.writeUTF(new Gson().toJson(views.getTxtComboBox()));
                    int[] id = new Gson().fromJson(input.readUTF(), int[].class);
                    String[] format = new Gson().fromJson(input.readUTF(), String[].class);
                    String[] filmName = new Gson().fromJson(input.readUTF(), String[].class);
                    String[] hour = new Gson().fromJson(input.readUTF(), String[].class);
                    int[] room = new Gson().fromJson(input.readUTF(), int[].class);
                    int[] cost = new Gson().fromJson(input.readUTF(), int[].class);
                    views.setFunctions(id, format, filmName, hour, cost, room);
                    break;
                case "Buscar Funcion 2":
                    output.writeUTF(new Gson().toJson("Buscar Funcion 2"));
                    output.writeUTF(new Gson().toJson(views.getTxtComboBox2()));
                    String tarjet = new Gson().fromJson(input.readUTF(), String.class);
                    String director = new Gson().fromJson(input.readUTF(), String.class);
                    views.show(tarjet);
                    views.setTxtFunction1(tarjet);
                    views.setTxtFunction2(director);
                    break;
                case "Seleccionar silla":
                    String txtField = views.getTxtField();
                    if (txtField.equals("")) {
                        views.setMessageError("No puede dejar espacios");
                        views.dialogError.setVisible(true);
                        break;
                    }
                    output.writeUTF(new Gson().toJson("Seleccionar silla"));
                    output.writeUTF(new Gson().toJson(txtField));
                    rooms = new Gson().fromJson(input.readUTF(), Room.class);
                    for (int i = 0; i < rooms.getChairList().length; i++) {
                        for (int j = 0; j < rooms.getChairList()[i].length; j++) {
                            if (!rooms.getChairList()[i][j].getState()) {
                                views.setColor(rooms.getChairList()[i][j].getId(), true);
                            } else {
                                views.setColor(rooms.getChairList()[i][j].getId(), false);
                            }
                        }
                    }
                    views.dialogBuy.dialog2.setVisible(true);

                    break;

                case "Chair":
                    for (int i = 0; i < rooms.getChairList().length; i++) {
                        for (int j = 0; j < rooms.getChairList()[i].length; j++) {
                            if (aux == rooms.getChairList()[i][j].getId()) {
                                views.setColor(rooms.getChairList()[i][j].getId(), false);
                                positions.add(aux);
                                break;
                            }
                        }
                    }
                    break;
                case "Aceptar 1":
                    output.writeUTF(new Gson().toJson("Aceptar 1"));
                    int[] positionAux = new int[positions.size()];
                    for (int i = 0; i < positions.size(); i++) {
                        positionAux[i] = positions.get(i);
                    }
                    output.writeUTF(new Gson().toJson(positionAux));
                    positions.clear();
                    views.setValue(new Gson().fromJson(input.readUTF(), Integer.class));
                    views.dialogBuy.dialog3.setVisible(true);
                    break;
                case "Aceptar 2":
                    views.dialogBuy.dialog3.setVisible(false);
                    views.dialogBuy.dialog2.setVisible(false);
                    views.dialogBuy.setVisible(false);
                    break;
                case "Aceptar 3":
                    views.dialogBillBoard.setVisible(false);
                    break;
                case "Aceptar 4":
                    views.dialogRanking.setVisible(false);
                    break;
                case "Aceptar Error":
                    views.setVisible(true);
                    views.dialogBillBoard.setVisible(false);
                    views.dialogBuy.setVisible(false);
                    views.dialogRanking.setVisible(false);
                    views.dialogError.setVisible(false);
                    views.dialogBuy.dialog3.setVisible(false);
                    views.dialogBuy.dialog2.setVisible(false);
                    break;
            }
        } catch (Exception e1) {
            e1.printStackTrace();
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
