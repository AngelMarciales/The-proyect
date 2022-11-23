package views;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.event.ActionListener;

public class TopPanelDialogBuy1 extends JPanel {

    private JComboBox<String> filmList;
    private JButton buttonSelectFilm;
    private JLabel txtMessageFilm;

    public TopPanelDialogBuy1(ActionListener listener) {
        initComponents(listener);
    }

    public void initComponents(ActionListener listener) {
        this.setBackground(Color.WHITE);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        filmList = new JComboBox<String>();
        buttonSelectFilm = new JButton("Buscar");
        txtMessageFilm = new JLabel("Seleccione la pelicula");

        filmList.setBackground(Color.WHITE);
        filmList.setForeground(Color.BLACK);

        txtMessageFilm.setForeground(Color.BLACK);

        buttonSelectFilm.setActionCommand("Buscar 1");
        buttonSelectFilm.setBackground(Color.WHITE);
        buttonSelectFilm.setForeground(Color.BLACK);
        buttonSelectFilm.setBorderPainted(false);
        buttonSelectFilm.setFocusable(false);

        txtMessageFilm.setHorizontalAlignment(SwingConstants.LEFT);
        buttonSelectFilm.setHorizontalAlignment(SwingConstants.CENTER);

        add(txtMessageFilm);
        add(filmList);
        add(buttonSelectFilm);

        buttonSelectFilm.addActionListener(listener);
    }

    public void addItems(String item) {
        filmList.addItem(item);
    }

    public String getTxtComboBox() {
        return String.valueOf(filmList.getSelectedItem());
    }
}
