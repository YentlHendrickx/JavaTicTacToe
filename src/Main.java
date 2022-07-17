import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class Main {
    public static final int FRAME_SIZE = 500;
    public static final int FRAME_WIDTH = FRAME_SIZE, FRAME_HEIGHT = FRAME_SIZE;
    public static final int MOVE_SIZE = FRAME_WIDTH / 3;
    public static Square[] gridSquares = new Square[9];
    public static MoveType lastMove = MoveType.Circle;

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < gridSquares.length; i ++) {
            gridSquares[i] = new Square();
            gridSquares[i].setId(i);
        }

        GridClass.DrawBoard(FRAME_WIDTH, FRAME_HEIGHT);
        JFrame frame = GridClass.getFrame();
        frame.getGraphics().setClip(0, 0, FRAME_WIDTH, FRAME_HEIGHT);

        GridUpdater gU = new GridUpdater(FRAME_WIDTH, FRAME_HEIGHT, MOVE_SIZE, gridSquares);
        frame.add(gU);
        frame.pack();

        // Add click listener to panel
        gU.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                switchState(getBox(e.getX(), e.getY()));
                gU.updateGrid(gridSquares);
                frame.repaint();
            }
        });
    }

    public static int getBox(int clickX, int clickY) {
        // Get which box has been pressed
        int xBoxPos = (int) Math.ceil(clickX / (FRAME_WIDTH / 3.0)) - 1;
        int yBoxPos = (int) Math.ceil(clickY / (FRAME_HEIGHT / 3.0)) - 1;

//        System.out.println("Clicked box: " + xBoxPos + " " + yBoxPos);
        return xBoxPos  + (yBoxPos * 3);
    }

    public static void switchState(int boxId) {
        gridSquares[boxId].toggleState();

        if (lastMove == MoveType.Cross) {
           lastMove = MoveType.Circle;
        } else {
            lastMove = MoveType.Cross;
        }
        gridSquares[boxId].setMType(lastMove);

        System.out.println("Hit box " + boxId);
    }
}


