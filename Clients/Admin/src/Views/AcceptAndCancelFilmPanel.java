package Views;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;

public class AcceptAndCancelFilmPanel extends JPanel{

    private JButton accept;
    private JButton cancel;
    
    public AcceptAndCancelFilmPanel(ActionListener listener){
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        this.setBackground(new Color(65, 69, 69));

        accept = new JButton("Aceptar");
        accept.addActionListener(listener);
        accept.setActionCommand("Aceptar2");
        add(accept);

        cancel = new JButton("Cancelar");
        cancel.addActionListener(listener);
        cancel.setActionCommand("Cancelar");
        add(cancel);
    }
}
