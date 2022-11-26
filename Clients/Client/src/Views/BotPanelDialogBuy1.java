package Views;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.plaf.DimensionUIResource;

import java.awt.Color;
import java.awt.event.ActionListener;

public class BotPanelDialogBuy1 extends JPanel {

    private JButton buttonSelectChair;
    private JLabel txtMessage;
    private JTextField textFieldEnter;

    public BotPanelDialogBuy1(ActionListener listener) {
        initComponents(listener);
    }

    public void initComponents(ActionListener listener) {
        this.setBackground(Color.WHITE);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        buttonSelectChair = new JButton("Seleccionar silla");
        txtMessage = new JLabel("Ingrese el numero de la funcion");
        textFieldEnter = new JTextField();

        textFieldEnter.setBounds(0, 0, 400, 10);
        textFieldEnter.setBackground(Color.WHITE);
        textFieldEnter.setForeground(Color.BLACK);
        textFieldEnter.setPreferredSize(new DimensionUIResource(10, 30));

        txtMessage.setForeground(Color.BLACK);

        buttonSelectChair.setBackground(Color.WHITE);
        buttonSelectChair.setForeground(Color.BLACK);
        buttonSelectChair.setBorderPainted(false);

        txtMessage.setHorizontalAlignment(SwingConstants.LEFT);
        buttonSelectChair.setHorizontalAlignment(SwingConstants.CENTER);

        add(txtMessage);
        add(textFieldEnter);
        add(buttonSelectChair);

        buttonSelectChair.addActionListener(listener);
    }

    public String getTxtField() {
        return textFieldEnter.getText();
    }
}
