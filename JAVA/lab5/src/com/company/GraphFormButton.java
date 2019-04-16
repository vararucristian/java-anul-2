package com.company;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.omg.CORBA.ORB.init;

public class GraphFormButton extends JPanel{
    private final CatalogFrame frame;
    JButton button1;
    public GraphFormButton(CatalogFrame frame) {
        this.frame = frame;
        init();
    }
    public void init() {

        this.button1 = new JButton("Add to repository");
        this.add(button1);



    }
}
