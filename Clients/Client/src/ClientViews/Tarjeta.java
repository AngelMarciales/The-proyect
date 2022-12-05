package ClientViews;

import javax.swing.JPanel;
import java.awt.Color;
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

    public void setIcon(String route){
        ImageIcon image = new ImageIcon(route);
        label.setIcon(image);
    }

    public void setName(String name){
        label.setName(name);
    }
}
