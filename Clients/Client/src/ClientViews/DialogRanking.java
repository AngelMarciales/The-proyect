package ClientViews;

import javax.swing.JDialog;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

public class DialogRanking extends JDialog {

    private TopPanelDialogRanking topPanelDialogRanking;
    private CenterPanelDialogRanking centerPanelDialogRanking;
    private BotPanelDialogRanking botPanelDialogRanking;

    public DialogRanking(ActionListener listener) {
        this.setSize(300, 350);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        initComponents(listener);
        this.setVisible(false);
    }

    public void initComponents(ActionListener listener) {
        this.setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        topPanelDialogRanking = new TopPanelDialogRanking();
        centerPanelDialogRanking = new CenterPanelDialogRanking();
        botPanelDialogRanking = new BotPanelDialogRanking(listener);

        add(topPanelDialogRanking, BorderLayout.NORTH);
        add(centerPanelDialogRanking, BorderLayout.CENTER);
        add(botPanelDialogRanking, BorderLayout.SOUTH);
    }

    public void setRanking(String[] filmList, int[] popularity) {
        centerPanelDialogRanking.setRanking(filmList, popularity);
    }
}
