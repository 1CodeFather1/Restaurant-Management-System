package Shapes;

import javax.swing.JButton;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class RoundButton extends JButton {
    private Shape shape;

    public RoundButton() {
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(getBackground().darker()); //The Color That Shown When Click The Button
        } else {
            g.setColor(getBackground());
        }
        g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(Color.BLACK);
        float thickness = 1.5f; //This For Modify Line thickness
        g2d.setStroke(new BasicStroke(thickness));
        g2d.drawOval(0, 0, getSize().width - 1, getSize().height - 1);
        g2d.dispose();
    }

    @Override
    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
        }
        return shape.contains(x, y);
    }
}