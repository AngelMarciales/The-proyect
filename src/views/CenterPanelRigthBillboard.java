package views;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CenterPanelRigthBillboard extends JPanel {

    private JLabel txtFilm1;
    private JLabel txtFilm2;

    public CenterPanelRigthBillboard() {
        initComponents();
    }

    public void initComponents() {
        this.setBackground(Color.WHITE);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        txtFilm1 = new JLabel();
        txtFilm2 = new JLabel();

        add(txtFilm1);
        add(txtFilm2);
    }

    public void setTxtFunction1(String message) {
        txtFilm1.setText("Nombre:  " + message);
    }

    public void setTxtFunction2(String message) {
        txtFilm2.setText("Director:  " + message);
    }
}
