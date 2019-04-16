package shapes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.text.AttributedCharacterIterator;
import java.util.Map;
import java.util.Random;

public class Canvas extends JPanel {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private BufferedImage image;
    private Graphics2D graphics;
    double radius;
    private int currentMouseX, currentMouseY;
    public Canvas() {
        this.setBorder(BorderFactory.createTitledBorder("Draw Here:"));
        setDoubleBuffered(false);
        setBackground(Color.white);
        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                drawNode(e.getX(), e.getY());
            }
        }

        );
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    protected void paintComponent(Graphics g) {
        if(image == null) {
            image = new BufferedImage(screenSize.width,screenSize.height,BufferedImage.TYPE_INT_ARGB);
            graphics = image.createGraphics();
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            clear();
        }
        g.drawImage(image, 0, 0, null);
    }


    public void drawNode(int x, int y) {
        String color=DrawingFrame.toolbar.getText();
        graphics.setColor(new Color(Integer.valueOf(color,16))); //you may use a random color or the one specified in the toolbar
        Integer val= (Integer) DrawingFrame.toolbar.size.getValue();
        double radius =val.doubleValue();
        graphics.fill(new NodeShape(x,y,radius));
        repaint();

    }

    public void drawNodeRandom() {
        Random rand = new Random();
        int x=rand.nextInt(screenSize.width);
        int y=rand.nextInt(screenSize.height-screenSize.height/7);
        String color=DrawingFrame.toolbar.getText();
        graphics.setColor(new Color(Integer.valueOf(color,16))); //you may use a random color or the one specified in the toolbar
        Integer val= (Integer) DrawingFrame.toolbar.size.getValue();
        double radius =val.doubleValue();
        graphics.fill(new NodeShape(x,y,radius));
        repaint();

    }

    public void clear() {
        graphics.setPaint(Color.white);
        graphics.fillRect(0, 0, getSize().width, getSize().height);
        graphics.setPaint(Color.black);
        repaint();
    }


}

