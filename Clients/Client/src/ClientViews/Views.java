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

    public void addItems(String[] item) {
        dialogBuy.addItems(item);
    }

    public String getTxtComboBox() {
        return dialogBuy.getTxtComboBox();
    }

    public void setColor(int position, boolean confirm) {
        dialogBuy.setColor(position, confirm);
    }

    public String getTxtField() {
        return dialogBuy.getTxtField();
    }

    public void setFunctions(int[] id, String[] format, String[] filmName, String[] hour, int[] cost, int[] room) {
        dialogBuy.setFunctions(id, format, filmName, hour, cost, room);
    }

    public void addItems2(String[] list) {
        dialogBillBoard.addItems(list);
    }

    public void show(String a) {
        dialogBillBoard.show(a);
    }

    public void addTarjet(String[] routes, String[] names){
        dialogBillBoard.addTarjet(routes, names);
    }

    public void setValue(int value){
        dialogBuy.setValue(value);
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

    public void setRanking(String[] filmList, int[] popularity) {
        dialogRanking.setRanking(filmList, popularity);
    }

}