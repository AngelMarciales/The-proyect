package views;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TopPanelDialogCancel extends JPanel {

    private JLabel txtMessage;
    private JTextField textFieldEnter;

    public TopPanelDialogCancel() {
        initComponents();
    }

    public void initComponents() {
        this.setBackground(Color.WHITE);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        txtMessage = new JLabel("Ingrese el numero de la funcion");
        textFieldEnter = new JTextField();

        add(txtMessage);
        add(textFieldEnter);
    }

    public String getTxtField() {
        return textFieldEnter.getText();
    }
}
