package views;

import javax.swing.JDialog;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

public class DialogRanking extends JDialog {

    private TopPanelDialogRanking topPanelDialogRanking;
    private CenterPanelDialogRanking centerPanelDialogRanking;
    private BotPanelDialogRanking botPanelDialogRanking;

    public DialogRanking(ActionListener listener) {
        this.setSize(300, 300);
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

    public void setFilm1(String name, String popularity) {
        centerPanelDialogRanking.setFilm1(name, popularity);
    }

    public void setFilm2(String name, String popularity) {
        centerPanelDialogRanking.setFilm2(name, popularity);
    }

    public void setFilm3(String name, String popularity) {
        centerPanelDialogRanking.setFilm3(name, popularity);
    }

    public void setFilm4(String name, String popularity) {
        centerPanelDialogRanking.setFilm4(name, popularity);
    }

    public void setFilm5(String name, String popularity) {
        centerPanelDialogRanking.setFilm5(name, popularity);
    }
}
