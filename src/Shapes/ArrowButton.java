package Shapes;


import javax.swing.*;
import java.awt.*;

public class ArrowButton extends JButton {
    public static final int RIGHT = 0;

    private final int direction;

    public ArrowButton(int direction) {
        this.direction = direction;
        setPreferredSize(new Dimension(100, 50));
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int[] xPoints;
        int[] yPoints;

        if (direction == RIGHT) {
            xPoints = new int[]{10, getWidth() - 10, 10};
        } else {
            xPoints = new int[]{getWidth() - 10, 10, getWidth() - 10};
        }
        yPoints = new int[]{10, getHeight() / 2, getHeight() - 10};

        g2.setColor(getBackground());
        g2.fillPolygon(xPoints, yPoints, 3);

        g2.dispose();
    }
}
