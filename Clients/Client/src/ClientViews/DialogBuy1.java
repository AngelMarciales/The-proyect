package ClientViews;

import java.awt.BorderLayout;
import javax.swing.JDialog;

import ClientViews.BotPanelDialogBuy1;
import ClientViews.CenterPanelDialogBuy1;
import ClientViews.DialogBuy2;
import ClientViews.DialogBuy3;
import ClientViews.TopPanelDialogBuy1;

import java.awt.Color;
import java.awt.event.ActionListener;

public class DialogBuy1 extends JDialog {

    public DialogBuy2 dialog2;
    public DialogBuy3 dialog3;
    private TopPanelDialogBuy1 topPanelBuy1;
    private CenterPanelDialogBuy1 centerPanelDialogBuy1;
    private BotPanelDialogBuy1 botPanelDialogBuy1;

    public DialogBuy1(ActionListener listener) {
        this.setSize(400, 250);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        initComponents(listener);
        this.setVisible(false);
    }

    public void initComponents(ActionListener listener) {
        this.getContentPane().setBackground(Color.BLACK);
        setLayout(new BorderLayout());
        dialog2 = new DialogBuy2(listener);
        dialog3 = new DialogBuy3(listener);
        dialog2.setVisible(false);
        dialog3.setVisible(false);
        topPanelBuy1 = new TopPanelDialogBuy1(listener);
        centerPanelDialogBuy1 = new CenterPanelDialogBuy1();
        botPanelDialogBuy1 = new BotPanelDialogBuy1(listener);

        add(topPanelBuy1, BorderLayout.NORTH);
        add(centerPanelDialogBuy1, BorderLayout.CENTER);
        add(botPanelDialogBuy1, BorderLayout.SOUTH);
    }

    public void addItems(String item) {
        topPanelBuy1.addItems(item);
    }

    public void setColor(String position, boolean confirm) {
        dialog2.setColor(position, confirm);
    }

    public String getTxtField() {
        return botPanelDialogBuy1.getTxtField();
    }

    public void setValue(String value) {
        dialog3.setLabelCost(value);
    }

    public void setLabelPosition(String value) {
        dialog3.setLabelPosition(value);
    }

    public String getTxtComboBox() {
        return topPanelBuy1.getTxtComboBox();
    }

    public String getTxtClient() {
        return dialog3.getTxtClient();
    }

    public void setTxtFunction1(int id, String format, String filmName, String hour, int cost, boolean confirm) {
        centerPanelDialogBuy1.setTxtFunction1(id, format, filmName, hour, cost, confirm);
    }

    public void setTxtFunction2(int id, String format, String filmName, String hour, int cost, boolean confirm) {
        centerPanelDialogBuy1.setTxtFunction2(id, format, filmName, hour, cost, confirm);
    }

    public void setTxtFunction3(int id, String format, String filmName, String hour, int cost, boolean confirm) {
        centerPanelDialogBuy1.setTxtFunction3(id, format, filmName, hour, cost, confirm);
    }
}
