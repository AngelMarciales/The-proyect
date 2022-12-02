package Views;

import java.awt.Color;
import javax.swing.JPanel;

import java.awt.CardLayout;

public class CenterPanelBillBoard extends JPanel {

    private CardLayout cl;

    public CenterPanelBillBoard() {
        initComponents();
    }

    public void initComponents() {
        this.setBackground(Color.WHITE);
        this.setLayout(new CardLayout());
        cl = (CardLayout) this.getLayout();
    }

    public void show(String a) {
        cl.show(this, a);
    }
}
