package ClientViews;

import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

public class PanelBillboard extends JPanel {

    private LeftPanelBillboard leftPanelBillboard;
    private CenterPanelBillBoard centerPanelBillBoard;
    private RightPanelBillboard rightPanelBillboard;

    public PanelBillboard(ActionListener listener) {
        initComponents(listener);
    }

    public void initComponents(ActionListener listener) {
        this.setLayout(new BorderLayout());
        leftPanelBillboard = new LeftPanelBillboard(listener);
        rightPanelBillboard = new RightPanelBillboard(listener);
        centerPanelBillBoard = new CenterPanelBillBoard();
        add(centerPanelBillBoard, BorderLayout.CENTER);
        add(leftPanelBillboard, BorderLayout.WEST);
        add(rightPanelBillboard, BorderLayout.EAST);
    }

    public void addItems(String[] list) {
        leftPanelBillboard.addItems(list);
    }

    public void show1(String a) {
        centerPanelBillBoard.show(a);
    }

    public void addTarjet(String[] routes, String[] names){
        centerPanelBillBoard.addTarjet(routes, names);
    }

    public String getTxtComboBox() {
        return leftPanelBillboard.getTxtComboBox();
    }

    public void setTxtFunction1(String message) {
        rightPanelBillboard.setTxtFunction1(message);
    }

    public void setTxtFunction2(String message) {
        rightPanelBillboard.setTxtFunction2(message);
    }
}
