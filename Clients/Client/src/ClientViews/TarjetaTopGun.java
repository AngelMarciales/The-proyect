package ClientViews;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class TarjetaTopGun extends JPanel {

    private JLabel label;

    public TarjetaTopGun() {
        initComponents();
    }

    public void initComponents() {
        this.setBackground(Color.WHITE);
        label = new JLabel();
        ImageIcon image = new ImageIcon("data/imageTopGun.jpg");
        label.setIcon(image);
        add(label);
    }
}
