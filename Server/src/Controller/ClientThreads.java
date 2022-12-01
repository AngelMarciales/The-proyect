package Controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;

import Models.Cinema;
import Models.Film;
import Models.Function;
import Persistance.Persistence;

public class ClientThreads extends Thread {

    private DataInputStream input;
    private DataOutputStream output;
    private Socket socket;
    private Cinema cinema;
    private Persistence persistence;
    private int cost;
    private String position;

    public ClientThreads(Socket serverSocket, Cinema cinema) {
        try {
            this.socket = serverSocket;
            this.cinema = cinema;
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
            persistence = new Persistence();
            loadData();
            addItems();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            boolean exit = true;
            while (exit) {
                switch (input.readUTF()) {
                    case "Cliente":

                        break;
                    case "Admin":
                        String response = input.readUTF();
                        switch (response) {
                            case "Añadir funcion":
                                cinema.addFunction(new Function(MAX_PRIORITY, position, null, position, cost, null));
                                break;
                            case "Añadir pelicula":
                                cinema.addFilm(new Film(response, response, response));
                                break;
                            case "Borrar funcion":

                                break;
                            case "Editar funcion":

                                break;
                            case "Salir":
                                exit = false;
                                break;
                        }
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadData() {
        try {
            persistence.readFunction();
            persistence.readFilm();
            cinema.loadArchives(persistence.getFuncTionList(), persistence.getFilmList());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void Save() {
        // try {
        // persistence.writeFunction(cinema.getFunctionList());
        // persistence.writeFilm(cinema.getFilmList());
        // } catch (FileNotFoundException e) {
        // e.printStackTrace();
        // }
    }

    public void addItems() {
        // ArrayList<Film> films = cinema.getFilmList();
        // for (int i = 0; i < films.size(); i++) {
        // views.addItems(films.get(i).getName());
        // views.addItems2(films.get(i).getName());
        // }
    }

}