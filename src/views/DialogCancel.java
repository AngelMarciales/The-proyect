package views;

import javax.swing.JDialog;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

public class DialogCancel extends JDialog {

    private TopPanelDialogCancel topPanelDialogCancel;
    private CenterPanelDialogCancel centerPanelDialogCancel;
    private BotPanelDialogCancel botPanelDialogCancel;

    public DialogCancel(ActionListener listener) {
        this.setSize(400, 150);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        initComponents(listener);
        this.setVisible(false);
    }

    public void initComponents(ActionListener listener) {
        this.setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        topPanelDialogCancel = new TopPanelDialogCancel();
        centerPanelDialogCancel = new CenterPanelDialogCancel();
        botPanelDialogCancel = new BotPanelDialogCancel(listener);

        add(topPanelDialogCancel, BorderLayout.NORTH);
        add(centerPanelDialogCancel, BorderLayout.CENTER);
        add(botPanelDialogCancel, BorderLayout.SOUTH);
    }

    public String getPosition() {
        return centerPanelDialogCancel.getPosition();
    }

    public String getRow() {
        return centerPanelDialogCancel.getRow();
    }

    public String getColum() {
        return centerPanelDialogCancel.getColum();
    }

    public String getTxtField() {
        return topPanelDialogCancel.getTxtField();
    }
}
