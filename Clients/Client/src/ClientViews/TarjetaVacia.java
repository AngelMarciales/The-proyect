package ClientViews;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class TarjetaVacia extends JPanel {

    private JLabel label;

    public TarjetaVacia() {
        initComponents();
    }

    public void initComponents() {
        this.setBackground(Color.WHITE);
        label = new JLabel();
        ImageIcon image = new ImageIcon();
        label.setIcon(image);
        add(label);
    }
}
