import java.awt.Color;
import java.awt.Dimension;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HeartBrokenWallpaper extends JFrame {
    
    private final JPanel backgroundPanel;
    
    public HeartBrokenWallpaper() {
        super("Heart Broken Wallpaper");
        
        backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                
                // Cast Graphics to Graphics2D to enable anti-aliasing
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                // Draw background gradient
                Color startColor = new Color(250, 206, 206); // Pale pink
                Color endColor = new Color(255, 238, 238); // Light pink
                GradientPaint gradient = new GradientPaint(0, 0, startColor, getWidth(), getHeight(), endColor);
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
                
                // Draw broken heart shape
                g2d.setColor(new Color(255, 87, 87)); // Coral pink
                int[] xPoints = {150, 250, 200};
                int[] yPoints = {150, 150, 250};
                g2d.fillPolygon(xPoints, yPoints, 3);
                g2d.setColor(new Color(255, 255, 255)); // White
                g2d.drawLine(150, 150, 200, 250);
                g2d.drawLine(250, 150, 200, 250);
                
                // Draw text
                g2d.setColor(new Color(255, 87, 87)); // Coral pink
                Font font = new Font("Arial", Font.BOLD, 60);
                g2d.setFont(font);
                String text = "Heartbroken";
                int x = getWidth() / 2 - g2d.getFontMetrics().stringWidth(text) / 2;
                int y = getHeight() / 2 + 100;
                g2d.drawString(text, x, y);
                
                // Draw subtext
                g2d.setColor(new Color(255, 255, 255)); // White
                Font subfont = new Font("Arial", Font.BOLD, 30);
                g2d.setFont(subfont);
                String subtext = "But not defeated";
                int subx = getWidth() / 2 - g2d.getFontMetrics().stringWidth(subtext) / 2;
                int suby = getHeight() / 2 + 150;
                g2d.drawString(subtext, subx, suby);
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
        new HeartBrokenWallpaper();
    }
}
