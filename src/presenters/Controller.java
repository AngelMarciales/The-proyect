package presenters;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.Cinema;
import models.Film;
import persistences.Persistence;
import views.Views;
import models.Function;

public class Controller implements ActionListener {

    private Views views;
    private Cinema cinema;
    private Persistence persistence;
    private Function function1;
    private int cost;
    private String position;

    public Controller() {
        views = new Views(this);
        cinema = new Cinema();
        persistence = new Persistence();
        loadData();
        addItems();
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
            persistence.writeFunction(cinema.getFunctionList());
            persistence.writeFilm(cinema.getFilmList());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addItems() {
        ArrayList<Film> films = cinema.getFilmList();
        for (int i = 0; i < films.size(); i++) {
            views.addItems(films.get(i).getName());
            views.addItems2(films.get(i).getName());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String source = e.getActionCommand();
        ArrayList<Function> functions = cinema.getFunctionList();
        ArrayList<Film> films = cinema.getFilmList();
        switch (source) {
            case "Button 1":
                views.dialogBuy.setVisible(true);
                break;
            case "Button 2":
                views.dialogBillBoard.setVisible(true);
                break;
            case "Button 3":
                views.dialogCancel.setVisible(true);
                break;
            case "Button 4":
                views.dialogRanking.setVisible(true);
                for (int i = 0; i < films.size(); i++) {
                    if (cinema.calculatePopularity()[0].equalsIgnoreCase(films.get(i).getName())) {
                        views.setFilm1(cinema.calculatePopularity()[0],
                                String.valueOf(films.get(i).getPopularity()));
                    }
                    if (cinema.calculatePopularity()[1].equalsIgnoreCase(films.get(i).getName())) {
                        views.setFilm2(cinema.calculatePopularity()[1],
                                String.valueOf(films.get(i).getPopularity()));
                    }
                    if (cinema.calculatePopularity()[2].equalsIgnoreCase(films.get(i).getName())) {
                        views.setFilm3(cinema.calculatePopularity()[2],
                                String.valueOf(films.get(i).getPopularity()));
                    }
                    if (cinema.calculatePopularity()[3].equalsIgnoreCase(films.get(i).getName())) {
                        views.setFilm4(cinema.calculatePopularity()[3],
                                String.valueOf(films.get(i).getPopularity()));
                    }
                    if (cinema.calculatePopularity()[4].equalsIgnoreCase(films.get(i).getName())) {
                        views.setFilm5(cinema.calculatePopularity()[4],
                                String.valueOf(films.get(i).getPopularity()));
                    }
                }
                break;
            case "Button 5":
                System.exit(0);
                break;
            case "Buscar 1":
                ArrayList<Function> nameList = new ArrayList<Function>();
                for (int i = 0; i < functions.size(); i++) {
                    if (functions.get(i).getFilm().getName().equalsIgnoreCase(views.dialogBuy.getTxtComboBox())) {
                        nameList.add(functions.get(i));
                    }
                }
                if (nameList.size() == 1) {
                    if (nameList.get(0) != null) {
                        views.setTxtFunction1(nameList.get(0).getId(), nameList.get(0).getFormat(),
                                nameList.get(0).getFilm().getName(),
                                nameList.get(0).getHourAndRoom(), nameList.get(0).getCost(), true);
                        views.setTxtFunction2(0, "", "", "", 0, false);
                        views.setTxtFunction3(0, "", "", "", 0, false);
                    }
                } else if (nameList.size() == 2) {
                    if (nameList.get(0) != null) {
                        views.setTxtFunction1(nameList.get(0).getId(), nameList.get(0).getFormat(),
                                nameList.get(0).getFilm().getName(),
                                nameList.get(0).getHourAndRoom(), nameList.get(0).getCost(), true);
                    }
                    if (nameList.get(1) != null) {
                        views.setTxtFunction2(nameList.get(1).getId(), nameList.get(1).getFormat(),
                                nameList.get(1).getFilm().getName(),
                                nameList.get(1).getHourAndRoom(), nameList.get(1).getCost(), true);
                        views.setTxtFunction3(0, "", "", "", 0, false);
                    }
                } else {
                    if (nameList.get(0) != null) {
                        views.setTxtFunction1(nameList.get(0).getId(), nameList.get(0).getFormat(),
                                nameList.get(0).getFilm().getName(),
                                nameList.get(0).getHourAndRoom(), nameList.get(0).getCost(), true);
                    }
                    if (nameList.get(1) != null) {
                        views.setTxtFunction2(nameList.get(1).getId(), nameList.get(1).getFormat(),
                                nameList.get(1).getFilm().getName(),
                                nameList.get(1).getHourAndRoom(), nameList.get(1).getCost(), true);
                    }
                    if (nameList.get(2) != null) {
                        views.setTxtFunction3(nameList.get(2).getId(), functions.get(2).getFormat(),
                                functions.get(2).getFilm().getName(),
                                functions.get(2).getHourAndRoom(), functions.get(2).getCost(), true);
                    }
                }
                break;
            case "Buscar 2":
                for (int i = 0; i < films.size(); i++) {
                    if (films.get(i).getName().equalsIgnoreCase(views.dialogBillBoard.getTxtComboBox())) {
                        views.show(films.get(i).getName());
                        views.setTxtFunction1(films.get(i).getName());
                        views.setTxtFunction2(films.get(i).getDirector());
                    }
                }
                break;
            case "Seleccionar silla":
                for (int i = 0; i < functions.size(); i++) {
                    if (functions.get(i).getId() == Integer.parseInt(views.getTxtField())) {
                        function1 = functions.get(i);
                    }
                }
                for (int i = 0; i < function1.getChairsLeft().length; i++) {
                    for (int j = 0; j < function1.getChairsLeft()[i].length; j++) {
                        if (function1.getChairsLeft()[i][j] == true) {
                            views.setColor("Left-" + i + "-" + j, true);
                        }
                    }
                }
                for (int i = 0; i < function1.getChairsCenter().length; i++) {
                    for (int j = 0; j < function1.getChairsCenter()[i].length; j++) {
                        if (function1.getChairsCenter()[i][j] == true) {
                            views.setColor("Center-" + i + "-" + j, true);
                        }
                    }
                }
                for (int i = 0; i < function1.getChairsRigth().length; i++) {
                    for (int j = 0; j < function1.getChairsRigth()[i].length; j++) {
                        if (function1.getChairsRigth()[i][j] == true) {
                            views.setColor("Right-" + i + "-" + j, true);
                        }
                    }
                }
                views.dialogBuy.dialog2.setVisible(true);
                break;
            case "Confirmar":
                Save();
                cost = 0;
                views.dialogBuy.setVisible(false);
                views.dialogBuy.dialog2.setVisible(false);
                views.dialogBuy.dialog3.setVisible(false);
                break;
            case "Confirmar 2":
                views.dialogBillBoard.setVisible(false);
                break;
            case "Continuar":
                views.setValue(String.valueOf(cinema.calculateDiscount(cost, views.dialogBuy.getTxtClient())));
                views.setLabelPosition(position);
                break;
            case "Siguiente":
                views.dialogBuy.dialog3.setVisible(true);
                break;
            case "Aceptar":
                String positions = views.getPosition() + "-" + views.getRow() + "-"
                        + views.getColum();
                for (int i = 0; i < functions.size(); i++) {
                    if (functions.get(i).getId() == Integer.parseInt(views.getTxtField2())) {
                        function1 = functions.get(i);
                    }
                }
                for (int i = 0; i < films.size(); i++) {
                    if (function1.getFilm() == films.get(i)) {
                        films.get(i).setPopularityMin(1);
                    }
                }
                cinema.cancelTicket(cinema.getPosition(positions), function1);
                Save();
                views.dialogCancel.setVisible(false);
                new Controller();
                break;
            case "Aceptar 2":
                views.dialogRanking.setVisible(false);
                break;
            case "Left-0-0":
                for (int i = 0; i < films.size(); i++) {
                    if (function1.getFilm().getName().equals(films.get(i).getName())) {
                        cost = cinema.buyTicket(cinema.getPosition(source), function1);
                        views.setColor(source, true);
                        films.get(i).setPopularityMax(1);
                        position = source;
                    }
                }
                break;
            case "Left-0-1":
                for (int i = 0; i < films.size(); i++) {
                    if (function1.getFilm().getName().equals(films.get(i).getName())) {
                        cost = cinema.buyTicket(cinema.getPosition(source), function1);
                        views.setColor(source, true);
                        films.get(i).setPopularityMax(1);
                        position = source;
                    }
                }
            case "Left-0-2":
                for (int i = 0; i < films.size(); i++) {
                    if (function1.getFilm().getName().equals(films.get(i).getName())) {
                        cost = cinema.buyTicket(cinema.getPosition(source), function1);
                        views.setColor(source, true);
                        films.get(i).setPopularityMax(1);
                        position = source;
                    }
                }
                break;
            case "Left-0-3":
                for (int i = 0; i < films.size(); i++) {
                    if (function1.getFilm().getName().equals(films.get(i).getName())) {
                        cost = cinema.buyTicket(cinema.getPosition(source), function1);
                        views.setColor(source, true);
                        films.get(i).setPopularityMax(1);
                        position = source;
                    }
                }
                break;
            case "Left-0-4":
                for (int i = 0; i < films.size(); i++) {
                    if (function1.getFilm().getName().equals(films.get(i).getName())) {
                        cost = cinema.buyTicket(cinema.getPosition(source), function1);
                        views.setColor(source, true);
                        films.get(i).setPopularityMax(1);
                        position = source;
                    }
                }
                break;
            case "Left-0-5":
                for (int i = 0; i < films.size(); i++) {
                    if (function1.getFilm().getName().equals(films.get(i).getName())) {
                        cost = cinema.buyTicket(cinema.getPosition(source), function1);
                        views.setColor(source, true);
                        films.get(i).setPopularityMax(1);
                        position = source;
                    }
                }
                break;
            case "Left-1-0":
                for (int i = 0; i < films.size(); i++) {
                    if (function1.getFilm().getName().equals(films.get(i).getName())) {
                        cost = cinema.buyTicket(cinema.getPosition(source), function1);
                        views.setColor(source, true);
                        films.get(i).setPopularityMax(1);
                        position = source;
                    }
                }
                break;
            case "Left-1-1":
                for (int i = 0; i < films.size(); i++) {
                    if (function1.getFilm().getName().equals(films.get(i).getName())) {
                        cost = cinema.buyTicket(cinema.getPosition(source), function1);
                        views.setColor(source, true);
                        films.get(i).setPopularityMax(1);
                        position = source;
                    }
                }
                break;
            case "Left-1-2":
                for (int i = 0; i < films.size(); i++) {
                    if (function1.getFilm().getName().equals(films.get(i).getName())) {
                        cost = cinema.buyTicket(cinema.getPosition(source), function1);
                        views.setColor(source, true);
                        films.get(i).setPopularityMax(1);
                        position = source;
                    }
                }
                break;
            case "Left-1-3":
                for (int i = 0; i < films.size(); i++) {
                    if (function1.getFilm().getName().equals(films.get(i).getName())) {
                        cost = cinema.buyTicket(cinema.getPosition(source), function1);
                        views.setColor(source, true);
                        films.get(i).setPopularityMax(1);
                        position = source;
                    }
                }
                break;
            case "Left-1-4":
                for (int i = 0; i < films.size(); i++) {
                    if (function1.getFilm().getName().equals(films.get(i).getName())) {
                        cost = cinema.buyTicket(cinema.getPosition(source), function1);
                        views.setColor(source, true);
                        films.get(i).setPopularityMax(1);
                        position = source;
                    }
                }
                break;
            case "Left-1-5":
                for (int i = 0; i < films.size(); i++) {
                    if (function1.getFilm().getName().equals(films.get(i).getName())) {
                        cost = cinema.buyTicket(cinema.getPosition(source), function1);
                        views.setColor(source, true);
                        films.get(i).setPopularityMax(1);
                        position = source;
                    }
                }
                break;
            case "Center-0-0":
                for (int i = 0; i < films.size(); i++) {
                    if (function1.getFilm().getName().equals(films.get(i).getName())) {
                        cost = cinema.buyTicket(cinema.getPosition(source), function1);
                        views.dialogBuy.setColor(source, true);
                        films.get(i).setPopularityMax(1);
                        position = source;
                    }
                }
                break;
            case "Center-0-1":
                for (int i = 0; i < films.size(); i++) {
                    if (function1.getFilm().getName().equals(films.get(i).getName())) {
                        cost = cinema.buyTicket(cinema.getPosition(source), function1);
                        views.dialogBuy.setColor(source, true);
                        films.get(i).setPopularityMax(1);
                        position = source;
                    }
                }
                break;
            case "Center-0-2":
                for (int i = 0; i < films.size(); i++) {
                    if (function1.getFilm().getName().equals(films.get(i).getName())) {
                        cost = cinema.buyTicket(cinema.getPosition(source), function1);
                        views.dialogBuy.setColor(source, true);
                        films.get(i).setPopularityMax(1);
                        position = source;
                    }
                }
                break;
            case "Center-0-3":
                for (int i = 0; i < films.size(); i++) {
                    if (function1.getFilm().getName().equals(films.get(i).getName())) {
                        cost = cinema.buyTicket(cinema.getPosition(source), function1);
                        views.dialogBuy.setColor(source, true);
                        films.get(i).setPopularityMax(1);
                        position = source;
                    }
                }
                break;
            case "Center-0-4":
                for (int i = 0; i < films.size(); i++) {
                    if (function1.getFilm().getName().equals(films.get(i).getName())) {
                        cost = cinema.buyTicket(cinema.getPosition(source), function1);
                        views.dialogBuy.setColor(source, true);
                        films.get(i).setPopularityMax(1);
                        position = source;
                    }
                }
                break;
            case "Center-0-5":
                for (int i = 0; i < films.size(); i++) {
                    if (function1.getFilm().getName().equals(films.get(i).getName())) {
                        cost = cinema.buyTicket(cinema.getPosition(source), function1);
                        views.dialogBuy.setColor(source, true);
                        films.get(i).setPopularityMax(1);
                        position = source;
                    }
                }
                break;
            case "Center-1-0":
                for (int i = 0; i < films.size(); i++) {
                    if (function1.getFilm().getName().equals(films.get(i).getName())) {
                        cost = cinema.buyTicket(cinema.getPosition(source), function1);
                        views.dialogBuy.setColor(source, true);
                        films.get(i).setPopularityMax(1);
                        position = source;
                    }
                }
                break;
            case "Center-1-1":
                for (int i = 0; i < films.size(); i++) {
                    if (function1.getFilm().getName().equals(films.get(i).getName())) {
                        cost = cinema.buyTicket(cinema.getPosition(source), function1);
                        views.dialogBuy.setColor(source, true);
                        films.get(i).setPopularityMax(1);
                        position = source;
                    }
                }
                break;
            case "Center-1-2":
                for (int i = 0; i < films.size(); i++) {
                    if (function1.getFilm().getName().equals(films.get(i).getName())) {
                        cost = cinema.buyTicket(cinema.getPosition(source), function1);
                        views.dialogBuy.setColor(source, true);
                        films.get(i).setPopularityMax(1);
                        position = source;
                    }
                }
                break;
            case "Center-1-3":
                for (int i = 0; i < films.size(); i++) {
                    if (function1.getFilm().getName().equals(films.get(i).getName())) {
                        cost = cinema.buyTicket(cinema.getPosition(source), function1);
                        views.dialogBuy.setColor(source, true);
                        films.get(i).setPopularityMax(1);
                        position = source;
                    }
                }
                break;
            case "Center-1-4":
                for (int i = 0; i < films.size(); i++) {
                    if (function1.getFilm().getName().equals(films.get(i).getName())) {
                        cost= cinema.buyTicket(cinema.getPosition(source), function1);
                        views.dialogBuy.setColor(source, true);
                        films.get(i).setPopularityMax(1);
                        position = source;
                    }
                }
                break;
            case "Center-1-5":
                for (int i = 0; i < films.size(); i++) {
                    if (function1.getFilm().getName().equals(films.get(i).getName())) {
                        cost = cinema.buyTicket(cinema.getPosition(source), function1);
                        views.dialogBuy.setColor(source, true);
                        films.get(i).setPopularityMax(1);
                        position = source;
                    }
                }
                break;
            case "Center-2-0":
                for (int i = 0; i < films.size(); i++) {
                    if (function1.getFilm().getName().equals(films.get(i).getName())) {
                        cost = cinema.buyTicket(cinema.getPosition(source), function1);
                        views.dialogBuy.setColor(source, true);
                        films.get(i).setPopularityMax(1);
                        position = source;
                    }
                }
                break;
            case "Center-2-1":
                for (int i = 0; i < films.size(); i++) {
                    if (function1.getFilm().getName().equals(films.get(i).getName())) {
                        cost = cinema.buyTicket(cinema.getPosition(source), function1);
                        views.dialogBuy.setColor(source, true);
                        films.get(i).setPopularityMax(1);
                        position = source;
                    }
                }
                break;
            case "Center-2-2":
                for (int i = 0; i < films.size(); i++) {
                    if (function1.getFilm().getName().equals(films.get(i).getName())) {
                        cost = cinema.buyTicket(cinema.getPosition(source), function1);
                        views.dialogBuy.setColor(source, true);
                        films.get(i).setPopularityMax(1);
                        position = source;
                    }
                }
                break;
            case "Center-2-3":
                for (int i = 0; i < films.size(); i++) {
                    if (function1.getFilm().getName().equals(films.get(i).getName())) {
                        cost = cinema.buyTicket(cinema.getPosition(source), function1);
                        views.dialogBuy.setColor(source, true);
                        films.get(i).setPopularityMax(1);
                        position = source;
                    }
                }
                break;
            case "Center-2-4":
                for (int i = 0; i < films.size(); i++) {
                    if (function1.getFilm().getName().equals(films.get(i).getName())) {
                        cost = cinema.buyTicket(cinema.getPosition(source), function1);
                        views.dialogBuy.setColor(source, true);
                        films.get(i).setPopularityMax(1);
                        position = source;
                    }
                }
                break;
            case "Center-2-5":
                for (int i = 0; i < films.size(); i++) {
                    if (function1.getFilm().getName().equals(films.get(i).getName())) {
                        cost = cinema.buyTicket(cinema.getPosition(source), function1);
                        views.dialogBuy.setColor(source, true);
                        films.get(i).setPopularityMax(1);
                        position = source;
                    }
                }
                break;
            case "Right-0-0":
                for (int i = 0; i < films.size(); i++) {
                    if (function1.getFilm().getName().equals(films.get(i).getName())) {
                        cost = cinema.buyTicket(cinema.getPosition(source), function1);
                        views.dialogBuy.setColor(source, true);
                        films.get(i).setPopularityMax(1);
                        position = source;
                    }
                }
                break;
            case "Right-0-1":
                for (int i = 0; i < films.size(); i++) {
                    if (function1.getFilm().getName().equals(films.get(i).getName())) {
                        cost = cinema.buyTicket(cinema.getPosition(source), function1);
                        views.dialogBuy.setColor(source, true);
                        films.get(i).setPopularityMax(1);
                        position = source;
                    }
                }
                break;
            case "Right-0-2":
                for (int i = 0; i < films.size(); i++) {
                    if (function1.getFilm().getName().equals(films.get(i).getName())) {
                        cost = cinema.buyTicket(cinema.getPosition(source), function1);
                        views.dialogBuy.setColor(source, true);
                        films.get(i).setPopularityMax(1);
                        position = source;
                    }
                }
                break;
            case "Right-0-3":
                for (int i = 0; i < films.size(); i++) {
                    if (function1.getFilm().getName().equals(films.get(i).getName())) {
                        cost = cinema.buyTicket(cinema.getPosition(source), function1);
                        views.dialogBuy.setColor(source, true);
                        films.get(i).setPopularityMax(1);
                        position = source;
                    }
                }
                break;
            case "Right-0-4":
                for (int i = 0; i < films.size(); i++) {
                    if (function1.getFilm().getName().equals(films.get(i).getName())) {
                        cost = cinema.buyTicket(cinema.getPosition(source), function1);
                        views.dialogBuy.setColor(source, true);
                        films.get(i).setPopularityMax(1);
                        position = source;
                    }
                }
                break;
            case "Right-0-5":
                for (int i = 0; i < films.size(); i++) {
                    if (function1.getFilm().getName().equals(films.get(i).getName())) {
                        cost = cinema.buyTicket(cinema.getPosition(source), function1);
                        views.dialogBuy.setColor(source, true);
                        films.get(i).setPopularityMax(1);
                        position = source;
                    }
                }
                break;
            case "Right-1-0":
                for (int i = 0; i < films.size(); i++) {
                    if (function1.getFilm().getName().equals(films.get(i).getName())) {
                        cost = cinema.buyTicket(cinema.getPosition(source), function1);
                        views.dialogBuy.setColor(source, true);
                        films.get(i).setPopularityMax(1);
                        position = source;
                    }
                }
                break;
            case "Right-1-1":
                for (int i = 0; i < films.size(); i++) {
                    if (function1.getFilm().getName().equals(films.get(i).getName())) {
                        cost = cinema.buyTicket(cinema.getPosition(source), function1);
                        views.dialogBuy.setColor(source, true);
                        films.get(i).setPopularityMax(1);
                        position = source;
                    }
                }
                break;
            case "Right-1-2":
                for (int i = 0; i < films.size(); i++) {
                    if (function1.getFilm().getName().equals(films.get(i).getName())) {
                        cost = cinema.buyTicket(cinema.getPosition(source), function1);
                        views.dialogBuy.setColor(source, true);
                        films.get(i).setPopularityMax(1);
                        position = source;
                    }
                }
                break;
            case "Right-1-3":
                for (int i = 0; i < films.size(); i++) {
                    if (function1.getFilm().getName().equals(films.get(i).getName())) {
                        cost = cinema.buyTicket(cinema.getPosition(source), function1);
                        views.dialogBuy.setColor(source, true);
                        films.get(i).setPopularityMax(1);
                        position = source;
                    }
                }
                break;
            case "Right-1-4":
                for (int i = 0; i < films.size(); i++) {
                    if (function1.getFilm().getName().equals(films.get(i).getName())) {
                        cost = cinema.buyTicket(cinema.getPosition(source), function1);
                        views.dialogBuy.setColor(source, true);
                        films.get(i).setPopularityMax(1);
                        position = source;
                    }
                }
                break;
            case "Right-1-5":
                for (int i = 0; i < films.size(); i++) {
                    if (function1.getFilm().getName().equals(films.get(i).getName())) {
                        cost = cinema.buyTicket(cinema.getPosition(source), function1);
                        views.dialogBuy.setColor(source, true);
                        films.get(i).setPopularityMax(1);
                        position = source;
                    }
                }
                break;
            default:
                break;
        }

    }
    public static void main(String[] args) throws FileNotFoundException {
        new Controller();
    }
}
