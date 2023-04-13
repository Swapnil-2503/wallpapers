import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class Wallpaper extends JFrame {
    
    private final JPanel backgroundPanel;
    
    public Wallpaper() {
        super("Wallpaper");
        
        backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                
                // Cast Graphics to Graphics2D to enable anti-aliasing
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                // Draw gradient background
                Color startColor = new Color(255, 255, 255); // White
                Color endColor = new Color(200, 200, 255); // Light blue
                GradientPaint gradient = new GradientPaint(0, 0, startColor, getWidth(), getHeight(), endColor);
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
                
                // Draw circle pattern
                g2d.setColor(new Color(255, 200, 200)); // Light red
                int circleSize = 50;
                int spacing = 75;
                for (int x = 0; x <= getWidth() + circleSize; x += spacing) {
                    for (int y = 0; y <= getHeight() + circleSize; y += spacing) {
                        g2d.fillOval(x, y, circleSize, circleSize);
                    }
                }
            }
        };
        
        // Set size and add panel to frame
        backgroundPanel.setPreferredSize(new Dimension(800, 600));
        add(backgroundPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new Wallpaper();
    }
}
