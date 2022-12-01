package ClientViews;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.event.ActionListener;

public class BotPanelDialogCancel extends JPanel {

    private JButton buttonAcept;

    public BotPanelDialogCancel(ActionListener listener) {
        initComponents(listener);
    }

    public void initComponents(ActionListener listener) {
        this.setBackground(Color.WHITE);
        buttonAcept = new JButton("Aceptar");

        buttonAcept.setBackground(Color.WHITE);
        buttonAcept.setForeground(Color.BLACK);
        buttonAcept.setFocusable(false);
        buttonAcept.setBorderPainted(false);

        add(buttonAcept);

        buttonAcept.addActionListener(listener);
    }
}
