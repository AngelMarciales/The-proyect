package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import ClientViews.Views;
import Models.Film;
import Models.Function;

public class ControllerUser implements ActionListener {

    /*private static final int PORT = 1234;
    private static final String HOST = "localhost";
    private DataInputStream input;
    private DataOutputStream output;
    private Socket socket;*/
    private Views views;

    public ControllerUser() throws UnknownHostException, IOException {
        //socket = new Socket(HOST, PORT);
        //output = new DataOutputStream(socket.getOutputStream());
        //input = new DataInputStream(socket.getInputStream());
        views = new Views(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String source = e.getActionCommand();
        ArrayList<Function> functions = null;
        ArrayList<Film> films = null;
        switch (source) {
            case "Button 1":
                views.dialogBuy.setVisible(true);
                break;
            case "Button 2":
                views.dialogBillBoard.setVisible(true);
                break;
            case "Button 3":
                views.dialogRanking.setVisible(true);
                break;
            case "Button 4":
                System.exit(0);
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
