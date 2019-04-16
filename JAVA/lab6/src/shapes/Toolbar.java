package shapes;

import javax.swing.*;
import java.awt.*;

public class Toolbar extends JPanel {
    JLabel strokeColor = new JLabel("Color: ");
    JLabel nodeSize = new JLabel("Node size: ");
    JButton drawButton = new JButton("Draw");

    JSpinner size=new JSpinner(
             new SpinnerNumberModel(50,0,100,1));
    TextField color = new TextField("0x777",10);

    public Toolbar(DrawingFrame drawingFrame) {
        this.setBorder(BorderFactory.createTitledBorder("Toolbar"));
            init();
    }
    public String getText(){
        return color.getText();
    }
    private void init(){

        add(strokeColor);
        add(color);
        add(nodeSize);
        add(size);
        add(drawButton);

    }
}
