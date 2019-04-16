package com.company;

import javax.swing.*;
import java.awt.*;

public class CatalogFrame extends JFrame {
    GraphForm form;
    CatalogList list;
    ControlPanel control;

    public CatalogFrame() {
        super("Visual Graph Manager");
        init();

        this.addComponents();
        this.pack();

    }
    private void addComponents(){
        add(form, BorderLayout.NORTH);
        add(list, BorderLayout.CENTER);
        add(control, BorderLayout.SOUTH);
    }
    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.blue);
        form=new GraphForm(this);
        list=new CatalogList();
        control=new ControlPanel(this);



    }
}
