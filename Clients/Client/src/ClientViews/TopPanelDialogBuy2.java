package ClientViews;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;

public class TopPanelDialogBuy2 extends JPanel {

    private JLabel space1;
    private JLabel space2;
    private JLabel space3;
    private JLabel space4;
    private JLabel space5;
    private JLabel space6;
    private JLabel space7;
    private JLabel space8;
    private JLabel space9;
    private JLabel space10;
    private JLabel space11;
    private JLabel space12;
    private JButton[] chairList;

    public TopPanelDialogBuy2(ActionListener listener) {
        initComponents(listener);
    }

    public void initComponents(ActionListener listener) {
        this.setBackground(Color.WHITE);
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        chairList = new JButton[43];
        ImageIcon image1 = new ImageIcon("data/chair.png");

        for (int i = 1; i < chairList.length; i++) {
            chairList[i] = new JButton(image1);
            chairList[i].setFocusable(false);
            chairList[i].setBackground(new Color(129, 145, 213));
            chairList[i].setActionCommand("Chair:" + i);
            chairList[i].addActionListener(listener);
        }

        space1 = new JLabel("          ");
        space2 = new JLabel("          ");
        space3 = new JLabel("          ");
        space4 = new JLabel("          ");
        space5 = new JLabel("          ");
        space6 = new JLabel("          ");
        space7 = new JLabel("          ");
        space8 = new JLabel("          ");
        space9 = new JLabel("          ");
        space10 = new JLabel("          ");
        space11 = new JLabel("          ");
        space12 = new JLabel("          ");

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(chairList[1], gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(chairList[2], gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(chairList[3], gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(chairList[4], gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(chairList[5], gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        add(chairList[6], gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(chairList[7], gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(chairList[8], gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        add(chairList[9], gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        add(chairList[10], gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        add(chairList[11], gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        add(chairList[12], gbc);

        gbc.gridx = 3;
        gbc.gridy = 0;
        add(space1, gbc);

        gbc.gridx = 3;
        gbc.gridy = 1;
        add(space2, gbc);

        gbc.gridx = 3;
        gbc.gridy = 2;
        add(space3, gbc);

        gbc.gridx = 3;
        gbc.gridy = 3;
        add(space4, gbc);

        gbc.gridx = 3;
        gbc.gridy = 4;
        add(space5, gbc);

        gbc.gridx = 3;
        gbc.gridy = 5;
        add(space6, gbc);

        gbc.gridx = 4;
        gbc.gridy = 0;
        add(chairList[13], gbc);

        gbc.gridx = 4;
        gbc.gridy = 1;
        add(chairList[14], gbc);

        gbc.gridx = 4;
        gbc.gridy = 2;
        add(chairList[15], gbc);

        gbc.gridx = 4;
        gbc.gridy = 3;
        add(chairList[16], gbc);

        gbc.gridx = 4;
        gbc.gridy = 4;
        add(chairList[17], gbc);

        gbc.gridx = 4;
        gbc.gridy = 5;
        add(chairList[18], gbc);

        gbc.gridx = 5;
        gbc.gridy = 0;
        add(chairList[19], gbc);

        gbc.gridx = 5;
        gbc.gridy = 1;
        add(chairList[20], gbc);

        gbc.gridx = 5;
        gbc.gridy = 2;
        add(chairList[21], gbc);

        gbc.gridx = 5;
        gbc.gridy = 3;
        add(chairList[22], gbc);

        gbc.gridx = 5;
        gbc.gridy = 4;
        add(chairList[23], gbc);

        gbc.gridx = 5;
        gbc.gridy = 5;
        add(chairList[24], gbc);

        gbc.gridx = 6;
        gbc.gridy = 0;
        add(chairList[25], gbc);

        gbc.gridx = 6;
        gbc.gridy = 1;
        add(chairList[26], gbc);

        gbc.gridx = 6;
        gbc.gridy = 2;
        add(chairList[27], gbc);

        gbc.gridx = 6;
        gbc.gridy = 3;
        add(chairList[28], gbc);

        gbc.gridx = 6;
        gbc.gridy = 4;
        add(chairList[29], gbc);

        gbc.gridx = 6;
        gbc.gridy = 5;
        add(chairList[30], gbc);

        gbc.gridx = 7;
        gbc.gridy = 0;
        add(space7, gbc);

        gbc.gridx = 7;
        gbc.gridy = 1;
        add(space8, gbc);

        gbc.gridx = 7;
        gbc.gridy = 2;
        add(space9, gbc);

        gbc.gridx = 7;
        gbc.gridy = 3;
        add(space10, gbc);

        gbc.gridx = 7;
        gbc.gridy = 4;
        add(space11, gbc);

        gbc.gridx = 7;
        gbc.gridy = 5;
        add(space12, gbc);

        gbc.gridx = 8;
        gbc.gridy = 0;
        add(chairList[31], gbc);

        gbc.gridx = 8;
        gbc.gridy = 1;
        add(chairList[32], gbc);

        gbc.gridx = 8;
        gbc.gridy = 2;
        add(chairList[33], gbc);

        gbc.gridx = 8;
        gbc.gridy = 3;
        add(chairList[34], gbc);

        gbc.gridx = 8;
        gbc.gridy = 4;
        add(chairList[35], gbc);

        gbc.gridx = 8;
        gbc.gridy = 5;
        add(chairList[36], gbc);

        gbc.gridx = 9;
        gbc.gridy = 0;
        add(chairList[37], gbc);

        gbc.gridx = 9;
        gbc.gridy = 1;
        add(chairList[38], gbc);

        gbc.gridx = 9;
        gbc.gridy = 2;
        add(chairList[39], gbc);

        gbc.gridx = 9;
        gbc.gridy = 3;
        add(chairList[40], gbc);

        gbc.gridx = 9;
        gbc.gridy = 4;
        add(chairList[41], gbc);

        gbc.gridx = 9;
        gbc.gridy = 5;
        add(chairList[42], gbc);
    }

    public void setColorChair(int position, boolean confirm) {
        if (confirm == false) {
            chairList[position].setBackground(Color.RED);
        } else if (confirm == true) {
            chairList[position].setBackground(new Color(129, 145, 213));
        }
    }

    public String getColor(int position) {
        String color = "";
        if (chairList[position].getBackground() == Color.RED) {
            color = "Rojo";
        } else {
            color = "Verde";
        }
        return color;
    }
}
