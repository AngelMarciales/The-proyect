package Views;

import javax.swing.*;

import java.awt.event.ActionListener;

public class AddFilmPanel extends JPanel{

    private JLabel nameLabel;
    private JLabel directoryLabel;
    private JLabel imgLabel;
    private JTextField nameTxt;
    private JTextField directoryTxt;
    private JTextField imgTxt;

    public AddFilmPanel(ActionListener listener){
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        nameLabel = new JLabel("Nombre");
        add(nameLabel);
        nameTxt = new JTextField(10);
        add(nameTxt);

        directoryLabel = new JLabel("Director");
        add(directoryLabel);
        directoryTxt = new JTextField(10);
        add(directoryTxt);

        imgLabel = new JLabel("Link de la imagen");
        add(imgLabel);

        imgTxt = new JTextField(100);
        add(imgTxt);
    }

    public String getName(){
        return nameTxt.getText();
    }

    public String getDirector(){
        return directoryTxt.getText();
    }

    public String getURLImage(){
        return imgTxt.getText();
    }
    
}
