package CustomComponents;

import javax.swing.*;
import java.awt.*;

public class adminButtons extends JButton {
    private final int cornerRadius;

    public adminButtons(String text, int radius) {
        super(text);
        this.cornerRadius = 25;
        setBackground(new Color(155, 155, 35));
        setContentAreaFilled(false);  // No background fill
        setBorderPainted(false);      // We'll paint custom border
        setFocusPainted(false);       // Remove focus ring
        setOpaque(false);             // Allow transparency
        setForeground(Color.white);   // Text color
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Optional: change color on hover
        if (getModel().isRollover()) {
            g2.setColor(new Color(255, 255, 0)); // Slight hover effect
            setForeground(new Color(35, 35, 35));
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);
        } else {
            setForeground(Color.white);   // Text color
        }

        super.paintComponent(g);
        g2.dispose();
    } 

//    @Override
//    protected void paintBorder(Graphics g) {
//        Graphics2D g2 = (Graphics2D) g.create();
//        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        g2.setColor(Color.WHITE);
//        g2.setStroke(new BasicStroke(2)); // Border thickness
//        g2.drawRoundRect(1, 1, getWidth() - 3, getHeight() - 3, cornerRadius, cornerRadius);
//        g2.dispose();
//    }
}
