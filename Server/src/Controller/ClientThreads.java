package Controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

import com.google.gson.Gson;

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
                String res = new Gson().fromJson(input.readUTF(), String.class);
                switch (res) {
                    case "Comprar Boleta":
                        output.writeUTF(new Gson().toJson(cinema.calculatePopularity()));
                        break;
                    case "Ver Cartelera":
                        break;
                    case "Ver Rankings":
                        String[] filmsnames = cinema.calculatePopularity();
                        int[] popularity = new int[cinema.calculatePopularity().length];
                        for (int i = 0; i < filmsnames.length; i++) {
                            for (int j = 0; j < cinema.getBillboard().length; j++) {
                                if (filmsnames[i].equalsIgnoreCase(cinema.getBillboard()[j].getName())) {
                                    popularity[i] = cinema.getBillboard()[j].getPopularity();
                                }
                            }
                        }
                        output.writeUTF(new Gson().toJson(filmsnames));
                        output.writeUTF(new Gson().toJson(popularity));
                        break;
                    case "Buscar Funcion":
                        ArrayList<Function> functionList = new ArrayList<>();
                        String name = new Gson().fromJson(input.readUTF(), String.class);
                        for (int i = 0; i < cinema.getFunctionList().length; i++) {
                            if (cinema.getFunctionList()[i].getFilm().getName().equalsIgnoreCase(name)) {
                                functionList.add(cinema.getFunctionList()[i]);
                            }
                        }

                        int[] id = new int[functionList.size()];
                        String[] format = new String[functionList.size()];
                        String[] filmName = new String[functionList.size()];
                        String[] hour = new String[functionList.size()];
                        int[] room = new int[functionList.size()];
                        int[] cost = new int[functionList.size()];

                        for (int i = 0; i < functionList.size(); i++) {
                            id[i] = functionList.get(i).getId();
                            format[i] = functionList.get(i).getFormat();
                            filmName[i] = functionList.get(i).getFilm().getName();
                            hour[i] = functionList.get(i).getHour();
                            room[i] = functionList.get(i).getRoom().getId();
                            cost[i] = functionList.get(i).getCost();
                        }

                        output.writeUTF(new Gson().toJson(id));
                        output.writeUTF(new Gson().toJson(format));
                        output.writeUTF(new Gson().toJson(filmName));
                        output.writeUTF(new Gson().toJson(hour));
                        output.writeUTF(new Gson().toJson(room));
                        output.writeUTF(new Gson().toJson(cost));
                        break;
                    case "Añadir funcion":
                        cinema.addFunction(new Function(MAX_PRIORITY, position, null, position, 0, null));
                        break;
                    case "Añadir pelicula":
                        cinema.addFilm(new Film(res, res, res));
                        break;
                    case "Borrar funcion":
                        cinema.deleteFunction(MAX_PRIORITY);
                        break;
                    case "Editar funcion":
                        cinema.editFunction(null);
                        break;
                    case "Salir":
                        exit = false;
                        socket.close();
                        break;
                }
                break;
            }
        } catch (

        Exception e) {
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