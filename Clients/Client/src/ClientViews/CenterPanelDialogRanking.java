package ClientViews;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CenterPanelDialogRanking extends JPanel {

    private JLabel film1;
    private JLabel film2;
    private JLabel film3;
    private JLabel film4;
    private JLabel film5;

    public CenterPanelDialogRanking() {
        initComponents();
    }

    public void initComponents() {
        this.setBackground(Color.WHITE);
        film1 = new JLabel();
        film2 = new JLabel();
        film3 = new JLabel();
        film4 = new JLabel();
        film5 = new JLabel();

        add(film1);
        add(film2);
        add(film3);
        add(film4);
        add(film5);
    }

    public void setFilm1(String name, String popularity) {
        film1.setText("1.  " + name + "  Popularidad:  " + popularity);
    }

    public void setFilm2(String name, String popularity) {
        film2.setText("2.  " + name + "  Popularidad:  " + popularity);
    }

    public void setFilm3(String name, String popularity) {
        film3.setText("3.  " + name + "  Popularidad:  " + popularity);
    }

    public void setFilm4(String name, String popularity) {
        film4.setText("4.  " + name + "  Popularidad:  " + popularity);
    }

    public void setFilm5(String name, String popularity) {
        film5.setText("5.  " + name + "  Popularidad:  " + popularity);
    }
}
