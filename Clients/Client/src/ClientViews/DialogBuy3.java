package ClientViews;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.event.ActionListener;

public class DialogBuy3 extends JDialog {

    private JLabel label;
    private JButton button;

    public DialogBuy3(ActionListener listener) {
        this.setSize(150, 100);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        initComponents(listener);
        this.setVisible(false);
    }

    public void initComponents(ActionListener listener) {
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        label = new JLabel();
        button = new JButton("Aceptar");

        label.setBackground(Color.WHITE);
        label.setForeground(Color.BLACK);
        label.setHorizontalAlignment(SwingConstants.CENTER);

        button.setBackground(Color.WHITE);
        button.setForeground(Color.BLACK);
        button.setFocusable(false);
        button.setBorderPainted(false);
        button.setActionCommand("Aceptar 2");

        button.addActionListener(listener);
        add(label);
        add(button);
    }

    public void setValue(int value) {
        label.setText("Valor: " + value);
    }

}
