package Views;

import java.awt.*;
import javax.swing.JDialog;
import java.awt.Color;
import java.awt.event.ActionListener;

public class AddfunctionDialog extends JDialog {

    private AddFunctionPanel addFunctionPanel;
    private AcceptAndCancelFunctionPanel buttons;

    public AddfunctionDialog(ActionListener listener) {
        this.setSize(600, 600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        initComponents(listener);
        this.setVisible(false);
    }

    public void initComponents(ActionListener listener) {
        this.getContentPane().setBackground(Color.BLACK);
        this.setLayout(new BorderLayout());
        
        addFunctionPanel = new AddFunctionPanel(listener);
        add(addFunctionPanel, BorderLayout.CENTER);

        buttons = new AcceptAndCancelFunctionPanel(listener);
        add(buttons, BorderLayout.SOUTH);
    }

    public void addFilmItems(String[] films){
    	addFunctionPanel.addFilmItems(films);
    }

    public void addRoomItems(String[] rooms){
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
