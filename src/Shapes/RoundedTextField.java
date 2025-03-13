package Shapes;

import javax.swing.*;
import java.awt.*;

public class RoundedTextField extends JTextField {
    private final int radius;

    public RoundedTextField(String Text, int radius) {
        super(Text);
        this.radius = radius;
        setOpaque(false); // لمنع الخلفية الافتراضية
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        super.paintComponent(g2);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(Color.GRAY);
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
        g2.dispose();
    }
}

