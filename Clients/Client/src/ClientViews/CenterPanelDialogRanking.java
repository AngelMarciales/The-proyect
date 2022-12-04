package ClientViews;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class CenterPanelDialogRanking extends JPanel {

    private JLabel[] label;

    public CenterPanelDialogRanking() {
        initComponents();
    }

    public void initComponents() {
        this.setBackground(Color.WHITE);
        label = new JLabel[15];
        for (int i = 0; i < label.length; i++) {
            label[i] = new JLabel();
            label[i].setHorizontalAlignment(SwingConstants.CENTER);
            add(label[i]);
        }
    }

    public void setRanking(String[] filmList, int[] popularity){
        for (int i = 0; i < filmList.length; i++) {
            label[i].setText(filmList[i] + " Popularidad: " + popularity[i]);
        }   
    }
}
