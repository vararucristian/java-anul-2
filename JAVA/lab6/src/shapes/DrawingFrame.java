package shapes;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import static com.sun.deploy.util.SessionState.save;

public class DrawingFrame extends JFrame {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int height = screenSize.height / 2;
    int width = screenSize.width / 2;
    static Toolbar toolbar;
    Canvas canvas;
    ControlPanel control;

    public DrawingFrame() {
        super("Drawing Application");
        rootPane.setBorder(BorderFactory.createTitledBorder("Drawing panel"));
        rootPane.setPreferredSize(new Dimension(width, height));
        init();
        addComponents();
        this.pack();
    }
    private void init() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        toolbar = new Toolbar(this);
        canvas = new Canvas();
        control = new ControlPanel(this);
        toolbar.drawButton.addActionListener(actionListener);
        control.resetButton.addActionListener(actionListener);
        control.saveButton.addActionListener(actionListener);
        control.loadButton.addActionListener(actionListener);
    }
    private void addComponents(){
        add(toolbar,BorderLayout.NORTH);
        add(control,BorderLayout.SOUTH);
        add(canvas,BorderLayout.CENTER);
    }
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == control.resetButton) {
                canvas.clear();
            } else if (e.getSource() == control.loadButton) {
                try {
                    load();
                } catch (IOException e1) {
                    System.out.println("File Not Found!");
                }
            } else if (e.getSource() == control.saveButton) {
                try {
                    save();
                } catch (IOException e1) {
                    System.out.println("FileNotFound");
                }
            } else if (e.getSource() == toolbar.drawButton) {
                canvas.drawNodeRandom();
            }
        }
    };

    public void save() throws IOException {
        ImageIO.write(canvas.getImage(), "PNG", new File("lab6_Paint_demo.png"));
    }

    public void load() throws IOException {
        canvas.setImage(ImageIO.read(new File("lab6_Paint_demo.png")));
        repaint();
    }

}
