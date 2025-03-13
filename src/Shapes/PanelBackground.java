package Shapes;
import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class PanelBackground extends JPanel {
    private final Image backgroundImage;

    // Constructor to set the background image
    public PanelBackground(String filePath) {
        backgroundImage = new ImageIcon(filePath).getImage();
        this.setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}

