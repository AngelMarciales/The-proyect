package models;

import java.util.ArrayList;
import java.util.Comparator;

public class Cinema {

    private ArrayList<Function> functionList;
    private ArrayList<Film> filmList;

    public Cinema() {
        functionList = new ArrayList<>();
        filmList = new ArrayList<Film>();
    }

    public void addFunction(Function function) {
        functionList.add(function);
    }

    public void addFilm(Film film) {
        filmList.add(film);
    }

    public void loadArchives(ArrayList<Function> functions, ArrayList<Film> films) {
        for (int i = 0; i < functions.size(); i++) {
            functionList.add(functions.get(i));
        }
        for (int i = 0; i < films.size(); i++) {
            filmList.add(films.get(i));
        }
    }

    public String[] getPosition(String position) {
        String[] positions = position.split("-");
        return positions;
    }

    public int buyTicket(String[] positions, Function function) {
        int cost = 0;
        String chairPosition = positions[0];
        int num1 = Integer.parseInt(positions[1]);
        int num2 = Integer.parseInt(positions[2]);
        for (int i = 0; i < functionList.size(); i++) {
            if (functionList.get(i) == function) {
                cost = functionList.get(i).getCost();
                if (chairPosition.equalsIgnoreCase("left")) {
                    tourLeftChais(num1, num2, functionList.get(i), true);
                } else if (chairPosition.equalsIgnoreCase("center")) {
                    tourCenterChais(num1, num2, functionList.get(i), true);
                } else if (chairPosition.equalsIgnoreCase("right")) {
                    tourRigthChais(num1, num2, functionList.get(i), true);
                }
            }
        }
        return cost;
    }

    public void tourLeftChais(int num1, int num2, Function function, boolean confirm) {
        for (int i = 0; i < function.getChairsLeft().length; i++) {
            for (int j = 0; j < function.getChairsLeft()[i].length; j++) {
                if (i == num1 && j == num2) {
                    function.getChairsLeft()[i][j] = confirm;
                }
            }
        }
    }

    public void tourCenterChais(int num1, int num2, Function function, boolean confirm) {
        for (int i = 0; i < function.getChairsLeft().length; i++) {
            for (int j = 0; j < function.getChairsLeft()[i].length; j++) {
                if (i == num1 && j == num2) {
                    function.getChairsLeft()[i][j] = confirm;
                }
            }
        }
    }

    public void tourRigthChais(int num1, int num2, Function function, boolean confirm) {
        for (int i = 0; i < function.getChairsLeft().length; i++) {
            for (int j = 0; j < function.getChairsLeft()[i].length; j++) {
                if (i == num1 && j == num2) {
                    function.getChairsLeft()[i][j] = confirm;
                }
            }
        }
    }

    public int calculateDiscount(int cost, String client) {
        int totalCost = 0;
        if (client.equalsIgnoreCase(String.valueOf(Client.PREMIUM))) {
            totalCost = (cost - 5000);
        } else {
            totalCost = cost;
        }
        return totalCost;
    }

    public void cancelTicket(String[] positions, Function function) {
        String chairPosition = positions[0];
        int num1 = Integer.parseInt(positions[1]);
        int num2 = Integer.parseInt(positions[2]);
        for (int i = 0; i < functionList.size(); i++) {
            if (functionList.get(i) == function) {
                if (chairPosition.equalsIgnoreCase("Left")) {
                    tourLeftChais(num1, num2, functionList.get(i), false);
                } else if (chairPosition.equalsIgnoreCase("Center")) {
                    tourCenterChais(num1, num2, functionList.get(i), false);
                } else if (chairPosition.equalsIgnoreCase("Right")) {
                    tourRigthChais(num1, num2, functionList.get(i), false);
                }
            }
        }
    }

    public String[] calculatePopularity() {
        String[] winner = new String[5];
        filmList.sort(new Comparator<Film>() {
            @Override
            public int compare(Film o1, Film o2) {
                return o2.getPopularity() - (o1.getPopularity());
            }
        });
        ;
        for (int i = 0; i < filmList.size(); i++) {
            winner[i] = filmList.get(i).getName();
        }
        return winner;
    }

    public ArrayList<Function> getFunctionList() {
        return functionList;
    }

    public ArrayList<Film> getFilmList() {
        return filmList;
    }
}
