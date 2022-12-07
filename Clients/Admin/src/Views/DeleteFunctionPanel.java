package Views;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DeleteFunctionPanel extends JPanel {

    private JLabel idLabel;
    private JTextField idTxt;

    public DeleteFunctionPanel(ActionListener listener) {
        initComponents(listener);
    }

    public void initComponents(ActionListener listener) {
        this.setLayout(new GridBagLayout());
        this.setBackground(new Color(69, 65, 65));
        GridBagConstraints gb = new GridBagConstraints();

        idLabel = new JLabel("Ingrese el ID");
        gb.gridx = 1;
        gb.gridy = 0;
        idLabel.setForeground(Color.WHITE);
        add(idLabel, gb);

        gb.gridx = 3;
        gb.gridy = 0;
        idTxt = new JTextField(10);
        add(idTxt, gb);
    }

    public int getDeleteID() {
        return Integer.parseInt(idTxt.getText());
    }
}
