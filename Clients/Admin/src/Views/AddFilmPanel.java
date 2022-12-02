package Views;

import javax.swing.*;

import java.awt.event.ActionListener;

public class AddFilmPanel extends JPanel{

    private JLabel nameLabel;
    private JLabel directoryLabel;
    private JTextField nameTxt;
    private JTextField directoryTxt;

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
    }

    public String getName(){
        return nameTxt.getText();
    }

    public String getDirector(){
        return directoryTxt.getText();
    }
    
}
