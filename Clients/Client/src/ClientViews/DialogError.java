package ClientViews;

import javax.swing.JDialog;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

public class DialogError extends JDialog{

    private PanelDialogError panelDialogError;

    public DialogError(ActionListener listener){
        this.setSize(200, 100);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        initComponents(listener);
        this.setVisible(false);
    }

    public void initComponents(ActionListener listener){
        setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);
        panelDialogError = new PanelDialogError(listener);
        add(panelDialogError, BorderLayout.CENTER);
    }

    public void setMessageError(String error){
        panelDialogError.setMessageError(error);
    }
}
