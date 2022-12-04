package ClientViews;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;

public class Views extends JFrame {

    private TopPanelMenu topPanel1;
    private CenterPanelMenu centerPanel1;
    public DialogBuy1 dialogBuy;
    public DialogBillBoard dialogBillBoard;
    public DialogRanking dialogRanking;

    public Views(ActionListener listener) {
        super("Cinema");
        this.setSize(300, 250);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        initComponents(listener);
        this.setVisible(true);
    }

    public void initComponents(ActionListener listener) {
        this.setLayout(new BorderLayout());
        topPanel1 = new TopPanelMenu();
        centerPanel1 = new CenterPanelMenu(listener);
        dialogBuy = new DialogBuy1(listener);
        dialogBillBoard = new DialogBillBoard(listener);
        dialogRanking = new DialogRanking(listener);
        dialogBuy.setVisible(false);
        dialogBillBoard.setVisible(false);
        dialogRanking.setVisible(false);
        this.getContentPane().add(topPanel1, BorderLayout.NORTH);
        this.getContentPane().add(centerPanel1, BorderLayout.CENTER);
    }

    public void addItems(String item) {
        dialogBuy.addItems(item);
    }

    public void setColor(String position, boolean confirm) {
        dialogBuy.setColor(position, confirm);
    }

    public String getTxtField() {
        return dialogBuy.getTxtField();
    }

    public void setTxtFunction1(int id, String format, String filmName, String hour, int cost, boolean confirm) {
        dialogBuy.setTxtFunction1(id, format, filmName, hour, cost, confirm);
    }

    public void setTxtFunction2(int id, String format, String filmName, String hour, int cost, boolean confirm) {
        dialogBuy.setTxtFunction2(id, format, filmName, hour, cost, confirm);
    }

    public void setTxtFunction3(int id, String format, String filmName, String hour, int cost, boolean confirm) {
        dialogBuy.setTxtFunction3(id, format, filmName, hour, cost, confirm);
    }

    public void addItems2(String list) {
        dialogBillBoard.addItems(list);
    }

    public void show(String a) {
        dialogBillBoard.show(a);
    }

    public String getTxtComboBox2() {
        return dialogBillBoard.getTxtComboBox();
    }

    public void setTxtFunction1(String message) {
        dialogBillBoard.setTxtFunction1(message);
    }

    public void setTxtFunction2(String message) {
        dialogBillBoard.setTxtFunction2(message);
    }

    public void setFilm1(String name, String popularity) {
        dialogRanking.setFilm1(name, popularity);
    }

    public void setFilm2(String name, String popularity) {
        dialogRanking.setFilm2(name, popularity);
    }

    public void setFilm3(String name, String popularity) {
        dialogRanking.setFilm3(name, popularity);
    }

    public void setFilm4(String name, String popularity) {
        dialogRanking.setFilm4(name, popularity);
    }

    public void setFilm5(String name, String popularity) {
        dialogRanking.setFilm5(name, popularity);
    }
}