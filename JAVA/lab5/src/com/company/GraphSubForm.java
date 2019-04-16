package com.company;

import javax.swing.*;

import java.awt.*;

import static org.omg.CORBA.ORB.init;

public class GraphSubForm extends JPanel {
    JComboBox graphtypes;
    JSpinner verticesField = new JSpinner(
            new SpinnerNumberModel(0,0,1000,1));
    JSpinner edgesField = new JSpinner(
            new SpinnerNumberModel(0,0,1000,1));
    private final CatalogFrame frame;
    public GraphSubForm(CatalogFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        JLabel label1=new JLabel("");
        this.add(label1);
        JLabel label4=new JLabel(" Graph Type ");
        String[] graphs= { "Simple", "Directed"};
        graphtypes=new JComboBox(graphs);
        graphtypes.setSelectedIndex(0);
        this.add(label4);
        this.add(graphtypes);
        JLabel label5=new JLabel(" Number of vertices ");
        this.add(label5);
        this.add(verticesField);
        JLabel label6=new JLabel(" Number of edges ");
        this.add(label6);
        this.add(edgesField);
        JLabel label2=new JLabel("");
        this.add(label2);
    }
    public String getElements(){
        return graphtypes.getSelectedItem().toString()+" n="+verticesField.getValue().toString()+" m="+edgesField.getValue().toString();
    }
}
