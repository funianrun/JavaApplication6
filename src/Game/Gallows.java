package Game;
 
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
 
import javax.swing.JPanel;

public class Gallows extends JPanel{
    private int baseWidth = 200;
    private int baseHeight = 20;
    private int poleWidth = 20;
    
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
         
        Color color1 = Color.BLUE;
        Color color2 = Color.BLUE;
        g.setColor(color1);
        drawHeader(g, color2);
        drawPole(g, color2);
        drawBase(g, color2);
    }
    
   

public void drawHeader(Graphics g, Color color) {
        int width = baseWidth / 2 + 20;
        int x = (getWidth() - baseWidth) / 2 + baseWidth - width;
        int y = 10;
        g.setColor(color);
        g.fill3DRect(x+200, y+60, width, baseHeight, true);
    }
     
    public void drawPole(Graphics g, Color color) {
        int height = getHeight() - 20;
        int x = (getWidth() - baseWidth) / 2 + baseWidth;
        int y = 10;
        g.setColor(color);
        g.fill3DRect(x+180, y+75, poleWidth, 325, true);
    }
     
    public void drawBase(Graphics g, Color color) {
        int x = (getWidth() - baseWidth) / 2;
        int y = getHeight() - baseHeight - 10;
        g.setColor(color);
        g.fill3DRect(x+200, y+420, baseWidth, baseHeight, true);
    }
}