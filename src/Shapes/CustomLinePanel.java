package Shapes;

import javax.swing.*;
import java.awt.*;

public class CustomLinePanel extends JPanel {
    // Custom JPanel to draw the line
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(0xd3c7b5));
        g2d.setStroke(new BasicStroke(40)); // Change high Line
        int x1 = 0;
        int y1 = getHeight() / 2;
        int x2 = getWidth();
        int y2 = getHeight() / 2;
        g2d.drawLine(x1, y1, x2, y2);
    }
}
