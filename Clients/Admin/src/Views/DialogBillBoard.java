package Views;

import javax.swing.JDialog;

import Views.PanelBillboard;

import java.awt.event.ActionListener;

public class DialogBillBoard extends JDialog {

    private PanelBillboard panelBillboard;

    public DialogBillBoard(ActionListener listener) {
        this.setSize(600, 450);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        initComponents(listener);
        this.setVisible(false);
    }

    public void initComponents(ActionListener listener) {
        panelBillboard = new PanelBillboard(listener);
        this.getContentPane().add(panelBillboard);
    }

    public void addItems(String list) {
        panelBillboard.addItems(list);
    }

    public void show(String a) {
        panelBillboard.show1(a);
    }

    public String getTxtComboBox() {
        return panelBillboard.getTxtComboBox();
    }

    public void setTxtFunction1(String message) {
        panelBillboard.setTxtFunction1(message);
    }

    public void setTxtFunction2(String message) {
        panelBillboard.setTxtFunction2(message);
    }
}