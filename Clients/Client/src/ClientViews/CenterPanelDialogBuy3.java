package ClientViews;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class CenterPanelDialogBuy3 extends JPanel {

    private JLabel labelCost;
    private JLabel labelPosition;

    public CenterPanelDialogBuy3() {
        initComponents();
    }

    public void initComponents() {
        this.setBackground(Color.WHITE);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        labelCost = new JLabel("      ");
        labelPosition = new JLabel("     ");

        labelCost.setBackground(Color.WHITE);
        labelCost.setForeground(Color.BLACK);

        labelPosition.setBackground(Color.WHITE);
        labelPosition.setForeground(Color.BLACK);

        labelCost.setAlignmentX(SwingConstants.CENTER);
        labelPosition.setAlignmentX(SwingConstants.CENTER);

        add(labelPosition);
        add(labelCost);
    }

    public void setLabelCost(String value) {
        labelCost.setText("  Valor:   " + value);
    }

    public void setLabelPosition(String value) {
        labelPosition.setText("  Posicion:   " + value);
    }

}
