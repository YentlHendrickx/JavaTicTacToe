import javax.swing.*;
import java.awt.*;

public class GridClass extends JPanel{
    public static JFrame frame;
    public static JPanel panel;

    private static GridClass gridClass;

    public static void DrawBoard(int width, int height) {
        frame = new JFrame();
//        panel = new JPanel();

//        panel.setPreferredSize(new Dimension(width, height));
//        panel.setLayout(new GridLayout(3,3));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
//        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static JFrame getFrame() {
        return frame;
    }

    public static JPanel getPanel() {
        return panel;
    }
}