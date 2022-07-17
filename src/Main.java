import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class Main {
    public static final int FRAME_WIDTH = 2000, FRAME_HEIGHT = 300;
    public static Square[] gridSquares = new Square[72];

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < gridSquares.length; i ++) {
            gridSquares[i] = new Square();
            gridSquares[i].setId(i);
        }

        GridClass.DrawBoard(FRAME_WIDTH, FRAME_HEIGHT);
        JFrame frame = GridClass.getFrame();
        frame.getGraphics().setClip(0, 0, 300, 300);

        GridUpdater gU = new GridUpdater(FRAME_WIDTH, FRAME_HEIGHT, 99, gridSquares);
        frame.add(gU);
        frame.pack();

        for (int j = 0; j < 10; j++) {
            for (int i =0 ; i < 500; i++) {
                gU.updateGrid(gridSquares, i);
                frame.repaint();
                Thread.sleep(5);
            }
            for (int i = 500 ; i > 0; i--) {
                gU.updateGrid(gridSquares, i);
                frame.repaint();
                Thread.sleep(1);
            }

        }


//        frame.revalidate();
//        frame.repaint();

        // Add click listener to panel
        frame.addMouseListener(new MouseAdapter() {
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


