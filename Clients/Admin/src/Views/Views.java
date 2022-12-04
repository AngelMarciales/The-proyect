package Views;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Views extends JFrame {

    private ImagePanel imagePanel;
    private MainBottonsPanel mainBottonsPanel;
    public AddfunctionDialog functionPanel;
    public AddFilmDialog filmPanel;
    public DeleteFunctionPanel deleteFunctionPanel;
    public EditFunctionDialog editFunctionPanel;

    public Views(ActionListener listener) {
        super("Cinema");
        this.setSize(300, 250);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        initComponents(listener);
        this.setVisible(true);
    }

    public void initComponents(ActionListener listener) {
        this.setLayout(new BorderLayout());
        imagePanel = new ImagePanel();
        mainBottonsPanel = new MainBottonsPanel(listener);
        functionPanel = new AddfunctionDialog(listener);
        filmPanel = new AddFilmDialog(listener);
        deleteFunctionPanel = new DeleteFunctionPanel(listener);
        editFunctionPanel = new EditFunctionDialog(listener);
        functionPanel.setVisible(false);
        filmPanel.setVisible(false);
        deleteFunctionPanel.setVisible(false);
        editFunctionPanel.setVisible(false);
        this.getContentPane().add(imagePanel, BorderLayout.NORTH);
        this.getContentPane().add(mainBottonsPanel, BorderLayout.CENTER);
    }

    public void addFilmItems(String[] films){
        functionPanel.addFilmItems(films);
    }

    public void addRoomItems(String[] rooms){
    	functionPanel.addRoomItems(rooms);
    }

    public String getID(){
        return functionPanel.getID();
    }

    public String getFormat(){
        return functionPanel.getFormat();
    }

    public String getFilm(){
        return functionPanel.getFilm();
    }

    public String getHour(){
        return functionPanel.getHour();
    }

    public int getCost(){
        return functionPanel.getCost();
    }

    public String getRoom(){
        return functionPanel.getRoom();
    }
}