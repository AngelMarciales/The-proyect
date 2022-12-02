package Views;

import java.awt.BorderLayout;
import javax.swing.JDialog;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddfunctionDialog extends JDialog {

    private AddFunctionPanel addFunctionPanel;

    public AddfunctionDialog(ActionListener listener) {
        this.setSize(400, 250);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        initComponents(listener);
        this.setVisible(false);
    }

    public void initComponents(ActionListener listener) {
        this.getContentPane().setBackground(Color.BLACK);
        setLayout(new BorderLayout());
        
        addFunctionPanel = new AddFunctionPanel(listener);
        add(addFunctionPanel);
    }

    public void addFilmItems(ArrayList<String> films){
    	addFunctionPanel.addFilmItems(films);
    }

    public void addRoomItems(ArrayList<String> rooms){
    	addFunctionPanel.addRoomItems(rooms);
    }

    public String getID(){
        return addFunctionPanel.getID();
    }

    public String getFormat(){
        return addFunctionPanel.getFormat();
    }

    public String getFilm(){
        return addFunctionPanel.getFilm();
    }

    public String getHour(){
        return addFunctionPanel.getHour();
    }

    public int getCost(){
        return addFunctionPanel.getCost();
    }

    public String getRoom(){
        return addFunctionPanel.getRoom();
    }
}
