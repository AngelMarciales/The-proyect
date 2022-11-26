package Views;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class TarjetaMinions extends JPanel {

    private JLabel label;

    public TarjetaMinions() {
        initComponents();
    }

    public void initComponents() {
        this.setBackground(Color.WHITE);
        label = new JLabel();
        ImageIcon image = new ImageIcon("data/imageMinions.jpg");
        label.setIcon(image);
        add(label);
    }
}