package CustomComponents;

import javax.swing.*;
import java.awt.*;

public class RoundedLabel extends JLabel {
    private int arcWidth = 20;
    private int arcHeight = 20;
    private Color backgroundColor = Color.WHITE;
    private Color borderColor = Color.BLACK;

    public RoundedLabel(String text) {
        super(text); // Explicitly call JLabel(String)
        setOpaque(false);
        setHorizontalAlignment(CENTER);
        setVerticalAlignment(CENTER);
        setFont(new Font("SansSerif", Font.PLAIN, 14));
        setForeground(Color.BLACK);
        setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
    }

    // Optional: default constructor if needed
    public RoundedLabel() {
        this("");
    }

    public void setBackgroundColor(Color color) {
        this.backgroundColor = color;
        repaint();
    }

    public void setBorderColor(Color color) {
        this.borderColor = color;
        repaint();
    }

    public void setCornerRadius(int arc) {
        this.arcWidth = this.arcHeight = arc;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Rounded background
        g2.setColor(backgroundColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), arcWidth, arcHeight);

        super.paintComponent(g); // Let JLabel paint the text
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Rounded border
        g2.setColor(borderColor);
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arcWidth, arcHeight);

        g2.dispose();
    }
}
