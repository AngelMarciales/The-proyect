package ClientViews;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;

public class BotPanelRightBillboard extends JPanel {

    private JButton buttonAcept;

    public BotPanelRightBillboard(ActionListener listener) {
        initComponents(listener);
    }

    public void initComponents(ActionListener listener) {
        this.setBackground(Color.WHITE);
        buttonAcept = new JButton("Confirmar");

        buttonAcept.setBackground(Color.WHITE);
        buttonAcept.setForeground(Color.BLACK);
        buttonAcept.setFocusable(false);
        buttonAcept.setBorderPainted(false);

        add(buttonAcept);

        buttonAcept.setActionCommand("Aceptar 3");
        buttonAcept.addActionListener(listener);
    }
}