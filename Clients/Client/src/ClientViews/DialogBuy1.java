package ClientViews;

import java.awt.BorderLayout;
import javax.swing.JDialog;
import java.awt.Color;
import java.awt.event.ActionListener;

public class DialogBuy1 extends JDialog {

    public DialogBuy2 dialog2;
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
        dialog2.setVisible(false);
        topPanelBuy1 = new TopPanelDialogBuy1(listener);
        centerPanelDialogBuy1 = new CenterPanelDialogBuy1();
        botPanelDialogBuy1 = new BotPanelDialogBuy1(listener);

        add(topPanelBuy1, BorderLayout.NORTH);
        add(centerPanelDialogBuy1, BorderLayout.CENTER);
        add(botPanelDialogBuy1, BorderLayout.SOUTH);
    }

    public void addItems(String[] item) {
        topPanelBuy1.addItems(item);
    }

    public String getTxtComboBox() {
        return topPanelBuy1.getTxtComboBox();
    }

    public void setColor(String position, boolean confirm) {
        dialog2.setColor(position, confirm);
    }

    public String getTxtField() {
        return botPanelDialogBuy1.getTxtField();
    }

    public void setFunctions(int[] id, String[] format, String[] filmName, String[] hour, int[] cost, int[] room) {
        centerPanelDialogBuy1.setFunctions(id, format, filmName, hour, cost, room);
    }

}
