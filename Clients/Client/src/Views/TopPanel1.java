package Views;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TopPanel1 extends JPanel {

    private JLabel label;

    public TopPanel1() {
        initComponents();
    }

    public void initComponents() {
        this.setBackground(Color.WHITE);
        Image img = new ImageIcon("data/icono.png").getImage();
        ImageIcon img2 = new ImageIcon(img.getScaledInstance(70, 70, Image.SCALE_SMOOTH));
        label = new JLabel();
        label.setIcon(img2);
        add(label);
    }
}