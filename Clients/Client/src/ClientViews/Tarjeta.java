package ClientViews;

import javax.swing.JPanel;
import java.awt.Color;
import java.net.URL;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Tarjeta extends JPanel {

    private JLabel label;

    public Tarjeta() {
        initComponents();
    }

    public void initComponents() {
        this.setBackground(Color.WHITE);
        label = new JLabel();
        add(label);
    }

    public void setIcon(String route) {
        try {
            URL url = new URL(route);
            Image image = null;
            image = ImageIO.read(url);
            Image image2 = image.getScaledInstance(250, 400, Image.SCALE_DEFAULT);
            label.setIcon(new ImageIcon(image2));
        } catch (Exception e) {
            
        }

    }

    public void setName(String name) {
        label.setName(name);
    }
}
