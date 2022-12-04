package ClientViews;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;

public class CenterPanelMenu extends JPanel {

    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;

    public CenterPanelMenu(ActionListener listener) {
        initComponents(listener);
    }

    public void initComponents(ActionListener listener) {
        this.setBackground(Color.WHITE);
        this.setLayout(null);

        button1 = new JButton("Comprar Boleta");
        button2 = new JButton("Ver Cartelera");
        button3 = new JButton("Ver Rankings");
        button4 = new JButton("Salir");

        button1.setForeground(Color.BLACK);
        button1.setBackground(Color.WHITE);
        button1.setFocusable(false);
        button1.setBorderPainted(false);

        button2.setForeground(Color.BLACK);
        button2.setBackground(Color.WHITE);
        button2.setFocusable(false);
        button2.setBorderPainted(false);

        button3.setForeground(Color.BLACK);
        button3.setBackground(Color.WHITE);
        button3.setFocusable(false);
        button3.setBorderPainted(false);

        button4.setForeground(Color.BLACK);
        button4.setBackground(Color.WHITE);
        button4.setFocusable(false);
        button4.setBorderPainted(false);

        button1.setAlignmentX(JButton.CENTER_ALIGNMENT);
        button2.setAlignmentX(JButton.CENTER_ALIGNMENT);
        button3.setAlignmentX(JButton.CENTER_ALIGNMENT);
        button4.setAlignmentX(JButton.CENTER_ALIGNMENT);

        button1.setActionCommand("Button 1");
        button2.setActionCommand("Button 2");
        button3.setActionCommand("Button 3");
        button4.setActionCommand("Button 4");

        button1.setBounds(40, 10, 200, 20);
        button2.setBounds(40, 30, 200, 20);
        button3.setBounds(40, 50, 200, 20);
        button4.setBounds(40, 70, 200, 20);

        add(button1);
        add(button2);
        add(button3);
        add(button4);

        button1.addActionListener(listener);
        button2.addActionListener(listener);
        button3.addActionListener(listener);
        button4.addActionListener(listener);
    }
}
