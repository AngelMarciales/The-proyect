package Views;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

public class EditFunctionDialog extends JDialog {

    private EditFunctionPanel editFunctionPanel;
    private AcceptAndCancelEditFunctionPanel buttons;

    public EditFunctionDialog(ActionListener listener) {
        this.setSize(300, 300);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        initComponents(listener);
        this.setVisible(false);
    }

    public void initComponents(ActionListener listener) {
        this.setBackground(Color.WHITE);
        setLayout(new BorderLayout());

        editFunctionPanel = new EditFunctionPanel(listener);
        add(editFunctionPanel, BorderLayout.CENTER);

        buttons = new AcceptAndCancelEditFunctionPanel(listener);
        add(buttons, BorderLayout.SOUTH);
    }
}
