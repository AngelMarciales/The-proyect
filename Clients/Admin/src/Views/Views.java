package Views;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Views extends JFrame {

    private ImagePanel imagePanel;
    private MainBottonsPanel mainBottonsPanel;
    public AddfunctionDialog functionPanel;
    public AddFilmDialog filmPanel;
    public DeleteFunctionDialog deleteFunctionPanel;
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
        deleteFunctionPanel = new DeleteFunctionDialog(listener);
        editFunctionPanel = new EditFunctionDialog(listener);
        functionPanel.setVisible(false);
        filmPanel.setVisible(false);
        deleteFunctionPanel.setVisible(false);
        editFunctionPanel.setVisible(false);
        this.getContentPane().add(imagePanel, BorderLayout.NORTH);
        this.getContentPane().add(mainBottonsPanel, BorderLayout.CENTER);
    }

    public void addEditedFilmItems(String[] films) {
        editFunctionPanel.addFilmItems(films);
    }

    public void addEditedRoomItems(String[] rooms) {
        editFunctionPanel.addRoomItems(rooms);
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

    public String getCost(){
        return functionPanel.getCost();
    }

    public String getRoom(){
        return functionPanel.getRoom();
    }

    public String getName(){
        return filmPanel.getName();
    }

    public String getDirector(){
        return filmPanel.getDirector();
    }

    public String getURLImage(){
        return filmPanel.getURLImage();
    }

    public int getDeleteID() {
        return deleteFunctionPanel.getDeleteID();
    }

    public String getEditedID(){
        return editFunctionPanel.getEditedID();
    }

    public String getEditedFormat(){
        return editFunctionPanel.getEditedFormat();
    }

    public String getEditedFilm(){
        return editFunctionPanel.getEditedFilm();
    }

    public String geteditedHour(){
        return editFunctionPanel.geteditedHour();
    }

    public String getEditedCost(){
        return editFunctionPanel.getEditedCost();
    }

    public String getEditedRoom(){
        return editFunctionPanel.getEditedRoom();
    }
}