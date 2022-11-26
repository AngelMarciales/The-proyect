package Views;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;

public class BotPanelDialogBuy3 extends JPanel {

    private JButton buttonAcept;

    public BotPanelDialogBuy3(ActionListener listener) {
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

        buttonAcept.addActionListener(listener);
    }
}
