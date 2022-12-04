package Views;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;

public class AcceptAndCancelEditFunctionPanel extends JPanel{

    private JButton accept;
    private JButton cancel;
    
    public AcceptAndCancelEditFunctionPanel(ActionListener listener){
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        this.setBackground(Color.GREEN);

        accept = new JButton("Aceptar");
        accept.addActionListener(listener);
        accept.setActionCommand("Aceptar4");
        add(accept);

        cancel = new JButton("Cancelar");
        cancel.addActionListener(listener);
        cancel.setActionCommand("Cancelar");
        add(cancel);
    }
}
