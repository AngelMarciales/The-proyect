package views;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import java.awt.event.ActionListener;

public class DialogBuy2 extends JDialog {

    private TopPanelDialogBuy2 centerpanel;
    private CenterPanelBuy topPanel;
    private BotPanelDialogBuy2 botPanel;

    public DialogBuy2(ActionListener listener) {
        this.setSize(800, 500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        initComponents(listener);
        this.setVisible(false);
    }

    public void initComponents(ActionListener listener) {
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        centerpanel = new TopPanelDialogBuy2(listener);
        topPanel = new CenterPanelBuy();
        botPanel = new BotPanelDialogBuy2(listener);
        add(centerpanel);
        add(topPanel);
        add(botPanel);
    }

    public void setColor(String position, boolean confirm) {
        centerpanel.setColorChair(position, confirm);
    }

    public String getColor(String position) {
        return centerpanel.getColor(position);
    }
}
