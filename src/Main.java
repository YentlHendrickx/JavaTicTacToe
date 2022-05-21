import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class Main {
    public static final int FRAME_WIDTH = 300, FRAME_HEIGHT = 300;
    public static Square[] gridSquares = new Square[9];

    public static void main(String[] args) {

        for (int i = 0; i < gridSquares.length; i ++) {
            gridSquares[i] = new Square();
            gridSquares[i].setId(i);
        }

        GridClass.DrawBoard(FRAME_WIDTH, FRAME_HEIGHT);
        JPanel panel = GridClass.getPanel();

        GridUpdater gU = new GridUpdater();
////        gU.testDraw(50, panel.getGraphics());
//        gU.testCircle(50, 50, 10, panel.getGraphics());
//        panel.add(new GridUpdater());

//        gU.drawO(7, 10, panel);
        for (int i =0 ;i < 9; i++) {
            gU.drawO(i,10, panel);
        }
//        panel.add(new GridUpdater());
        // Add click listener to panel
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println(getBox(e.getX(), e.getY()));
                switchState(getBox(e.getX(), e.getY()));
            }
        });
    }

    public static int getBox(int clickX, int clickY) {
        // Check which box has been selected
        final int BOX_X = FRAME_WIDTH / 3, BOX_Y = FRAME_HEIGHT / 3;

        // Get which box has been pressed
        int xPos = clickX;
        int xBoxPos = -1;
        while (xPos >= 0) {
            xPos -= BOX_X;
            xBoxPos++;
        }

        int yPos = clickY;
        int yBoxPos = -1;
        while (yPos >= 0) {
            yPos -= BOX_Y;
            yBoxPos++;
        }

        System.out.println("Clicked box: " + xBoxPos + " " + yBoxPos);
        return xBoxPos  + (yBoxPos * 3);
    }

    public static void switchState(int boxId) {
        gridSquares[boxId].toggleState();

        for (int i = 0; i < gridSquares.length; i++) {
            System.out.println(gridSquares[i].getState() + " ");
        }
    }
}


