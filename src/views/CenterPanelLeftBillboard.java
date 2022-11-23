package views;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;

public class CenterPanelLeftBillboard extends JPanel {

    private JButton buttonSearch;

    public CenterPanelLeftBillboard(ActionListener listener) {
        initComponents(listener);
    }

    public void initComponents(ActionListener listener) {
        this.setBackground(Color.WHITE);
        buttonSearch = new JButton("Buscar");

        buttonSearch.setBackground(Color.WHITE);
        buttonSearch.setForeground(Color.BLACK);
        buttonSearch.setFocusable(false);
        buttonSearch.setBorderPainted(false);

        buttonSearch.setActionCommand("Buscar 2");

        add(buttonSearch);

        buttonSearch.addActionListener(listener);
    }
}
