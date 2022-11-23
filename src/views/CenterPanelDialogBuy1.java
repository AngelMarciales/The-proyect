package views;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class CenterPanelDialogBuy1 extends JPanel {

    private JLabel txtFunction1;
    private JLabel txtFunction2;
    private JLabel txtFunction3;

    public CenterPanelDialogBuy1() {
        initComponents();
    }

    public void initComponents() {
        this.setBackground(Color.WHITE);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        txtFunction1 = new JLabel("           ");
        txtFunction2 = new JLabel("           ");
        txtFunction3 = new JLabel("           ");

        txtFunction1.setBackground(Color.WHITE);
        txtFunction1.setForeground(Color.BLACK);

        txtFunction2.setBackground(Color.WHITE);
        txtFunction2.setForeground(Color.BLACK);

        txtFunction3.setBackground(Color.WHITE);
        txtFunction3.setForeground(Color.BLACK);

        txtFunction1.setAlignmentX(SwingConstants.CENTER);
        txtFunction2.setAlignmentX(SwingConstants.CENTER);
        txtFunction3.setAlignmentX(SwingConstants.CENTER);

        add(txtFunction1);
        add(txtFunction2);
        add(txtFunction3);
    }

    public void setTxtFunction1(int id, String format, String filmName, String hour, int cost, boolean confirm) {
        if (confirm == true) {
            txtFunction1
                    .setText("  " + id + "   " + filmName + "    " + format + "    Valor:   " + cost + "    " + hour);
        } else {
            txtFunction1.setText("");
        }

    }

    public void setTxtFunction2(int id, String format, String filmName, String hour, int cost, boolean confirm) {
        if (confirm == true) {
            txtFunction2
                    .setText("  " + id + "   " + filmName + "    " + format + "    Valor:   " + cost + "    " + hour);
        } else {
            txtFunction2.setText("");
        }
    }

    public void setTxtFunction3(int id, String format, String filmName, String hour, int cost, boolean confirm) {
        if (confirm == true) {
            txtFunction3
                    .setText("  " + id + "   " + filmName + "    " + format + "    Valor:   " + cost + "    " + hour);
        } else {
            txtFunction3.setText("");
        }
    }
}
