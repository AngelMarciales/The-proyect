package Models;

import Structure.*;

import java.util.ArrayList;

public class Cinema {

    private SearchBinaryTree<Function> functionList;
    private SearchBinaryTree<Film> filmList;

    public Cinema() {
        functionList = new SearchBinaryTree<>(null);
        filmList = new SearchBinaryTree<Film>(null);
    }

    public void addFunction(Function function) {
        functionList.insert(function);
    }

    public void addFilm(Film film) {
        filmList.insert(film);
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
        return null;
    }

    public Function[] getFunctionList() {
        return null;
    }

    public void deleteFilm(String name) {

    }

    public void editFunction(Function function) {

    }

    public int buyTicket(int id, Function function) {
        return 0;
    }

    public void tourChairs(int id, Function function, boolean confirm) {

    }

    public int getReservations(int idFunction) {
        return 0;
    }

    public String[] calculatePopularity() {
        String[] winner = new String[5];
        // filmList.sort(new Comparator<Film>() {
        // @Override
        // public int compare(Film o1, Film o2) {
        // return o2.getPopularity() - (o1.getPopularity());
        // }
        // });
        // ;
        // for (int i = 0; i < filmList.size(); i++) {
        // winner[i] = filmList.get(i).getName();
        // }
        return winner;
    }

}
