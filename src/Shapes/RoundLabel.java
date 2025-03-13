package Shapes;

import java.awt.*;
import javax.swing.*;

/*This To Make The Image in Rounded Arrow Label*/
/*Create and Login Frame*/
public class RoundLabel extends JLabel {

    public RoundLabel() {
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int diameter = Math.min(getWidth(), getHeight());
        g2.setColor(getBackground());
        g2.fillOval(0, 0, diameter, diameter);

        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int diameter = Math.min(getWidth(), getHeight());
        g2.setColor(getForeground());
        g2.drawOval(0, 0, diameter - 1, diameter - 1);
    }

    @Override
    public Dimension getPreferredSize() {
        int diameter = Math.max(super.getPreferredSize().width, super.getPreferredSize().height);
        return new Dimension(diameter, diameter);
    }
}

