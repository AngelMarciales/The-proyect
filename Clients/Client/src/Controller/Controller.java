package Controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Views.Views;

public class Controller implements ActionListener {

    private Views views;
    private int cost;
    private String position;

    public Controller() {
        views = new Views(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
