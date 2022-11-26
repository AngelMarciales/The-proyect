package Views;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TopPanelDialogRanking extends JPanel {

    private JLabel title;

    public TopPanelDialogRanking() {
        initComponents();
    }

    public void initComponents() {
        this.setBackground(Color.WHITE);
        title = new JLabel("Ranking");

        add(title);
    }
}
