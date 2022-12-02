package Views;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

public class EditFunctionId extends JDialog {

    private JLabel idLabel;
    private JTextField idTxt;

    public EditFunctionId(ActionListener listener) {
        this.setSize(300, 300);
        initComponents(listener);
        this.setVisible(false);
    }

    public void initComponents(ActionListener listener) {
        this.setBackground(Color.WHITE);
        setLayout(new BorderLayout());

        idLabel = new JLabel("Ingrese el ID");
        add(idLabel);
        idTxt = new JTextField(10);
        add(idTxt);
    }
}