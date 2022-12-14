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

    public String[] getFilmsName() {
        ArrayList<Film> aux = filmList.inOrder();
        String[] billboard = new String[aux.size()];
        for (int i = 0; i < aux.size(); i++) {
            billboard[i] = aux.get(i).getName();
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

    public ArrayList<Function> getArrayFunctions() {
        return functionList.inOrder();
    }

    public ArrayList<Film> getArrayListFilms() {
        return filmList.inOrder();
    }

    public void deleteFunction(int id) {
        Function aux = new Function(id, null, null, null, 0, null);
        if (functionList.exist(aux)) {
            functionList.delete(functionList.search(aux));
            System.out.println("aaaaa");
        }
    }

    public void editFunction(Function function) {
        if (functionList.exist(function)) {
            if (!(function.getCost() == 0)) {
                functionList.search(function).setCost(function.getCost());
            }
            functionList.search(function).setFilm(function.getFilm());
            if (!(function.getFormat().equals(""))) {
                functionList.search(function).setFormat(function.getFormat());
            }
            if (!(function.getHour().equals(""))) {
                functionList.search(function).setHour(function.getHour());
            }
            functionList.search(function).setRoom(function.getRoom());
        }
    }

    public Film searchFilm(String name) {
        Film selectedFilm = new Film(name, null, "");
        Film aux = null;
        if (filmList.exist(selectedFilm)) {
            aux = filmList.search(selectedFilm);
        }
        return aux;
    }

    public int buyTicket(ArrayList<Integer> id, Function function) {
        int cost = 0;
        if (functionList.exist(function)) {
            for (int i = 0; i < id.size(); i++) {
                System.out.println(id.get(i));
            }
            filmList.search(functionList.search(function).getFilm()).setPopularityMax(id.size());
            tourChairs(id, function, true);
            cost = functionList.search(function).getCost() * id.size();
            System.out.println(cost);
        }
        return cost;
    }

    public void tourChairs(ArrayList<Integer> id, Function function, boolean confirm) {
        Chair[][] aux = functionList.search(function).getRoom().getChairList();
        for (int i = 0; i < aux.length; i++) {
            for (int j = 0; j < aux[i].length; j++) {
                for (int j2 = 0; j2 < id.size(); j2++) {
                    if (aux[i][j].getId() == id.get(j2)) {
                        aux[i][j].setState(confirm);
                        System.out.println(aux[i][j].getState());
                        System.out.println(aux[i][j].getId());
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
