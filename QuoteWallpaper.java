import java.awt.Color;
import java.awt.Dimension;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class QuoteWallpaper extends JFrame {
    
    private final JPanel backgroundPanel;
    
    public QuoteWallpaper() {
        super("Quote Wallpaper");
        
        backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                
                // Cast Graphics to Graphics2D to enable anti-aliasing
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                // Draw gradient background
                Color startColor = new Color(30, 30, 30); // Black
                Color endColor = new Color(0, 0, 70); // Dark blue
                GradientPaint gradient = new GradientPaint(0, 0, startColor, getWidth(), getHeight(), endColor);
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
                
                // Draw quote text
                g2d.setColor(new Color(255, 255, 255)); // White
                Font font = new Font("Arial", Font.BOLD, 50);
                g2d.setFont(font);
                String quote = "Suffer the pain of discipline or suffer the pain of regret";
                int x = 50;
                int y = getHeight() / 2;
                g2d.drawString(quote, x, y);
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
        new QuoteWallpaper();
    }
}
