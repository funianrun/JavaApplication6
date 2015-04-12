package Game;
 
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
 
import javax.swing.JPanel;
 
//import com.ggl.hangman.model.HangmanModel;
 
public class Figure extends JPanel {
     
    private static final long   serialVersionUID    = -4531686346612357752L;
     
    public static final int     maximumWrongGuesses = 10;
     
    private int baseWidth = 200;
    private int baseHeight = 20;
    private int poleWidth = 20;
    
    public Figure(){}
     

    public void drawNoose(Graphics g, Color color) {
        g.setColor(color);
        Graphics2D g2d = (Graphics2D) g;
        BasicStroke stroke = new BasicStroke(8.0f);
        g2d.setStroke(stroke);
        int x = getWidth() / 2;
        int y = baseHeight;
        g2d.drawLine(190, 120, 190, 90);
        stroke = new BasicStroke(20.0f);
        g2d.setStroke(stroke);
        g2d.drawLine(190, 200, 190, 220);
    }
     
    public void drawRightLeg(Graphics g, Color color) {
        g.setColor(color);
        Graphics2D g2d = (Graphics2D) g;
        BasicStroke stroke = new BasicStroke(4.0f);
        g2d.setStroke(stroke);
        int x = getWidth() / 2;
        int y = 240;
        g2d.drawLine(190, 320, 230, 365);
    }
 
    public void drawLeftLeg(Graphics g, Color color) {
        g.setColor(color);
        Graphics2D g2d = (Graphics2D) g;
        BasicStroke stroke = new BasicStroke(4.0f);
        g2d.setStroke(stroke);
        int x = getWidth() / 2;
        int y = 240;
        g2d.drawLine(190, 320, 150, 365);
    }
         
    public void drawRightArm(Graphics g, Color color) {
        g.setColor(color);
        Graphics2D g2d = (Graphics2D) g;
        BasicStroke stroke = new BasicStroke(4.0f);
        g2d.setStroke(stroke);
        int x = getWidth() / 2;
        int y = 200;
        g2d.drawLine(190, 250, 230, 210);
    }
 
    public void drawLeftArm(Graphics g, Color color) {
        g.setColor(color);
        Graphics2D g2d = (Graphics2D) g;
        BasicStroke stroke = new BasicStroke(4.0f);
        g2d.setStroke(stroke);
        int x = getWidth() / 2;
        int y = 200;
        g2d.drawLine(190, 250, 150, 210);
    }
     
    public void drawBody(Graphics g, Color color) {
        g.setColor(color);
        Graphics2D g2d = (Graphics2D) g;
        BasicStroke stroke = new BasicStroke(4.0f);
        g2d.setStroke(stroke);
        int x = getWidth() / 2;
        int y = 140;
        g2d.drawLine(190, 320, 190, 200);
    }
     
    public void drawHead(Graphics g, Color color) {
        int width = 40;
        int x = (getWidth() - baseWidth) / 2 + baseWidth / 2 - width;
        int y = 100 - width;
        g.setColor(color);
        Graphics2D g2d = (Graphics2D) g;
        BasicStroke stroke = new BasicStroke(4.0f);
        g2d.setStroke(stroke);
        g2d.drawOval(x+190, y+60, width + width, width + width);
    }
}