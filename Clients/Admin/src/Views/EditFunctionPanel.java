package Views;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

public class EditFunctionPanel extends JPanel {

    private JLabel idLabel;
    private JLabel formatLabel;
    private JLabel filmLabel;
    private JLabel hourLabel;
    private JLabel costLabel;
    private JLabel roomLabel;

    private JTextField idTxt;
    private JTextField hourTxt;
    private JTextField costTxt;
    private JComboBox<String> formatCBox;
    private JComboBox<String> filmCBox;
    private JComboBox<String> roomCBox;

    public EditFunctionPanel(ActionListener listener) {
        initComponents(listener);
    }

    public void initComponents(ActionListener listener) {
        this.setLayout(new GridLayout(10, 2, 15, 15));
        this.setBackground(new Color(69, 65, 65));

        idLabel = new JLabel("ID");
        add(idLabel);
        idTxt = new JTextField(10);
        add(idTxt);

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

    public void addFilmItems(String[] films) {
        filmCBox.removeAllItems();
        for (int i = 0; i < films.length; i++) {
            filmCBox.addItem(films[i]);
        }
    }

    public void addRoomItems(String[] rooms) {
        roomCBox.removeAllItems();
        for (int i = 0; i < rooms.length; i++) {
            roomCBox.addItem(rooms[i]);
        }
    }

    public String getEditedID(){
        return idTxt.getText();
    }

    public String getEditedFormat(){
        return String.valueOf(formatCBox.getSelectedItem());
    }

    public String getEditedFilm(){
        return String.valueOf(filmCBox.getSelectedItem());
    }

    public String geteditedHour(){
        return hourTxt.getText();
    }

    public String getEditedCost(){
        return costTxt.getText();
    }

    public String geteditedRoom(){
        return String.valueOf(roomCBox.getSelectedItem());
    }
}
