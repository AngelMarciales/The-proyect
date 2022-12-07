package Views;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

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
        this.setLayout(new GridLayout(3, 2));
        this.setBackground(new Color(69, 65, 65));

        nameLabel = new JLabel("Nombre");
        nameLabel.setForeground(Color.WHITE);
        add(nameLabel);
        nameTxt = new JTextField(10);
        add(nameTxt);

        directoryLabel = new JLabel("Director");
        directoryLabel.setForeground(Color.WHITE);
        add(directoryLabel);
        directoryTxt = new JTextField(10);
        add(directoryTxt);

        imgLabel = new JLabel("Link de la imagen");
        imgLabel.setForeground(Color.WHITE);
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
