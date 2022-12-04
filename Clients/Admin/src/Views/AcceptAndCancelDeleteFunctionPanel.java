package Views;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;

public class AcceptAndCancelDeleteFunctionPanel extends JPanel{

    private JButton accept;
    private JButton cancel;
    
    public AcceptAndCancelDeleteFunctionPanel(ActionListener listener){
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        this.setBackground(Color.GREEN);

        accept = new JButton("Aceptar");
        accept.addActionListener(listener);
        accept.setActionCommand("Aceptar3");
        add(accept);

        cancel = new JButton("Cancelar");
        cancel.addActionListener(listener);
        cancel.setActionCommand("Cancelar");
        add(cancel);
    }
}
