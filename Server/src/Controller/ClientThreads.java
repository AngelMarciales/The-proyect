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
import Models.Room;
import Persistance.Persistence;

public class ClientThreads extends Thread {

    private DataInputStream input;
    private DataOutputStream output;
    private Socket socket;
    private Cinema cinema;
    private Persistence persistence;
    private int idFilm;
    private int totalCost;

    public ClientThreads(Socket serverSocket, Cinema cinema) {
        try {
            this.socket = serverSocket;
            this.cinema = cinema;
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
            persistence = new Persistence();
            loadData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            String res = new Gson().fromJson(input.readUTF(), String.class);
            switch (res) {
                case "Comprar Boleta":
                    output.writeUTF(new Gson().toJson(cinema.calculatePopularity()));
                    break;
                case "Ver Cartelera":
                    output.writeUTF(new Gson().toJson(cinema.calculatePopularity()));
                    String[] routes = new String[cinema.getBillboard().length];
                    String[] names = new String[cinema.getBillboard().length];
                    for (int i = 0; i < cinema.getBillboard().length; i++) {
                        routes[i] = cinema.getBillboard()[i].getRouteImage();
                        names[i] = cinema.getBillboard()[i].getName();
                    }
                    output.writeUTF(new Gson().toJson(routes));
                    output.writeUTF(new Gson().toJson(names));
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
                case "Buscar Funcion 2":
                    String name2 = new Gson().fromJson(input.readUTF(), String.class);
                    String tarjet = "";
                    String director = "";
                    for (int i = 0; i < cinema.getFunctionList().length; i++) {
                        if (cinema.getFunctionList()[i].getFilm().getName().equalsIgnoreCase(name2)) {
                            tarjet = cinema.getFunctionList()[i].getFilm().getName();
                            director = cinema.getFunctionList()[i].getFilm().getDirector();
                            break;
                        }
                    }
                    output.writeUTF(new Gson().toJson(tarjet));
                    output.writeUTF(new Gson().toJson(director));
                    break;
                case "Seleccionar silla":
                    Room rooms = null;
                    idFilm = Integer.parseInt(new Gson().fromJson(input.readUTF(), String.class));
                    for (int i = 0; i < cinema.getFunctionList().length; i++) {
                        if (cinema.getFunctionList()[i].getId() == idFilm) {
                            rooms = cinema.getFunctionList()[i].getRoom();
                            break;
                        }
                    }
                    output.writeUTF(new Gson().toJson(rooms));
                    break;
                case "Aceptar 1":
                    ArrayList<Integer> newChairsBought = new ArrayList<>();
                    int[] newChairsBoughtAux = new Gson().fromJson(input.readUTF(), int[].class);
                    for (int i = 0; i < newChairsBoughtAux.length; i++) {
                        newChairsBought.add(newChairsBoughtAux[i]);
                    }
                    for (int i = 0; i < cinema.getFunctionList().length; i++) {
                        if (cinema.getFunctionList()[i].getId() == idFilm) {
                            totalCost = cinema.buyTicket(newChairsBought, cinema.getFunctionList()[i]);
                            System.out.println(totalCost);
                            break;
                        }
                    }
                    output.writeUTF(new Gson().toJson(totalCost));
                    Save();
                    break;
                case "A??adir funcion":
                case "Editar funcion":
                    String[] function2 = cinema.getFilmsName();
                    output.writeUTF(new Gson().toJson(function2));
                    break;
                case "Aceptar2":
                    String[] newFunction = new Gson().fromJson(input.readUTF(), String[].class);
                    Film aux = cinema.searchFilm(newFunction[2]);
                    Room aux2 = new Room(Integer.parseInt(newFunction[5]));
                    cinema.addFunction(new Function(Integer.parseInt(newFunction[0]), newFunction[1], aux,
                            newFunction[3], Integer.parseInt(newFunction[4]), aux2));
                    Save();
                    break;
                case "Aceptar3":
                    String[] film = new Gson().fromJson(input.readUTF(), String[].class);
                    cinema.addFilm(new Film(film[0], film[1], film[2]));
                    Save();
                    break;
                case "Aceptar4":
                    cinema.deleteFunction(input.readInt());
                    Save();
                    break;
                case "Aceptar5":
                    String[] editedFunction = new Gson().fromJson(input.readUTF(), String[].class);
                    Film aux3 = cinema.searchFilm(editedFunction[2]);
                    Room aux4 = new Room(Integer.parseInt(editedFunction[5]));
                    if (!(editedFunction[4].equals(""))) {
                        cinema.editFunction(new Function(Integer.parseInt(editedFunction[0]), editedFunction[1], aux3,
                                editedFunction[3], Integer.parseInt(editedFunction[4]), aux4));
                    }

                    Save();
                    break;
                case "Salir":
                    socket.close();
                    break;
            }
            run();
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
        try {
            persistence.writeFunction(cinema.getArrayFunctions());
            persistence.writeFilm(cinema.getArrayListFilms());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}