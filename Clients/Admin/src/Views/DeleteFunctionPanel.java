package Views;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DeleteFunctionPanel extends JDialog {

    private JLabel idLabel;
    private JTextField idTxt;
    private AcceptAndCancelPanel buttons;

    public DeleteFunctionPanel(ActionListener listener) {
        this.setSize(400, 150);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        initComponents(listener);
        this.setVisible(false);
    }

    public void initComponents(ActionListener listener) {
        this.setBackground(Color.WHITE);
        setLayout(new GridBagLayout());
        GridBagConstraints gb = new GridBagConstraints();

        idLabel = new JLabel("Ingrese el ID");
        gb.gridx = 1;
        gb.gridy = 0;
        add(idLabel, gb);

        gb.gridx = 2;
        gb.gridy = 0;
        idTxt = new JTextField(10);
        add(idTxt, gb);

        buttons = new AcceptAndCancelPanel(listener);
        gb.gridx = 1;
        gb.gridy = 1;
        gb.gridwidth = 2;
        add(buttons, gb);
    }

    public int getID() {
        return Integer.parseInt(idTxt.getText());
    }
}
