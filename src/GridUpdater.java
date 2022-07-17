import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GridUpdater extends JPanel{

    public Square[] squares;

    public int frameWidth;
    public int frameHeight;
    public int moveSize;

    public GridUpdater(int frameWidth, int frameHeight, int moveSize, Square[] squares) {
        this.squares = squares;
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        this.moveSize = moveSize;

        this.setPreferredSize(new Dimension(frameWidth, frameHeight));
    }

    public void updateGrid(Square[] squares, int moveSize) {
        this.squares = squares;
        this.moveSize = moveSize;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Get size of entire grid, divide by 3 to get one grid square (3x3)
        int squareXMiddle = this.frameWidth / 24;
        int squareYMiddle = this.frameHeight / 3;

        for (Square square : squares) {
            // Get square position
            int row = square.getRow();
            int column = square.getColumn();

            // Get actual position on the board
            int originX = ((row - 1) * squareXMiddle) + squareXMiddle / 2;
            int originY = ((column - 1) * squareYMiddle) + squareYMiddle / 2;

            originX -= this.moveSize / 2;
            originY -= this.moveSize / 2;

            g.drawOval(originX, originY, this.moveSize, this.moveSize);
//            System.out.println("Drawing oval: " + originX + " " + originY);
        }

    }
}
