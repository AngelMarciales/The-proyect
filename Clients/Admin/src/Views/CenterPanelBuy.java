package Views;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CenterPanelBuy extends JPanel {
    private JLabel label;

    public CenterPanelBuy() {
        initComponents();
    }

    public void initComponents() {
        this.setBackground(Color.WHITE);
        Image img = new ImageIcon("data/pantallaimage.png").getImage();
        ImageIcon img2 = new ImageIcon(img.getScaledInstance(270, 100, Image.SCALE_SMOOTH));
        label = new JLabel();
        label.setIcon(img2);
        add(label);
    }
}
