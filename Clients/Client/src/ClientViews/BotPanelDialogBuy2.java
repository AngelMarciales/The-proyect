package ClientViews;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;

public class BotPanelDialogBuy2 extends JPanel {

    private JButton buttonConfirm;

    public BotPanelDialogBuy2(ActionListener listener) {
        initComponents(listener);
    }

    public void initComponents(ActionListener listener) {
        this.setBackground(Color.WHITE);
        buttonConfirm = new JButton("Aceptar");

        buttonConfirm.setBackground(Color.WHITE);
        buttonConfirm.setForeground(Color.BLACK);
        buttonConfirm.setFocusable(false);
        buttonConfirm.setBorderPainted(false);
        buttonConfirm.setActionCommand("Aceptar 1");

        add(buttonConfirm);

        buttonConfirm.addActionListener(listener);
    }
}
