import javax.swing.*;
import java.awt.*;

public class GridUpdater extends GridClass{

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawOval(20, 20, 10, 10);
    }

    public void testDraw(int x, Graphics g) {
//        this.paintComponent(g, x);
        super.paintComponent(g);
        g.drawOval(x, x, 10, 10);
        super.repaint();
    }

    public void testCircle(int x, int y, int size, Graphics g) {
        super.paintComponent(g);
        g.drawOval(x, y, size, size);
        super.repaint();
    }

    public void drawO(int gridId, int size, JPanel panel) {
        // First we need to figure x and y coordinates of our origin
        int xSize = panel.getX();
        int ySize = panel.getY();

        // Figure out what row we are on
        int row = (gridId / 3) + 1;

        // Figure out our column
        int column = (gridId % 3) + 1;

        // Do calculations to determine position and draw 0

        System.out.println("Y is " + row);
        System.out.println("x is " + column);

    }

}
