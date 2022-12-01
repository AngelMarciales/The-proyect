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
        chairList = new JButton[42];
        ImageIcon image1 = new ImageIcon("data/chair.png");

        for (int i = 0; i < chairList.length; i++) {
            chairList[i] = new JButton(image1);
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

        for (int i = 0; i < chairList.length; i++) {
            chairList[i].setFocusable(false);
            chairList[i].setBackground(new Color(129, 145, 213));
        }

        chairList[0].setActionCommand("Left-0-0");
        chairList[1].setActionCommand("Left-0-1");
        chairList[2].setActionCommand("Left-0-2");
        chairList[3].setActionCommand("Left-0-3");
        chairList[4].setActionCommand("Left-0-4");
        chairList[5].setActionCommand("Left-0-5");
        chairList[6].setActionCommand("Left-1-0");
        chairList[7].setActionCommand("Left-1-1");
        chairList[8].setActionCommand("Left-1-2");
        chairList[9].setActionCommand("Left-1-3");
        chairList[10].setActionCommand("Left-1-4");
        chairList[11].setActionCommand("Left-1-5");
        chairList[12].setActionCommand("Center-0-0");
        chairList[13].setActionCommand("Center-0-1");
        chairList[14].setActionCommand("Center-0-2");
        chairList[15].setActionCommand("Center-0-3");
        chairList[16].setActionCommand("Center-0-4");
        chairList[17].setActionCommand("Center-0-5");
        chairList[18].setActionCommand("Center-1-0");
        chairList[19].setActionCommand("Center-1-1");
        chairList[20].setActionCommand("Center-1-2");
        chairList[21].setActionCommand("Center-1-3");
        chairList[22].setActionCommand("Center-1-4");
        chairList[23].setActionCommand("Center-1-5");
        chairList[24].setActionCommand("Center-2-0");
        chairList[25].setActionCommand("Center-2-1");
        chairList[26].setActionCommand("Center-2-2");
        chairList[27].setActionCommand("Center-2-3");
        chairList[28].setActionCommand("Center-2-4");
        chairList[29].setActionCommand("Center-2-5");
        chairList[30].setActionCommand("Right-0-0");
        chairList[31].setActionCommand("Right-0-1");
        chairList[32].setActionCommand("Right-0-2");
        chairList[33].setActionCommand("Right-0-3");
        chairList[34].setActionCommand("Right-0-4");
        chairList[35].setActionCommand("Right-0-5");
        chairList[36].setActionCommand("Right-1-0");
        chairList[37].setActionCommand("Right-1-1");
        chairList[38].setActionCommand("Right-1-2");
        chairList[39].setActionCommand("Right-1-3");
        chairList[40].setActionCommand("Right-1-4");
        chairList[41].setActionCommand("Right-1-5");

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(chairList[0], gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(chairList[1], gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(chairList[2], gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(chairList[3], gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(chairList[4], gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        add(chairList[5], gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(chairList[6], gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(chairList[7], gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        add(chairList[8], gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        add(chairList[9], gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        add(chairList[10], gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        add(chairList[11], gbc);

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
        add(chairList[12], gbc);

        gbc.gridx = 4;
        gbc.gridy = 1;
        add(chairList[13], gbc);

        gbc.gridx = 4;
        gbc.gridy = 2;
        add(chairList[14], gbc);

        gbc.gridx = 4;
        gbc.gridy = 3;
        add(chairList[15], gbc);

        gbc.gridx = 4;
        gbc.gridy = 4;
        add(chairList[16], gbc);

        gbc.gridx = 4;
        gbc.gridy = 5;
        add(chairList[17], gbc);

        gbc.gridx = 5;
        gbc.gridy = 0;
        add(chairList[18], gbc);

        gbc.gridx = 5;
        gbc.gridy = 1;
        add(chairList[19], gbc);

        gbc.gridx = 5;
        gbc.gridy = 2;
        add(chairList[20], gbc);

        gbc.gridx = 5;
        gbc.gridy = 3;
        add(chairList[21], gbc);

        gbc.gridx = 5;
        gbc.gridy = 4;
        add(chairList[22], gbc);

        gbc.gridx = 5;
        gbc.gridy = 5;
        add(chairList[23], gbc);

        gbc.gridx = 6;
        gbc.gridy = 0;
        add(chairList[24], gbc);

        gbc.gridx = 6;
        gbc.gridy = 1;
        add(chairList[25], gbc);

        gbc.gridx = 6;
        gbc.gridy = 2;
        add(chairList[26], gbc);

        gbc.gridx = 6;
        gbc.gridy = 3;
        add(chairList[27], gbc);

        gbc.gridx = 6;
        gbc.gridy = 4;
        add(chairList[28], gbc);

        gbc.gridx = 6;
        gbc.gridy = 5;
        add(chairList[29], gbc);

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
        add(chairList[30], gbc);

        gbc.gridx = 8;
        gbc.gridy = 1;
        add(chairList[31], gbc);

        gbc.gridx = 8;
        gbc.gridy = 2;
        add(chairList[32], gbc);

        gbc.gridx = 8;
        gbc.gridy = 3;
        add(chairList[33], gbc);

        gbc.gridx = 8;
        gbc.gridy = 4;
        add(chairList[34], gbc);

        gbc.gridx = 8;
        gbc.gridy = 5;
        add(chairList[35], gbc);

        gbc.gridx = 9;
        gbc.gridy = 0;
        add(chairList[36], gbc);

        gbc.gridx = 9;
        gbc.gridy = 1;
        add(chairList[37], gbc);

        gbc.gridx = 9;
        gbc.gridy = 2;
        add(chairList[38], gbc);

        gbc.gridx = 9;
        gbc.gridy = 3;
        add(chairList[39], gbc);

        gbc.gridx = 9;
        gbc.gridy = 4;
        add(chairList[40], gbc);

        gbc.gridx = 9;
        gbc.gridy = 5;
        add(chairList[41], gbc);

        for (int i = 0; i < chairList.length; i++) {
            chairList[i].addActionListener(listener);
        }

    }

    public void setColorChair(String position, boolean confirm) {
        for (int i = 0; i < chairList.length; i++) {
            if (chairList[i].getActionCommand().equalsIgnoreCase(position)) {
                if (confirm == true) {
                    chairList[i].setBackground(Color.RED);
                } else if (confirm == false) {
                    chairList[i].setBackground(new Color(129, 145, 213));
                }
            }
        }
    }

    public String getColor(String position) {
        String color = "";
        for (int i = 0; i < chairList.length; i++) {
            if (chairList[i].getActionCommand().equalsIgnoreCase(position)) {
                if (chairList[i].getBackground() == Color.RED) {
                    color = "Rojo";
                } else {
                    color = "Verde";
                }
            }
        }
        return color;
    }
}
