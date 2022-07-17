import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class GridUpdater extends JPanel {

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

    public void updateGrid(Square[] squares) {
        this.squares = squares;
    }

    public void updateGrid(Square[] squares, int moveSize) {
        this.squares = squares;
        this.moveSize = moveSize;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Get size of entire grid, divide by 3 to get one grid square (3x3)
        int squareXMiddle = this.frameWidth / 3;
        int squareYMiddle = this.frameHeight / 3;

        g.drawLine(squareXMiddle, 0, squareXMiddle, this.frameHeight);
        g.drawLine(squareXMiddle * 2, 0, squareXMiddle * 2, this.frameHeight);
        g.drawLine(0, squareYMiddle, this.frameWidth, squareYMiddle);
        g.drawLine(0, squareYMiddle * 2, this.frameWidth, squareYMiddle * 2);
//        g.drawLine(originX, originY + this.moveSize, originX + this.moveSize, originY);

        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));

        // Loop through active squares
        Arrays.stream(squares).filter(Square::getState).forEach( square -> {
            // Get square position
            int row = square.getRow();
            int column = square.getColumn();

            // Get actual position on the board
            int originX = ((row - 1) * squareXMiddle) + squareXMiddle / 2;
            int originY = ((column - 1) * squareYMiddle) + squareYMiddle / 2;

            originX -= this.moveSize / 2;
            originY -= this.moveSize / 2;

            if (square.getMType() == MoveType.Cross) {
                g2.drawLine(originX, originY, originX + this.moveSize, originY + this.moveSize);
                g2.drawLine(originX, originY + this.moveSize, originX + this.moveSize, originY);
            } else {
                g2.drawOval(originX, originY, this.moveSize, this.moveSize);
            }
        });
    }
}
