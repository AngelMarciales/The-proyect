package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.*;

public class EditFunctionPanel extends JPanel {

    private JLabel formatLabel;
    private JLabel filmLabel;
    private JLabel hourLabel;
    private JLabel costLabel;
    private JLabel roomLabel;

    private JTextField hourTxt;
    private JTextField costTxt;
    private JComboBox<String> formatCBox;
    private JComboBox<String> filmCBox;
    private JComboBox<String> roomCBox;

    public EditFunctionPanel(ActionListener listener) {
        this.setSize(300, 300);
        initComponents(listener);
        this.setVisible(false);
    }

    public void initComponents(ActionListener listener) {
        this.setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        formatLabel = new JLabel("Formato");
        add(formatLabel);
        formatCBox = new JComboBox<String>();
        formatCBox.addItem("2D");
        formatCBox.addItem("3D");
        add(formatCBox);

        filmLabel = new JLabel("Pelicula");
        add(filmLabel);
        filmCBox = new JComboBox<String>();
        add(filmCBox);

        hourLabel = new JLabel("Hora");
        add(hourLabel);
        hourTxt = new JTextField(10);
        add(hourTxt);

        costLabel = new JLabel("Precio");
        add(costLabel);
        costTxt = new JTextField(10);
        add(costTxt);

        roomLabel = new JLabel("Sala");
        add(roomLabel);
        roomCBox = new JComboBox<String>();
        add(roomCBox);
    }
}
