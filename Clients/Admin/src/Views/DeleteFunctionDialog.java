package Views;

import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.*;

public class DeleteFunctionDialog extends JDialog{

    private DeleteFunctionPanel deleteFunctionPanel;
    private AcceptAndCancelFilmPanel buttons;

    public DeleteFunctionDialog(ActionListener listener) {
        this.setSize(600, 450);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        initComponents(listener);
        this.setVisible(false);
    }

    public void initComponents(ActionListener listener) {
        setLayout(new BorderLayout());
        deleteFunctionPanel = new DeleteFunctionPanel(listener);
        add(deleteFunctionPanel, BorderLayout.CENTER);

        buttons = new AcceptAndCancelFilmPanel(listener);
        add(buttons, BorderLayout.SOUTH);
    }

    public int getDeleteID() {
        return deleteFunctionPanel.getDeleteID();
    }

}
