package Views;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TopPanelLeftBillboard extends JPanel{
    
    private JComboBox<String> filmList;
    private JLabel txtMessageFilm;

    public TopPanelLeftBillboard(){
        this.setBackground(Color.WHITE);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        filmList = new JComboBox<String>();
        txtMessageFilm = new JLabel("Seleccione la pelicula");

        filmList.setBackground(Color.WHITE);
        filmList.setForeground(Color.BLACK);

        txtMessageFilm.setBackground(Color.WHITE);
        txtMessageFilm.setForeground(Color.BLACK);

        txtMessageFilm.setAlignmentX(SwingConstants.LEFT);

        add(txtMessageFilm);
        add(filmList);
    }

    public void addItems(String list){
        filmList.addItem(list);
    }

    public String getTxtComboBox(){
        return String.valueOf(filmList.getSelectedItem());
    }
}
