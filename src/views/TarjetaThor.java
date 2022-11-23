package views;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class TarjetaThor extends JPanel {

    private JLabel label;

    public TarjetaThor() {
        initComponents();
    }

    public void initComponents() {
        this.setBackground(Color.WHITE);
        label = new JLabel();
        ImageIcon image = new ImageIcon("data/imageThor.jpg");
        label.setIcon(image);
        add(label);
    }
}
