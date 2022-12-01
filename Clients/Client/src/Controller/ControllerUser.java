package Controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import ClientViews.Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerUser implements ActionListener {

    private Views views;
    private int cost;
    private String position;

    public ControllerUser() {
        views = new Views(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
