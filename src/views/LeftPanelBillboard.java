package views;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class LeftPanelBillboard extends JPanel {

    private TopPanelLeftBillboard topPanelLeftBillboard;
    private CenterPanelLeftBillboard centerPanelLeftBillboard;

    public LeftPanelBillboard(ActionListener listener) {
        initComponents(listener);
    }

    public void initComponents(ActionListener listener) {
        this.setBackground(Color.WHITE);
        this.setLayout(new BorderLayout());
        topPanelLeftBillboard = new TopPanelLeftBillboard();
        centerPanelLeftBillboard = new CenterPanelLeftBillboard(listener);

        add(topPanelLeftBillboard, BorderLayout.NORTH);
        add(centerPanelLeftBillboard, BorderLayout.CENTER);
    }

    public void addItems(String list) {
        topPanelLeftBillboard.addItems(list);
    }

    public String getTxtComboBox() {
        return topPanelLeftBillboard.getTxtComboBox();
    }
}
