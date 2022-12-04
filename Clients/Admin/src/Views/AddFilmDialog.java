package Views;

import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.*;

public class AddFilmDialog extends JDialog {

    private AddFilmPanel addFilmPanel;
    private AcceptAndCancelFilmPanel buttons;

    public AddFilmDialog(ActionListener listener) {
        this.setSize(600, 450);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        initComponents(listener);
        this.setVisible(false);
    }

    public void initComponents(ActionListener listener) {
        setLayout(new BorderLayout());
        addFilmPanel = new AddFilmPanel(listener);
        add(addFilmPanel, BorderLayout.CENTER);

        buttons = new AcceptAndCancelFilmPanel(listener);
        add(buttons, BorderLayout.SOUTH);
    }

    public String getName(){
        return addFilmPanel.getName();
    }

    public String getDirector(){
        return addFilmPanel.getDirector();
    }
}