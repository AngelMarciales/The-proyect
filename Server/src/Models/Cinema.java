package Models;

import Structure.*;

import java.util.ArrayList;
import java.util.Comparator;

public class Cinema {

    private SearchBinaryTree<Function> functionList;
    private SearchBinaryTree<Film> filmList;

    public Cinema() {
        functionList = new SearchBinaryTree<Function>(Function::compareTo);
        filmList = new SearchBinaryTree<Film>(Film::compareTo);
    }

    public void addFunction(Function function) {
        if (!functionList.exist(function)) {
            functionList.insert(function);
        }
    }

    public void addFilm(Film film) {
        if (!filmList.exist(film)) {
            filmList.insert(film);
        }
    }

    public void loadArchives(ArrayList<Function> functions, ArrayList<Film> films) {
        for (int i = 0; i < functions.size(); i++) {
            functionList.insert(functions.get(i));
        }
        for (int i = 0; i < films.size(); i++) {
            filmList.insert(films.get(i));
        }
    }

    public Film[] getBillboard() {
        ArrayList<Film> aux = filmList.inOrder();
        Film[] billboard = new Film[aux.size()];
        for (int i = 0; i < aux.size(); i++) {
            billboard[i] = aux.get(i);
        }
        return billboard;
    }

    public Function[] getFunctionList() {
        ArrayList<Function> aux = functionList.inOrder();
        Function[] functions = new Function[aux.size()];
        for (int i = 0; i < aux.size(); i++) {
            functions[i] = aux.get(i);
        }
        return functions;
    }

    public void deleteFunction(int id) {
        ArrayList<Function> functionInOrder = functionList.inOrder();
        for (int i = 0; i < functionInOrder.size(); i++) {
            if (functionInOrder.get(i).getId() == id) {
                functionList.delete(functionInOrder.get(i));
            }
        }
    }

    public void editFunction(Function function) {

    }

    public int buyTicket(int id, Function function) {
        int cost = 0;
        if (!functionList.exist(function)) {
            filmList.search(functionList.search(function).getFilm()).setPopularityMax(1);
            tourChairs(id, function, true);
            cost = functionList.search(function).getCost();
        }
        return cost;
    }

    public int buyTicket(ArrayList<Integer> id, Function function) {
        int cost = 0;
        if (!functionList.exist(function)) {
            filmList.search(functionList.search(function).getFilm()).setPopularityMax(id.size());
            tourChairs(id, function, true);
            cost += functionList.search(function).getCost();
        }
        return cost;
    }

    public void tourChairs(int id, Function function, boolean confirm) {
        if (!functionList.exist(function)) {
            Chair[][] aux = functionList.search(function).getRoom().getChairList();
            for (int i = 0; i < aux.length; i++) {
                for (int j = 0; j < aux[i].length; j++) {
                    if (aux[i][j].getId() == id) {
                        aux[i][j].setState(confirm);
                        break;
                    }
                }
            }
        }
    }

    public void tourChairs(ArrayList<Integer> id, Function function, boolean confirm) {
        Chair[][] aux = functionList.search(function).getRoom().getChairList();
        for (int i = 0; i < aux.length; i++) {
            for (int j = 0; j < aux[i].length; j++) {
                for (int j2 = 0; j2 < id.size(); j2++) {
                    if (aux[i][j].getId() == id.get(j2)) {
                        aux[i][j].setState(confirm);
                    }
                }

            }
        }
    }

    public int getReservations(int idFunction) {
        Function aux = null;
        int count = 0;
        for (int i = 0; i < functionList.inOrder().size(); i++) {
            if (functionList.inOrder().get(i).getId() == idFunction) {
                aux = functionList.inOrder().get(i);
                break;
            }
        }
        for (int i = 0; i < aux.getRoom().getChairList().length; i++) {
            for (int j = 0; j < aux.getRoom().getChairList()[i].length; j++) {
                if (aux.getRoom().getChairList()[i][j].getState() != false) {
                    count++;
                }
            }
        }
        return count;
    }

    public String[] calculatePopularity() {
        String[] winner = new String[filmList.inOrder().size()];
        ArrayList<Film> aux = filmList.inOrder();
        aux.sort((Comparator<? super Film>) new Comparator<Film>() {
            @Override
            public int compare(Film o1, Film o2) {
                return o2.getPopularity() - (o1.getPopularity());
            }
        });
        ;
        for (int i = 0; i < aux.size(); i++) {
            winner[i] = aux.get(i).getName();
        }
        return winner;
    }

}
