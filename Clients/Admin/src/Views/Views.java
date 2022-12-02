package Views;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

public class Views extends JFrame {

    private ImagePanel imagePanel;
    private MainBottonsPanel mainBottonsPanel;
    public AddfunctionDialog functionPanel;
    public AddFilmDialog filmPanel;
    public DeleteFunctionPanel deleteFunctionPanel;
    public EditFunctionDialog editFunctionPanel;

    public Views(ActionListener listener) {
        super("Cinema");
        this.setSize(300, 250);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        initComponents(listener);
        this.setVisible(true);
    }

    public void initComponents(ActionListener listener) {
        this.setLayout(new BorderLayout());
        imagePanel = new ImagePanel();
        mainBottonsPanel = new MainBottonsPanel(listener);
        functionPanel = new AddfunctionDialog(listener);
        filmPanel = new AddFilmDialog(listener);
        deleteFunctionPanel = new DeleteFunctionPanel(listener);
        editFunctionPanel = new EditFunctionDialog(listener);
        functionPanel.setVisible(false);
        filmPanel.setVisible(false);
        deleteFunctionPanel.setVisible(false);
        editFunctionPanel.setVisible(false);
        this.getContentPane().add(imagePanel, BorderLayout.NORTH);
        this.getContentPane().add(mainBottonsPanel, BorderLayout.CENTER);
    }
}