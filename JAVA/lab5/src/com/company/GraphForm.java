package com.company;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphForm extends JPanel {
    GraphSubForm graphSubForm;
    GraphFormButton graphFormButton;
    TextField textField1=new TextField();
    TextField textField2=new TextField();
    TextField textField3=new TextField();
    private final CatalogFrame frame;
    public GraphForm(CatalogFrame frame) {
        String title = "Add graph" ;
        this.setBorder(BorderFactory.createTitledBorder(title));
        this.frame = frame;
        init();
    }


    private void init() {
        GridLayout layout=new GridLayout(0,1);
        this.setLayout(layout);
       JLabel label1=new JLabel("Name of the graph");
       this.add(label1);
       this.add(textField1);
        JLabel label2=new JLabel("Path of the definition file");
        this.add(label2);
        this.add(textField2);
        JLabel label3=new JLabel("Path of the image file");
        this.add(label3);
        this.add(textField3);
        this.graphSubForm=new GraphSubForm(this.frame);
        this.add(graphSubForm);
        this.graphFormButton=new GraphFormButton(this.frame);
        this.add(graphFormButton);
        graphFormButton.button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addGraph();
            }
        });
    }

    private void addGraph() {
        String graph=textField1.getText()+" "+textField2.getText()+" " +textField3.getText() +" "+graphSubForm.getElements();
        frame.list.addGraph(graph);
    }
}
