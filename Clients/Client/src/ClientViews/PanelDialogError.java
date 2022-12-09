package ClientViews;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelDialogError extends JPanel{
    
    private JButton button;
    private JLabel label;

    public PanelDialogError(ActionListener listener){
        initComponents(listener);
    }

    public void initComponents(ActionListener listener){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.WHITE);
        button = new JButton("Aceptar");
        label = new JLabel("          ");

        label.setAlignmentX(SwingConstants.CENTER);
        label.setForeground(Color.BLACK);

        button.setActionCommand("Aceptar Error");
        button.addActionListener(listener);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.RED);
        button.setFocusable(false);
        button.setBorderPainted(false);

        add(label);
        add(button);
    }

    public void setMessageError(String error){
        label.setText("   " + error);
    }
}
