package Views;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

import Views.BotPanelRightBillboard;
import Views.CenterPanelRigthBillboard;

public class RightPanelBillboard extends JPanel {

    private CenterPanelRigthBillboard centerPanelRigthBillboard;
    private BotPanelRightBillboard botPanelRightBillboard;

    public RightPanelBillboard(ActionListener listener) {
        initComponents(listener);
    }

    public void initComponents(ActionListener listener) {
        this.setLayout(new BorderLayout());
        centerPanelRigthBillboard = new CenterPanelRigthBillboard();
        botPanelRightBillboard = new BotPanelRightBillboard(listener);

        add(centerPanelRigthBillboard, BorderLayout.CENTER);
        add(botPanelRightBillboard, BorderLayout.SOUTH);
    }

    public void setTxtFunction1(String message) {
        centerPanelRigthBillboard.setTxtFunction1(message);
    }

    public void setTxtFunction2(String message) {
        centerPanelRigthBillboard.setTxtFunction2(message);
    }
}