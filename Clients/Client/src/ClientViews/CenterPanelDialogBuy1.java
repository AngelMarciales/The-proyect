package ClientViews;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class CenterPanelDialogBuy1 extends JPanel {

    private JLabel[] functions;
    
    public CenterPanelDialogBuy1() {
        initComponents();
    }

    public void initComponents() {
        this.setBackground(Color.WHITE);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        functions = new JLabel[5];
        for (int i = 0; i < functions.length; i++) {
            functions[i] = new JLabel("              ");
            functions[i].setBackground(Color.WHITE);
            functions[i].setForeground(Color.BLACK);
            functions[i].setAlignmentX(SwingConstants.CENTER);
            add(functions[i]);
        }
    }

    public void setFunctions(int[] id, String[] format, String[] filmName, String[] hour, int[] cost, int[] room) {
        for (int i = 0; i < id.length; i++) {
            functions[i].setText(
                    id[i] + " " + filmName[i] + " " + format[i] + " " + hour[i] + " " + room[i] + " " + cost[i]);
        }
    }
}
