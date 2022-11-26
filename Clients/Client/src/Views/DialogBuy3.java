package Views;

import javax.swing.JDialog;

import Views.BotPanelDialogBuy3;
import Views.CenterPanelDialogBuy3;
import Views.TopPanelDialogBuy3;

import java.awt.event.ActionListener;
import java.awt.BorderLayout;

public class DialogBuy3 extends JDialog {

    private TopPanelDialogBuy3 topPanelDialogBuy3;
    private CenterPanelDialogBuy3 centerPanelDialogBuy3;
    private BotPanelDialogBuy3 botPanelDialogBuy3;

    public DialogBuy3(ActionListener listener) {
        this.setSize(300, 200);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        initComponents(listener);
        this.setVisible(false);
    }

    public void initComponents(ActionListener listener) {
        setLayout(new BorderLayout());
        topPanelDialogBuy3 = new TopPanelDialogBuy3(listener);
        centerPanelDialogBuy3 = new CenterPanelDialogBuy3();
        botPanelDialogBuy3 = new BotPanelDialogBuy3(listener);

        add(topPanelDialogBuy3, BorderLayout.NORTH);
        add(centerPanelDialogBuy3, BorderLayout.CENTER);
        add(botPanelDialogBuy3, BorderLayout.SOUTH);
    }

    public void setLabelCost(String value) {
        centerPanelDialogBuy3.setLabelCost(value);
    }

    public void setLabelPosition(String value) {
        centerPanelDialogBuy3.setLabelPosition(value);
    }

    public String getTxtClient() {
        return topPanelDialogBuy3.getTxtClient();
    }
}
