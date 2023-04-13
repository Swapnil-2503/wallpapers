import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;

public class CodeWallpaper extends JFrame {
    
    private final JPanel backgroundPanel;
    
    public CodeWallpaper() {
        super("Code Wallpaper");
        
        backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                
                // Cast Graphics to Graphics2D to enable anti-aliasing
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                // Draw gradient background
                Color startColor = new Color(70, 70, 70); // Dark grey
                Color endColor = new Color(30, 30, 30); // Black
                GradientPaint gradient = new GradientPaint(0, 0, startColor, getWidth(), getHeight(), endColor);
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
                
                // Draw code snippets
                g2d.setColor(new Color(0, 200, 0)); // Green
                String[] snippets = {
                    "public static void main(String[] args) {",
                    "    System.out.println(\"Hello World!\");",
                    "}",
                    "for (int i = 0; i < array.length; i++) {",
                    "    // do something with array[i]",
                    "}",
                    "if (x > y) {",
                    "    return x;",
                    "} else {",
                    "    return y;",
                    "}"
                };
                int x = 50;
                int y = 100;
                for (String snippet : snippets) {
                    g2d.drawString(snippet, x, y);
                    y += 25;
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
        new CodeWallpaper();
    }
}
