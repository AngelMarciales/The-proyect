package Views;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CenterPanelDialogCancel extends JPanel {

    private JComboBox<String> positionList;
    private JComboBox<String> rowList;
    private JComboBox<String> columList;
    private JLabel label;

    public CenterPanelDialogCancel() {
        initComponentes();
    }

    public void initComponentes() {
        this.setBackground(Color.WHITE);
        positionList = new JComboBox<String>();
        rowList = new JComboBox<String>();
        columList = new JComboBox<String>();
        label = new JLabel("Seleccione su posicion");

        positionList.addItem("Left");
        positionList.addItem("Center");
        positionList.addItem("Right");

        rowList.addItem("0");
        rowList.addItem("1");
        rowList.addItem("2");

        columList.addItem("0");
        columList.addItem("1");
        columList.addItem("2");
        columList.addItem("3");
        columList.addItem("4");
        columList.addItem("5");

        add(label);
        add(positionList);
        add(rowList);
        add(columList);
    }

    public String getPosition() {
        return String.valueOf(positionList.getSelectedItem());
    }

    public String getRow() {
        return String.valueOf(rowList.getSelectedItem());
    }

    public String getColum() {
        return String.valueOf(columList.getSelectedItem());
    }
}
