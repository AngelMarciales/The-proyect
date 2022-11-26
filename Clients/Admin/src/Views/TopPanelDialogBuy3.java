package Views;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;

public class TopPanelDialogBuy3 extends JPanel {

    private JButton buttonContinue;
    private JComboBox<String> client;
    private JLabel labelClient;

    public TopPanelDialogBuy3(ActionListener listener) {
        initComponents(listener);
    }

    public void initComponents(ActionListener listener) {
        this.setBackground(Color.WHITE);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        buttonContinue = new JButton("Continuar");
        labelClient = new JLabel("¿Que tipo de cliente es?");
        client = new JComboBox<String>();
        client.addItem("PREMIUM");
        client.addItem("CORRIENTE");

        labelClient.setBackground(Color.WHITE);
        labelClient.setForeground(Color.BLACK);

        client.setBackground(Color.WHITE);
        client.setForeground(Color.BLACK);

        buttonContinue.setBackground(Color.WHITE);
        buttonContinue.setForeground(Color.BLACK);
        buttonContinue.setFocusable(false);
        buttonContinue.setBorderPainted(false);

        add(labelClient);
        add(client);
        add(buttonContinue);

        buttonContinue.addActionListener(listener);
    }

    public String getTxtClient() {
        return String.valueOf(client.getSelectedItem());
    }
}
