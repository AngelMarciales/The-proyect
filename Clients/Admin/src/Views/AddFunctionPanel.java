package Views;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddFunctionPanel extends JPanel{

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

    public AddFunctionPanel(ActionListener listener){
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        this.setLayout(new GridLayout(10,2));

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

    public void addFilmItems(String[] films){
    	filmCBox.removeAllItems();
        for (int i = 0; i < films.length; i++) {
            filmCBox.addItem(films[i]);
        }
    }

    public void addRoomItems(String[] rooms){
    	roomCBox.removeAllItems();
        for (int i = 0; i < rooms.length; i++) {
            roomCBox.addItem(rooms[i]);
        }
    }

    public String getID(){
        return idTxt.getText();
    }

    public String getFormat(){
        return String.valueOf(formatCBox.getSelectedItem());
    }

    public String getFilm(){
        return String.valueOf(filmCBox.getSelectedItem());
    }

    public String getHour(){
        return hourTxt.getText();
    }

    public int getCost(){
        return Integer.parseInt(costTxt.getText());
    }

    public String getRoom(){
        return String.valueOf(roomCBox.getSelectedItem());
    }
    
}
