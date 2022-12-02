package Views;

import javax.swing.JDialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

public class DeleteFunctionPanel extends JDialog {

    public DeleteFunctionPanel(ActionListener listener) {
        this.setSize(400, 150);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        initComponents(listener);
        this.setVisible(false);
    }

    public void initComponents(ActionListener listener) {
        this.setBackground(Color.WHITE);
        setLayout(new BorderLayout());
    }
}
