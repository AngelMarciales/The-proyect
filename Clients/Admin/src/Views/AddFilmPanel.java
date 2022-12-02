package Views;

import javax.swing.JDialog;

import java.awt.event.ActionListener;

public class AddFilmPanel extends JDialog {

    public AddFilmPanel(ActionListener listener) {
        this.setSize(600, 450);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        initComponents(listener);
        this.setVisible(false);
    }

    public void initComponents(ActionListener listener) {
    }
}